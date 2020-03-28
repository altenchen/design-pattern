package designpattern.creation.prototype;

/**
 * @description:
 * @create: 2020/3/24
 * @author: altenchen
 */
public class SearchWord {

    private String keyword;
    private long lastUpdateTime;
    private long count;

    public SearchWord(String keyword, long lastUpdateTime, long count) {
        this.keyword = keyword;
        this.lastUpdateTime = lastUpdateTime;
        this.count = count;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long time) {
        this.count = time;
    }
}
