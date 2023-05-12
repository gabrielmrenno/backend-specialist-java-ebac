package br.com.grenno;

public class FisicalPerson extends Person{
    private Long cpf;
    private Long employmentCard;

    public FisicalPerson(String name, Long cpf) {
        super(name);
        this.cpf = cpf;
    }

    public FisicalPerson(String name, Long cpf, Long employmentCard) {
        super(name);
        this.cpf = cpf;
        this.employmentCard = employmentCard;
    }

    protected FisicalPerson(String name) {
        super(name);
    }
    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getEmploymentCard() {
        return employmentCard;
    }

    public void setEmploymentCard(Long employmentCard) {
        this.employmentCard = employmentCard;
    }
}
