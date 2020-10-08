package Lesson04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class Lesson04 {
    static final Character markerX = 'X';
    static final Character markerO = 'O';
    static final Character empty = '.';

    public static void main(String[] args) {
        startGame(4,2);
    }

    // Запуск игры
    private static void startGame (int grid, int victoryCountSimbols){
        if (grid < victoryCountSimbols) { victoryCountSimbols = grid;}
        if (victoryCountSimbols == 0) { victoryCountSimbols = 1;}
        ArrayList<ArrayList<Character>> map = creataMap(grid);
        boolean finish = false;
        boolean isHuman = true;
        while (!finish) {
            System.out.println("Состояние карты");
            printMap(map, grid);
            System.out.println("\nНовый ход");
            if (isHuman) {
                makeHumanTurn(map, grid);
            } else {
                makePCTurn(grid, map, victoryCountSimbols);
            }
            if (isDrawGame(map, grid)) {
                System.out.println("Это ничья");
                finish = !finish;
                break;
            }
            if (isWin(map, grid, victoryCountSimbols, isHuman)) {
                if (isHuman) {
                    System.out.println("Победил игрок");
                } else {
                    System.out.println("Победил компьютер");
                }
                printMap(map, grid);
                finish = !finish;
                break;
            }
            isHuman = !isHuman;
        }
    }

    //  Создание карты
    private static ArrayList<ArrayList<Character>> creataMap (int grid){
        ArrayList<ArrayList<Character>> map = new ArrayList<ArrayList<Character>>();
        for(int val = 0; val<grid; val++) {
            map.add(new ArrayList<Character>(Collections.nCopies(grid, empty)));
        }
        return  map;
    }

    // Печать карты
    private static void printMap (ArrayList<ArrayList<Character>> map, int grid) {
        IntStream stream = IntStream.range(0, grid+1);
        for (int num : stream.toArray()) {
            System.out.print(num);
        }
        for (int num = 0; num<map.size(); num++) {
            System.out.printf(String.valueOf("\n" + (num+1)));
            map.get(num).forEach(elem -> System.out.print(elem));
        }
    }

    // Проверка на возможность хода
    private static boolean isPossibleMovePlayer (ArrayList<ArrayList<Character>> map, int X, int Y, int grid) {
        if (X < 0 || Y < 0 || X > grid-1 || Y > grid-1) //проверка на максимальное число и минус
        { return false; }
        if (map.get(Y).get(X) != empty)
        { return false; }
        return true;
    }

    // проверка на ничью
    private static boolean isDrawGame (ArrayList<ArrayList<Character>> map, int grid) {
        AtomicBoolean check = new AtomicBoolean(true);
        map.forEach(elem -> {
            elem.forEach(value -> {
                if (value == empty) {
                    check.set(false);
                }
            });
        });
        return check.get();
    }

    // Ход первого игрока (человека)
    private static void makeHumanTurn(ArrayList<ArrayList<Character>> map, int grid) {
        Integer x;
        Integer y;
        boolean cancel = false;
        while (!cancel) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите координаты в формате X Y");
            if (scanner.hasNextInt()) {
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
                if (isPossibleMovePlayer(map, x, y, grid)) {
                    map.get(y).set(x, markerX);
                    cancel = true;
                }
                } else {
                System.out.println("Введены не корректные данные X Y");
                scanner.nextLine();
            }
        }
    }

    // Ход компьютера
    private static void makePCTurn(int grid, ArrayList<ArrayList<Character>> map, int victoryCountSimbols)
    {
        boolean recomendTurn = false;
        int counter = 0;
        // не успел толком логику допилить для ПК ((
        for (int val=0; val<map.size(); val++) {
            for (int valRow=0; valRow<map.size(); valRow++) {
                if (counter>0) {
                    ArrayList<ArrayList<Character>> newMap = (ArrayList<ArrayList<Character>>) map.clone();
                    if (newMap.get(val).get(valRow) == empty && !recomendTurn) {
                        newMap.get(val).set(valRow, markerO);
                        if (isWin(newMap, grid, victoryCountSimbols, false)) {
                            System.out.println("Компьютер сходил в точку: " + (valRow + 1) + " " + (val + 1));
                            map.get(val).set(valRow, markerO);
                            recomendTurn = true;
                            counter += 1;
                        }
                    }
                }
            }
        }
        if (!recomendTurn) {
            Random random = new Random();
            int x, y;
            do {
                x = random.nextInt(grid);
                y = random.nextInt(grid);
            } while (!isPossibleMovePlayer(map, x, y, grid));
            System.out.println("Компьютер сходил в точку: " + (x + 1) + " " + (y + 1));
            map.get(y).set(x, markerO);
        }
    }

    // проверка на победу
    private static boolean isWin (ArrayList<ArrayList<Character>> map, int grid, int victoryCountSimbols, boolean isHuman) {
        // проверка стандартная кол-во фишек равно размеру сетки
        if (map.size() == victoryCountSimbols) {
            return checkWinner(map, isHuman);
            // проверка если кол-во фишек меньше размеру сетки
        } else {
            boolean win = false;
            int maxShiftForMap = map.size() - victoryCountSimbols;
            for (int vertVal = 0; vertVal<maxShiftForMap+1; vertVal++) {
                for (int horizontalVal = 0; horizontalVal < maxShiftForMap + 1; horizontalVal++) {
                    ArrayList<ArrayList<Character>> newMap = creataMap(victoryCountSimbols);
                    for (int valueA = 0; valueA < newMap.size(); valueA++) {
                        for (int valueB = 0; valueB < newMap.size(); valueB++) {
                            newMap.get(valueA).set(valueB, map.get(valueA+vertVal).get(valueB + horizontalVal));
                        }
                    }
                    if (checkWinner(newMap, isHuman)) {
                        horizontalVal = maxShiftForMap;
                        win = true;
                    }
                }
            }
            return win;
        }
    }
    // Блок проверок относительного квадрата
    private static boolean checkWinner(ArrayList<ArrayList<Character>> map, boolean isHuman) {
        return checkWinnerHorizontalandVertical(map, isHuman) ||
                checkWinnerDiagonals(map, isHuman);
    }
    private static boolean checkWinnerHorizontalandVertical(ArrayList<ArrayList<Character>> map, boolean isHuman) {
        char symb = isHuman ? markerX : markerO;
        boolean cols, rows;
        for (int col=0; col<map.size(); col++) {
            cols = true;
            rows = true;
            for (int row=0; row<map.size(); row++) {
                cols &= (map.get(col).get(row) == symb);
                rows &= (map.get(row).get(col) == symb);
            }
            if (cols || rows) return true;
        }
        return false;
    }
    private static boolean checkWinnerDiagonals(ArrayList<ArrayList<Character>> map, boolean isHuman) {
        boolean isWinnerLeft = true;
        boolean isWinnerRight = true;
        char simb = isHuman ? markerX : markerO;
        for (int val = 0; val < map.size(); val++) {
            // вправо
            if (map.get(val).get(val) != simb) {
                isWinnerLeft = false;
            }
            // влево
            if (map.get(val).get(map.size()-val-1) != simb) {
                isWinnerRight = false;
            }
        }
        return (isWinnerLeft || isWinnerRight) ? true : false;
    }
}
