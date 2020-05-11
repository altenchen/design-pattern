package designpattern.behavior.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author altenchen
 * @time 2020/5/11
 * @description 功能
 */
public class ApplicationDemo {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("kobe");
        names.add("paul");
        names.add("jordan");
        names.add("james");
    
        ArrayIterator<String> iterator = new ArrayIterator<>(names);
        while (iterator.hasNext()) {
            System.out.println("elem=> " + iterator.currentItem());
            iterator.next();
        }
    
        Iterator<String> iterator1 = names.iterator();
        Iterator<String> iterator2 = names.iterator();
        
        iterator1.next();
        iterator1.remove();
//        iterator1.next();
        iterator2.next();
    }

}
