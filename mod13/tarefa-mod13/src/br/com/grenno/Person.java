package br.com.grenno;

public abstract class Person {
    private String name;
    private double income;
    private String contactPhone;

    protected Person(String name) {
        this.name = name;
    }

    public Person(String name, double income, String contactPhone) {
        this.name = name;
        this.income = income;
        this.contactPhone = contactPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
