package designpattern.behavior.visitor;

/**
 * @description:
 * @create: 2020/5/30
 * @author: altenchen
 */
public class Extractor {
    public void extract2txt(PPTFile pptFile) {
        System.out.println("Extract PPT.");
    }

    public void extract2txt(PdfFile pdfFile) {
        System.out.println("Extract PDF.");
    }

    public void extract2txt(WordFile wordFile) {
        System.out.println("Extract WORD.");
    }


}
