package designpattern.behavior.finitestatemachine.statepattern;

import designpattern.behavior.finitestatemachine.MarioStateMachine;
import designpattern.behavior.finitestatemachine.State;

/**
 * @author altenchen
 * @time 2020/5/9
 * @description 功能
 */
public class SuperMario implements IMario {
    private static final SuperMario instance = new SuperMario();
    
    private SuperMario() {
    }
    
    public static SuperMario getInstance() {
        return instance;
    }
    
    @Override
    public State getName() {
        return State.SUPER;
    }
    
    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        //do nothing
    }
    
    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(CapeMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 200);
    }
    
    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(FireMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 300);
    }
    
    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 100);
    }
}
