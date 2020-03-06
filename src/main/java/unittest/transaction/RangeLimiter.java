package unittest.transaction;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertTrue;

/**
 * @description:
 * @create: 2020/2/25
 * @author: altenchen
 */
public class RangeLimiter {

    private static AtomicInteger position = new AtomicInteger(0);

    public static final int MAX_LIMIT = 5;

    public static final int MIN_LIMIT = -5;

    public static boolean move(int delta) {
        int currentPos = position.addAndGet(delta);
        boolean betweenRange = ((currentPos <= MAX_LIMIT) && (currentPos >= MIN_LIMIT));
        return betweenRange;
    }

    public static void main(String[] args) {
        testMove_betweenRange();
        testMove_exceedRange();
    }

    private static void testMove_betweenRange() {
        RangeLimiter rangeLimiter = new RangeLimiter();
        assertTrue(move(1));
        assertTrue(move(3));
        assertTrue(move(-5));
    }

    private static void testMove_exceedRange() {
        RangeLimiter rangeLimiter = new RangeLimiter();
        assertTrue(move(6));
    }



}
