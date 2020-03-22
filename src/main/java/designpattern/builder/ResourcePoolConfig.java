package designpattern.builder;


import org.apache.commons.lang.StringUtils;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @description:
 * @create: 2020/3/22
 * @author: altenchen
 */
public class ResourcePoolConfig {

    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MAX_IDEL = 8;
    private static final int DEFAULT_MIN_IDLE = 0;

    private String name;
    private int maxTotal = DEFAULT_MAX_TOTAL;
    private int maxIdel = DEFAULT_MAX_IDEL;
    private int minIdel = DEFAULT_MIN_IDLE;

    public ResourcePoolConfig(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("name should not be empty.");
        }
        this.name = name;
    }

    public void setMaxTotal(int maxTotal) {
        if (maxTotal <= 0) {
            throw new IllegalArgumentException("maxTotal should be positive.");
        }
        this.maxTotal = maxTotal;
    }

    public void setMaxIdel(int maxIdel) {
        if (maxIdel <= 0) {
            throw new IllegalArgumentException("maxIdle should be positive.");
        }
        this.maxIdel = maxIdel;
    }

    public void setMinIdel(int minIdel) {
        if (minIdel <= 0) {
            throw new IllegalArgumentException("minIdel should be positive");
        }
        this.minIdel = minIdel;
    }

}
