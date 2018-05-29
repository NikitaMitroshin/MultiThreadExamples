package com.company.singleton;

/*
 * ИДЕАЛЬНАЯ РЕАЛИЗАЦИЯ ДЛЯ ОДНОГО ПОТОКА
 */
public class SingletonOneThreadExample {

    private static SingletonOneThreadExample instance = null;

    private static volatile SingletonOneThreadExample instanceFor2 = null; // тогда


    // private static final SingletonOneThreadExample SINGLETON_EXAMPLE = new SingletonOneThreadExample();
    // можно сделать так, тоогда объект создасться при загрузке класса в память
    // но есть вероятность что он нам никогда не понадобится, НО будет создан всеравно
    // создание синглтона как правило ресурсоемкая операция

    private SingletonOneThreadExample() {
    }

    public static SingletonOneThreadExample getInstance() { // вариант сделать synchronized метод  - даст дополнительную нагрузку на приложение
                                                            // не очень вариант, ибо это всего лишь чтение
        if (instance == null) {
            instance = new SingletonOneThreadExample(); // при многопоточке здесь может произойти перезапись
            // значения переменной instance
        }

        /* варик для многопоточки */
        if (instance == null) {
            synchronized (SingletonOneThreadExample.class) { // тогда как только монитор освободится потоки как с цепи сорвавшись начнут инициализировать переменную
                instance = new SingletonOneThreadExample();
            }                                               // если переместить if внутрь synchronized то получается тоже самое что метод делать синх - ресурсоемко
        }

        /* варик для многопоточки 2*/
        if (instance == null) {
            synchronized (SingletonOneThreadExample.class) { // при таком подходе все будет ок, все потоки получат один и тот же объект
                if (instance == null) {                      // но всеравно есть вероятность неправильной работы
                    instance = new SingletonOneThreadExample(); // нужно делать instance volatile
                    // перед тем как считывается значение volatile проихсходит слив данных с процессора в память
                }
            }
        }

        return instance; // тогда здесь будет чтение волатайл что обяжет процессор слить все операции которые были сделаны с переменной на текущий момент в память
        // операции с обычными полями кешируются, НО даже если у нас есть поля класса которые не волатайл, у переменной которая волатайл, то даже их данные будут слиты в память
    }

    public void m1() {

    }

    // вызов из вне SingletonOneThreadExample.getInstance()
    // SingletonOneThreadExample.getInstance().m1();


}
