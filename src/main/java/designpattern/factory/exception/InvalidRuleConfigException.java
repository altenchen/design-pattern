package designpattern.factory.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @description:
 * @create: 2020/3/12
 * @author: altenchen
 */
public class InvalidRuleConfigException extends Throwable {

    private static Logger logger = LoggerFactory.getLogger(InvalidRuleConfigException.class);

    public InvalidRuleConfigException(String exceptionMsg) {
        logger.error(exceptionMsg);
    }
}
