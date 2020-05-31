package designpattern.behavior.snapshot;

/**
 * @description:
 * @create: 2020/5/31
 * @author: altenchen
 */
public class SnapShot {
    private String text;

    public SnapShot(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
