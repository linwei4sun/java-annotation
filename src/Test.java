import annotation.FieldAnnotation;
import annotation.MyAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test
{
    public static void main(String[] args)
    {
        testField();
    }
    public static void testField()
    {
        Class c = TestAnnotation.class;
        TestAnnotation ta = null;
        Field[] fs = c.getDeclaredFields();
        try
        {
            ta = (TestAnnotation)c.newInstance();
            for(Field f : fs)
            {
                FieldAnnotation fa = f.getAnnotation(FieldAnnotation.class);
                String fieldName = f.getName();
                char first = fieldName.charAt(0);
                first = Character.toUpperCase(first);
                StringBuilder sb = new StringBuilder();
                sb.append("set");
                sb.append(first);
                sb.append(fieldName.substring(1,fieldName.length()));
                Method setter = c.getMethod(sb.toString(),String.class);
                setter.invoke(ta,fa.value());
            }
            ta.display();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public static void testMethod()
    {
        Class c = TestAnnotation.class;
        try
        {
            Method m = c.getDeclaredMethod("display");
            MyAnnotation ma = m.getAnnotation(MyAnnotation.class);
            if(ma == null)
                return;
            System.out.print(ma.name() + ":" + ma.value());
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }
    }
}