package designpattern.behavior.state;

/**
 * @author altenchen
 * @time 2020/4/30
 * @description 功能
 */
public class ApplicationDemo {
    
    public static void main(String[] args) {
        MarioStateMachine mario = new MarioStateMachine();
        mario.obtainMushRoom();
        mario.meetMonster();
        mario.obtainCape();
        int score = mario.getScore();
        State state = mario.getCurrentState();
        System.out.println("mario score: " + score + "; mario state: " + state);
    }
}
