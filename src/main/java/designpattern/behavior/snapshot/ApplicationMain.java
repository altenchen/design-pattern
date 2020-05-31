package designpattern.behavior.snapshot;

import java.util.Scanner;

/**
 * @description:
 * @create: 2020/5/31
 * @author: altenchen
 */
public class ApplicationMain {
    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals(":list")) {
                System.out.println(inputText.toString());
            } else if (input.equals(":undo")) {
                SnapShot snapshop = snapshotHolder.popSnapshop();
                inputText.restoreSnapshot(snapshop);
            } else {
                snapshotHolder.pushSnapshot(inputText.createSnapshot());
                inputText.append(input);
            }
        }
    }
}
