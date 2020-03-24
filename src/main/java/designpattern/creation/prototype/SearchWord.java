package designpattern.creation.prototype;

/**
 * @description:
 * @create: 2020/3/24
 * @author: altenchen
 */
public class SearchWord {

    private String keyword;
    private long lastUpdateTime;
    private long time;

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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
