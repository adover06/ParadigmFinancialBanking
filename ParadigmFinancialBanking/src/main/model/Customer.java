public class Customer {
    private int customerId;
    private String name;
    private String address;
    private String email;
    private LocalDate dob;
    private String phoneNumber;

    public Customer(int customerId, String name, String address, String email, LocalDate dob, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
    }

    
    //getters
    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob(){
        return dob;
    }

    //setters

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
