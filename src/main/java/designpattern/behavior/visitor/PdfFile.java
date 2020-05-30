package designpattern.behavior.visitor;

/**
 * @description:
 * @create: 2020/5/30
 * @author: altenchen
 */
public class PdfFile extends ResourceFile {
    public PdfFile(String filePath) {
        super(filePath);
    }

    @Override
    public void extract2txt() {
        System.out.println("Extract PDF.");
    }
}
