package refactor;

import exception.IdGenerationFailureException;

/**
 * @description:
 * @create: 2020/2/25
 * @author: altenchen
 */
public interface IdGenerator {

    String generate() throws IdGenerationFailureException;
}
