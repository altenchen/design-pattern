package designpattern.behavior.finitestatemachine;

import designpattern.behavior.finitestatemachine.statepattern.IMario;
import designpattern.behavior.finitestatemachine.statepattern.SmallMario;

/**
 * @author altenchen
 * @time 2020/4/30
 * @description 功能
 */
public class MarioStateMachine {
    private int score;
    private IMario currentState; //不再使用枚举类来表示状态
    
    public MarioStateMachine() {
        this.score = 0;
        this.currentState = new SmallMario(this);
    }
    
    public void obtainMushRoom() {
        this.currentState.obtainMushRoom();
    }
    
    public void obtainCape() {
        this.currentState.obtainCape();
    }
    
    public void obtainFireFlower() {
        this.currentState.obtainFireFlower();
    }
    
    public void meetMonster() {
        this.currentState.meetMonster();
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public State getCurrentState() {
        return currentState.getName();
    }
    
    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }
}
