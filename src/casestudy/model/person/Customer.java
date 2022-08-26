package casestudy.model.person;

public class Customer extends Person {
    private String guest;
    private String address;

    public Customer() {
    }

    public Customer(String guest, String address) {
        this.guest = guest;
        this.address = address;
    }

    public Customer(String code, String name, String dateOfBirth, String gender, int citizenship, int phoneNumber, String email, String guest, String address) {
        super(code, name, dateOfBirth, gender, citizenship, phoneNumber, email);
        this.guest = guest;
        this.address = address;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%s,Khách mời: %s,Địa chỉ: %s",super.toString(),guest,address);
    }
}
