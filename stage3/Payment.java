
public class Payment {

    private float total;
    private String selectPayment;
    private String customerLookup;
    private String rewardsLookup;
    private float tax;


    /*
     * Constructor
     * @param float total, String selectPayment, String customerLookup, String rewardsLookup, float tax
     */
    public Payment(float total, String selectPayment, String customerLookup, String rewardsLookup, float tax) {
        this.total = total;
        this.selectPayment = selectPayment;
        this.customerLookup = customerLookup;
        this.rewardsLookup = rewardsLookup;
        this.tax = tax;
    }


    /*
     * returns the rewards status of the customer.
     * @return rewardsLookup
     */
    public String getRewards() {
        return rewardsLookup;
    }

    
    /*
     * changes the value of rewardsLookup to "Enrolled"
     */
    public void rewardsEnroll() {
        rewardsLookup = "Enrolled";
    }


    /*
     * Returns the total
     * @return float total
     */
    public float getTotal() {
        return total;
    }

    /*
     * Prints the total and returns the total.
     * @return float total
     */
    public float showTotal() {
        System.out.println("Total: $" + total);
        return total;
    }


    /*
     * Prints the payment type. checks whether the payment type is card or cash. 
     * If neither is selected, an error message is printed.
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
         * Verifies if the payment type is either card or cash.
         * If the payment type is valid paymentVerification is true, otherwise it is false.
         * @param String selectPayment
         * @return boolean paymentVerifiaction
         */
    public boolean verifyPayment(String selectPayment) {
        boolean  paymentVerification = false;
        if (selectPayment.equalsIgnoreCase("card") || selectPayment.equalsIgnoreCase("cash")) {
            paymentVerification = true;
        }
        return paymentVerification;

    }
    /*
     * Creates a random 6-digit transaction number and stores it in transactionNumber.
     * @return String transactionNumber
     */
    public String generateTransactionNumber() {
        int transactionNumber =  (int) (100000 + Math.random() * 900000);
        return String.valueOf(transactionNumber);
    }

    public void storeTransactionNumber(String transactionNumber) {
        System.out.println("Transaction Number: " + transactionNumber);
    }

    }
    




