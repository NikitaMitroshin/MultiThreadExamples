package com.company;

public class MC {
    boolean a;
    boolean b;

    void m1() {
        a= true;
        b= true;
    }

    void m2() {
        while (!b) {
            System.out.println(a);
        }
    }

    //2 потока
    //t1 вызывает m1, t2 вызывает m2
    //не всегда они будут выполнены в нужном порядке
    //что влияет на выполнение (реордеринг): процессор, рантайкм, jit компилятор

}
