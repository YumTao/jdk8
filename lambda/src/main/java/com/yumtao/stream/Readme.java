package com.yumtao.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream：(高级迭代器)函数式编程方式在集合类上进行复杂操作的工具，更像一个高级版本的 Iterator
 * 常用方法：
 * filter ：根据条件筛选元素
 * collect：返回当前集合
 * foreach: 遍历当前集合
 * count：获取当前集合size
 *
 */
public class Readme {

    public static void main(String[] args){
        List<String> nameGroup = new ArrayList<>();
        nameGroup.add("jack");
        nameGroup.add("rose");
        nameGroup.add("tom");
        nameGroup.add("bo");

        long count = nameGroup.stream().count();
        System.out.println(count);

        Stream<String> lengthGt2 = nameGroup.stream().filter(s -> s.length() > 2);
        lengthGt2.forEach(System.out::println);

        // 注意：同一个stream不能多次操作，同io，关流后操作会抛异常
//        Stream<String> lengthEq4 = lengthGt2.filter(s -> s.length() == 4);
//        lengthEq4.forEach(System.out::println);
        
        System.out.println("===========分隔符===========");
        List<String> lengthGt2List = nameGroup.stream().filter(s -> s.length() > 2).collect(Collectors.toList());
        lengthGt2List.stream().filter(s -> s.length() == 4).forEach(System.out::println);

//        List<String> lengthGt2List = lengthGt2.collect(Collectors.toList());
//        lengthGt2List.stream().filter(s -> s.length() == 4).forEach(System.out::println);
    }
}
