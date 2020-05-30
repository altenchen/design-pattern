package designpattern.behavior.visitor;

/**
 * @description:
 * @create: 2020/5/30
 * @author: altenchen
 */
public abstract class ResourceFile {
    protected String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    public abstract void accept(Extractor extractor);

}
