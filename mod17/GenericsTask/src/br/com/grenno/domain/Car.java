package br.com.grenno.domain;

public abstract class Car<T> {
    private Long code;
    private String name;
    private String color;

    public Car(Long code, String name, String color) {
        this.code = code;
        this.name = name;
        this.color = color;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void accelerateAction() {
        System.out.println("Acelerando");
    }

    public void breakAction() {
        System.out.println("Freando");
    }
}
