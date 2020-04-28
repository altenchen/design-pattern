package designpattern.behavior.responsibilitychain.sensitivefliterdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author altenchen
 * @time 2020/4/28
 * @description 功能
 */
public class SensitiveWordFilterChain {
    
    List<SensitiveWordFilter> filters = new ArrayList<>();
    
    public void addFliter(SensitiveWordFilter filter) {
        this.filters.add(filter);
    }
    
    // return true if content doesn't contain sensitive words.
    public boolean filter(Content content) {
        for (SensitiveWordFilter filter : filters) {
            if (!filter.doFilter(content)) {
                return false;
            }
        }
        return true;
    }
    
}
