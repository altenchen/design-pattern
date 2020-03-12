package factory.simple;

import factory.*;

/**
 * @description:
 * @create: 2020/3/12
 * @author: altenchen
 */
public class RuleConfigParserFactory {

    public static IRuleConfigParser createParser(String ruleConfigFilePath, String ruleConfigFileExtension) throws InvalidRuleConfigException {
        IRuleConfigParser parser = null;
        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equalsIgnoreCase(ruleConfigFileExtension)) {
            parser = new YamlRuleConfigParser();
        }
        return parser;
    }
}
