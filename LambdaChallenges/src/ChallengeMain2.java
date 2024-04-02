import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ChallengeMain2 {

    private static Random random = new Random();

    public static void main(String[] args) {

        String[] names = {"Ava", "Bollob", "Cakey", "Douglas","Evaline","Fakhar","Goyal"};
        Arrays.setAll(names, s-> names[s].toUpperCase());
        System.out.println("Names in upper case");
        System.out.println(Arrays.toString(names));

        List<String> backedByArray = Arrays.asList(names);
        backedByArray.replaceAll(s -> s += " " + getRandomChar('A' , 'D') + ".");
        System.out.println("--> added middle name");
        System.out.println(Arrays.toString(names));

        backedByArray.replaceAll(s -> s+= " "+ getReverseName(s.split(" ")[0]));
        System.out.println("--> Reversed name as last name");
        Arrays.asList(names).forEach(s -> System.out.println(s));

        List<String> newList = new ArrayList<>(List.of(names));
//        newList.removeIf(s -> s.substring(0, s.indexOf(" ") ).equals
//                (s.substring(s.lastIndexOf(" ") +1)));

        newList.removeIf(s -> {
            String first = s.substring(0, s.indexOf(" "));
            String last = s.substring(s.lastIndexOf(" ") + 1);
            return first.equals(last);
        });

        System.out.println("Removed names where first name same as last name");
        newList.forEach(s -> System.out.println(s));

    }

    public static char getRandomChar(char startChar, char endChar){
        return (char) random.nextInt( (int)startChar, (int) endChar + 1);

    }

    public static String getReverseName (String firstName){
        return new StringBuffer(firstName).reverse().toString();
    }

}
