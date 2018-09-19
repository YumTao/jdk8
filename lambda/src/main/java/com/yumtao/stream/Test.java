package com.yumtao.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args){
        new Test().fun01();
        System.out.println("======== test split ========");
        new Test().fun02();
    }

    // 查找集合中以a开头的字符的长度集合
    private void fun02(){
        List<String> signList = Arrays.asList("abc", "b", "a", "abcd");
        List<Integer> sizeList = signList.stream().filter((String s) -> s.startsWith("a")).map((String s) -> s.length()).collect(Collectors.toList());
        System.out.println(sizeList);
    }

    // 获取Student集合中年龄小于20岁的集合中年龄最大的学生信息
    private void fun01() {
        List<Student> students = init();
        Student maxAgeStudent = students.stream().filter((Student student) -> student.getAge() < 20).max((Student a, Student b) -> a.getAge() - b.getAge()).get();
        System.out.println("20岁内年龄最大的学生是：" + maxAgeStudent.getAge());
    }

    private List<Student> init() {
        List<Student> list = new ArrayList<>();

        Student s1 = new Student("张三", 21);
        Student s2 = new Student("李四", 19);
        Student s3 = new Student("王五", 18);
        Student s4 = new Student("程六", 17);
        Student s5 = new Student("赵七", 20);

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        
        return list;
    }
}

class Student {
    private String name;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
