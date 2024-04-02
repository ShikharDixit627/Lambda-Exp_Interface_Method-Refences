import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Consumer<String> printWordsLambda = sentence ->{
            String[] parts = sentence.split(" ");
            for(String part: parts){
                System.out.println(part);
            }
        };

        printWordsLambda.accept("This is a trial string passed for checking");

        Consumer<String> printWordsForEach = sentence ->{
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s-> System.out.println(s));
        };
        System.out.println("\n");
        printWordsForEach.accept("This is a trial trial passed for checking");

        Consumer<String> printWordsConcise = sentence ->{
            Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));
        };
        System.out.println("\n");
        printWordsConcise.accept("This is a trial trial passed for checking");

        Function<String, String> everySecondChar = source ->{
            StringBuilder returnVal = new StringBuilder();
            for(int i=0; i < source.length(); i++){
                if(i%2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondChar.apply("1234567890"));
        System.out.println("Now calling the method for function !");
        System.out.println(everySecondCharacter(everySecondChar,"1234567890"));

        Supplier<String> iLoveJava = () -> "I love Java";

        System.out.println(iLoveJava.get());


    }
    public static String everySecondCharacter(Function<String, String> func,String source){
       return  func.apply(source);
    };
}