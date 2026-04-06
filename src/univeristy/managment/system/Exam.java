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
public class Exam {

    private int examID;
    private Course course;
    private LocalDate date;
    private int totalMarks;
    private Grade grade;

    public Exam(int examID, Course course, LocalDate date) {
        this.examID = examID;
        this.course = course;
        this.date = date;
    }

    public Exam(int examID, Course course, LocalDate date, int totalMarks) {
        this.examID = examID;
        this.course = course;
        this.date = date;
        this.totalMarks = totalMarks;
    }

    public Exam(int examID, Course course, LocalDate date, int totalMarks, Grade grade) {
        this.examID = examID;
        this.course = course;
        this.date = date;
        this.totalMarks = totalMarks;
        this.grade = grade;
    }

    public void scheduleExam(LocalDate dayExam) {
        this.setDate(dayExam);
    }

    public int getExamID() {
        return examID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Exam{" + "examID=" + examID + ", course=" + course.getCode() + "," + course.getTitle() + ", date=" + this.getDate() + ", totalMarks=" + totalMarks + ", grade=" + grade + '}';
    }

    public String getExamDetails() {
        return this.toString();
    }

}
