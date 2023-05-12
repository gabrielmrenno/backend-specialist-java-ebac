package br.com.grenno.interfaces;

public interface IPen {

    public void write(String text);

    public String getColor();

    default void writeMethodDefault() {
        System.out.println("All class' can use and don't need to implements");
    }
}
