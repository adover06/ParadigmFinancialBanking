public class Customer {
    private int customerId;
    private String name;
    private String address;
    private String email;
    private LocalDate dob;

    public Customer(int customerId, String name, String address, String email, LocalDate dob) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.dob = dob;
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
}
