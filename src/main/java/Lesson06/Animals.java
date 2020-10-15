package Lesson06;

/*
1. Создать классы Собака и Кот с наследованием от класса Животное.

2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания),
или высоту (для прыжков).

3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.;
плавание: кот не умеет плавать, собака 10 м.).

4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
(Например, dog1.run(150); -> результат: run: true)

5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
 */

interface Realistic { boolean result();}
enum methodName {run, jump, swim};

abstract class Animals {
    abstract void run(Double length);
    abstract void swim(Double length);
    abstract void jump(Double length);

    static void print(Animals obj, boolean result, methodName name) {
        System.out.println(obj.getClass().getSimpleName() + "->" + name + "->" + result);
    }
}

class Cat extends Animals {
    final Double fichuresAnimals = Math.random() * 100;
    @Override
    void run(Double length) {
        Double constraint = 200.0 + fichuresAnimals;
        Realistic can = () -> length < constraint;
        print(this, can.result(), methodName.run);
    }
    @Override
    void swim(Double length) {
        Double constraint = 0.0d;
        Realistic can = () -> length < constraint;
        print(this, can.result(), methodName.swim);
    }
    @Override
    void jump(Double length) {
        Double constraint = 2.0d + fichuresAnimals/90;
        Realistic can = () -> length < constraint;
        print(this, can.result(), methodName.jump);
    }
}

class Dog extends Animals {
    final Double fichuresAnimals = Math.random() * 100;
    @Override
    void run(Double length) {
        Double constraint = 500d + fichuresAnimals;
        Realistic can = () -> length < constraint;
        print(this, can.result(), methodName.run);
    }
    @Override
    void swim(Double length) {
        Double constraint = 10d + fichuresAnimals / 10;
        Realistic can = () -> length < constraint;
        print(this, can.result(), methodName.swim);
    }
    @Override
    void jump(Double length) {
        Double constraint = 0.5d + fichuresAnimals/100;
        Realistic can = () -> length < constraint;
        print(this, can.result(), methodName.jump);
    }
}

// Проверка
class Tester {
    public static void main(String[] args) {
        Dog someDog = new Dog();
        Cat someCat = new Cat();
        someDog.jump(2d);
        someDog.run(500d);
        someDog.swim(2d);
        someCat.jump(1d);
        someCat.run(300d);
        someCat.swim(1d);
    }
}