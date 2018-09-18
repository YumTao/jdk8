package com.yumtao.lambda;

/**
 * Lambda使用相当于匿名内部类的简化
 */
public class Lambda {

    public static void main(String[] args){
        Lambda bean = new Lambda();
        // 带有类型声明的lambda表达式
        MathOperation addition = (int a, int b) -> a + b;
        String addStr = String.format("10 + 20 = %d", addition.operation(10, 20));
        System.out.println(addStr);

        // 不声明变量的lambda表达式
        MathOperation subtion = (a, b) -> a - b;
        String subStr = String.format("10 - 20 = %d", subtion.operation(10, 20));
        System.out.println(subStr);

        MathOperation multion = (a, b) -> { return  a * b; };
        String mulStr = String.format("10 * 20 = %d", multion.operation(10, 20));
        System.out.println(mulStr);

        // Target type of a lambda conversion must be an interface
        // lambda表达式只针对于接口
//        TestAbstractObj obj = (a, b) -> {return 0;};

    }

    interface MathOperation{
        int operation(int i, int b);
    }

    abstract class TestAbstractObj{
        abstract int abstactOpt(String a, String b);
    }

}
