package dz19;

import dz19.Annotations.AfterSuite;
import dz19.Annotations.BeforeSuite;
import dz19.Annotations.Test;
import dz19.Exceptions.AnnotaionException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestRunner {
    public static void start(Tests tests) throws AnnotaionException, InvocationTargetException, IllegalAccessException {
        Method beforeSuite = null, afterSuite = null;
        List<Method> testList = new ArrayList<>();

        //считываем все методы класса и выделяем из них before и after suites, а также список тестов
        for(Method method : tests.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(BeforeSuite.class)){
                if(beforeSuite==null) {
                    beforeSuite = method;
                }else {
                    throw new AnnotaionException("There can be only one BeforeSuite!");
                }
            }
            if(method.isAnnotationPresent(AfterSuite.class)){
                if(afterSuite==null) {
                    afterSuite = method;
                }else {
                    throw new AnnotaionException("There can be only one AfterSuite!");
                }
            }
            if(method.isAnnotationPresent(Test.class)){
                testList.add(method);
            }
        }

        //проверяем наличие before и after suites ,а также наличие самих тестов
        if(beforeSuite==null | afterSuite==null | testList.isEmpty()){
            throw new AnnotaionException("Test class must contain Before and After suites and at least one test method!");
        }

        beforeSuite.invoke(tests);

        //далее отсоритуем все тесты в списке по их приоритету и запустим их в уже отсортированном порядке
        Collections.sort(testList, new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                    Test annotation1 = o1.getAnnotation(Test.class);
                    Test annotation2 = o2.getAnnotation(Test.class);
                    return Integer.compare(annotation1.priority(), annotation2.priority());
            }
        });

        for (Method method : testList) {
            method.invoke(tests);
        }

        afterSuite.invoke(tests);
    }
}
