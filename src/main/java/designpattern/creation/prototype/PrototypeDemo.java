package designpattern.creation.prototype;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @create: 2020/3/24
 * @author: altenchen
 */
public class PrototypeDemo {

    private HashMap<String, SearchWord> currentKeywords = new HashMap<String, SearchWord>();
    private long lastUpdateTime = -1;

    public void refresh() {
        //原型模式就是这么简单，拷贝已有对象的数据，更新少量差值
        HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) deepCopy(currentKeywords);

        //从数据库中取出更新时间 > lastUpdateTime 的数据，更新少量差值
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (newKeywords.containsKey(searchWord.getKeyword())) {
                SearchWord oldSearchWord = newKeywords.get(searchWord.getKeyword());
                oldSearchWord.setCount(searchWord.getCount());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
            } else {
                newKeywords.put(searchWord.getKeyword(), searchWord);
            }
        }

        lastUpdateTime = maxNewUpdatedTime;
        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        //TODO:从数据库中取出更新时间 > lastUpdateTime 的数据
        return null;
    }

    /**
     * 先将对象序列化，然后再反序列化成新的对象
     * @param object
     * @return
     */
    public Object deepCopy(Object object) {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = null;
        try {
            oo = new ObjectOutputStream(bo);
            oo.writeObject(object);
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            try {
                Object res = oi.readObject();
                return res;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
