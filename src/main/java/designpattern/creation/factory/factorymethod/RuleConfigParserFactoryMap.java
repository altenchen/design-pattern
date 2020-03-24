package designpattern.creation.factory.factorymethod;



import designpattern.creation.factory.exception.InvalidRuleConfigException;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @create: 2020/3/12
 * @author: altenchen
 */
public class RuleConfigParserFactoryMap{

    private static final Map<String, IRuleConfigParserFactory> cachedFactories = new HashMap<>();

    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory getParserFactory(String type) throws InvalidRuleConfigException {
        if (type == null || type.isEmpty()) {
            throw new InvalidRuleConfigException(type);
        }
        IRuleConfigParserFactory parserFactory = cachedFactories.get(type.toLowerCase());
        return parserFactory;
    }

}