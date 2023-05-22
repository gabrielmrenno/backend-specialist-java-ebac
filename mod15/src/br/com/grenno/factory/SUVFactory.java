package br.com.grenno.factory;

import br.com.grenno.domain.Car;
import br.com.grenno.domain.SUVCar;

public class SUVFactory extends CarFactory{
    @Override
    public Car createCar() {
        return new SUVCar();
    }
}
