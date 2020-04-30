package designpattern.behavior.finitestatemachine;

import com.sun.scenario.effect.impl.prism.PrImage;

/**
 * @author altenchen
 * @time 2020/4/30
 * @description 功能
 */
public enum State {
    SAMLL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);
    
    private int value;
    
    private State(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
}

