/**
 * @author gabrielmrenno
 */

public class FirstClass {
    public static void main (String[] args) {
        // create an instance
        Customer customer = new Customer();
        // setting attributes
        customer.registerAddress("Rua X");
        customer.setCode(1);
        // printing attributes
        System.out.println(customer.getCode());
        System.out.println(customer.getAddress());
        customer.printAddress();
        String customerAddress = customer.returnAddressName();
        System.out.println(customerAddress);
    }
}
