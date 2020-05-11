package designpattern.behavior.state.statepattern;

import designpattern.behavior.state.MarioStateMachine;
import designpattern.behavior.state.State;

/**
 * @author altenchen
 * @time 2020/5/9
 * @description 功能
 */
public class CapeMario implements IMario {
    private static final CapeMario instance = new CapeMario();
    
    private CapeMario() {
    }
    
    public static CapeMario getInstance() {
        return instance;
    }
    
    @Override
    public State getName() {
        return State.CAPE;
    }
    
    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        //do nothing
    }
    
    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
        //do nothing
    }
    
    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        //do nothing
    }
    
    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 100);
    }
}
