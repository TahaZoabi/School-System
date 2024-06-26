package models;

public abstract class Person {
    private String name;
    private int age;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract String getInfo();


}
