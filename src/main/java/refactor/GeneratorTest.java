package refactor;

import exception.IdGenerationFailureException;

/**
 * @description:
 * @create: 2020/2/25
 * @author: altenchen
 */
public class GeneratorTest {

    public static void main(String[] args) throws IdGenerationFailureException {

        new RandomIdGenerator().generate();

    }

}
