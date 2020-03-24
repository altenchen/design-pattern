package designpattern.creation.factory.simple;

import designpattern.creation.factory.exception.InvalidRuleConfigException;
import designpattern.creation.factory.parser.YamlRuleConfigParser;
import designpattern.creation.factory.parser.IRuleConfigParser;
import designpattern.creation.factory.parser.JsonRuleConfigParser;
import designpattern.creation.factory.parser.XmlRuleConfigParser;

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
