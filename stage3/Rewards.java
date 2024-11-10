import java.util.LinkedList;


public class Rewards {

    private String rewardNumber;
    private short rewardPoint;
    private short rewardPointMax;
    private LinkedList<String> rewardsDataBase;

    /*
     * Consructor
     * @param String rewardNumber, short rewardPoint, short rewardPointMax,LinkedList<String> rewardsDataBase
     */
    public Rewards(String rewardNumber, short rewardPoint, short rewardPointMax,LinkedList<String> rewardsDataBase) {
        this.rewardNumber = rewardNumber;
        this.rewardPoint = rewardPoint;
        this.rewardPointMax = rewardPointMax;
        this.rewardsDataBase = rewardsDataBase;

    }




    private short nextRewardNumber = 1;
    /*
     * Creates a 5-digit formatted number using nextRewaardNumber.
     * Adds the formattedRewardNumber to the RewardsDatabase and increments nextRewardNumber.
     * @return rewardsDatabase
     */
    public LinkedList<String> createRewardNumber() {
        String formattedRewardNumber = String.format("%05d", nextRewardNumber);
        rewardsDataBase.add(formattedRewardNumber);
        nextRewardNumber++;
        return rewardsDataBase;
    }

    /*
     * Returns thr reward number
     * @return rewardNumber
     */
    public String getRewardNumber() {
        return rewardNumber;
    }

    /*
     * gets an index to acces a specific reward number in rewardsDatabase.
     * If the index is valid, the reward number is printed. Otherwise, an error message is diplayed.
     * @param int index
     */
    public void showRewardNumber(int index) {
        if(index >= 0 && index < rewardsDataBase.size()) {
            System.out.println("Rewards number: " + rewardsDataBase.get(index));
        }
        else{
            System.out.println("Error. Invalid index.");
        }
    }
    /*
     * Returns the value rewardPoint.
     * @return short rewardPoint.
     */
    public short getRewardPoint() {
        return rewardPoint;
    }

    /*
     * Prints the current reward points.
     */
    public void showRewardPoint() {
        System.out.println("Current Reward Points:" + rewardPoint);
    }
    /*
     * Gets a reward number and checks if it is in the rewards datase.
     * If it is, it is removed from the database. otherwase, an error message is displayed.
     * The update rewards database is returned.
     * @param String rewardNumber
     * @return LinkedList<String> rewardsDatabase
     */
    public LinkedList<String> deleteRewardNumber(String rewardNumber) {
        if(rewardsDataBase.contains(rewardNumber)) {
            rewardsDataBase.remove(rewardNumber);
            System.out.println("Reward number " + rewardNumber + "has been removed.");
        }
        else {
            System.out.println("Error. Reward number not found.");
        }
        return rewardsDataBase;
    }

    /*
     * Checks if the rewars poinst exceeds the max limit. 
     * If it does not then it adds rewards points to the current rewards points.
     * Otherwise, an error message is displayed.
     * @param short rewardPoint
     * @return LinkedList<String> rewardsDataBase
     */

    public LinkedList<String> addRewardPoint(short rewardPoint) {
        if (rewardPoint <= rewardPointMax) {
            this.rewardPoint += rewardPoint;
            System.out.println("Rewards points added " + rewardPoint);
             return rewardsDataBase;

        }

        else {
            System.out.println("Error. Cannot add more points. Max limit reached.");
            return rewardsDataBase;
        }
    }

    /*
     * Checks if the reward points are greater than or = to the given amount.
     * If it is, it removes the given value from the current rewards points.
     * Otherwise, an error message is displayed.
     * @param short rewardPointsToRemove
     * @return LinkedList<String> rewardsDataBase
     */

    public LinkedList<String> removeRewardPoint(short rewardPointsToRemove) {
        if (this.rewardPoint >= rewardPointsToRemove) {
            this.rewardPoint -= rewardPointsToRemove;
            System.out.println("Rewards points removed " + rewardPointsToRemove);
        }

        else {
            System.out.println("Error. Cannot remove more points. points at zero.");
        }
        return rewardsDataBase;
    }
}
