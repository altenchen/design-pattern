package apicompute;

import apicompute.reporter.ConsoleReporter;
import apicompute.reporter.EmailReporter;
import apicompute.storage.MetricsStorage;
import apicompute.storage.RedisMetricsStorage;
import apicompute.viewer.ConsoleViewer;
import apicompute.viewer.EmailViewer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @create: 2020/3/3
 * @author: altenchen
 */
public class PerfCounterTest {

    public static void main(String[] args) {

        //定时触发统计并将结果显示到终端
        ConsoleReporter consoleReporter = new ConsoleReporter();
        consoleReporter.startRepeatedReport(60, 60);

        //定时触发统计并将结果输出到邮件
        List<String> emailToAddresses = new ArrayList<>();
        emailToAddresses.add("altenchen@aliyun.com");
        EmailReporter emailReporter = new EmailReporter(emailToAddresses);
        emailReporter.startDailyReport();

        //收集接口访问数据
        MetricsCollector collector = new MetricsCollector();
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12334));
        collector.recordRequest(new RequestInfo("login", 23, 12434));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
