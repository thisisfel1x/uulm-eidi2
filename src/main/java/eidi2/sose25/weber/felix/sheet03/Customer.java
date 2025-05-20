package eidi2.sose25.weber.felix.sheet03;

public class Customer {
    private int id;

    public Customer(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                '}';
    }
}
