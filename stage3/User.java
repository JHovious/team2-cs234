public class User {
    private String userID;
    private String password;
    private boolean managerCheck;

    public User(String userID, String password, boolean managerCheck) {
        this.userID = userID;
        this.password = password;
        this.managerCheck = managerCheck;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public boolean isManager() {
        return managerCheck;
    }
}
