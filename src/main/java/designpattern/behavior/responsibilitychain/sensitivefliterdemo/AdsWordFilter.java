package designpattern.behavior.responsibilitychain.sensitivefliterdemo;

/**
 * @author altenchen
 * @time 2020/4/28
 * @description 功能
 */
public class AdsWordFilter implements SensitiveWordFilter {
    @Override
    public boolean doFilter(Content content) {
        boolean legal = true;
        //...
        return legal;
    }
}
