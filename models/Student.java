package models;

public class Student extends Person {
    private String parentPhoneNUmber;

    public Student(int age, String name, String parentPhoneNUmber) {
        super(age, name);
        this.parentPhoneNUmber = parentPhoneNUmber;
    }


    public Student() {
    }

    @Override
    public String getInfo() {
        return "Name " + this.getName() + ", Age " + this.getAge() + ", Parent Number " + this.getParentPhoneNUmber();
    }


    public String getParentPhoneNUmber() {
        return parentPhoneNUmber;
    }

    public void setParentPhoneNUmber(String parentPhoneNUmber) {
        this.parentPhoneNUmber = parentPhoneNUmber;
    }
}
