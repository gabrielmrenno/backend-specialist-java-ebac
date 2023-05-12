package br.com.grenno;

import java.util.List;

public class LegalPerson extends Person {
    private Long cnpj;
    private List<FisicalPerson> employeeNames;
    private List<FisicalPerson> partnersNames;

    protected LegalPerson(String name) {
        super(name);
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public List<FisicalPerson> getEmployeeNames() {
        return employeeNames;
    }

    public void setEmployeeNames(List<FisicalPerson> employeeNames) {
        this.employeeNames = employeeNames;
    }

    public List<FisicalPerson> getPartnersNames() {
        return partnersNames;
    }

    public void setPartnersNames(List<FisicalPerson> partnersNames) {
        this.partnersNames = partnersNames;
    }

    public void addEmployeeName(FisicalPerson employeeName) {
        this.employeeNames.add(employeeName);
    }

    public void addPartnerName(FisicalPerson partnerName) {
        this.partnersNames.add(partnerName);
    }
}
