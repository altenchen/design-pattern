package apicompute.storage;

import apicompute.RequestInfo;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @create: 2020/2/24
 * @author: altenchen
 */
public interface MetricsStorage {

    void saveRequestInfo(RequestInfo requestInfo);

    List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);


}
