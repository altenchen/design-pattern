package apicompute.viewer;

import apicompute.RequestStat;

import java.util.Map;

/**
 * @description:
 * @create: 2020/3/3
 * @author: altenchen
 */
public interface StatViewer {
    void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills);
}
