package br.com.grenno.register.domain;

public class Product implements IPersistent {
    private Long code;
    private String name;

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

    @Override
    public Long getKey() {
        return this.code;
    }
}
