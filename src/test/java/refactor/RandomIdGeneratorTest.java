package refactor;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;

/**
 * @description:
 * @create: 2020/2/26
 * @author: altenchen
 */
public class RandomIdGeneratorTest {

    @Test
    public void testGetLastSubstrSplittedByDot() {
        RandomIdGenerator randomIdGenerator = new RandomIdGenerator();
        String actualStr = randomIdGenerator.getLastSubstrSplittedByDot("field1.field2.field3");
        Assert.assertEquals("field3", actualStr);

        actualStr = randomIdGenerator.getLastSubstrSplittedByDot("field");
        Assert.assertEquals("field", actualStr);

        actualStr = randomIdGenerator.getLastSubstrSplittedByDot("field#field2");
        Assert.assertEquals("field#field2", actualStr);
    }

    @Test
    public void testGetLastSubstrSplittedByDot_nullOrEmpty() {
        RandomIdGenerator randomIdGenerator = new RandomIdGenerator();
        String lastSubstrSplittedByDot = randomIdGenerator.getLastSubstrSplittedByDot(null);
        Assert.assertNull(lastSubstrSplittedByDot);

        String lastSubstrSplittedByDot1 = randomIdGenerator.getLastSubstrSplittedByDot("");
        Assert.assertEquals("", lastSubstrSplittedByDot1);
    }

    @Test
    public void testGenerateRandomAlphameric() {
        RandomIdGenerator randomIdGenerator = new RandomIdGenerator();
        String actualRandomString = randomIdGenerator.generateRandomAlphameric(8);
        Assert.assertNotNull(actualRandomString);
        Assert.assertEquals(8, actualRandomString.length());
        for (char c : actualRandomString.toCharArray()) {
            Assert.assertTrue((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
        }
    }

    @Test
    public void testGenerateRandomAlphameric_lengthEqualsOrLessThanZero() {
        RandomIdGenerator randomIdGenerator = new RandomIdGenerator();
        String actualRandomString = randomIdGenerator.generateRandomAlphameric(0);
        Assert.assertEquals("", actualRandomString);

        String s = randomIdGenerator.generateRandomAlphameric(-1);
        Assert.assertNull(s);
    }
}
