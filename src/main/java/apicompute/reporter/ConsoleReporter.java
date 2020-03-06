package apicompute.reporter;

import apicompute.Aggregator;
import apicompute.RequestInfo;
import apicompute.RequestStat;
import apicompute.storage.MetricsStorage;
import apicompute.storage.RedisMetricsStorage;
import apicompute.viewer.ConsoleViewer;
import apicompute.viewer.StatViewer;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @description:
 * @create: 2020/2/24
 * @author: altenchen
 */
public class ConsoleReporter extends ScheduledReporter{

    private MetricsStorage metricsStorage;

    private Aggregator aggregator;

    private StatViewer viewer;

    private ScheduledExecutorService executor;

    public ConsoleReporter() {
        this(new RedisMetricsStorage(), new Aggregator(), new ConsoleViewer());
    }

    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
//        this.metricsStorage = metricsStorage;
//        this.aggregator = aggregator;
//        this.viewer = viewer;
        super(metricsStorage, aggregator, viewer);
        this.executor = new ScheduledThreadPoolExecutor(1);
    }

    public void startRepeatedReport(long periodInSeconds, final long durationInSeconds) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                //第1个代码逻辑：根据给定的时间区间，从数据库中拉取数据
                long durationInMillins = durationInSeconds * 1000;
                long endTimeInMillins = System.currentTimeMillis();
                long startTimeInMillins = endTimeInMillins - durationInMillins;
                doStatAndReport(startTimeInMillins, endTimeInMillins);
            }
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }

}
