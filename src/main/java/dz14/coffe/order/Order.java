package dz14.coffe.order;

public class Order {
    private int number;
    private String customerName;

    public Order(int number, String customerName) {
        this.number = number;
        this.customerName = customerName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return number + " | " + customerName;
    }
}
