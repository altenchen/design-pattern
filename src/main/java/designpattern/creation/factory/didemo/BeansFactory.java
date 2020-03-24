package designpattern.creation.factory.didemo;

import com.google.common.annotations.VisibleForTesting;
import designpattern.creation.factory.exception.BeanCreationFailureException;
import designpattern.creation.factory.exception.NoSuchBeanDefinitionException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @create: 2020/3/22
 * @author: altenchen
 */
public class BeansFactory {

    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap<>();

    public void addBeanDefinitions(List<BeanDefinition> beanDefinitionList) {
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            this.beanDefinitions.putIfAbsent(beanDefinition.getId(), beanDefinition);
        }

        for (BeanDefinition beanDefinition : beanDefinitionList) {
            if (beanDefinition.isLazyInit() == false && beanDefinition.isSingleton()) {
                try {
                    createBean(beanDefinition);
                } catch (BeanCreationFailureException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Object getBean(String beanId) {
        BeanDefinition beanDefinition = beanDefinitions.get(beanId);
        try {
            if (beanDefinition == null) {
                throw new NoSuchBeanDefinitionException("Bean is not defined: " + beanId);
            }
            return createBean(beanDefinition);
        } catch (NoSuchBeanDefinitionException | BeanCreationFailureException e) {
            //TODO error log
        }
        return null;
    }

    /**
     * 递归的createBean方法可能由于循环调用导致堆栈溢出
     * 1. 研究了Spring容器中处理循环依赖的知识点：
     * （1）只能处理单例的、setter注入的循环依赖，其他的注入模式无法处理；
     * （2）依赖缓存处理循环依赖，关键思想是，将正在创建中的对象提前暴露一个单例工厂，让其他实例可以引用到
     * 2. 网上一篇比较好的文章：https://juejin.im/post/5d0d8f64f265da1b7b3193ac
     * @param beanDefinition
     * @return
     * @throws BeanCreationFailureException
     */
    @VisibleForTesting
    protected Object createBean(BeanDefinition beanDefinition) throws BeanCreationFailureException {
        if (beanDefinition.isSingleton() && singletonObjects.containsKey(beanDefinition.getId())) {
            return singletonObjects.get(beanDefinition.getId());
        }

        Object bean = null;
        try {
            Class beanClass = Class.forName(beanDefinition.getClassName());
            List<BeanDefinition.ConstructorArg> args = beanDefinition.getConstructorArgs();
            if (args.isEmpty()) {
                bean = beanClass.newInstance();
            } else {
                Class[] argClasses = new Class[args.size()];
                Object[] argObjects = new Object[args.size()];
                for (int i = 0; i < args.size(); i++) {
                    BeanDefinition.ConstructorArg arg = args.get(i);
                    if (!arg.isRef()) {
                        argClasses[i] = arg.getType();
                        argObjects[i] = arg.getArg();
                    } else {
                        BeanDefinition refBeanDefinition = beanDefinitions.get(arg.getArg());
                        if (refBeanDefinition == null) {
                            throw new NoSuchBeanDefinitionException("Bean is not defined: " + arg.getArg());
                        }
                        argClasses[i] = Class.forName(refBeanDefinition.getClassName());
                        argObjects[i] = createBean(refBeanDefinition);
                    }
                }
                bean = beanClass.getConstructor(argClasses).newInstance(argObjects);
            }
        } catch (ClassNotFoundException | IllegalAccessException
                | InstantiationException | NoSuchBeanDefinitionException
                | NoSuchMethodException | InvocationTargetException e) {
            throw new BeanCreationFailureException("", e);
        }

        if (bean != null && beanDefinition.isSingleton()) {
            singletonObjects.putIfAbsent(beanDefinition.getId(), bean);
            return singletonObjects.get(beanDefinition.getId());
        }
        return bean;
    }


}
