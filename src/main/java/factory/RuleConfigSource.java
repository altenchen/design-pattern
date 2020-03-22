package factory;

import designpattern.factory.RuleConfig;
import designpattern.factory.exception.InvalidRuleConfigException;
import designpattern.factory.parser.IRuleConfigParser;
import factory.factorymethod.IRuleConfigParserFactory;
import factory.factorymethod.RuleConfigParserFactoryMap;

/**
 * @description:
 * @create: 2020/3/12
 * @author: altenchen
 */
public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) throws InvalidRuleConfigException {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        //简单工厂实现
//        IRuleConfigParser parser = RuleConfigParserFactory.createParser(ruleConfigFileExtension);
        //工厂方法实现
        IRuleConfigParserFactory parserFactory = RuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);

        if (parserFactory == null) {
            throw new InvalidRuleConfigException(
                    "Rule config file format is not supported: " + ruleConfigFilePath);
        }

        IRuleConfigParser parser = parserFactory.createParser();

        String configText = "";
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json,返回json
        return "json";
    }


}
