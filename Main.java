package dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of(
                "alpha","bravo","charlie","delta"
        ));
        for(String s : list){
            System.out.println(s);
        }
        System.out.println("|----------------|");

        list.forEach(System.out::println);
        System.out.println("|----------------|");

        String prefix = "nato";
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString+ " means "+ first);
        });

        int result = calculator((a,b) -> a + b, 12,62);
        var result2 = calculator((a,b) -> a/b,16.20,4.05);
        var result3 = calculator((a,b) -> a.toUpperCase() + " " + b.toUpperCase(), "walter", "whale");
//
//        var coords = Arrays.asList(
//                new double[]{16.99,73.30},
//                new double[]{26.85,80.94},
//                new double[]{19.07,72.87});
//        coords.forEach(s -> System.out.println((Arrays.toString(s))));
//
//        BiConsumer<Double,Double> p1 = (lat, lng) ->
//            System.out.printf("[lat:%.3f lng:%.3f]%n",lat , lng );
//
//        System.out.println("------------------");
//        coords.forEach(s -> processPoint(s[0],s[1],(lat, lng) ->
//                System.out.printf("[lat:%.3f lng:%.3f]%n",lat , lng )));
//
//        list.removeIf(s-> s.equalsIgnoreCase("Bravo"));
//        list.forEach(s -> System.out.println(s));
//
//        list.addAll(List.of("Echo","Equal","Erratic"));
//        list.forEach(s -> System.out.println(s));
//
//        System.out.println("---------------");
//        list.removeIf(s -> s.startsWith("Er"));
//        list.forEach(s -> System.out.println(s));

//        list.replaceAll(s -> s.charAt(0)+ " - "+ s.toUpperCase());
//        list.forEach(s -> System.out.println(s));
//
//        String[] emptyStrings = new String[10];
//        System.out.println(Arrays.toString(emptyStrings));
//        Arrays.fill(emptyStrings,"");
//        Arrays.setAll(emptyStrings, (i) -> ""+ (i+1)+ ". ");
//        System.out.println(Arrays.toString(emptyStrings));
//
//        Arrays.setAll(emptyStrings, (i) -> ""+ (i+1)+ ". "+
//                switch (i){
//            case 0 -> "one";
//            case 1 -> "two";
//            case 2 -> "three";
//                    default -> " ";
//                });
//        System.out.println(Arrays.toString(emptyStrings));

        String[] names = {"Aman", "Bimal", "Chandu", "David", "Eli", "Farid"};
        String[] randomList = randomlySelectedValues(15, names,
                () -> new Random().nextInt(0,names.length));
        System.out.println(Arrays.toString(randomList));

    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2 ){

        T result = function.apply(value1, value2);
        System.out.println("Result of Operation " + result);
        return result;
    }
    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer){
        consumer.accept(t1,t2);
    }
    public static String[] randomlySelectedValues (int count,
                                                   String values[],
                                                   Supplier<Integer> s){
        String[] selectedValues = new String[count];
        for(int i=0; i< count; i++){
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }
}