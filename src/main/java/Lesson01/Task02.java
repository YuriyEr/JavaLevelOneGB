package Lesson01;

import org.javatuples.Octet;

public class Task02 {

    public static void main(String[] args) {
        //Lesson 02 Check
        Octet someTuple = mainTypes();
        for(Object obj: someTuple) {
            System.out.println(obj + " тип " + obj.getClass().getName());
            // для меня осталось тайной почему не смотря на явное указание типа - класс в итоге не Byte или Short а Integer хотя в самом классе нет приведения к Integer
        }

    }

    //Lesson 02 2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
    // чуть чуть усложнил
    // Это не примитивы, но если провалится в класс то Byte наследник примитива byte..
    private static Octet mainTypes () {
        //можно не задавать типы, но тогда результат может быть не ожиданным
        Octet<Byte, Short, Integer, Long, Float, Double, Character, Boolean> values;
        return Octet.with(0,10, 12, 12000, 12.2f, 12.222, 'A', true);
    }
}
