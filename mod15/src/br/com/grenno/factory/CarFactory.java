package br.com.grenno.factory;

import br.com.grenno.domain.Car;

public abstract class CarFactory {
    public abstract Car createCar();

    private void prepareCar() {
        System.out.println("Car is being prepared... Finish, car prepared");
    }

    public void deliverCar() {
        Car car = createCar();
        car.getInfo();
        prepareCar();
        System.out.println("Delivering car... Delivered");
    }
}
