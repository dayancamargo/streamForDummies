package others;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author Alex Carvalho
 */
public class Closed {

    public static void main(String[] args) {
        alreadyClosed();

        newEveryCall();
    }

    public static void alreadyClosed() {
        try {
            String[] array = {"a", "b", "c", "d", "e"}; // or Stream.of("a", "b", "c", "d", "e");

            Stream<String> stream = Arrays.stream(array);

            stream.forEach(System.out::println);

            long count = stream.filter("b"::equals).count();

            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void newEveryCall() {
        String[] array = {"a", "b", "c", "d", "e"};

        Supplier<Stream<String>> streamSupplier = () -> Stream.of(array);

        //get new stream
        streamSupplier.get().forEach(System.out::println);

        //get another new stream
        long count = streamSupplier.get().filter("b"::equals).count();

        System.out.println(count);
    }


}
