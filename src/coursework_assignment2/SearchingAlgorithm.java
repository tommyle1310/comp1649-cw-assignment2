package coursework_assignment2;
import java.util.List;

public class SearchingAlgorithm {

    public static int binarySearchOrdersById(List<Order> orders, String orderId, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            String currentOrderId = orders.get(mid).getOrderId();

            if (currentOrderId.equals(orderId)) {
                return mid;
            }

            if (currentOrderId.compareTo(orderId) > 0) {
                return binarySearchOrdersById(orders, orderId, low, mid - 1);
            } else {
                return binarySearchOrdersById(orders, orderId, mid + 1, high);
            }
        }
        return -1; // Order not found
    }

    public static int binarySearchBooksById(List<Book> books, String bookId, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            String currentBookId = books.get(mid).getId();

            if (currentBookId.equals(bookId)) {
                return mid;
            }

            if (currentBookId.compareTo(bookId) > 0) {
                return binarySearchBooksById(books, bookId, low, mid - 1);
            } else {
                return binarySearchBooksById(books, bookId, mid + 1, high);
            }
        }
        return -1; // Book not found
    }
}
