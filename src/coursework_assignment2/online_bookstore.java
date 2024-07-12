package coursework_assignment2;
import java.util.ArrayList; 
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class online_bookstore {
    private static Queue<Order> orderQueue = new Queue<>();
    private static List<Order> orderList = new ArrayList<>();
    private static List<Book> bookStore = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBookStore();
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Add Order");
            System.out.println("2. Process and Sort Orders");
            System.out.println("3. Search Order by Customer Name");
            System.out.println("4. Search Order by Order ID and Customer ID");
            System.out.println("5. Search Book by Book ID");
            System.out.println("6. View Available Books");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int option = getIntInput(scanner);

            switch (option) {
                case 1:
                    addOrder(scanner);
                    break;
                case 2:
                    processAndSortOrders();
                    break;
                case 3:
                    searchOrderByCustomerName(scanner);
                    break;
                case 4:
                    searchOrderByIdAndCustomerId(scanner);
                    break;
                case 5:
                    searchBookById(scanner);
                    break;
                case 6:
                    viewAvailableBooks();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void initializeBookStore() {
        bookStore.add(new Book("1", "To Kill a Mockingbird", "Harper Lee", 10));
        bookStore.add(new Book("2", "The Song of Achilles", "Madeline Miller", 5));
        bookStore.add(new Book("3", "Harry Potter", "J.K. Rowling", 7));
        bookStore.add(new Book("4", "The Mystic Guardians", "Lila Sterling", 3));
        bookStore.add(new Book("5", "The Monk Who Sold His Ferrari", "Robin Sharma", 8));
    }

    private static void addOrder(Scanner scanner) {
        String orderId = UUID.randomUUID().toString();
        String customerId = UUID.randomUUID().toString();
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter shipping address: ");
        String shippingAddress = scanner.nextLine();

        List<Book> books = new ArrayList<>();
        boolean addMoreBooks = true;

        while (addMoreBooks) {
            viewAvailableBooks();
            System.out.print("Enter book ID from the above list: ");
            String bookId = scanner.nextLine();
            Book book = findBookById(bookId);

            if (book != null) {
                int quantity;
                while (true) {
                    System.out.print("Enter book quantity: ");
                    quantity = getIntInput(scanner);
                    if (quantity >= 0) {
                        break;
                    }
                    System.out.println("Quantity must be a non-negative integer. Please try again.");
                }
                books.add(new Book(book.getId(), book.getTitle(), book.getAuthor(), quantity));
            } else {
                System.out.println("Invalid book ID. Please try again.");
            }

            System.out.print("Add another book? (yes/no): ");
            String response = scanner.nextLine();
            addMoreBooks = response.equalsIgnoreCase("yes");
        }

        Order order = new Order(orderId, customerId, customerName, shippingAddress, books);
        orderQueue.enqueue(order);
        orderList.add(order);

        System.out.println("Order added successfully.");
    }

    private static Book findBookById(String bookId) {
        int index = SearchingAlgorithm.binarySearchBooksById(bookStore, bookId, 0, bookStore.size() - 1);
        return index != -1 ? bookStore.get(index) : null;
    }

    private static void processAndSortOrders() {
        if (orderQueue.isEmpty()) {
            System.out.println("No orders to process.");
            return;
        }

        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.dequeue();
            List<Book> booksToSort = order.getBooks();
            SortingAlgorithm.quicksort(booksToSort, 0, booksToSort.size() - 1);

            System.out.println("Processed Order: " + order.getCustomerName());
            System.out.println("Sorted Books:");
            for (Book book : booksToSort) {
                System.out.println(book);
            }
        }
    }

    private static void searchOrderByCustomerName(Scanner scanner) {
        System.out.print("Enter customer name to search: ");
        String customerName = scanner.nextLine();

        for (Order order : orderList) {
            if (order.getCustomerName().equalsIgnoreCase(customerName)) {
                System.out.println("Order found: " + order);
                return;
            }
        }
        System.out.println("Order not found.");
    }

    private static void searchOrderByIdAndCustomerId(Scanner scanner) {
        System.out.print("Enter order ID: ");
        String orderId = scanner.nextLine();
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();

        int index = SearchingAlgorithm.binarySearchOrdersById(orderList, orderId, 0, orderList.size() - 1);
        if (index != -1 && orderList.get(index).getCustomerId().equals(customerId)) {
            System.out.println("Order found: " + orderList.get(index));
        } else {
            System.out.println("Order not found.");
        }
    }

    private static void searchBookById(Scanner scanner) {
        System.out.print("Enter book ID to search: ");
        String bookId = scanner.nextLine();

        Book book = findBookById(bookId);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void viewAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : bookStore) {
            System.out.println("Book ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter an integer: ");
            }
        }
    }
}
