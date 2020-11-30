package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;

import java.util.ArrayList;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    Object[] tempArray;
    MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        this.comparator = cmp;
        this.tempArray = Arrays.copyOf(smartArray.toArray(), smartArray.size());
        sort();
    }

    public void sort(){
        Arrays.sort(tempArray);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(tempArray, tempArray.length);
    }

    @Override
    public String operationDescription() {
        return "distinct " + smartArray.operationDescription();
    }

    @Override
    public int size() {
        return toArray().length;
    }

}
