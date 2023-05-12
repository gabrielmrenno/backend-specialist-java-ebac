package br.com.grenno.interfaces;

public class Chalk implements IPen {

    @Override
    public void write(String text) {
        System.out.println("Writing the value: " + text + " on class" + getClass().getSimpleName());
    }

    @Override
    public String getColor() {
        return "White";
    }
}
