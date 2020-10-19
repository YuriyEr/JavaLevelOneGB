package Lesson07;

/*
1. Расширить задачу про котов и тарелки с едой
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20)
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
Если коту удалось покушать (хватило еды), сытость = true
4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает,
то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки
и потом вывести информацию о сытости котов в консоль
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
 */

import java.util.Random;

public class Lesson07  extends ActionsAnimals {
    public static void main(String[] args) {
        Cat[] someCats = new Cat[5];
        Plate somePlate = new Plate();
        somePlate.setFoodInPlate(20);
        for (Cat cat : someCats) {
            System.out.println("В тарелке сейчас " + somePlate);
            cat = new Cat();
            System.out.println("Состояние котика " + cat);
            catEats(somePlate, cat);
            System.out.println("Котик попытался покушать 🐱 " + cat + "\n***********");
        }
    }
}

class Cat {
    private Boolean isCatFull = false;
    private Integer catsAppetite = new Random().nextInt(10);
    //setters
    public void setCatsAppetite(Integer byValue) {
        if ((catsAppetite + byValue <= 0)) {
            catsAppetite = 0;
            isCatFull = true;
        } else {
            catsAppetite += byValue;
        }
    }
    //getters
    public Integer getCatsAppetite() { return catsAppetite;}
    public Boolean isCatFull() { return isCatFull;}
    // Object
    @Override
    public String toString() {
        return new String(this.getClass().getSimpleName() +
                " isCatFull: " + isCatFull + ", catsAppetite: " + catsAppetite);
    }

}
class Plate {
    private Integer foodInPlate = new Random().nextInt(10);
    //setters
    public void setFoodInPlate(Integer byValue) {
        if ((foodInPlate + byValue < 0)) {
            foodInPlate = 0;
        } else {
            foodInPlate += byValue;
        }
    }

    //getters
    public Integer getFoodInPlate() {return foodInPlate;}

    // Object
    @Override
    public String toString() {
        return new String(this.getClass().getSimpleName() +
                " foodInPlate: " + foodInPlate);
    }

}
class ActionsAnimals {
    static void catEats (Plate plate, Cat cat) {
        Integer oldAppetite = cat.getCatsAppetite();
        cat.setCatsAppetite(-plate.getFoodInPlate());
        plate.setFoodInPlate(-oldAppetite);
    }
}
