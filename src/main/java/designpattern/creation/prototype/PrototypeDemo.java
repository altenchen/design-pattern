package designpattern.creation.prototype;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @create: 2020/3/24
 * @author: altenchen
 */
public class PrototypeDemo {

    private HashMap<String, SearchWord> currentKeywords = new HashMap<String, SearchWord>();

    public void refresh() {
        LinkedHashMap<String, SearchWord> newKeywords = new LinkedHashMap<>();

        //从数据库中取出所有的数据，放入到newKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords();
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            newKeywords.put(searchWord.getKeyword(), searchWord);
        }

        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords() {
        //TODO:从数据库中取出所有数据
        return null;
    }

}
