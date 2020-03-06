package exception;

import org.apache.commons.lang.StringUtils;

/**
 * @description:
 * @create: 2020/2/27
 * @author: altenchen
 */
public class IdGenerationFailureException extends Throwable{

    public IdGenerationFailureException(String str) {
        System.out.println(str);
    }
}
