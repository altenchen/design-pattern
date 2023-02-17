package designpattern.behavior.statemachine.statepattern;

import designpattern.behavior.statemachine.MarioStateMachine;
import designpattern.behavior.statemachine.State;

/**
 * @author altenchen
 * @time 2020/5/9
 * @description 功能  所有状态类的接口
 */
public interface IMario {
    State getName();
    //以下是定义的事件
    void obtainMushRoom(MarioStateMachine stateMachine);
    void obtainCape(MarioStateMachine stateMachine);
    void obtainFireFlower(MarioStateMachine stateMachine);
    void meetMonster(MarioStateMachine stateMachine);
}
