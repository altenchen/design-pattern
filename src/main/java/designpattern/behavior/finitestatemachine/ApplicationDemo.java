package designpattern.behavior.finitestatemachine;

/**
 * @author altenchen
 * @time 2020/4/30
 * @description 功能
 */
public class ApplicationDemo {
    
    public static void main(String[] args) {
        MarioStateMachine mario = new MarioStateMachine();
        mario.obtainMushRoom();
        int score = mario.getScore();
        State state = mario.getCurrentState();
        System.out.println("mario score: " + score + "; mario state: " + state);
    }
}
