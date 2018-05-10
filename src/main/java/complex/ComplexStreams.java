package complex;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ComplexStreams {

    public void saladByColor(String color, Integer max) {
        getSalad().stream()
                .filter(sal -> sal.getColor().equalsIgnoreCase(color))
                .limit(max)
                .forEach(t -> System.out.println(t.getName() + " - " + t.getColor()));
    }

    public void countSaladByColor() {
        Map<String, Long> result = getSalad().stream()
                .collect(Collectors.groupingBy(Salad::getColor, Collectors.counting()));

        result.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

//        Case the stream is executed in parallel is necessary use forEachOrdered
//        .parallel()
//        .forEachOrdered(System.out::println);
    }

    private List<Salad> getSalad() {
        return Arrays.asList(new Salad("batata", "purple", 1),
                new Salad("cenora", "orange", 3),
                new Salad("tomate", "red", 4),
                new Salad("alface", "green", 5),
                new Salad("beterraba", "purple", 2),
                new Salad("couve", "green", 1),
                new Salad("cebola", "white", 7),
                new Salad("repolho", "green", 9),
                new Salad("aspargo", "green", 2),
                new Salad("salsa", "green", 6));
    }
}
