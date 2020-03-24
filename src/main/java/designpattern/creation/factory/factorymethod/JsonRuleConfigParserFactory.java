package designpattern.creation.factory.factorymethod;

import designpattern.creation.factory.parser.IRuleConfigParser;
import designpattern.creation.factory.parser.JsonRuleConfigParser;

/**
 * @description:
 * @create: 2020/3/12
 * @author: altenchen
 */
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
