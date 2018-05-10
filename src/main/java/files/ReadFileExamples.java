package files;

/**
 * @author Alex Carvalho
 */
public class ReadFileExamples {


    public static void main(String[] args) {
        ReadFile reader = new ReadFile();

        System.out.println("simpleRead");
        reader.simpleRead("lines.txt");

        System.out.println("readFilterAndTransform");
        reader.readFilterAndTransform("lines.txt");
    }
}
