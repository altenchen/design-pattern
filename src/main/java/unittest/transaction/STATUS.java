package unittest.transaction;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @description:
 * @create: 2020/2/25
 * @author: altenchen
 */
public class STATUS {

    public static STATUS TO_BE_EXECUTD = new STATUS("TO_BE_EXECUTD");
    public static STATUS EXECUTED = new STATUS("TO_BE_EXECUTD");

    public STATUS(String STATUS) {

    }
}
