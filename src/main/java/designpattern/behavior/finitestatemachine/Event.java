package designpattern.behavior.finitestatemachine;

/**
 * @author altenchen
 * @time 2020/4/30
 * @description 功能
 */
public enum Event {
    GOT_MASHROOM(0),
    GOT_CAPE(1),
    GOT_FIRE(2),
    MET_MONSTER(3);
    
    private int value;
    
    private Event(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }}
