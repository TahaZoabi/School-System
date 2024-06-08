package services;

import models.Grade;
import models.School;
import models.Student;
import models.Teacher;

public class SchoolServices {

    School mySchool;

    public SchoolServices(School mySchool) {
        this.mySchool = mySchool;
    }

    public School getMySchool() {
        return mySchool;
    }

    // methods to add students/teachers/grades
    public void addStudent(Student student) {
        this.mySchool.getStudents().add(student);
    }

    public void addTeacher(Teacher teacher) {
        this.mySchool.getTeachers().add(teacher);
    }

    public void addGrade(Grade grade) {
        this.mySchool.getGrades().add(grade);
    }

    // methods to delete students/teachers/grades
    public void deleteStudent(Student student) {
        this.mySchool.getStudents().remove(student);
    }

    public void deleteTeacher(Teacher teacher) {
        this.mySchool.getTeachers().remove(teacher);
    }

    public void deleteGrade(Grade grade) {
        this.mySchool.getGrades().remove(grade);
    }

    // methods to search for a student/teacher/grade by name
    public Student getStudentByName(String name) {
        // check if the given name equals  any name in the students array
        for (Student student : this.mySchool.getStudents()) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    public Teacher getTeacherByName(String name) {
        for (Teacher teacher : this.mySchool.getTeachers()) {
            if (teacher.getName().equalsIgnoreCase(name)) {
                return teacher;
            }
        }
        return null;
    }

    public Grade getGradeByName(String name) {
        for (Grade grade : this.mySchool.getGrades()) {
            if (grade.getName().equals(name)) {
                return grade;
            }
        }
        return null;
    }
}
