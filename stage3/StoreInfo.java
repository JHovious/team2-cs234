public class StoreInfo {
    private String name;
    private String storeAddress;
    private String hours;

    public StoreInfo() {
        this.name = "Test store";
        this.storeAddress = "123 Main St";
        this.hours = "Monday-Friday: 9:00 AM - 5:00 PM, Saturday: 10:00 AM - 4:00 PM, Sunday: Closed";
    }
    public void showName() {
        System.out.println("Store Name: " + name);
    }

    public void showAddress() {
        System.out.println("Store Address: " + storeAddress);
    }

    public void showHours() {
        System.out.println("Store Hours: "  + hours);
    }

}

