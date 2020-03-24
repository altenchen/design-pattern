package designpattern.creation.factory.didemo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @create: 2020/3/22
 * @author: altenchen
 */
public class XmlBeanConfigParser implements BeanConfigParser {

    @Override
    public List<BeanDefinition> parse(InputStream inputStream) {
        String content = null;
        //TODO
        return parse(content);
    }

    @Override
    public List<BeanDefinition> parse(String configContent) {
        List<BeanDefinition> beanDefinitions = new ArrayList<>();
        //TODO
        return beanDefinitions;
    }
}
