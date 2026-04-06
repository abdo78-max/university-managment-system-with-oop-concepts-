/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package univeristy.managment.system;

import java.time.LocalDate;

/**
 *
 * @author Compu City
 */
public class Enrollment {

    private Student student;
    private Course course;
    private LocalDate dateEnrolled;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Enrollment(Student student, Course course, LocalDate dateEnrolled) {
        this.student = student;
        this.dateEnrolled = dateEnrolled;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(LocalDate dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }

    @Override
    public String toString() {
        return "Enrollment{" + "student=" + student.getStudentID() + ", " + student.getName() + ", course=" + course.getTitle() + ", " + course.getCode() + ", dateEnrolled=" + dateEnrolled + '}';
    }

    public String getEnrollmentDetails() {
        return "Enrollment{" + "student=" + student.getStudentID() + ", " + student.getName() + ", course=" + course.getTitle() + ", " + course.getCode() + ", dateEnrolled=" + dateEnrolled + '}';
    }
}
