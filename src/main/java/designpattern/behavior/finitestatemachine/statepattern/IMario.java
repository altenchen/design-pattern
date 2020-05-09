package designpattern.behavior.finitestatemachine.statepattern;

import designpattern.behavior.finitestatemachine.State;

/**
 * @author altenchen
 * @time 2020/5/9
 * @description 功能  所有状态类的接口
 */
public interface IMario {
    State getName();
    //以下是定义的事件
    void obtainMushRoom();
    void obtainCape();
    void obtainFireFlower();
    void meetMonster();
}
