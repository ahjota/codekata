import java.util.Arrays;
import java.util.List;

/**
 * This tests a map-reduce function that compares two collections
 * and returns true if the collections have a common "matching"
 * object. In this case, matching is done with String.equalsIgnoreCase()
 * but could be done with any BinaryOperator.
 */
class Scratch {
    public static void main(String[] args) {
        List<String> existing = Arrays.asList("hello", "world");
        List<String> update = Arrays.asList("you", "had", "me", "at", "hello");

        System.out.println(testReduction(existing, update));

        update = Arrays.asList("you", "had", "me", "at");

        System.out.println(testReduction(existing, update));

        update = Arrays.asList("world", "hello");

        System.out.println(testReduction(existing, update));

        update = Arrays.asList("hola", "mundo");

        System.out.println(testReduction(existing, update));

        existing = Arrays.asList("hola", "mundo");

        System.out.println(testReduction(existing, update));

        existing = Arrays.asList("hola", "Mundo");

        System.out.println(testReduction(existing, update));
    }

    private static boolean testReduction(List<String> existing, List<String> update) {
        System.out.println(existing);
        System.out.println(update);
        return update.stream()
                .anyMatch(u -> existing.stream()
                        // the equalsIgnoreCase() is a placeholder for more complex business logic
                        .map(s -> s.equalsIgnoreCase(u))
                        .reduce(false, ((aBoolean, aBoolean2) -> aBoolean || aBoolean2)));
    }
}
