package apicompute.reporter;

import apicompute.Aggregator;
import apicompute.RequestInfo;
import apicompute.RequestStat;
import apicompute.storage.MetricsStorage;
import apicompute.viewer.StatViewer;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @create: 2020/3/4
 * @author: altenchen
 */
public abstract class ScheduledReporter {

    protected MetricsStorage metricsStorage;

    protected Aggregator aggregator;

    protected StatViewer viewer;

    public ScheduledReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }

    protected void doStatAndReport(long startTimeInMillis, long endTimeInMillis) {
        long durationInMillis = endTimeInMillis - startTimeInMillis;
        Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
        Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos, durationInMillis);
        viewer.output(requestStats, startTimeInMillis, endTimeInMillis);
    }

}
