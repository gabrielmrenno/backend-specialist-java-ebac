package main.java.br.com.grenno.domain;

public class Customer {
    private String name;
    private Long doc;
    private Long phone;
    private String address;
    private Integer addressNumber;
    private String city;
    private String state;

    public Customer() {

    }

    public Customer(String name, Long doc, Long phone, String address, Integer addressNumber, String city, String state) {
        this.name = name;
        this.doc = doc;
        this.phone = phone;
        this.address = address;
        this.addressNumber = addressNumber;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(Integer addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDoc(long doc) {
        this.doc = doc;
    }

    public Long getDoc() {
        return doc;
    }
}
