package designpattern.behavior.finitestatemachine;

/**
 * @author altenchen
 * @time 2020/4/30
 * @description 功能
 */
public class MarioStateMachine {

    private int score;
    private State currentState;
    
    public MarioStateMachine() {
        this.score = 0;
        this.currentState = State.SAMLL;
    }
    
    public void obtainMushRoom() {
        //TODO
    }
    
    public void obtainCape() {
        //TODO
    }
    
    public void obtainFireFlower() {
        //TODO
    }
    
    private void meetMonster() {
        //TODO
    }
    
    public int getScore() {
        return this.score;
    }
    
    public State getCurrentState() {
        return this.currentState;
    }
}
