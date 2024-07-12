package coursework_assignment2;
import java.util.List;

public class SortingAlgorithm {

    public static void quicksort(List<Book> books, int low, int high) {
        // Error handling: check for null or empty list
        if (books == null || books.size() < 2) {
            return;
        }
        // Error handling: ensure low and high indices are within valid ranges
        if (low < 0 || high >= books.size() || low >= high) {
            return;
        }

        if (low < high) {
            int pi = partition(books, low, high);
            quicksort(books, low, pi - 1);
            quicksort(books, pi + 1, high);
        }
    }

    private static int partition(List<Book> books, int low, int high) {
        Book pivot = books.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (books.get(j).getTitle().compareTo(pivot.getTitle()) < 0) {
                i++;
                Book temp = books.get(i);
                books.set(i, books.get(j));
                books.set(j, temp);
            }
        }
        Book temp = books.get(i + 1);
        books.set(i + 1, books.get(high));
        books.set(high, temp);
        return i + 1;
    }
}
