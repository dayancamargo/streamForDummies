package simple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class SimpleStreams {

    /**
     * A simple filter example
     */
    public void simpleFilter(){
        System.out.println("Tirando numeros impares:");

         createIntegerList().stream()
                  .filter(x -> (x % 2) == 0)
                  .forEach(x -> System.out.println(x));
//
//         for(Integer num : createIntegerList()){
//            if((num % 2) == 0)   {
//                System.out.println(num);
//            }
//         }
    }


    /**
     * A simple example to generate a stream of random Integers
     */
    public void simpleRandomGenerate(){
        System.out.println("Generando aleatorios");

        Stream.iterate( new Random().nextInt(100), n -> new Random().nextInt(100))
              .limit(10)
              .forEach(t -> System.out.println(t));


//         for(int  i = 0; i < 10; i++ ){
//            System.out.println(new Random().nextInt(100));
//         }
    }

    /**
     * A simple example of ordened streams
     */
    public void ordenedSalad(){

        System.out.println("------- Saladas ordenadas --------");
        salad().stream()
                .sorted()
                .forEach(t -> System.out.println(t));

        System.out.println("------- Saladas decrescente --------");
        salad().stream()
                .sorted(Comparator.reverseOrder())
                .forEach(t -> System.out.println(t));

        System.out.println("------- Saladas invertidas --------");
        salad().stream()
                .sorted((n1, n2) -> new StringBuilder(n1).reverse().toString().compareTo(new StringBuilder(n2).reverse().toString()))
                .forEach(t -> System.out.println(t));
    }

    /**
     * A example to get a average number of letters
     */
    public void averageSaladLength(){
        System.out.println("------- Obtendo tamanho medio das  saladas--------");
        double average = salad().stream()
                                 .mapToInt(String::length)
                                 .summaryStatistics()
                                 .getAverage();

        System.out.println("tamanho medio:" + average);

//        double size = 0;
//        int saladaSize;
//        for(saladaSize = 0; saladaSize < salad().size(); saladaSize++)  {
//            size += salad().get(saladaSize).length();
//        }
//        System.out.println("tamanho medio old:" + new Double( (size / saladaSize)));
    }

    /**
     * A example to get the biggest vegetable
     */
    public void biggerVegetable(){

        System.out.println("Maior vegetal: " +
                           salad().stream()
                                   .peek(System.out::print)
                                   .mapToInt(String::length)
                                   .peek(System.out::println)
                                   .summaryStatistics()
                                   .getMax());

    }

    /**
     * Try find first vegetable with letter
     * @param letter to be used on find
     */
    public void findFirst(String letter){


        Optional<String> found = salad().stream()
                                         .filter(i -> i.startsWith(letter))
                                         .findFirst();

        showFindFirst(found, letter);
    }

    private void showFindFirst(Optional<String> found, String letter) {
        if(found.isPresent()){
            System.out.println("First vegetable with " + letter + ": "  + found.get());
        } else {
            System.out.println("Not found with letter " + letter);
        }
    }

    private List<Integer> createIntegerList(){
        return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    private List<String> salad(){
        return Arrays.asList("batata",
                             "cenora",
                             "tomate",
                             "alface",
                             "beterraba",
                             "couve",
                             "cebola",
                             "repolho",
                             "aspargo",
                             "salsa");
    }
}