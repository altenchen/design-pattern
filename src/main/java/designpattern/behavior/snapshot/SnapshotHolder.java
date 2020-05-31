package designpattern.behavior.snapshot;

import java.util.Stack;

/**
 * @description:
 * @create: 2020/5/31
 * @author: altenchen
 */
public class SnapshotHolder {
    private Stack<SnapShot> snapshots = new Stack<>();

    public SnapShot popSnapshop() {
        return snapshots.pop();
    }

    public void pushSnapshot(SnapShot snapShot) {
        snapshots.push(snapShot);
    }
}
