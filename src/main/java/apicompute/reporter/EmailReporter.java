package apicompute.reporter;

import apicompute.Aggregator;
import apicompute.storage.MetricsStorage;
import apicompute.storage.RedisMetricsStorage;
import apicompute.viewer.EmailViewer;
import apicompute.viewer.StatViewer;

import java.util.*;

/**
 * @description:
 * @create: 2020/2/24
 * @author: altenchen
 */
public class EmailReporter extends ScheduledReporter{

    private static final long DAY_HOURS_IN_SECONDS = 86400L;

    private MetricsStorage metricsStorage;

    private Aggregator aggregator;

    private StatViewer viewer;

    public EmailReporter(List<String> toAddresses) {
        this(new RedisMetricsStorage(), new Aggregator(), new EmailViewer(toAddresses));
    }

    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
//        this.metricsStorage = metricsStorage;
//        this.aggregator = aggregator;
//        this.viewer = viewer;
        super(metricsStorage, aggregator, viewer);
    }

    public void startDailyReport() {
        Date firstTime = trimTimeFieldsToZeroOfNextDay(new Date());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillins = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillins = System.currentTimeMillis();
                long startTimeInMillins = endTimeInMillins - durationInMillins;
                doStatAndReport(startTimeInMillins, endTimeInMillins);
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }

    // 设置成protected而非private是为了方便写单元测试
    protected Date trimTimeFieldsToZeroOfNextDay(Date date) {
        Calendar calendar = Calendar.getInstance(); //这里可以获取当前时间
        calendar.setTime(date); //重新设置时间
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

}
