package designpattern.behavior.templatemethod.callback;

/**
 * @author altenchen
 * @time 2020/4/30
 * @description 功能
 */
public class ClassA {
    
    public static void main(String[] args) {
        ClassB classB = new ClassB();
        classB.process(new ICallBack() { //回调对象
            @Override
            public void methodToCallBack() {
                System.out.println("Call back me...");
            }
        });
    }

}
