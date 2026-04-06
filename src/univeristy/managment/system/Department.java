/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package univeristy.managment.system;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Compu City
 */
public class Department {

    private String name;
    private Professor head;
    private ArrayList<Professor> professorsList = new ArrayList<>();
    private ArrayList<Course> coursesList = new ArrayList<>();
    private Faculty faculty;

    public Department(String name, Professor head, Faculty faculty) {
        this.name = name;
        this.head = head;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor getHead() {
        return head;
    }

    public void setHead(Professor head) {
        this.head = head;
    }

    public ArrayList<Professor> getProfessorsList() {
        return professorsList;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void addCourse(Course course) {
        if (coursesList.contains(course)) {
            System.out.println(course.getTitle() + " is in the department list");
        } else {
            coursesList.add(course);
            System.out.println("The new course is " + course);
        }
    }

    public void removeCourse(Course course) {
        if (coursesList.isEmpty()) {
            IsEmptyException isEmpty = new IsEmptyException("your course lists is empty\n");
            throw isEmpty;
        }
        if (!coursesList.contains(course)) {
            NotFoundException isNotFound = new NotFoundException("your course in not existed in the list\n");
            throw isNotFound;
        } else {
            System.out.println("you deleted the course called : " + course);
            for (Student student : course.getStudents()) {
                student.getCoursesList().remove(course);
                student.getEnrolledCourses().removeIf(e -> e.getCourse().equals(course));
            }
            coursesList.remove(course);
            course.getProfessors().clear();
        }
    }

    public void addProfessor(Professor professor) {
        if (professorsList.contains(professor)) {
            System.out.println(professor.getName() + " is in the list of department ");
        } else {
            professorsList.add(professor);
            System.out.println("the new professor is : " + professor.getName() + " and his id " + professor.getProfessorID());
        }
    }

    public void removeProfessor(Professor professor) {
        if (professorsList.isEmpty()) {
            IsEmptyException isEmpty = new IsEmptyException("you professor lists is empty\n");
            throw isEmpty;
        } else if (!professorsList.contains(professor)) {
            NotFoundException isNotFound = new NotFoundException("your list doesn't contain this : " + professor.getName());
            throw isNotFound;
        } else {
            System.out.println("you deleted professor called: " + professor.getName());
            for (Course course : professor.getProfessorCoursesList()) {
                for (Student student : course.getStudents()) {
                    Iterator<Course> it = student.getCoursesList().iterator();
                    while (it.hasNext()) {
                        Course c = it.next();
                        if (c.getProfessors().contains(professor)) {
                            it.remove();
                        }
                    }
                    student.getEnrolledCourses().removeIf(e -> e.getCourse().equals(course));
                }
            }
            professorsList.remove(professor);
            professor.getProfessorCoursesList().clear();
        }
    }

    public void assignProfessorToCourse(Professor professor, Course course) {
        if (!professorsList.contains(professor)) {
            System.out.println(professor.getName() + " and his id " + professor.getProfessorID() + " is not existed in this " + this.getName() + " department ");
            return;
        }
        if (!coursesList.contains(course)) {
            System.out.println(course.getTitle() + " is not existed in this " + this.getName() + " department ");
            return;
        }
        professor.assignCourses(course);
        course.assignProfessor(professor);
    }

    public ArrayList<Course> getCoursesList() {
        return coursesList;
    }

    @Override
    public String toString() {
        String profName = "";
        String coursesName = "";
        for (Professor professor : professorsList) {
            profName += "{" + professor.getName() + "," + professor.getProfessorID() + "}" + ", ";
        }
        for (Course course : coursesList) {
            coursesName += "{" + course.getCode() + "," + course.getTitle() + "}" + ", ";
        }
        String afterFilteringProfName = "";
        if (!profName.isEmpty()) {
            afterFilteringProfName = profName.substring(0, profName.length() - 2);
        }
        String afterFilteringCoursesName = "";
        if (!coursesName.isEmpty()) {
            afterFilteringCoursesName = coursesName.substring(0, coursesName.length() - 2);
        }
        return "Department{" + "name=" + name + ", head=" + head + ", professorsList=" + afterFilteringProfName + ", coursesList=" + afterFilteringCoursesName + ", faculty=" + faculty.getName() + " " + faculty.getDean() + '}';
    }
}
