/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package univeristy.managment.system;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Compu City
 */
public class Student {

    private static int counter = 0;
    private int studentID;
    private String name;
    private String email;
    private ArrayList<Course> coursesList = new ArrayList<>();
    private ArrayList<Enrollment> enrolledCourses = new ArrayList<>();
    private ArrayList<Exam> tests = new ArrayList<>();
    private ArrayList<Grade> gradesList = new ArrayList<>();
    private LocalDate dateEnrolled;

    public Student(String name, String email) {
        this.studentID = ++counter;
        this.name = name;
        this.email = email;
    }

    public Student(String name, String email, LocalDate dateEnrolled) {
        this.studentID = ++counter;
        this.name = name;
        this.email = email;
        this.dateEnrolled = dateEnrolled;
    }

    public ArrayList<Course> getCoursesList() {
        return coursesList;
    }

    public ArrayList<Enrollment> getEnrolledCourses() {
        return enrolledCourses;
    }

    public int getStudentID() {
        return studentID;
    }

    public ArrayList<Exam> getTests() {
        return tests;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public ArrayList<Grade> getGradesList() {
        return gradesList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(LocalDate dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }

    public void enrollCourse(Enrollment enrollment) {
        if (enrolledCourses.contains(enrollment)) {
            System.out.println(" Student " + this.getName() + " and his id " + this.getStudentID() + " enrolled this course before ");
        } else if (!enrollment.getStudent().equals(this)) {
            System.out.println(" Student " + this.getName() + " and his id " + this.getStudentID() + " doesn't enroll this course ");
        } else {
            enrolledCourses.add(enrollment);
            coursesList.add(enrollment.getCourse());
            System.out.println(" the enrollment course : ");
            System.out.println(enrollment.getEnrollmentDetails());
        }
    }

    public void dropCourse(Enrollment enrollment) {
        if (enrolledCourses.isEmpty()) {
            IsEmptyException isEmpty = new IsEmptyException("you must enter at least one element\n");
            throw isEmpty;
        }
        if (!enrolledCourses.contains(enrollment)) {
            NotFoundException isNotFound = new NotFoundException(enrollment.getCourse().getTitle() + " is not existed in the list");
            throw isNotFound;
        } else {
            System.out.println("the courses which are deleted from enrollmentlist " + enrollment);
            enrolledCourses.remove(enrollment);
            System.out.println("the courses which are deleted from enrollmentlist " + enrollment.getCourse());
            coursesList.remove(enrollment.getCourse());
            enrollment.getCourse().getStudents().remove(this);
            enrollment.getCourse().getEnrollments().remove(enrollment);
        }
    }

    public void takeExam(Exam exam, double marks) {
        if (!coursesList.contains(exam.getCourse())) {
            System.out.println(this.getName() + " and his id " + this.getStudentID() + " doesn't enroll this course ");
            return;
        }
        Course course = exam.getCourse();
        Grade grade = new Grade(this, course, exam, marks);
        gradesList.add(grade);
        System.out.println("Student took exam and his mark is : " + marks);
    }

    @Override
    public String toString() {
        String studentCourses = "";
        String enrolledCourse = "";
        String grade = "";
        for (Course course : coursesList) {
            studentCourses += "{" + course.getCode() + ',' + course.getTitle() + ',' + "}" + ',';
        }
        for (Enrollment enrollment : enrolledCourses) {
            enrolledCourse += "{" + enrollment.getCourse().getCode() + ',' + enrollment.getCourse().getTitle() + ',' + enrollment.getStudent().getStudentID() + ',' + enrollment.getStudent().getName() + ',' + enrollment.getStudent().getEmail() + ',' + "}" + ", ";
        }
        for (Grade grades : gradesList) {
            grade += "{" + grades.getCourse().getTitle() + " , " + grades.getMarks() + "}" + " , ";
        }
        String afterFilteringStudentCourses = "";
        if (!studentCourses.isEmpty()) {
            afterFilteringStudentCourses = studentCourses.substring(0, studentCourses.length() - 2);
        }
        String afterFilteringEnrolledCourse = "";
        if (!enrolledCourse.isEmpty()) {
            afterFilteringEnrolledCourse = enrolledCourse.substring(0, enrolledCourse.length() - 2);
        }
        String afterFilteringGrades = "";
        if (!grade.isEmpty()) {
            afterFilteringGrades = grade.substring(0, grade.length() - 2);
        }
        return "Student{" + "studentID=" + studentID + ", name=" + name + ", email=" + email + ", coursesList=" + afterFilteringStudentCourses + ", enrolledCourses=" + afterFilteringEnrolledCourse + ", tests=" + tests + ", gradesList=" + afterFilteringGrades + ", dateEnrolled=" + dateEnrolled + '}';
    }
}
