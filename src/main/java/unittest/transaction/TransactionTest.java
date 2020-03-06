//package unittest.transaction;
//
//import javax.transaction.InvalidTransactionException;
//import java.util.UUID;
//
///**
// * @description:
// * @create: 2020/2/25
// * @author: altenchen
// */
//
//public class TransactionTest {
//    private String id;
//    private Long buyerId;
//    private Long sellerId;
//    private Long productId;
//    private String orderId;
//    private Long createTimestamp;
//    private Double amount;
//    private STATUS status;
//    private String walletTransactionId;
//
//    // ...get() methods...
//
//    public Transaction(String preAssignedId, Long buyerId, Long sellerId, Long productId, String orderId) {
//        if (preAssignedId != null && !preAssignedId.isEmpty()) {
//            this.id = preAssignedId;
//        } else {
////            this.id = RandomIdGenerator.generateTransactionId();
//            this.id = UUID.randomUUID().toString();
//        }
//        if (!this.id.startsWith("t_")) {
//            this.id = "t_" + preAssignedId;
//        }
//        this.buyerId = buyerId;
//        this.sellerId = sellerId;
//        this.productId = productId;
//        this.orderId = orderId;
//        this.status = STATUS.TO_BE_EXECUTD;
//        this.createTimestamp = System.currentTimeMillis();
//    }
//
//    public boolean execute() throws InvalidTransactionException {
//        if ((buyerId == null || (sellerId == null || amount < 0.0))) {
//            throw new InvalidTransactionException("InvalidTransactionException...");
//        }
//        if (status == STATUS.EXECUTED) return true;
//        boolean isLocked = false;
//        try {
//            isLocked = RedisDistributedLock.getSingletonIntance().lockTransction(id);
//            if (!isLocked) {
//                return false; // 锁定未成功，返回false，job兜底执行
//            }
//            if (status == STATUS.EXECUTED) return true; // double check
//            long executionInvokedTimestamp = System.currentTimeMillis();
//            if (executionInvokedTimestamp - createdTimestap > 14days) {
//                this.status = STATUS.EXPIRED;
//                return false;
//            }
//            WalletRpcService walletRpcService = new WalletRpcService();
//            String walletTransactionId = walletRpcService.moveMoney(id, buyerId, sellerId, amount);
//            if (walletTransactionId != null) {
//                this.walletTransactionId = walletTransactionId;
//                this.status = STATUS.EXECUTED;
//                return true;
//            } else {
//                this.status = STATUS.FAILED;
//                return false;
//            }
//        } finally {
//            if (isLocked) {
//                RedisDistributedLock.getSingletonIntance().unlockTransction(id);
//            }
//        }
//    }
//}
