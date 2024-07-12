package coursework_assignment2;
import java.util.ArrayList;
import java.util.List;

public class testSortingAlgorithm {
    public static void main(String[] args) {
        // Test case 1: Sorting a list of books with random titles
        List<Book> books1 = new ArrayList<>();
        books1.add(new Book("1", "To Kill a Mockingbird", "Harper Lee", 10));
        books1.add(new Book("2", "1984", "George Orwell", 15));
        books1.add(new Book("3", "The Great Gatsby", "F. Scott Fitzgerald", 5));
        books1.add(new Book("4", "Moby Dick", "Herman Melville", 7));
        testQuicksort(books1);

        // Test case 2: Sorting an already sorted list of books
        List<Book> books2 = new ArrayList<>();
        books2.add(new Book("1", "1984", "George Orwell", 15));
        books2.add(new Book("2", "Moby Dick", "Herman Melville", 7));
        books2.add(new Book("3", "The Great Gatsby", "F. Scott Fitzgerald", 5));
        books2.add(new Book("4", "To Kill a Mockingbird", "Harper Lee", 10));
        testQuicksort(books2);

        // Test case 3: Sorting a list with duplicate book titles
        List<Book> books3 = new ArrayList<>();
        books3.add(new Book("1", "To Kill a Mockingbird", "Harper Lee", 10));
        books3.add(new Book("2", "To Kill a Mockingbird", "Harper Lee", 12));
        books3.add(new Book("3", "1984", "George Orwell", 15));
        books3.add(new Book("4", "1984", "George Orwell", 10));
        testQuicksort(books3);

        // Test case 4: Sorting an empty list of books
        List<Book> books4 = new ArrayList<>();
        testQuicksort(books4);

        // Test case 5: Null list of books
        List<Book> books5 = null;
        testQuicksort(books5);

        // Test case 6: Sorting a list with one book
        List<Book> books6 = new ArrayList<>();
        books6.add(new Book("1", "To Kill a Mockingbird", "Harper Lee", 10));
        testQuicksort(books6);

        // Test case 7: Low index out of bounds (low < 0)
        List<Book> books7 = new ArrayList<>();
        books7.add(new Book("1", "To Kill a Mockingbird", "Harper Lee", 10));
        books7.add(new Book("2", "1984", "George Orwell", 15));
        testQuicksort(books7, -1, books7.size() - 1);

        // Test case 8: High index out of bounds (high >= size)
        List<Book> books8 = new ArrayList<>();
        books8.add(new Book("1", "To Kill a Mockingbird", "Harper Lee", 10));
        books8.add(new Book("2", "1984", "George Orwell", 15));
        testQuicksort(books8, 0, books8.size());

        // Test case 9: Low index >= High index
        List<Book> books9 = new ArrayList<>();
        books9.add(new Book("1", "To Kill a Mockingbird", "Harper Lee", 10));
        books9.add(new Book("2", "1984", "George Orwell", 15));
        testQuicksort(books9, 1, 0);
    }

    private static void testQuicksort(List<Book> books) {
        System.out.println("Before sorting: " + books);
        SortingAlgorithm.quicksort(books, 0, books != null ? books.size() - 1 : 0);
        System.out.println("After sorting: " + books);
        System.out.println();
    }

    private static void testQuicksort(List<Book> books, int low, int high) {
        System.out.println("Before sorting: " + books);
        SortingAlgorithm.quicksort(books, low, high);
        System.out.println("After sorting: " + books);
        System.out.println();
    }
}