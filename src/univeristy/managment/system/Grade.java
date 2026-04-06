/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package univeristy.managment.system;

/**
 *
 * @author Compu City
 */
public class Grade {

    private Student student;
    private Course course;
    private Exam exam;
    private double marks;

    public Grade(Student student, Exam exam, double marks) {
        this.student = student;
        this.exam = exam;
        this.marks = marks;
    }

    public Grade(Student student, Course course, Exam exam, double marks) {
        this.student = student;
        this.course = course;
        this.exam = exam;
        this.marks = marks;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public Exam getExam() {
        return exam;
    }

    public double getMarks() {
        return marks;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Grade{" + "student=" + student.getStudentID() + " " + student.getName() + ", course=" + course.getCode() + " " + course.getTitle() + ", exam=" + exam.getExamID() + " " + ", marks=" + marks + '}';
    }

    public String getGradeDetails() {
        return this.toString();
    }
}
