package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray{
    private Object[] arr;
    private int length;

    public BaseArray(Object[] arr){
        this.arr = arr;
        this.length = arr.length;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[this.length];
        System.arraycopy(this.arr, 0, newArray, 0, this.length);
        return newArray;
    }

    @Override
    public String operationDescription() {
        return "basic array";
    }

    public void setValue(int index) {
        arr[index] = 0;
    }

}
