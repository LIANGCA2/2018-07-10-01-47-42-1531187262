package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        if(leftBorder>rightBorder){
            int tmp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = tmp;
        }
        List<Integer> list = IntStream.range(leftBorder,rightBorder+1).boxed().collect(Collectors.toList());
       return  list.stream().filter((x)->x%2==0).reduce(0,(sum,x)-> sum + x);
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        if(leftBorder>rightBorder){
            int tmp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = tmp;
        }
        List<Integer> list = IntStream.range(leftBorder,rightBorder+1).boxed().collect(Collectors.toList());
        return  list.stream().filter((x)->x%2!=0).reduce(0,(sum,x)-> sum + x);
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().reduce(0,(sum,x)->sum+3*x+2);

    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
       return  arrayList.stream().map((x)->{
             if(x%2!=0)
                 return 3*x+2;
             else
                 return x;

         }).collect(Collectors.toList());


    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        //求数组中奇数元素的3倍加5的和
        return  arrayList.stream().filter((x)->x%2!=0).reduce(0,(sum,x)-> sum + x*3+5);

    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> list = arrayList.stream().filter((x)->x%2==0).collect(Collectors.toList());
        return list.size()%2==0?(list.get(list.size()/2-1)+list.get(list.size()/2))/2:list.get(list.size()/2);
       // return  (arrayList.stream().filter((x)->x%2==0).collect(Collectors.toList()).size()/2==0?:(arrayList.stream().filter((x)->x%2==0).collect(Collectors.toList()).get()size()/2+1;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return  (arrayList.stream().filter((x)->x%2==0).reduce(0,(sum,x)-> sum + x))/arrayList.stream().filter((x)->x%2==0).collect(Collectors.toList()).size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return  arrayList.stream().filter((x)->x%2==0).collect(Collectors.toList()).contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return  arrayList.stream().filter((x)->x%2==0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evens =  arrayList.stream().filter((x)->x%2==0).sorted().collect(Collectors.toList());
        List<Integer> odds = arrayList.stream().filter((x)->x%2!=0).sorted((a,b)->a>b?-1:1).collect(Collectors.toList());
        evens.addAll(odds);
        return evens;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        AtomicInteger temp = new AtomicInteger(0);
        arrayList =   arrayList.stream().map((x)->{
            int result = (x+ temp.get())*3;
            temp.set(x);
            return result;
        }).collect(Collectors.toList());
        arrayList.remove(0);
        return arrayList;
    }
}
