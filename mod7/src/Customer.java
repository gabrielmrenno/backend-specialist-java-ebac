public class Customer {
    private int code;
    // private: can be accessed just inside class
    private String name;

    private String address;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        // this: referencing class itself
        this.address = address;
    }

    // public: can be accessed out of the class
    // void: it will return nothing
    // method name: camelCase pattern
    // parameters: variables that can be passed when method is called
    public void registerAddress (String address) {
        setAddress(address);
    }

    public void printAddress() {
        System.out.println(this.address);
    }

    public String returnAddressName() {
        return "Endereço do Gabriel";
    }
}
