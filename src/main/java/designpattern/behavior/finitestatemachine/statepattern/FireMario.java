package designpattern.behavior.finitestatemachine.statepattern;

import designpattern.behavior.finitestatemachine.MarioStateMachine;
import designpattern.behavior.finitestatemachine.State;

/**
 * @author altenchen
 * @time 2020/5/9
 * @description 功能
 */
public class FireMario implements IMario {
    private MarioStateMachine stateMachine;
    
    public FireMario(MarioStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }
    
    @Override
    public State getName() {
        return State.FIRE;
    }
    
    @Override
    public void obtainMushRoom() {
        //do nothing...
    }
    
    @Override
    public void obtainCape() {
        //do nothing...
    }
    
    @Override
    public void obtainFireFlower() {
        //do nothing
    }
    
    @Override
    public void meetMonster() {
        stateMachine.setCurrentState(new SmallMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore() - 100);
    }
}
