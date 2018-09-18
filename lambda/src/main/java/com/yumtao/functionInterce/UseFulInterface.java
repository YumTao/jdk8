package com.yumtao.functionInterce;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 常用函数式接口使用
 * Function<T, R>: 功能类，传入T,执行后返回R。 用于将入参处理后并返回的情况
 * Supplier<T>: 生产类，无入参，返回指定需要对象。
 * Consumer<T>: 消费类，使用入参情形，不返回。
 * Predicate<T>: 断言类，传入T，根据自定义逻辑判断，返回布尔值。
 */
public class UseFulInterface {

    public static void main(String[] args) {
        Function<String, Integer> getSize = s -> s.length();
        System.out.println(getSize.apply("test my size"));

        Supplier<List<Ege>> getDozenEge = () -> {
            List<Ege> eges = new ArrayList<>();
            int i = 0;
            while (i < 12) {
                eges.add(new Ege("name" + i));
                i++;
            }
            return eges;
        };
        List<Ege> eges = getDozenEge.get();

        Consumer<List<Ege>> drinkWine = egesTmp -> {
            for (Ege ege : egesTmp) {
                ege.eatMe();
            }
        };
        drinkWine.accept(eges);

        String name = "";
        Predicate<String> isEmpty = s -> null == s || s.length() == 0;
        System.out.println(isEmpty.test(name));
    }

}

class Ege {
    private String name;

    void eatMe() {
        System.out.println("ege:" + name + " be eated");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Ege(String name){
        this.name = name;
    }

}
