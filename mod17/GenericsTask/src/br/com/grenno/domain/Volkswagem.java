package br.com.grenno.domain;

public class Volkswagem extends Car<Volkswagem>{
    public Volkswagem(Long code, String name, String color) {
        super(code, name, color);
    }

    @Override
    public Class<Volkswagem> getClass() {
        return Volkswagem.class;
    }
}
