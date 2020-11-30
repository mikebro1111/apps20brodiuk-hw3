package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    Object[] tempArray;
    MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.function = func;
        this.tempArray = Arrays.copyOf(smartArray.toArray(), smartArray.size());
        this.tempArray = apply(tempArray);
    }

    public Object[] apply(Object[] array){
        ArrayList<Object> result = new ArrayList<>();
        for (Object o : array) {
            result.add(function.apply(o));
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
