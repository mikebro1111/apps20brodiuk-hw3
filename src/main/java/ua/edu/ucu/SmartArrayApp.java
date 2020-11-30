package ua.edu.ucu;

import java.util.Arrays;
import java.util.logging.Filter;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3x]
        SmartArray sa = new BaseArray(integers);

//        sa = new DistinctDecorator(sa); //
//        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
//        sa = new MapDecorator(sa, func); // Result: [2, 4, 6];
//        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3;

        // Alternative
        sa = new MapDecorator(
                    new SortDecorator(
                        new FilterDecorator(sa, pr),
                    cmp),
                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        SmartArray sa = new BaseArray(students);
        sa = new DistinctDecorator(sa);

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getYear() >= 2;
            }
        };
        sa = new FilterDecorator(sa, pr);



        MyPredicate pr1 = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getGPA() >= 4;
            }
        };
        sa = new FilterDecorator(sa, pr1);




        String[] result = new String[sa.size()];
        for (int i = 0; i < sa.size(); i++) {
            result[i] = ((Student) sa.toArray()[i]).getName();
        }
        Arrays.sort(result);
        return Arrays.copyOf(result, result.length);




    }
    public static void main(String[] args){
        Integer[] integers = {-1, 2, 0, 1, -5, 3, 3, -1};
        Object[] result = filterPositiveIntegersSortAndMultiplyBy2(integers);
        System.out.println(Arrays.toString(result));

        Student[] students = {
                new Student("Ivar", "Grimstad", 3.9, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Antons", "Kranga", 4.0, 2),
                new Student("Burr", "Sutter", 4.2, 2),
                new Student("Philipp", "Krenn", 4.3, 3),
                new Student("Tomasz", "Borek", 4.1, 2),
                new Student("Ittai", "Zeidman", 4.5, 1),
                new Student("Burr", "Sutter", 4.2, 2)};
        Object[] equals = findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(students);
//        findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(students);
        System.out.println(Arrays.toString(equals));
    }




}
