/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package univeristy.managment.system;

import java.util.ArrayList;

/**
 *
 * @author Compu City
 */
public class Professor {

    private static int counter = 0;
    private int professorID;
    private String name;
    private String email;
    private ArrayList<Course> professorCoursesList = new ArrayList<>();
    private Department department;

    public Professor(String name, String email) {
        this.professorID = ++counter;
        this.name = name;
        this.email = email;
    }

    public Professor(int professorID, String name, String email, Department department) {
        this.professorID = professorID;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public int getProfessorID() {
        return professorID;
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

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ArrayList<Course> getProfessorCoursesList() {
        return professorCoursesList;
    }

    public void assignCourses(Course course) {
        if (professorCoursesList.contains(course)) {
            System.out.println(this.getName() + " and his id " + this.getProfessorID() + " assigned " + course.getTitle() + " before ");
        } else {
            professorCoursesList.add(course);
            System.out.println(this.getName() + " and his id " + this.getProfessorID() + " assign " + course.getTitle() + " now ");
        }
    }

    public void removeCourses(Course course) {
        if (professorCoursesList.isEmpty()) {
            IsEmptyException isEmpty = new IsEmptyException("your professor list is empty\n");
            throw isEmpty;
        }
        if (!professorCoursesList.contains(course)) {
            NotFoundException isNotFound = new NotFoundException("your list must contain this professor");
            throw isNotFound;
        } else {
            System.out.println(" you deleted the course : " + course.getTitle());
            for (Student student : course.getStudents()) {
                student.getCoursesList().remove(course);
                student.getEnrolledCourses().removeIf(e -> e.getCourse().equals(course));
            }
            professorCoursesList.remove(course);
            course.getProfessors().remove(this);
        }
    }

    public Grade gradeExam(Student student, Exam exam, int marks) {
        if (!exam.getCourse().getStudents().contains(student)) {
            System.out.println(student.getName() + " doesn't belong to course " + exam.getCourse().getTitle());
            return null;
        } else {
            Course course = exam.getCourse();
            Grade grade = new Grade(student, course, exam, marks);
            return grade;
        }
    }

    @Override
    public String toString() {
        String coursesName = "";
        for (Course course : professorCoursesList) {
            coursesName += "{" + course.getTitle() + ',' + course.getCode() + ',' + course.getCredits() + ',' + "}" + ", ";
        }
        String afterFilteringCoursesName = "";
        if (!coursesName.isEmpty()) {
            afterFilteringCoursesName = coursesName.substring(0, coursesName.length() - 2);
        }
        return "Professor{" + "professorID=" + professorID + ", name=" + name + ", email=" + email + ", professorcoursesList=" + afterFilteringCoursesName + '}';
    }
}
