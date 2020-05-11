package designpattern.behavior.iterator;

import java.util.ArrayList;

/**
 * @author altenchen
 * @time 2020/5/11
 * @description 功能
 */
public class Demo {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("kobe");
        names.add("paul");
        names.add("jordan");
    
        ArrayIterator<String> iterator = new ArrayIterator<>(names);
        while (iterator.hasNext()) {
            System.out.println("elem=> " + iterator.currentItem());
            iterator.next();
        }
    }

}
