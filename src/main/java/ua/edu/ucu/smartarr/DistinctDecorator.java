package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;



public class DistinctDecorator extends SmartArrayDecorator{
    Object[] tempArray;
    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        this.tempArray = Arrays.copyOf(smartArray.toArray(), smartArray.size());
        this.tempArray = deleteBalance(tempArray);

    }
    public Object[] deleteBalance(Object[] array){
        ArrayList<Object> result = new ArrayList<>();
        ArrayList<Object> arr = new ArrayList<>(Arrays.asList(array));

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if ((!result.contains(arr.get(i)))) {
                    result.add(arr.get(i));
                }
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
