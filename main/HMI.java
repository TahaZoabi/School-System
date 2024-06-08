package main;

import models.Person;
import models.School;
import models.Student;
import models.Teacher;
import services.SchoolServices;
import tools.Options;

import java.util.Scanner;

public class HMI {

    private static final Scanner SCANNER_INPUT = new Scanner(System.in);
    private static SchoolServices schoolServices;

    public static void start() {

        School school = HMI.createSchool();
        System.out.println("Welcome to " + school.getName() + " in " + school.getAddress());
        String action;

        do {
            System.out.println("How can i help you today?");
            action = SCANNER_INPUT.next();

            switch (action) {
                case "addStudent":
                    addStudent();
                    break;
                case "addTeacher":
                    addTeacher();
                    break;
                case "displayAllTeachers":
                    displayAllTeachers();
                    break;
                case "displayAllStudents":
                    displayAllStudents();
                    break;

                case "searchStudentByName":
                    printPersonDataByName(Options.STUDENT);
                    break;
                case "searchTeacherByName":
                    printPersonDataByName(Options.TEACHER);
                    break;
                case "deleteStudent":
                    deletePerson(Options.STUDENT);
                    break;
                case "deleteTeacher":
                    deletePerson(Options.TEACHER);
                    break;
            }

        } while (!action.equalsIgnoreCase("exit"));
    }

    // create a school object
    private static School createSchool() {
        School school = new School();
        school.setName("Range's School");
        school.setAddress("Palestine");
        school.setPhoneNumber("050-123-4567");

        HMI.schoolServices = new SchoolServices(school);
        return school;
    }

    private static void addStudent() {
        Student student = new Student();
        setPersonData(student);
        schoolServices.addStudent(student);
    }

    public static void displayAllStudents() {
        for (Student student1 : HMI.schoolServices.getMySchool().getStudents()) {
            System.out.println(student1.getInfo());
        }
    }

    public static void addTeacher() {
        Teacher teacher = new Teacher();
        setPersonData(teacher);
        schoolServices.addTeacher(teacher);
    }

    public static void displayAllTeachers() {
        for (Teacher teacher : HMI.schoolServices.getMySchool().getTeachers()) {
            System.out.println(teacher.getInfo());
        }
    }

    private static void setPersonData(Person person) {
        if (person instanceof Teacher) {
            System.out.println("Please enter the teacher's name ");
            person.setName(SCANNER_INPUT.next());
            System.out.println("Please enter the teacher's age ");
            person.setAge(SCANNER_INPUT.nextInt());
            System.out.println("PLease enter the teacher's salary");
            ((Teacher) person).setSalary(SCANNER_INPUT.nextDouble());
        }
        else if (person instanceof Student) {
            System.out.println("Please enter the student's name ");
            person.setName(SCANNER_INPUT.next());
            System.out.println("Please enter the student's age ");
            person.setAge(SCANNER_INPUT.nextInt());
            System.out.println("Please enter the student's parent phone number ");
            ((Student) person).setParentPhoneNUmber(SCANNER_INPUT.next());
        }
    }

    private static Person searchPersonByName(Options option) {
        System.out.println("Please enter the student's name");
        String name = SCANNER_INPUT.next();
        Person person;

        if (option == Options.STUDENT) {
            person = schoolServices.getStudentByName(name);
        }
        else {
            person = schoolServices.getTeacherByName(name);
        }

        return person;
    }

    private static void printPersonData(Person person) {
        if (person == null) {
            System.out.println("Student not found, please try again!");
        }
        else {
            System.out.print(person.getInfo());
        }
    }

    private static void printPersonDataByName(Options option) {
        Person p = searchPersonByName(option);
        printPersonData(p);

    }

    private static void deletePerson(Options option) {

        Person p = searchPersonByName(option);
        if (p instanceof Student) {
            schoolServices.deleteStudent((Student) p);
        }
        else {
            schoolServices.deleteTeacher((Teacher) p);

        }
    }


}
