package designpattern.creation.factory.didemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @description:
 * @create: 2020/3/12
 * @author: altenchen
 */
public class ClassPathXmlApplicationContext implements ApplicationContext{


    private BeansFactory beansFactory;
    private BeanConfigParser beanConfigParser;

    public ClassPathXmlApplicationContext(String configLocation) {
        this.beansFactory = new BeansFactory();
        this.beanConfigParser = new XmlBeanConfigParser();
        loadBeanDefinitions(configLocation);
    }

    private void loadBeanDefinitions(String configuration) {
        InputStream in = null;
        try {
            in = this.getClass().getResourceAsStream("/" + configuration);
            if (in == null) {
                throw new RuntimeException("Can not find config file: " + configuration);
            }
            List<BeanDefinition> beanDefinitions = beanConfigParser.parse(in);
            beansFactory.addBeanDefinitions(beanDefinitions);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    //TODO: log error
                }
            }
        }
    }


    @Override
    public Object getBean(String beanId) {
        return beansFactory.getBean(beanId);
    }
}
