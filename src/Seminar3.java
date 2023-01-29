import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Seminar3 {
    public static void main(String[] args) {
        ex3();
    }

    static void ex1(int n) {
        /*
        Заполнить список десятью случайными числами.
        Отсортировать список методом sort() и вывести его на экран.
         */
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        System.out.println();
        Collections.sort(list);
        Collections.reverse(list);
        System.out.println(list);

    }
    static void ex0() {
        /*
        Даны следующие строки, cравнить их с помощью == и метода equals() класса Object
            String s1 = "hello";
            String s2 = "hello";
            String s3 = s1;
            String s4 = "h" + "e" + "l" + "l" + "o";
            String s5 = new String("hello");
            String s6 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});
         */
        String s1 = "hello";
        String s2 = "hello";
        String s3 = s1;
        String s4 = "h" + "e" + "l" + "l" + "o";
        String s5 = new String("hello");
        String s6 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});

        //System.out.println(s1 == s2);
        System.out.println(s1.equals(s6));
    }
    static void ex2() {
        /*
        Создать список типа ArrayList
        Поместить в него как строки, так и целые числа.
        Пройти по списку, найти и удалить целые числа.
         */
        List list = new ArrayList();
        list.add(55);
        list.add("Привет");
        list.add(44);
        list.add("Gjrf");
        list.add(890);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Integer) {
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
    }
    static void ex3() {
        /*
        Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так,
        что на 0й позиции каждого внутреннего списка содержится название жанра,
        а на остальных позициях - названия книг. Напишите метод для заполнения данной структуры.
         */
        List<List<String>> list = new ArrayList<>();
        addBook(list, "детектив", "Шерлок Холмс");
        addBook(list, "детектив", "Пуаро");
        addBook(list, "роман", "Война и мир");

        System.out.println(list);
    }
    static void addBook(List<List<String>> list, String genere, String bookName) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(0).equals(genere)) {
                list.get(i).add(bookName);
                return;
            }
        }
        List<String> list1 = new ArrayList<>();
        list1.add(genere);
        list1.add(bookName);
        list.add(list1);
    }
}
