package coursework_assignment2;
import java.util.List;

public class Order {
    private String orderId;
    private String customerId;
    private String customerName;
    private String shippingAddress;
    private List<Book> books;

    public Order(String orderId, String customerId, String customerName, String shippingAddress, List<Book> books) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.books = books;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", books=" + books +
                '}';
    }
}
