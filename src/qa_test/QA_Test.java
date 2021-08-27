/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qa_test;
import java.lang.reflect.Field;
import java.lang.*;
/**
 *
 * @author W I N D O W S
 */
public class QA_Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         ABC abc = new ABC();
    abc.setA(10);
    abc.setB(20);
    abc.setC(30);
    
    ABC abc2 = new ABC();
    abc2.setA(3);
    abc2.setC(6);
    abc2.setD(3);

try {
    ABC abcFinal = mergeObjects(abc, abc2);
    System.out.println("Properties of ABC Final:");
    System.out.println("A: " + abcFinal.getA());
    System.out.println("B: " + abcFinal.getB());
    System.out.println("C: " + abcFinal.getC());
    System.out.println("D: " + abcFinal.getD());
} catch (Exception ex) {
    System.out.println("err:"+ex);
}
    }
    
    @SuppressWarnings("unchecked")
public static <T> T mergeObjects(T first, T second) throws IllegalAccessException, InstantiationException {
    Class<?> clazz = first.getClass();
    Field[] fields = clazz.getDeclaredFields();
    Object returnValue = clazz.newInstance();
    for (Field field : fields) {
        field.setAccessible(true);
        Object value1 = field.get(first);
        Object value2 = field.get(second);
        int int1 = Integer.parseInt(String.valueOf(value1));
        int int2 = Integer.parseInt(String.valueOf(value2));
        int total = int1 + int2;
        field.set(returnValue, total);
    }
    return (T) returnValue;
}


public static class ABC {
    private int a;
    private int b;
    private int c;
    private int d;

    public ABC() {
    }


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
    
    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    
    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
    
    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
}
}
