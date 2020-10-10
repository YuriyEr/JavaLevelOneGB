package Lesson05;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class CompanyEmployee {

    // * 1 Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
    private String firstName, secondName, lastName;
    private String position;
    private String email;
    private String phone;
    private String salary;
    private Integer age;

    // * 2 Конструктор класса должен заполнять эти поля при создании объекта;
    public CompanyEmployee(String firstName, String secondName, String lastName, 
                           String position, String email, String phone, String salary, Integer age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = Math.abs(age);
    }

    //фабрика
    public static CompanyEmployee preset() {
        String firstName = "MyFirstName " + "RD-D" + new Random().nextInt(1000);
        String secondName = "MySecondName " + "THREEPIO" + new Random().nextInt(100);
        String lastName = "MyLastName " + "SUPREMO" + new Random().nextInt(10);
        String position = "position" + new Random().nextInt(5);
        String email = new ArrayList<String>(Arrays.asList("Manager","SuperManager","GrandSuperManager"))
                .get(new Random().nextInt(3)) + "stars.su";
        String phone = "+100-" + new Random().nextInt(12345678);
        String salary = String.valueOf(new Random().nextInt(12345));
        Integer age = 20 + new Random().nextInt(100);
        CompanyEmployee obj = new CompanyEmployee(firstName, secondName, lastName, position, email, phone, salary, age);
        return obj;
    }

    // * 3 Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    public void info(Object self, boolean needClassInfo) {
        if (needClassInfo) { System.out.println("Class name: " + this.getClass().getName());};
        for (Field elem : this.getClass().getDeclaredFields()) {
            if (needClassInfo) {
            System.out.println(elem.getName() + " - " + elem.getType().getTypeName());
            }
            if (!elem.getType().isPrimitive()) {
                try {
                    System.out.println(elem.get(self));
                } catch (Exception e){
                    System.out.println(e);
                    System.out.println("Рефлексия не удалась :) 📛");
                }
            }
        }
    }
    public Integer getAge(){return this.age;}
}

// Класс для проверки
class Tester {
    public static void main(String[] args) {
        // * 3 Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
        CompanyEmployee obj = CompanyEmployee.preset();
        obj.info(obj, true);

        // * 4 Создать массив из 5 сотрудников
        ArrayList<CompanyEmployee> objs = new ArrayList<CompanyEmployee>();
        while (objs.size()<5) { objs.add(CompanyEmployee.preset());}

        // * 5 С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        System.out.println("*****\nинформация о сотрудниках старше 40 лет");
        objs.forEach(elem -> {
            if (elem.getAge()>40) {
                System.out.println("**");
                elem.info(elem, false);}
        });
    }
}
