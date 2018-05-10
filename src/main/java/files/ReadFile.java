package files;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Alex Carvalho
 */
public class ReadFile {

    /**
     * Simple read e print lines file
     */
    public void simpleRead(String fileName) {
        URL url = getClass().getClassLoader().getResource(fileName);

        try (Stream<String> stream = Files.lines(Paths.get(url.toURI()))) {

            stream.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Read file, filter lines, after transform to upper case and print
     */
    public void readFilterAndTransform(String fileName) {
        URL url = getClass().getClassLoader().getResource(fileName);

        try (Stream<String> stream = Files.lines(Paths.get(url.toURI()))) {

            stream
                    .filter(line -> !line.startsWith("line3"))
                    .map(String::toUpperCase)
                    .forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
