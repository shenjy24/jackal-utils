package com.jonas.collection.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author shenjy
 * @createTime 2022/2/21 11:01
 * @description StreamDemo
 */
public class StreamCreator {

    //创建流: 通过stream方法用集合创建流
    //顺序流与并发流的区分：stream是顺序流，由主线程按顺序对流执行操作；parallelStream是并行流，内部以多线程并行执行的方式对流进行操作，但前提是流中的数据处理没有顺序要求。
    //如果流中的数据量足够大，并行流可以加快速度。除了直接创建并行流，还可以通过parallelStream方法把顺序流转换成并行流。
    public void create1() {
        List<String> list = Arrays.asList("a", "b", "c");
        //创建一个顺序流
        Stream<String> stream = list.stream();
        //创建一个并行流
        Stream<String> parallelStream1 = list.parallelStream();
        //流转换
        Stream<String> parallelStream2 = stream.parallel();
    }

    //创建流: 通过Arrays.stream()方法用数组创建流
    public void create2() {
        int[] array = {1, 3, 5, 8};
        IntStream stream = Arrays.stream(array);
    }

    //创建流: 使用静态方法 of(), iterate(), generate()
    public void create3() {
        //使用of方法
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4);
        //使用iterate方法
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 3).limit(4);
        //使用generate方法
        Stream<Double> stream3 = Stream.generate(Math::random).limit(3);
    }
}
