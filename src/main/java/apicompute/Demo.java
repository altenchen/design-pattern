//package apicompute;
//
///**
// * @description:
// * @create: 2020/2/24
// * @author: altenchen
// */
//public class Demo {
//
//    public static void main(String[] args) {
//        MetricsStorage storage = new RedisMetricsStorage();
//        ConsoleReporter consoleReporter = new ConsoleReporter(storage);
//        consoleReporter.startRepeatedReport(60, 60);
//
//        EmailReporter emailReporter = new EmailReporter(storage);
//        emailReporter.addToAddresses("altenchen@aliyun.com");
//        emailReporter.startDailyReport();
//
//        MetricsCollector collector = new MetricsCollector(storage);
//        collector.recordRequest(new RequestInfo("register1", 10, 10));
//        collector.recordRequest(new RequestInfo("register2", 20, 20));
//        collector.recordRequest(new RequestInfo("register3", 30, 30));
//        collector.recordRequest(new RequestInfo("register4", 40, 40));
//
//        try {
//            Thread.sleep(100000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//
//
//
//    }
//}
