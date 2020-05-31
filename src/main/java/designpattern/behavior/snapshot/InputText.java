package designpattern.behavior.snapshot;

/**
 * @description:
 * @create: 2020/5/31
 * @author: altenchen
 */
public class InputText {
    private StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    public void append(String input) {
        text.append(input);
    }

    public SnapShot createSnapshot() {
        return new SnapShot(text.toString());
    }

    public void restoreSnapshot(SnapShot snapshot) {
        this.text.replace(0, this.text.length(), snapshot.getText());
    }

    @Override
    public String toString() {
        return text.toString();
    }
}
