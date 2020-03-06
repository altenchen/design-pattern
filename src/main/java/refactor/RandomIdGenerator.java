package refactor;

import com.google.common.annotations.VisibleForTesting;
import exception.IdGenerationFailureException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @description:
 * @create: 2020/2/25
 * @author: altenchen
 */
public class RandomIdGenerator implements LogTraceIdGenerator{

    private static final Logger logger = LoggerFactory.getLogger(RandomIdGenerator.class);

    @Override
    public String generate() throws IdGenerationFailureException {
        String lastfieldOfHostName = null;
        try {
            lastfieldOfHostName = getLastfieldOfHostName();
        } catch (UnknownHostException e) {
            throw new IdGenerationFailureException("host name is empty.");
        }
        String randomString = generateRandomAlphameric(8);
        String id = String.format("%s-%d-%s", lastfieldOfHostName, System.currentTimeMillis(), new String(randomString));
        System.out.println("randomId = [" + id + "]");
        return id;
    }

    /**
     * 产生随机字符串
     * @param length
     * @return
     */
    @VisibleForTesting
    protected String generateRandomAlphameric(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("...");
        }
        char[] randomChars = new char[8];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            /*ascii=[48, 57],为0~9；ascii=[65, 90],为A~Z；ascii=[97, 122],为a~z*/
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char) (randomAscii);
                ++count;
            }
        }
        return new String(randomChars);
    }

    /**
     * 生成id头字符
     * @return
     */
    private String getLastfieldOfHostName() throws UnknownHostException {
        String hostName = InetAddress.getLocalHost().getHostName();
        if (hostName == null || hostName.isEmpty()) {
            throw new UnknownHostException("getLastfieldOfHostName 位置host异常");
        }
        String subStrOfHostName = getLastSubstrSplittedByDot(hostName);
        return subStrOfHostName;
    }

    /**
     * 获取用'.'分割后的最后一个字符
     * @param hostName
     * @return
     */
    @VisibleForTesting
    protected String getLastSubstrSplittedByDot(String hostName) {
        if (hostName == null || StringUtils.isEmpty(hostName)) {
            throw new IllegalArgumentException("getLastSubstrSplittedByDot 参数非法");
        }
        String[] tokens = hostName.split("\\.");
        String subStrOfHostName = tokens[tokens.length - 1];
        return subStrOfHostName;
    }


}
