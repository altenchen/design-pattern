package designpattern.creation.prototype;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @create: 2020/3/24
 * @author: altenchen
 */
public class PrototypeDemo {

    private ConcurrentHashMap<String, SearchWord> currentKeywords = new ConcurrentHashMap<String, SearchWord>();
    private long lastUpdateTime = -1;

    public void refresh() {
        // 从数据库中取出更新时间 > lastUpdateTime的数据，放入到currentKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdateTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdateTime) {
                maxNewUpdateTime = searchWord.getLastUpdateTime();
            }
            if (currentKeywords.containsKey(searchWord.getKeyword())) {
                currentKeywords.replace(searchWord.getKeyword(), searchWord);
            } else {
                currentKeywords.put(searchWord.getKeyword(), searchWord);
            }
        }

        lastUpdateTime = maxNewUpdateTime;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        //TODO:从数据库中取出更新时间 > lastUpdateTime的数据
        return null;
    }

}
