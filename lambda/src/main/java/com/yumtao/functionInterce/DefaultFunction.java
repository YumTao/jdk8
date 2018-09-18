package com.yumtao.functionInterce;

public class DefaultFunction {

    public static void main(String[] args) {
        Smaller smaller = new Smaller();
        smaller.print();
    }
}


/**
 * default ： 接口中，使用default定义的方法，可有方法体。
 */
interface Leader {
    default void print() {
        System.out.println("I am a leader");
    }
}

/**
 * 除一个抽象方法外，其他方法都是default 修饰的方法时，仍为函数式接口
 */
@FunctionalInterface
interface Follower {
    default void print() {
        System.out.println("I am a follower");
    }

    void abstractFun();
}

class Smaller implements Leader, Follower {
    public void print() {
        Leader.super.print();
    }

    @Override
    public void abstractFun() {

    }
}