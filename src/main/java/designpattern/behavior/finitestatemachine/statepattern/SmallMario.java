package designpattern.behavior.finitestatemachine.statepattern;

import designpattern.behavior.finitestatemachine.MarioStateMachine;
import designpattern.behavior.finitestatemachine.State;

/**
 * @author altenchen
 * @time 2020/5/9
 * @description 功能
 */
public class SmallMario implements IMario {
    private MarioStateMachine stateMachine;
    
    public SmallMario(MarioStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }
    
    @Override
    public State getName() {
        return State.SMALL;
    }
    
    @Override
    public void obtainMushRoom() {
        stateMachine.setCurrentState(new SuperMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore() + 100);
    }
    
    @Override
    public void obtainCape() {
        stateMachine.setCurrentState(new CapeMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore() + 200);
    }
    
    @Override
    public void obtainFireFlower() {
        stateMachine.setCurrentState(new FireMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore() + 300);
    }
    
    @Override
    public void meetMonster() {
        //...do nothing
    }
}
