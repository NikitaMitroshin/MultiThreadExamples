package com.company.singleton;

import java.util.Scanner; // импорт класса из внешнего пакета

// Класс - шаблон для создания объектов
public class Dog {
    // поля (свойства) класса - для описания состояния объектов.
    private String name; // в данном случае объект класса Dog будет обладать именем и возрастом
    private int age;

    // конструктор - специальный метод для создания объектов
    public Dog(String name, int age) {
        this.name = name; //присваивание значения полю текущего объекта
        this.age = age;
    }

    // метод для получения значения поля name у объекта типа Dog
    public String getName() {
        return name;
    }

    // метод для получения значения поля age
    public int getAge() {
        return age;
    }

    //главный метод с помощью которого запускается наша программа
    public static void main(String[] args) {
        // создание объекта класса
        // слева объявление переменной, справа создание объекта, = служит для присваивания значеня
        // операция будет выполнена справа налево, тоесть сперва будет создан объект,
        // потом переменной dog будет присвоена ссылка на него
        Dog dog = new Dog("Pes", 15);
        // вывод значения поля name у объекта dog на консоль
        System.out.println("Имя пса: " + dog.getName());
        System.out.println("Возраст пса: " + dog.getAge());

        // создания объекта типа scanner для считывания пользовательского ввода с консоли
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя для песика");

        // считывания строки с консоли
        String nameFromConsole = scanner.next();

        System.out.println("Введите возраст для песика");

        // считывание строки с консоли и привидение ее к числу
        // помните что если будет введена строка которая не может быть преобразована к числу
        // случиться ошибка - исключительная ситуация
        int ageFromConsole = Integer.valueOf(scanner.next());

        Dog dogFromConsole = new Dog(nameFromConsole, ageFromConsole);
        System.out.println("Песик введенный пользователем");
        System.out.println("Имя: " + dogFromConsole.getName());
        System.out.println("Возраст: " + dogFromConsole.getAge());
    }

}
