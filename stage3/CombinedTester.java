import java.util.ArrayList;

public class CombinedTester {
    public static void main(String[] args) {
        // Test StoreInfo
        System.out.println("Testing StoreInfo:");
        StoreInfo store = new StoreInfo();
        store.showName();
        store.showAddress();
        store.showHours();
        System.out.println();

        // Test Rewards
        System.out.println("Testing Rewards:");
        ArrayList<String> rewardsDataBase = new ArrayList<>();
        Rewards rewards = new Rewards("00001", (short) 100, (short) 500, rewardsDataBase);
        rewards.createRewardNumber();
        rewards.createRewardNumber();
        System.out.println("Rewards Database: " + rewardsDataBase);
        rewards.showRewardNumber(0);
        rewards.showRewardNumber(1);
        rewards.addRewardPoint((short) 50);
        rewards.showRewardPoint();
        rewards.removeRewardPoint((short) 30);
        rewards.showRewardPoint();
        rewards.deleteRewardNumber("00001");
        System.out.println("Rewards Database after deletion: " + rewardsDataBase);
        System.out.println();

        // Test Payment
        System.out.println("Testing Payment:");
        Payment payment = new Payment(100.0f, "card", "Customer123", "Not Enrolled", 8.25f);
        payment.showTotal();
        payment.getPayment();
        boolean isPaymentVerified = payment.verifyPayment("card");
        System.out.println("Payment verified: " + isPaymentVerified);
        String transactionNumber = payment.generateTransactionNumber();
        payment.storeTransactionNumber(transactionNumber);
        System.out.println("Rewards status before enrollment: " + payment.getRewards());
        payment.rewardsEnroll();
        System.out.println("Rewards status after enrollment: " + payment.getRewards());
        System.out.println();

        // Test Purchase
        System.out.println("Testing Purchase:");
        Purchase purchase = new Purchase("Laptop", "12345", 999.99f, "10", "2");
        purchase.showItem();
        float subtotal = purchase.getSubtotal();
        System.out.println("Subtotal: $" + subtotal);
        purchase.removeItem("3");
        purchase.showItem();
        purchase.removeItem("8");
        purchase.updateItemQuantity("5");
        purchase.showItem();
        purchase.updateItemQuantity("-20");
    }
}