package designpattern.creation.factory.factorymethod;

import designpattern.creation.factory.parser.IRuleConfigParser;
import designpattern.creation.factory.parser.XmlRuleConfigParser;

/**
 * @description:
 * @create: 2020/3/12
 * @author: altenchen
 */
public class YamlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
