

public class Payment {

    private float total;
    private String selectPayment;
    private String customerLookup;
    private String rewardsLookup;
    private float tax;

    public Payment(float total, String selectPayment, String customerLookup, String rewardsLookup, float tax) {
        this.total = total;
        this.selectPayment = selectPayment;
        this.customerLookup = customerLookup;
        this.rewardsLookup = rewardsLookup;
        this.tax = tax;
    }


    /*
     * work in progress
     */
    public String getRewards() {
        return rewardsLookup;
    }

     /*
      * work in progress
     */

    public void rewardsEnroll() {
        rewardsLookup = "Enrolled";
    }

    public float getTotal() {
        return total;
    }

    public float showTotal() {
        System.out.println("Total: $" + total);
        return total;
    }


    /*
     * checks if the payment type is cash or card.
     */
    public void getPayment() {
        System.out.println("Payment type: " + selectPayment);
        if(selectPayment.equalsIgnoreCase("card")) {
            System.out.println("You have selected a card payment.");
        }
        else if(selectPayment.equalsIgnoreCase("cash")) {
            System.out.println("You have selected a cash payment.");
        }
        else {
            System.out.println("Error. Invalid payment type selected.");
        }


        }


        /*
         * verifies a correct payment was recieved.
         */
    public boolean verifyPayment(String selectPayment) {
        boolean  paymentVerification = false;
        if (selectPayment.equalsIgnoreCase("card") || selectPayment.equalsIgnoreCase("cash")) {
            paymentVerification = true;
        }
        return paymentVerification;

    }
    /*
     * generates a random 6-digit transaction number.
     */
    public String generateTransactionNumber() {
        int transactionNumber =  (int) (100000 + Math.random() * 900000);
        return String.valueOf(transactionNumber);
    }

    public void storeTransactionNumber(String transactionNumber) {
        System.out.println("Transaction Number: " + transactionNumber);
    }

    }
    




