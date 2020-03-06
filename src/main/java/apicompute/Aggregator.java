package apicompute;



import java.util.*;

/**
 * @description:
 * @create: 2020/2/24
 * @author: altenchen
 */
public class Aggregator {

    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {
        Map<String, RequestStat> requestStats = new HashMap<String, RequestStat>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfosPerApi = entry.getValue();
            RequestStat requestStat = doAggregate(requestInfosPerApi, durationInMillis);
            requestStats.put(apiName, requestStat);
        }
        return requestStats;
    }

    private RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {

        double maxRespTime = Double.MIN_VALUE;
        double minRespTime = Double.MAX_VALUE;
        double avgRespTime = -1;
        double p999RespTime = -1;
        double p99RespTime = -1;
        double sumRespTime = 0;
        long count = 0;

        List<Double> respTimes = new ArrayList<>();
        RequestStat requestStat = new RequestStat();
        for (RequestInfo requestInfo : requestInfos) {
            count++;
            double respTime = requestInfo.getResponseTime();
            respTimes.add(respTime);
            maxRespTime = max(maxRespTime, respTime);
            minRespTime = min(minRespTime, respTime);
            sumRespTime = sum(sumRespTime, respTime);
        }

        avgRespTime = avg(sumRespTime, count);
        p99RespTime = percentile(requestInfos, count)[0];
        p999RespTime = percentile(requestInfos, count)[1];

        requestStat.setMaxResponseTime(maxRespTime);
        requestStat.setMinResponseTime(minRespTime);
        requestStat.setAvgResponseTime(avgRespTime);
        requestStat.setP99ResponseTime(p99RespTime);
        requestStat.setP999ResponseTime(p999RespTime);
        requestStat.setCount(respTimes.size());
        requestStat.setTps(tps(durationInMillis, count));
        return requestStat;
    }


    private double[] percentile(List<RequestInfo> requestInfos, long count) {
        double p999RespTime = 0D;
        double p99RespTime = 0D;
        Collections.sort(requestInfos, new Comparator<RequestInfo>() {
            @Override
            public int compare(RequestInfo o1, RequestInfo o2) {
                double diff = o1.getResponseTime() - o2.getResponseTime();
                if (diff < 0) {
                    return -1;
                } else if (diff > 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        int idx999 = (int)(count * 0.999);
        int idx99 = (int)(count * 0.99);

        if (count != 0){
            p999RespTime = requestInfos.get(idx999).getResponseTime();
            p99RespTime = requestInfos.get(idx99).getResponseTime();
        }
        double[] doubles = new double[2];
        doubles[0] = p99RespTime;
        doubles[1] = p999RespTime;
        return doubles;
    }

    private long tps(long durationInMillis, long count) {
        return (long)(count / (durationInMillis * 1000));
    }

    private double avg(double sumRespTime, long count) {
        double avgRespTime = 0D;
        if (count != 0) {
            avgRespTime = sumRespTime / count;
        }
        return avgRespTime;
    }

    private double sum(double sumRespTime, double respTime) {
        sumRespTime += respTime;
        return sumRespTime;
    }

    private double min(double minRespTime, double respTime) {
        if (minRespTime > respTime) {
            minRespTime = respTime;
        }
        return minRespTime;
    }

    private double max(double maxRespTime, double respTime) {
        if (maxRespTime < respTime) {
            maxRespTime = respTime;
        }
        return maxRespTime;
    }


}
