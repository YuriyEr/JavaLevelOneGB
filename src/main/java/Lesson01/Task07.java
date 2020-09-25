package Lesson01;

public class Task07 {
    public static void main(String[] args) {
//        7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
//                метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
        //Check
        greating("Иван");
    }
    private static void greating(String firstname) {
        System.out.println("Привет, " + firstname + "!");
    }
}
