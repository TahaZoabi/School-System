package services;

import models.Grade;
import models.Student;

public class GradeServices {

    Grade myGrade;

    public GradeServices(Grade myGrade) {
        this.myGrade = myGrade;
    }

    public Grade getMyGrade() {
        return myGrade;
    }

    // method to add/delete student from a grade
    public void addStudent(Student student) {
        this.myGrade.getStudents().add(student);
    }

    public void deleteStudent(Student student) {
        this.myGrade.getStudents().remove(student);
    }
}
