package ConfigFactory.factory;

import ConfigFactory.bean.Coffee;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

/**
 * This class is a class which simulates how spring is initialize and create and load the bean
 * The beans are American Coffee and Latte Coffee instance
 */
public class CoffeeFactory {

    // 1, define a container object to store the coffee object
    // hashMap is the closest structure to simulate the management structure of the beans in spring framework

    private static HashMap<String, Coffee> beanMap = new HashMap<>();

    // 2, load the config file, just need to load once
    static {
        Properties properties = new Properties();
        // use the class loader to load the bean.properties
        InputStream resourceAsStream = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            properties.load(resourceAsStream);
            Set<Object> keys = properties.keySet();
            for (Object key : keys) {
                String className = properties.getProperty((String) key);
                Class<?> c = Class.forName(className);
                // here can either use c.newInstance() to create a new object
                // while from java 9, class.newInstance() is already deprecated
                // Coffee coffee = c.newInstance();
                // the standard and safe method since after java 9 is using the declaredConstructor to get the constructor
                // then use constructor.newInstance to create new object
                Constructor<?> declaredConstructor = c.getDeclaredConstructor();
                Coffee coffee = (Coffee) declaredConstructor.newInstance();
                beanMap.put((String) key, coffee);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Coffee produceCoffee(String name) {
        return beanMap.get(name);
    }
}
