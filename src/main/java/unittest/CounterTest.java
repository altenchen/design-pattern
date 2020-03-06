package unittest;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @description:
 * @create: 2020/2/25
 * @author: altenchen
 */
public class CounterTest {


    public static void main(String[] args) {
//        computeWithTimer();
//        computeWithTimerInFixTime();
        computeWithSchedulerExecutorService();
    }

    //定时Timer
    private static void computeWithTimer() {
        new Timer("testTimer").schedule(new TimerTask() {
            int count = 0;
            @Override
            public void run() {
                long now = System.currentTimeMillis() / 1000;
                System.out.println("schedule timer test--[" + count++ + "], now = [" + now + "]");
            }
        }, 1000, 2000);
    }

    //定时Timer，指定开始时间
    private static void computeWithTimerInFixTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date startDate = dateFormat.parse("2020-02-25 02:43:00");
            long now = System.currentTimeMillis();
            if (now >= startDate.getTime()) {
                startDate = new Date(now);
            }
            TimerTask timerTask = new TimerTask() {
                int count = 0;
                @Override
                public void run() {
                    long now = System.currentTimeMillis() / 1000;
                    System.out.println("schedule timer fix starting time test--[" + count++ + "], now = [" + now + "]");
                }
            };

            if (now >= startDate.getTime()) {
                new Timer("testTimerWithFixStartingTime").scheduleAtFixedRate(timerTask, startDate, 2000);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //ScheduledExecutorService
    private static void computeWithSchedulerExecutorService() {

        ThreadFactory namedThreadPool = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                10,
                10L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(),
                namedThreadPool);

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);

        scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                long a = 0;
                for (long i = 0; i < 1000000000; i++) {
                    a++;
                }
                long now = System.currentTimeMillis() / 1000;
                System.out.println("schedule scheduleAtFixedRate test--[" + count++ + "], now = [" + now + "]");
            }
        }, 0, 2, TimeUnit.SECONDS);

        scheduledThreadPoolExecutor.scheduleWithFixedDelay(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                long a = 0;
                for (long i = 0; i < 1000000000; i++) {
                    a++;
                }
                long now = System.currentTimeMillis() / 1000;
                System.out.println("schedule scheduleWithFixedDelay test--[" + count++ + "], now = [" + now + "]");
            }
        }, 0, 2, TimeUnit.SECONDS);

    }





}
