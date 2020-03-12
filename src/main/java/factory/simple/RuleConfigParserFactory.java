package factory.simple;

import factory.exception.InvalidRuleConfigException;
import factory.parser.IRuleConfigParser;
import factory.parser.JsonRuleConfigParser;
import factory.parser.XmlRuleConfigParser;
import factory.parser.YamlRuleConfigParser;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @create: 2020/3/12
 * @author: altenchen
 */
public class RuleConfigParserFactory {

    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

    static {
        cachedParsers.put("json", new JsonRuleConfigParser());
        cachedParsers.put("xml", new XmlRuleConfigParser());
        cachedParsers.put("yaml", new YamlRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) throws InvalidRuleConfigException {
        if (configFormat == null || configFormat.isEmpty()) {
            throw new InvalidRuleConfigException(configFormat);
        }
        IRuleConfigParser parser = cachedParsers.get(configFormat);
        return parser;
    }
}
