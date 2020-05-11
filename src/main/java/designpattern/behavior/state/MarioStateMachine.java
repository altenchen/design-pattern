package designpattern.behavior.state;

import designpattern.behavior.state.statepattern.IMario;
import designpattern.behavior.state.statepattern.SmallMario;

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
        this.currentState = SmallMario.getInstance();
    }
    
    public void obtainMushRoom() {
        this.currentState.obtainMushRoom(this);
    }
    
    public void obtainCape() {
        this.currentState.obtainCape(this);
    }
    
    public void obtainFireFlower() {
        this.currentState.obtainFireFlower(this);
    }
    
    public void meetMonster() {
        this.currentState.meetMonster(this);
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
