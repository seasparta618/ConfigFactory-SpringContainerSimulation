package ConfigFactory.bean;

public abstract class Coffee {
    private String coffeeName;

    protected Coffee() {
    }


    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }
}
