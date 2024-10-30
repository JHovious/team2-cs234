import java.util.ArrayList;


public class Rewards {

    private String rewardNumber;
    private short rewardPoint;
    private short rewardPointMax;
    private ArrayList<String> rewardsDataBase;

    public Rewards(String rewardNumber, short rewardPoint, short rewardPointMax,ArrayList<String> rewardsDataBase) {
        this.rewardNumber = rewardNumber;
        this.rewardPoint = rewardPoint;
        this.rewardPointMax = rewardPointMax;
        this.rewardsDataBase = rewardsDataBase;

    }


    /*
     * creates a random 5 digit number and adds it to rewardsDataBase.
     */

    private short nextRewardNumber = 1;
    public ArrayList<String> createRewardNumber() {
        String formattedRewardNumber = String.format("%05d", nextRewardNumber);
        rewardsDataBase.add(formattedRewardNumber);
        nextRewardNumber++;
        return rewardsDataBase;
    }

    public String getRewardNumber() {
        return rewardNumber;
    }

    /*
     * given the index of reward number, prints the corresponding reward number.
     */
    public void showRewardNumber(int index) {
        if(index >= 0 && index < rewardsDataBase.size()) {
            System.out.println("rewards number" + rewardsDataBase.get(index));
        }
        else{
            System.out.println("Error. Invalid index.");
        }
    }

    public short getRewardPoint() {
        return rewardPoint;
    }

    public void showRewardPoint() {
        System.out.println("Current Reward Points:" + rewardPoint);
    }
    /*
     * removes a reward number from the database, checks if the reward number exists.
     */
    public ArrayList<String> deleteRewardNumber(String rewardNumber) {
        if(rewardsDataBase.contains(rewardNumber)) {
            rewardsDataBase.remove(rewardNumber);
            System.out.println("Reward number has been removed.");
        }
        else {
            System.out.println("Error. Reward number not found.");
        }
        return rewardsDataBase;
    }

    /*
     * idk if this is right but it adds reward points.
     */

    public ArrayList<String> addRewardPoint(short rewardPoint) {
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
     * does the same thing as addRewardPoint but removes points.
     */

    public ArrayList<String> removeRewardPoint(short rewardPointsToRemove) {
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
