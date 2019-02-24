package cn.buqixiaomi.demo.jdk8.lambda.pojo;

public class Dish {

    private String name;
    private boolean vegatarian;
    private int calories;
    private Type type;

    public Dish(String name, boolean vegatarian, int calories, Type type) {
        this.name = name;
        this.vegatarian = vegatarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegatarian() {
        return vegatarian;
    }

    public void setVegatarian(boolean vegatarian) {
        this.vegatarian = vegatarian;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        MEAT,FISH,OTHER
    }
}
