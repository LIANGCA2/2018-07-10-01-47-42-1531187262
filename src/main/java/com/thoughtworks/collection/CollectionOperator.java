package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if(left<right) {
            return IntStream.range(left, right + 1).boxed().collect(Collectors.toList());
        }else{
             List<Integer> arrayList =  IntStream.range(right, left + 1).boxed().collect(Collectors.toList());
            Collections.reverse(arrayList);
            return arrayList;
        }

    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if(left<right) {
            return IntStream.range(left, right + 1).boxed().filter((x)->x%2==0).collect(Collectors.toList());
        }else{
            List<Integer> arrayList =  IntStream.range(right, left + 1).boxed().filter((x)->x%2==0).collect(Collectors.toList());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }

    public List<Integer> popEvenElments(int[] array) {
       ArrayList<Integer> arrayList =  arrayToList(array);
      return   arrayList.stream().filter((x)->x%2==0).collect(Collectors.toList());

    }

    public int popLastElment(int[] array) {
       return array[array.length-1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        ArrayList<Integer> firstarrayList = arrayToList(firstArray);
        ArrayList<Integer> secondarrayList =arrayToList(secondArray);
       return firstarrayList.stream().filter((x)->secondarrayList.contains(x)).collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(firstArray));
        arrayList.addAll(Arrays.asList(secondArray));
      return  arrayList.stream().distinct().collect(Collectors.toList());

    }
    public ArrayList<Integer> arrayToList(int[] array){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0;i<array.length;i++){
            arrayList.add(array[i]);
        }
        return arrayList;
    }
}
