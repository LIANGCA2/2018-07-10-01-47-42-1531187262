package com.thoughtworks.collection;

import com.sun.javafx.scene.control.skin.DoubleFieldSkin;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
       return arrayList.stream().max((x, y) -> (x - y)).get();
    }

    public double getMinimum() {
        return arrayList.stream().min((x, y) -> (x - y)).get();
    }

    public double getAverage() {
        return arrayList.stream().reduce(0,(sum,x)->sum+x)*1.0/arrayList.size();
    }

    public double getOrderedMedian() {

        //List<Integer> list = arrayList.stream().filter((x)->x%2==0).collect(Collectors.toList());
        return arrayList.size()%2==0?((arrayList.get(arrayList.size()/2-1)+arrayList.get(arrayList.size()/2))*1.0/2):arrayList.get(arrayList.size()/2);
    }

    public int getFirstEven() {
     return arrayList.stream().filter((x)->x%2==0).limit(1).collect(Collectors.toList()).get(0);
    }

    public int getIndexOfFirstEven() {
       return arrayList.indexOf(arrayList.stream().filter((x)->x%2==0).limit(1).collect(Collectors.toList()).get(0));
    }

    public boolean isEqual(List<Integer> arrayList) {
        if(this.arrayList.size() == arrayList.size()) {
            for (int i = 0; i < this.arrayList.size(); i++) {
                if (this.arrayList.get(i) != arrayList.get(i)) {
                    return false;
                }
            }
        }else{
            return false;
        }
       return true;
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (singleLink.getNode(i) != null) list.add((Integer)singleLink.getNode(i));
        }
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        return (collect.size() % 2 == 0) ? (collect.get((collect.size()) / 2 - 1) + collect.get((collect.size()) / 2)) * 1.0 / 2 : collect.get((collect.size()) / 2) * 1.0;
    }

    public int getLastOdd() {
        Collections.reverse(arrayList);
        return arrayList.stream().filter((x)->x%2!=0).limit(1).collect(Collectors.toList()).get(0);
    }

    public int getIndexOfLastOdd() {
        Collections.reverse(arrayList);
       return arrayList.size()-1-arrayList.indexOf(arrayList.stream().filter((x)->x%2!=0).limit(1).collect(Collectors.toList()).get(0));
    }
}
