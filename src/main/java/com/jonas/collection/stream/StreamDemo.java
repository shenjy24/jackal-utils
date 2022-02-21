package com.jonas.collection.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author shenjy
 * @createTime 2022/2/21 11:17
 * @description StreamDemo
 */
public class StreamDemo {

    public static void main(String[] args) {
        StreamDemo app = new StreamDemo();
        app.concat();
    }

    //测试数据
    public List<Person> listPerson() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Tom", 8900, 23, "male", "New York"));
        people.add(new Person("Jack", 7000, 25, "male", "Washington"));
        people.add(new Person("Lily", 7800, 21, "female", "Washington"));
        people.add(new Person("Anni", 8200, 24, "female", "New York"));
        people.add(new Person("Owen", 9500, 25, "male", "New York"));
        people.add(new Person("Alisa", 7900, 26, "female", "New York"));
        return people;
    }

    public List<Integer> listNum() {
        return Arrays.asList(7, 6, 9, 4, 11, 6);
    }

    public List<String> listStr() {
        return Arrays.asList("before", "good", "machine");
    }

    public void match() {
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        //遍历输出符合条件的元素
        list.stream().filter(x -> x > 6).forEach(System.out::println);
        //匹配第一个
        Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst();
        //任意匹配（适用于并行流）
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();
        //是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x > 6);

        System.out.println("匹配第一个值：" + findFirst.get());
        System.out.println("匹配任意一个值：" + findAny.get());
        System.out.println("是否存在大于6的值：" + anyMatch);
    }

    public void filter1() {
        List<Integer> list = Arrays.asList(6, 7, 3, 8, 1, 2, 9);
        Stream<Integer> stream = list.stream();
        stream.filter(x -> x > 7).forEach(System.out::println);
    }

    public void filter2() {
        List<String> people = listPerson().stream().filter(x -> x.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
        System.out.println("工资高于8000的员工姓名：" + people);
    }

    public void max1() {
        List<String> list = Arrays.asList("Tom", "Jonas", "Ahn");
        //获取最长的名字
        Optional<String> maxName = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + maxName.get());
    }

    public void max2() {
        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);
        //自然排序
        Optional<Integer> max1 = list.stream().max(Integer::compareTo);
        //自定义排序
        Optional<Integer> max2 = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("自然排序的最大值：" + max1.get());
        System.out.println("自定义排序的最大值：" + max2.get());
    }

    public void max3() {
        //获取工资最高的员工
        Optional<Person> person = listPerson().stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("员工工资最大值: " + person.map(Person::getSalary).orElse(0));
    }

    public void count() {
        long count = listNum().stream().filter(x -> x > 6).count();
        System.out.println("大于6的元素个数：" + count);
    }

    public void map1() {
        //将字符转换成大写
        List<String> strList = listStr().stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("每个元素大写：" + strList);

        //每个数字+3
        List<Integer> intList = listNum().stream().map(x -> x + 3).collect(Collectors.toList());
        System.out.println("每个元素+3：" + intList);
    }

    public void map2() {
        //每个员工工资+1000
        List<Person> people = listPerson();
        //不改变原来员工集合的方式
        List<Person> people1 = people.stream().map(person -> {
            return new Person(person.getName(), person.getSalary() + 1000, person.getAge(), person.getSex(), person.getArea());
        }).collect(Collectors.toList());
        System.out.println("一次改动前：" + people);
        System.out.println("一次改动后：" + people1);

        //改变原来员工集合的方式
        List<Person> people2 = people.stream().map(person -> {
            person.setSalary(person.getSalary() + 1000);
            return person;
        }).collect(Collectors.toList());
        System.out.println("二次改动前：" + people);
        System.out.println("二次改动后：" + people2);
    }

    //flatMap接受一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
    public void flatMap() {
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> listNew = list.stream().flatMap(s -> {
            //将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).collect(Collectors.toList());
        System.out.println("处理前的集合：" + list);
        System.out.println("处理后的集合：" + listNew);
    }

    //reduce是把一个流缩减成一个值，能实现对集合求和、求乘积和求最值操作
    public void reduce1() {
        List<Integer> list = listNum();
        //求和方式1
        Optional<Integer> sum1 = list.stream().reduce((x, y) -> x + y);
        //求和方式2
        Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
        //求和方式3
        Integer sum3 = list.stream().reduce(0, Integer::sum);

        //求乘积
        Optional<Integer> product = list.stream().reduce((x, y) -> x * y);

        //求最大值方式1
        Optional<Integer> max1 = list.stream().reduce((x, y) -> x > y ? x : y);
        //求最大值方式2
        Integer max2 = list.stream().reduce(1, Integer::max);

        System.out.println("list求和：" + sum1.get() + "," + sum2.get() + "," + sum3);
        System.out.println("list求积：" + product.get());
        System.out.println("list求最大值：" + max1.get() + "," + max2);
    }

    public void reduce2() {
        List<Person> people = listPerson();

        //求工资之和方式1
        Optional<Integer> sum1 = people.stream().map(Person::getSalary).reduce(Integer::sum);
        //求工资之和方式2
        Integer sum2 = people.stream().reduce(0, (sum, p) -> sum += p.getSalary(), (s1, s2) -> s1 + s2);
        //求工资之和方式3
        Integer sum3 = people.stream().reduce(0, (sum, p) -> sum += p.getSalary(), Integer::sum);

        //求最高工资方式1
        Integer max1 = people.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(), Integer::max);
        //求最高工资方式2
        Integer max2 = people.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(), (m1, m2) -> m1 > m2 ? m1 : m2);

        System.out.println("工资之和：" + sum1.get() + "," + sum2 + "," + sum3);
        System.out.println("最高工资：" + max1 + "," + max2);
    }

    //流不存储数据，那么在流中的数据完成处理后，需要将流中的数据重新归集到新的集合中。
    //常用的有toList, toSet和toMap等，另外还有toCollection, toConcurrentMap等复杂用法
    public void collect() {
        List<Integer> list = listNum();
        List<Integer> listNew = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        Set<Integer> set = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());

        List<Person> people = listPerson();
        Map<?, Person> map = people.stream().filter(p -> p.getSalary() > 8000).collect(Collectors.toMap(Person::getName, p -> p));

        System.out.println("toList: " + listNew);
        System.out.println("toSet: " + set);
        System.out.println("toMap: " + map);
    }

    //Collectors提供了用于数据统计的静态方法
    //计数：count
    //平均值：averagingInt, averagingLong, averagingDouble
    //最值：maxBy, minBy
    //求和：summingInt, summingLong, summingDouble
    //统计以上所有：summarizingInt, summarizingLong, summarizingDouble
    public void statistic() {
        List<Person> people = listPerson();
        //求总数
        Long count = people.stream().collect(Collectors.counting());
        //求平均工资
        Double average = people.stream().collect(Collectors.averagingDouble(Person::getSalary));
        //求最高工资
        Optional<Integer> max = people.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare));
        //求工资之和
        Integer sum = people.stream().collect(Collectors.summingInt(Person::getSalary));
        //一次性统计所有信息
        DoubleSummaryStatistics collect = people.stream().collect(Collectors.summarizingDouble(Person::getSalary));

        System.out.println("员工总数：" + count);
        System.out.println("员工平均工资：" + average);
        System.out.println("员工最高工资：" + max);
        System.out.println("员工工资总和：" + sum);
        System.out.println("员工工资统计信息：" + collect);
    }

    //partitioningBy将stream按条件分为两个Map，比如员工按薪资是否高于8000分为两部分
    //groupBy将集合分为多个Map，比如员工按照性别分组，有单极分组和多级分组
    public void partAndGroupBy() {
        List<Person> people = listPerson();
        //按薪资是否高于8000分组
        Map<Boolean, List<Person>> part = people.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        //按性别分组
        Map<String, List<Person>> group1 = people.stream().collect(Collectors.groupingBy(Person::getSex));
        //按性别分组，再按地区分组
        Map<String, Map<String, List<Person>>> group2 = people.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));

        System.out.println("员工按薪资是否大于8000分组情况：" + part);
        System.out.println("员工按性别分组情况：" + group1);
        System.out.println("员工按性别、地区分组情况：" + group2);
    }

    public void joining() {
        List<Person> people = listPerson();
        String names = people.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println("所有员工的名字：" + names);

        List<String> list = listStr();
        String str = list.stream().collect(Collectors.joining("-"));
        System.out.println("拼接后的字符串：" + str);
    }

    public void collectorsReduce() {
        List<Person> people = listPerson();
        Integer sum1 = people.stream().collect(Collectors.reducing(0, Person::getSalary, (i, j) -> (i + j - 5000)));
        System.out.println("员工扣税薪资总和：" + sum1);

        Optional<Integer> sum2 = people.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println("员工薪资总和：" + sum2.get());
    }

    //sorted: 自然排序，流中元素需要实现Comparable接口
    //sorted(Comparator com)：自定义Comparator排序
    public void sorted() {
        List<Person> people = listPerson();
        //按工资升序排序（自然排序）
        List<String> list1 = people.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName).collect(Collectors.toList());
        //按工资倒序排序
        List<String> list2 = people.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).map(Person::getName).collect(Collectors.toList());
        //先按工资再按年龄自然排序
        List<String> list3 = people.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(Person::getName).collect(Collectors.toList());
        //先按工资再按年龄倒序排序
        List<String> list4 = people.stream().sorted((p1, p2) -> {
            if (p1.getSalary() == p2.getSalary()) {
                return p2.getAge() - p1.getAge();
            } else {
                return p2.getSalary() - p1.getSalary();
            }
        }).map(Person::getName).collect(Collectors.toList());
        System.out.println("按工资升序排序：" + list1);
        System.out.println("按工资倒序排序：" + list2);
        System.out.println("先按工资再按年龄自然排序：" + list3);
        System.out.println("先按工资再按年龄倒序排序：" + list4);
    }

    public void concat() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"d", "e", "f", "g"};
        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        //concat: 合并两个流，distinct: 去重
        List<String> list1 = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        //limit: 限制从流中获得前n个数据
        List<Integer> list2 = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
        //skip: 跳过前n个数据
        List<Integer> list3 = Stream.iterate(1, x -> x + 2).skip(1).limit(5).collect(Collectors.toList());

        System.out.println("流合并：" + list1);
        System.out.println("limit：" + list2);
        System.out.println("skip：" + list3);
    }
}
