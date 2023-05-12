package br.com.grenno;

import br.com.grenno.abstracts.Employee;
import br.com.grenno.abstracts.Salaried;
import br.com.grenno.interfaces.BallpointPen;
import br.com.grenno.interfaces.IPen;

public class Main {
    public static void main(String[] args) {
        IPen pen = new BallpointPen();
        pen.write("Hello guys");
        pen.writeMethodDefault();
        System.out.println(pen.getColor());

        Salaried employee = new Salaried();
        employee.setName("Gabriel");
        employee.setLastName("Renno");
        employee.setSalary(100d);
        System.out.println(employee.getName() + ": R$ " + employee.maturity());
    }
}