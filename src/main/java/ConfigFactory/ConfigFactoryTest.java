package ConfigFactory;

import ConfigFactory.bean.Coffee;
import ConfigFactory.factory.CoffeeFactory;
import org.junit.Test;

public class ConfigFactoryTest {
    @Test
    public void test() {
        Coffee american = CoffeeFactory.produceCoffee("american");
        System.out.println("Get bean from the config factory container with bean name: " + american.getCoffeeName());

        Coffee latte = CoffeeFactory.produceCoffee("latte");
        System.out.println("Get bean from the config factory container with bean name: " + latte.getCoffeeName());

    }
}
