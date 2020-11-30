package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    Object[] tempArray;
    MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate pred) {
        super(smartArray);
        this.predicate = pred;
        this.tempArray = Arrays.copyOf(smartArray.toArray(), smartArray.size());
        this.tempArray = test(tempArray);
    }

    public Object[] test(Object[] array){
        ArrayList<Object> result = new ArrayList<>();
        for (Object o : array) {
            if (predicate.test(o)) {
                result.add(o);
            }
        }
        return result.toArray();
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
