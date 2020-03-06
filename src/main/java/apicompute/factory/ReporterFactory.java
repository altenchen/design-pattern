package apicompute.factory;

import apicompute.Aggregator;
import apicompute.reporter.ConsoleReporter;
import apicompute.storage.MetricsStorage;
import apicompute.viewer.ConsoleViewer;

/**
 * @description:
 * @create: 2020/3/4
 * @author: altenchen
 */
public class ReporterFactory {

    public static ConsoleReporter consoleConsoleReporter(MetricsStorage storage) {
        Aggregator aggregator = new Aggregator();
        return new ConsoleReporter(storage, aggregator, new ConsoleViewer());
    }


}
