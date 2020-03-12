package factory.parser;

import factory.RuleConfig;

/**
 * @description:
 * @create: 2020/3/12
 * @author: altenchen
 */
public interface IRuleConfigParser {


    RuleConfig parse(String configText);

}
