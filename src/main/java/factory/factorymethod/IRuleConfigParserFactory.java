package factory.factorymethod;

import factory.parser.IRuleConfigParser;

/**
 * @description:
 * @create: 2020/3/12
 * @author: altenchen
 */
public interface IRuleConfigParserFactory {

    IRuleConfigParser createParser();

}
