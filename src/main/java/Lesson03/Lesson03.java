package Lesson03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson03 {
    public static void main(String[] args) {
        /* 1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
        * При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
        * После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
         */

        //Check task01
        guessNumber(10, 3);
        System.out.println("\n******************\n");

        //Check task01
        guessWord();
    }
    static private void guessNumber (Integer maxRange, Integer attemps) {
        boolean repeatGame = true;
        Scanner scan;
        while (repeatGame) {
            repeatGame = !repeatGame;
            System.out.printf("Hello user!\nYou have %d attemps and you need to guess the number from 0 to %d.\n",attemps, maxRange );
            int num = new Random().nextInt(maxRange+1);
            for (Integer val = 1; val < attemps+1; val++) {
                boolean isCorrectEnter = false;
                while (!isCorrectEnter) {
                    scan = new Scanner(System.in);
                    System.out.printf("Attemp %d from %d. Enter unsigned number from 0 to %d:\n", val, attemps, maxRange);
                    if (scan.hasNextInt()) {
                        isCorrectEnter = true;
                        int value = scan.nextInt();
                        if (num == value) {
                            System.out.println("You win!");
                            val = attemps + 1;
                        } else {
                            System.out.println("You didn't guess the number :( \n");
                            System.out.printf("The number is %s\n", num<value ? "less" : "more");
                        }
                    } else {
                        System.out.println("You enter incorrect value");
                    }
                }
            }
            System.out.println("Want again? 1 - Yes, 0 Quit.");
            scan = new Scanner(System.in);
            if ((scan.hasNextInt() && scan.nextInt() == 1)) {
                repeatGame = !repeatGame;
            } else {
                System.out.println("You're tired. Goodbye!");
            }
        }
    }

        /*
        2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        * сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
        Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
         */
    private static void guessWord() {
        ArrayList<String> words = new ArrayList<String>(Arrays.asList("apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"));
        String choise = words.get(new Random().nextInt(words.size()-1));
        System.out.printf("Hello! Guess the word which start from \"%s\".\n", choise.substring(0,2));
        Scanner scan;
        Integer attemps = 1;
        String compare = choise.substring(0,2)+ "*************";
        char[] prepear = compare.toCharArray();
        while (true) {
            System.out.printf("Enter word. Attemp #%d\n", attemps);
            scan = new Scanner(System.in);
            String enter = scan.nextLine().toLowerCase();
            if (choise.equals(enter)) {
                System.out.println("You win!");
                break;
            }
            for (int val = 0; val<choise.toCharArray().length && val<enter.toCharArray().length; val++) {
                if (enter.toCharArray()[val] == choise.toCharArray()[val]) {
                    prepear[val] = enter.toCharArray()[val];
                    compare = String.valueOf(prepear);
                } else {break;}
            }
            System.out.println(compare);
            attemps++;
        }
    }
}
