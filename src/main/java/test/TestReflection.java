package test;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflection {

    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<TestRef> testRef = TestRef.class;
//        Class<?> testRef = Class.forName("TestRef");

        TestRef object = new TestRef();
        Method methodPut = testRef.getMethod("put");
        methodPut.invoke(object, null);
        Method methodGet = testRef.getMethod("get", String.class);
        methodGet.invoke(object, "who");


    }

    class TestRef{
        public void put() {System.out.println("test put success");}
        public void get(String str) {System.out.println("test get success " +str);}
    }


}
