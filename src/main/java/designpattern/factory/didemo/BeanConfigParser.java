package designpattern.factory.didemo;

import java.io.InputStream;
import java.util.List;

/**
 * @description:
 * @create: 2020/3/22
 * @author: altenchen
 */
public interface BeanConfigParser {

    List<BeanDefinition> parse(InputStream inputStream);

    List<BeanDefinition> parse(String configContent);

}
