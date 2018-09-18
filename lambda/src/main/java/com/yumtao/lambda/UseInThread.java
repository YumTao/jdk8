package com.yumtao.lambda;

import java.util.function.Function;

public class UseInThread {

    public static void main(String[] args){

        new Thread(() -> System.out.println("just do it")).start();

        new Thread(Entity::doSometing).start();

        Function<String, Integer> getSize = (String s) -> s.length();
        Integer size = getSize.apply("i am strong");
        System.out.println(size);
    }

}



class Entity{
    static void doSometing(){
        System.out.println("I am doing something");
    }
}