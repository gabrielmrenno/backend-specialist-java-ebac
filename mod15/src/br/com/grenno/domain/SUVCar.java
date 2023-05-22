package br.com.grenno.domain;

public class SUVCar implements Car{
    @Override
    public void getInfo() {
        System.out.println("This is a SUV car.");
    }
}
