import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    //Task_1
    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.collect(Collectors.toList());
        
        /*T min = list.stream().min(order).orElse(null);
        T max = list.stream().max(order).orElse(null);
        minMaxConsumer.accept(min, max);*/

        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            T min = list.stream().min(order).orElseThrow();
            T max = list.stream().max(order).orElseThrow();
            minMaxConsumer.accept(min, max);
        }
        
        System.out.println("Все значения списка: " +
                list.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(",")));
    }

    //Task_2
    public static IntStream even(int... x) {
        return Arrays.stream(x).filter(a -> a % 2 == 0);
    }


    public static void main(String[] args) {
        System.out.println("Task_1\n");
        List<Integer> list = new ArrayList<>();
        while (list.size() < 10) {
            list.add(new Random().nextInt(0, 101));
        }
        findMinMax(list.stream(),
                Integer::compareTo,
                (a, b) -> System.out.println("min: " + a + ", max: " + b));
//-----------------------------------------------------------------------------------------------------------------//
        System.out.println("--------------------------------------------------------------------------------\nTask_2\n");
        int[] num = {4, 2, 5, 7, 3, 7, 3, 7, 4, 7};
        System.out.println("Всего четных чисел:");
        System.out.println(even(num).count());
        System.out.println("Все четные числа из списка:");
        even(num).forEach(System.out::println);
    }
}
