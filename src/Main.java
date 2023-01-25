import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ex4();
    }

    static void ex0() {
        /*
        Написать программу, которая пользователя ввести <Имя> в консоли.
        Получит введенную строку и выведет в консольсообщение "Привет, <Имя>!"
        */
        System.out.println("Как тебя зовут?");
        try (Scanner scanner = new Scanner(System.in)) {
            String name = scanner.nextLine();
            System.out.printf("Привет, %s!", name);
        }
        //scanner.close(); Используется для закрытия ресурса scanner, если пользуемся как здесь try, то try закрывает ресурс автоматически
    }

    static void ex1() {
        /*
        В консоли запросить имя пользователя. В зависимости лот текущего времени,
        вывести приветствие вида
        "Доброе утро, <Имя>!", если время от 05:00 до 11:59
        "Добрый день, <Имя>!", если время от 12:00 до 17:59
        "Добрый вечер, <Имя>!", если время от 18:00 до 22:59
        "Доброй ночи, <Имя>!", если время от 23:00 до 04:00
        */
        System.out.println("Как тебя зовут?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        if (hour >= 5 && hour < 12) {
            System.out.printf("Доброе утро, %s!", name);
        } else if (hour >= 12 && hour < 18) {
            System.out.printf("Добрый день, %s!", name);
        } else if (hour >= 18 && hour < 23) {
            System.out.printf("Добрый вечер, %s!", name);
        } else {
            System.out.printf("Доброй ночи, %s!", name);
        }
    }

    static void ex2() {
        /* Дан массив двоичных чисел,
        например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1
         */
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(2);
        }
        System.out.println(Arrays.toString(arr));
        int res = ex2_1(arr, 1);
        System.out.printf("Максимальное количество подряд идущих <1> равно %d", res);
    }

    static int ex2_1(int[] arr, int num) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                count++;
            } else {
                if (maxCount < count) {
                    maxCount = count;
                }
                count = 0;
            }
        }
        if (maxCount < count) {
            maxCount = count;
        }
        return maxCount;
    }

    static void ex3() {
        /*
        Дан массив nums = [3,2,5,3] и число val = 3.
        Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
        Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного,
        а остальные равны ему.
         */
        int[] arr = new int[]{3,2,5,3};
        int[] res = new int[arr.length];
        int val = 3;
        Arrays.fill(res, val);
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                res[j] = arr[i];
                j ++;
            }
        }
        System.out.println(Arrays.toString(res));
    }
    static void ex4() {
        /*
        Во фразе "Добро пожаловать на курс по Java" переставить слова в обратном порядке.
         */
        String s = "Добро пожаловать на курс по Java";
        String[] arr = s.split(" ");
        String res = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            res += arr[i] + " ";
        }
        System.out.println(res);
    }


}