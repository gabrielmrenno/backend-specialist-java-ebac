package br.com.grenno.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AppReflections {
    public static void main(String[] args) {
        Class specificClass = Product.class;

        // instancing object by reflection
        try {
            Constructor specificConstructor = specificClass.getConstructor();
            System.out.println(specificConstructor);

            Product product1 = (Product) specificConstructor.newInstance();
            System.out.println(product1);

            Field[] fields = product1.getClass().getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getType());
                System.out.println(field.getName());
            }

            Method[] methods = product1.getClass().getDeclaredMethods();
            for (Method method : methods ) {
                Class type = method.getReturnType();
                System.out.println(type);
                System.out.println(method.getName());

                System.out.println("Running method");
                // verify if method name starts with get
                if(method.getName().startsWith("set")) {
                    if(method.getParameterTypes()[0].equals(String.class)) {
                        method.invoke(product1, "Gabriel");
                    } else if (method.getParameterTypes()[0].equals(Long.class)) {
                        method.invoke(product1, 10L);
                    } else if (method.getParameterTypes()[0].equals(Double.class)) {
                        method.invoke(product1, 10D);
                    }
                } else {
                    System.out.println(method.invoke(product1));
                }

            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(specificClass);

        Product product = new Product();
        Class specificClass2 = product.getClass();

        System.out.println(specificClass2);
    }
}
