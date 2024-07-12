package coursework_assignment2;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class testSearchingAlgorithm {
    public static void main(String[] args) {
        // Test case 1: Searching for an existing order by ID
        List<Order> orders1 = createOrderList();
        String orderId1 = orders1.get(0).getOrderId(); 
        System.out.println("Check input" + orders1 + orderId1);
        testBinarySearchOrdersById(orders1, orderId1);

        // Test case 2: Searching for a non-existent order by ID
        List<Order> orders2 = createOrderList();
        String orderId2 = "nonexistentId";
        testBinarySearchOrdersById(orders2, orderId2);

        // Test case 3: Searching in an empty list of orders
        List<Order> orders3 = new ArrayList<>();
        String orderId3 = "1"; // Any ID for testing in an empty list
        testBinarySearchOrdersById(orders3, orderId3);

     // Test case 4: Searching in a list with one order
        List<Order> orders4 = new ArrayList<>();
        Order singleOrder = createOrder("Customer 4", "Address 4", createBookList());
        orders4.add(singleOrder);
        String orderId4 = singleOrder.getOrderId();
        testBinarySearchOrdersById(orders4, orderId4);

        // Test case 5: Searching for an existing book by ID
        List<Book> books1 = createBookList();
        String bookId1 = books1.get(1).getId(); // Using the second generated book ID for testing
        testBinarySearchBooksById(books1, bookId1);

        // Test case 6: Searching for a non-existent book by ID
        List<Book> books2 = createBookList();
        String bookId2 = "nonexistentId";
        testBinarySearchBooksById(books2, bookId2);

        // Test case 7: Searching in an empty list of books
        List<Book> books3 = new ArrayList<>();
        String bookId3 = "1"; // Any ID for testing in an empty list
        testBinarySearchBooksById(books3, bookId3);

        // Test case 8: Searching in a list with one book
        List<Book> books4 = new ArrayList<>();
        Book singleBook = createBookList().get(0);
        books4.add(singleBook);
        String bookId4 = singleBook.getId();
        testBinarySearchBooksById(books4, bookId4);
    }

    private static List<Order> createOrderList() {
        List<Order> orders = new ArrayList<>();

        // Create some sample orders with default values
        Order order1 = createOrder("Customer 1", "Address 1", createBookList());
        Order order2 = createOrder("Customer 2", "Address 2", createBookList());
        Order order3 = createOrder("Customer 3", "Address 3", createBookList());

        // Add orders to the list
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        return orders;
    }

    private static Order createOrder(String customerName, String shippingAddress, List<Book> books) {
        String orderId = UUID.randomUUID().toString();
        String customerId = UUID.randomUUID().toString();
        return new Order(orderId, customerId, customerName, shippingAddress, books);
    }

    private static List<Book> createBookList() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(UUID.randomUUID().toString(), "Book 1", "Author 1", 1));
        books.add(new Book(UUID.randomUUID().toString(), "Book 2", "Author 2", 2));
        books.add(new Book(UUID.randomUUID().toString(), "Book 3", "Author 3", 3));
        return books;
    }

    private static void testBinarySearchOrdersById(List<Order> orders, String orderId) {
        System.out.println("Searching for order ID: " + orderId);
        int index = SearchingAlgorithm.binarySearchOrdersById(orders, orderId, 0, orders.size() - 1);
        if (index != -1) {
            System.out.println("Order found at index: " + index);
            System.out.println("Order details: " + orders.get(index));
        } else {
            System.out.println("Order not found.");
        }
        System.out.println();
    }
    
    private static void testBinarySearchBooksById(List<Book> books, String bookId) {
        System.out.println("Searching for book ID: " + bookId);
        int index = SearchingAlgorithm.binarySearchBooksById(books, bookId, 0, books.size() - 1);
        if (index != -1) {
            System.out.println("Book found at index: " + index);
            System.out.println("Book details: " + books.get(index));
        } else {
            System.out.println("Book not found.");
        }
        System.out.println();
    }

}
