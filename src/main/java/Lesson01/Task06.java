package Lesson01;

public class Task06 {
    public static void main (String[]args){
//      6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true,
//      если число отрицательное;

        //Check
        System.out.println(checkUInt(-2000));
        System.out.println(checkUInt(0));
        System.out.println(checkUInt(2000));
    }
    private static boolean checkUInt(long value) {
        if (value < 0) return true;
        else return false;
    }
}
