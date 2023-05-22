package br.com.grenno.domain;

public class SedanCar implements Car{
    @Override
    public void getInfo() {
        System.out.println("This is a Sedan car.");
    }
}
