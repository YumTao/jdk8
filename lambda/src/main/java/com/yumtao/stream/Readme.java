package com.yumtao.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stream：(高级迭代器)函数式编程方式在集合类上进行复杂操作的工具，更像一个高级版本的 Iterator
 * 常用方法：
 * filter ：根据条件筛选元素
 * collect(toList())：返回当前集合
 * foreach: 遍历当前集合
 * map: 将一种类型的值转换成另外一种类型。转换集合类型
 * flatmap: 用于多个stream合并
 * reduce: 用于根据集合及自行实现的函数获取单个元素（同MapReduce，旨在合并的意思）
 * parallel：并行流，使API为并行 （同Collection类parallelStream）
 * sequential：顺序流，使API为顺序执行
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

        System.out.println("===========filter 对集合进行筛选， collect 转换stream至集合===========");
        List<String> lengthGt2List = nameGroup.stream().filter(s -> s.length() > 2).collect(Collectors.toList());
        lengthGt2List.stream().filter(s -> s.length() == 4).forEach(System.out::println);

        System.out.println("===========map 修改集合到集合，可不同类型===========");
        List<Integer> nameSize = nameGroup.stream().map(s -> s.length()).collect(Collectors.toList());
        nameSize.stream().forEach(System.out::println);

        System.out.println("===========flatmap stream合并===========");
        Stream<?> flatMap = Stream.of(Arrays.asList("a", "b"), Arrays.asList(1, 2, 3)).flatMap((s) -> s.stream());
        flatMap.forEach(System.out :: println);

        System.out.println("===========max min 传入排序规则取最大最小值 ===========");
        List<Integer> number = new ArrayList<>();
        number.add(1);
        number.add(100);
        number.add(12);
        Integer max = number.stream().max((Integer a, Integer b) -> a.intValue() - b.intValue()).get();
        Integer min = number.stream().min((Integer a, Integer b) -> a.intValue() - b.intValue()).get();
        System.out.println(max);
        System.out.println(min);

        System.out.println("===========reduce 根据指定函数，把集合汇聚成一个元素 ===========");
        seqReduce(10001);
        paraReduce(10001);

        // type2: 两个参数，第一个参数为初始值，返回第一个参数类型
        List<Integer> map3 = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            map3.add(i);
        }
        Integer sum2 = map3.stream().reduce(50, (Integer a, Integer b) -> a + b);
        System.out.println(sum2);
    }

    private static void paraReduce(int size) {
        long paraBefore = System.currentTimeMillis();
        List<Integer> map2 = new ArrayList<>();
        for (int i = 1; i < size; i++) {
            map2.add(i);
        }
        // type1: 一个参数，指定函数，返回optional
        Integer sum3 = map2.stream().parallel().reduce((Integer a, Integer b) -> a + b).get();
        System.out.println(sum3);
        long paraAfter = System.currentTimeMillis();
        System.out.println(String.format("para take : %d 秒", paraAfter - paraBefore));
    }

    private static void seqReduce(int size) {
        long seqBefore = System.currentTimeMillis();
        List<Integer> map = new ArrayList<>();
        for (int i = 1; i < size; i++) {
            map.add(i);
        }
        // type1: 一个参数，指定函数，返回optional
        Integer sum = map.stream().reduce((Integer a, Integer b) -> a + b).get();
        System.out.println(sum);
        long seqAfter = System.currentTimeMillis();
        System.out.println(String.format("seq take : %d 秒", seqAfter - seqBefore));
    }
}
