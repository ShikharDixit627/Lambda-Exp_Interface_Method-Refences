package develop;

import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

//        String name = "Davey";
//        Function<String, String> uCase = String::toUpperCase;
//        Function<String, String> lastName = s -> s.concat(" Quaker");
//        System.out.println(uCase.apply(name));
//
//        Function<String, String> uCaseLastName = uCase.andThen(lastName);
//        System.out.println(uCaseLastName.apply(name));
//
//        uCaseLastName = uCase.compose(lastName);
//        // the .compose() method is used only with functions or Unary operators not with other functional Interfaces
//
//        System.out.println(uCaseLastName.apply(name));
//
//        Function<String, String[]> f0 = uCase
//                .andThen(s -> s.concat(" wardesz"))
//                .andThen(s -> s.split(" "));
//        System.out.println(Arrays.toString(f0.apply(name)));
//
//        Function<String, String> f1 = uCase
//                .andThen(s -> s.concat(" wardesz"))
//                .andThen(s -> s.split(" "))
//                .andThen(s -> s[1].toUpperCase()+ ","+ s[0]);
//        System.out.println(f1.apply(name));
//
//        Function<String,Integer> f2 = uCase
//                .andThen(s -> s.concat(" wardesz"))
//                .andThen(s -> s.split(" "))
//                .andThen(s -> String.join(", ", s))
//                .andThen(String::length);
//        System.out.println(f2.apply(name));
//
//        String[] names = {"Ankit","Babloo","Chandra","Dakshin"};
//        Consumer<String> s0 = s -> System.out.print(s.charAt(0));
//        Consumer<String> s1 = System.out::println;
//        Arrays.asList(names).forEach(s0
//                .andThen( s -> System.out.print("-"))
//                .andThen(s1));

        Predicate<String> p1 = s -> s.equals("MINE");
        Predicate<String> p2 = s -> s.equalsIgnoreCase("mine");
        Predicate<String> p3 = s -> s.startsWith("M");
        Predicate<String> p4 = s-> s.endsWith("e");

        Predicate<String> c1 = p1.or(p2);
        System.out.println("Combined test: "+ c1.test("mine"));

        Predicate<String> c2 = p3.and(p4);
        Predicate<String> c3 = p3.and(p4).negate();
        System.out.println("Combined test: "+ c2.test("mine")+ "\n"+ "result for test 3: "+ c3.test("mine"));

        record Person(String firstName, String lastName){}

        List<Person> list = new ArrayList<>(Arrays.asList(
                new Person("John", "Lennon"),
                new Person("Ringo", "Starr"),
                new Person("Paul", "McCartney"),
                new Person("George", "Harrison")
        ));

        list.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        list.forEach(System.out::println);

        System.out.println("______________________");
        list.sort(Comparator.comparing(Person::lastName));
        list.forEach(System.out::println);

        System.out.println("______________________");
        list.sort(Comparator.comparing(Person::lastName).thenComparing(Person::firstName).reversed());
        list.forEach(System.out::println);


    }
}
