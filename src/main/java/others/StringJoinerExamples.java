package others;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author Alex Carvalho
 */
public class StringJoinerExamples {

    public static void main(String[] args) {
        stringJoiner();
        simpleString();
        collectJoining();
    }

    public static void stringJoiner() {
        StringJoiner joiner = new StringJoiner("/", "(", ")");
        joiner.add("26");
        joiner.add("02");
        joiner.add("2016");
        String result = joiner.toString();

        System.out.println(result);
    }

    public static void simpleString() {
        String result = String.join("-", "31", "10", "2015");

        System.out.println(result);

        List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");

        result = String.join(", ", list);

        System.out.println(result);
    }

    public static void collectJoining() {
        List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");

        String result = list.stream().map(String::toUpperCase).collect(Collectors.joining(" | "));

        System.out.println(result);
    }


}
