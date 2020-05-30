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
    public void accept(Extractor extractor) {
        extractor.extract2txt(this);
    }
}
