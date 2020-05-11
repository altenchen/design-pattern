package designpattern.behavior.iterator;

/**
 * @author altenchen
 * @time 2020/5/9
 * @description 功能
 */
public interface Iterator<E> {
    boolean hasNext();
    void next();
    E currentItem();
}
