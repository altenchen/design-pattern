package designpattern.creation.factory.factorymethod;

import designpattern.creation.factory.parser.YamlRuleConfigParser;
import designpattern.creation.factory.parser.IRuleConfigParser;

/**
 * @description:
 * @create: 2020/3/12
 * @author: altenchen
 */
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}
