package designpattern.behavior.responsibilitychain.sensitivefliterdemo;

/**
 * @author altenchen
 * @time 2020/4/28
 * @description 功能
 */
public class ApplicationDemo {
    
    public static void main(String[] args) {
        SensitiveWordFilterChain filterChain = new SensitiveWordFilterChain();
        filterChain.addFliter(new SexyWordFilter());
        filterChain.addFliter(new AdsWordFilter());
        filterChain.addFliter(new PoliticalWordFilter());
    
        boolean legal = filterChain.filter(new Content());
        
        if (legal) {
            //发表...
        } else {
            //不发表...
        }
    
    }
    
}
