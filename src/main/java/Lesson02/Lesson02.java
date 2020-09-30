package Lesson02;

/*
6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
если в массиве есть место, в котором сумма левой и правой части массива равны.
Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
граница показана символами ||, эти символы в массив не входят.
 */
import java.util.*;
import java.util.stream.*;


public class Lesson02 {
    public static void main(String[] args) {
        //Check Tasks
        // Task 01
        System.out.println("Task 01 results");
        System.out.println(generateArrayList(10));
        //Task 02
        System.out.println("Task 02 results");
        System.out.println(Arrays.toString(generatePrepearedArray()));
        //Task 03
        System.out.println("Task 03 results");
        multipleGenArray();
        //Task 04
        System.out.println("Task 04 results");
        qmatrix(5);
        //Task 05
        System.out.println("Task 05 results");
        randomArray();

    }


    //    1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//    С помощью цикла и условия заменить 0 на 1, 1 на 0;
    private static ArrayList generateArrayList(int longArray) {
        // генерируем массив
        IntStream stream = IntStream.range(0, longArray);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int num : stream.toArray()) result.add(new Random().nextInt(2));
        // инвертируем как указано в задание
        ArrayList<Integer> newList = new ArrayList<Integer>();
        result.forEach(value -> newList.add((value == 0 ? 1 : 0)));
        return  newList;
    }

    //    2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static int[] generatePrepearedArray() {
        int[] result = new int[8];
        int[] arrayListPrepeared = new int[] {0,3,6,9,12,15,18,21};
        // добавление значений из задания с помощью цикла
        for (int value = 0; value < result.length; value++) {
            result[value] = arrayListPrepeared[value];
        }
        return result;
    }

    //    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void multipleGenArray () {
        ArrayList<Integer> myArray = new ArrayList<>(Arrays.asList(1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1));
        myArray.forEach(val -> System.out.println(val < 6 ? val*2 : val));
    }

    //    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void qmatrix (int gradeNumber) {
        int[][] array = new int[gradeNumber][gradeNumber];
        array[0][0] = 1;
        for (int val = 0; val < array.length; val++) array[val][val] = val+1;
        for (int[] val : array) System.out.println(Arrays.toString(val));
    }

    //    5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void randomArray() {
        ArrayList<Integer> myArray = new ArrayList<>();
        IntStream stream = IntStream.range(0, 10);
        for (Integer val : stream.toArray()) myArray.add(new Random().nextInt(10));
        System.out.println("Сгенерированный массив: " + myArray);
        Collections.sort(myArray);
        System.out.println("Минимальное значение массива: " + myArray.get(0));
        System.out.println("Максимальное значение массива: " + myArray.get(myArray.size()-1));
    }

}
