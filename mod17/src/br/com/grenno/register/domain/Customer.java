package br.com.grenno.register.domain;

import java.util.Objects;

public class Customer implements IPersistent {
    private String name;
    private Long doc;
    private Long phone;
    private String address;
    private Integer number;
    private String city;
    private String state;

    public Customer(String name, String doc, String phone, String address, String number, String city, String state) {
        this.name = name;
        this.doc = Long.valueOf(doc.trim());
        this.phone = Long.valueOf(phone.trim());;
        this.address = address;
        this.number = Integer.valueOf(number.trim());;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDoc() {
        return doc;
    }

    public void setDoc(Long doc) {
        this.doc = doc;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(doc, customer.doc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doc);
    }

    @Override
    public String toString() {
        return "br.com.grenno.domain.Customer{" +
                "name='" + name + '\'' +
                ", doc=" + doc +
                '}';
    }

    @Override
    public Long getKey() {
        return this.doc;
    }
}
