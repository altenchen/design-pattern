package apicompute.viewer;

import apicompute.RequestStat;
import com.google.gson.Gson;

import java.util.Map;

/**
 * @description:
 * @create: 2020/3/3
 * @author: altenchen
 */
public class ConsoleViewer implements StatViewer {
    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills) {
        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMills + "]");
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestStats));
    }
}
