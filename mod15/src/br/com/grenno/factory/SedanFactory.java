package br.com.grenno.factory;

import br.com.grenno.domain.Car;
import br.com.grenno.domain.SedanCar;

public class SedanFactory extends CarFactory{
    @Override
    public Car createCar() {
        return new SedanCar();
    }
}
