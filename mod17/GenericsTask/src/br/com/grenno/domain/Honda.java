package br.com.grenno.domain;

public class Honda extends Car<Honda>{
    public Honda(Long code, String name, String color) {
        super(code, name, color);
    }

    @Override
    public Class<Honda> getClass() {
        return Honda.class;
    }


}
