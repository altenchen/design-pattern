package designpattern.behavior.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @create: 2020/5/30
 * @author: altenchen
 */
public class ToolApplication {
    public static void main(String[] args) {
        List<ResourceFile> resourceFiles = listAllResourceFiles(args[0]);
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.extract2txt();
        }
    }

    private static List<ResourceFile> listAllResourceFiles(String resourceDirectory) {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        //...根据后缀(pdf/ppt/word)由工厂方法创建不同的类对象(PdfFile/PPTFile/WordFile)
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new PdfFile("b.word"));
        resourceFiles.add(new PdfFile("c.ppt"));
        return resourceFiles;
    }

}
