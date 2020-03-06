package apicompute.reporter;

import apicompute.Aggregator;
import apicompute.RequestInfo;
import apicompute.RequestStat;
import apicompute.storage.MetricsStorage;
import apicompute.viewer.StatViewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @create: 2020/3/4
 * @author: altenchen
 */
public abstract class ScheduledReporter {

    private static final long MAX_STAT_DURATION_IN_MILLIS = 10 * 60 * 1000; //将长的统计时间拆分为10分钟一段进行统计

    protected MetricsStorage metricsStorage;

    protected Aggregator aggregator;

    protected StatViewer viewer;

    public ScheduledReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }

    protected void doStatAndReport(long startTimeInMillis, long endTimeInMillis) {
//        long durationInMillis = endTimeInMillis - startTimeInMillis;
//        Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
//        Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos, durationInMillis);

        Map<String, RequestStat> aggregatedStats = doStat(startTimeInMillis, endTimeInMillis);
        viewer.output(aggregatedStats, startTimeInMillis, endTimeInMillis);
    }

    private Map<String, RequestStat> doStat(long startTimeInMillis, long endTimeInMillis) {
        Map<String, List<RequestStat>> segmentStats = new HashMap<>();
        long segmentStartTimeInMillis = startTimeInMillis;
        while (segmentStartTimeInMillis < endTimeInMillis) {
            long segmentEndTimeInMillis = segmentStartTimeInMillis + MAX_STAT_DURATION_IN_MILLIS;
            if (segmentEndTimeInMillis > endTimeInMillis) {
                segmentEndTimeInMillis = endTimeInMillis;
            }
            Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(segmentStartTimeInMillis, segmentEndTimeInMillis);
            if (requestInfos == null || requestInfos.isEmpty()) {
                continue;
            }
            Map<String, RequestStat> segmentStat = aggregator.aggregate(requestInfos, segmentEndTimeInMillis - segmentStartTimeInMillis);
            addStat(segmentStats, segmentStat);
            segmentStartTimeInMillis += MAX_STAT_DURATION_IN_MILLIS;
        }
        long durationInMillis = endTimeInMillis - startTimeInMillis;
        Map<String, RequestStat> aggregatedStats = aggregateStats(segmentStats, durationInMillis);
        return aggregatedStats;
    }

    private void addStat(Map<String, List<RequestStat>> segmentStats, Map<String, RequestStat> segmentStat) {
        for (Map.Entry<String, RequestStat> entry : segmentStat.entrySet()) {
            String apiName = entry.getKey();
            RequestStat stat = entry.getValue();
            List<RequestStat> requestList = segmentStats.putIfAbsent(apiName, new ArrayList<>());
            requestList.add(stat);
        }
    }

    private Map<String, RequestStat> aggregateStats(Map<String, List<RequestStat>> segmentStats, long durationInMillis) {
        Map<String, RequestStat> aggregatedStats = new HashMap<>();
        for (Map.Entry<String, List<RequestStat>> entry : segmentStats.entrySet()) {
            String apiName = entry.getKey();
            List<RequestStat> apiStats = entry.getValue();
            double maxRespTime = Double.MIN_VALUE;
            double minRespTime = Double.MAX_VALUE;
            long count = 0;
            double sumRespTime = 0.0D;
            for (RequestStat stat : apiStats) {
                if (stat.getMaxResponseTime() > maxRespTime) {
                    maxRespTime = stat.getMaxResponseTime();
                }
                if (stat.getMinResponseTime() < minRespTime) {
                    minRespTime = stat.getMinResponseTime();
                }
                count += stat.getCount();
                sumRespTime += (stat.getCount() * stat.getAvgResponseTime());
            }
            RequestStat aggregatedStat = new RequestStat();
            aggregatedStat.setMaxResponseTime(maxRespTime);
            aggregatedStat.setMinResponseTime(minRespTime);
            aggregatedStat.setAvgResponseTime(sumRespTime / count);
            aggregatedStat.setCount(count);
            aggregatedStat.setTps(count / durationInMillis * 1000);
            aggregatedStats.put(apiName, aggregatedStat);
        }
        return aggregatedStats;
    }

}
