package models;

public class Teacher extends Person {

    private double salary;

    public Teacher(int age, String name, double salary) {
        super(age, name);
        this.salary = salary;
    }

    public Teacher() {
    }

    @Override
    public String getInfo() {
        return "Name " + this.getName() + ", Age " + this.getAge() + ", Salary " + this.getSalary();

    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
