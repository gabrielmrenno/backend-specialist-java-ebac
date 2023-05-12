package br.com.grenno.abstracts;

public class Salaried extends Employee{
    private Double salary;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public double maturity() {
        return salary;
    }
}
