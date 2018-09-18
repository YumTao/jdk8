package com.yumtao.lambda;

/**
 * 简化Lambda表达式(当Lambda表达式是调用现有方法时使用)
 */
public class FunctionReference {

    public static void main(String[] args) {
        // String::valueOf 等价于lambda表达式 (s) -> String.valueOf(s);
        NameFormat lambdaOrg = intValue -> String.valueOf(intValue);
        System.out.println(lambdaOrg.getNameFromInt(10));

        // 静态方法引用
        NameFormat funStatic = String::valueOf;
        System.out.println(funStatic.getNameFromInt(100));

        // 构造方法引用
        Life life = Person::new;
        Person jack = life.getInstance("jack", 18);
        System.out.println(jack);
    }
    

}

interface NameFormat {
    String getNameFromInt(int intValue);
}

interface Life {
    Person getInstance(String name, int age);
}

class Person {
    private String name;
    private int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name:" + this.name + " age:" + this.age;
    }
}