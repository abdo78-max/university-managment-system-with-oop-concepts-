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
public class University {

    private String name;
    private String location;
    private int establishedyear;
    private ArrayList<Faculty> facultyList = new ArrayList<>();
    private ArrayList<Department> departList = new ArrayList<>();
    private ArrayList<Student> studentsList = new ArrayList<>();

    public University(String name, String location, int establishedyear) {
        this.name = name;
        this.location = location;
        this.establishedyear = establishedyear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEstablishedyear() {
        return establishedyear;
    }

    public void setEstablishedyear(int establishedyear) {
        this.establishedyear = establishedyear;
    }

    public ArrayList<Faculty> getFacultyList() {
        return facultyList;
    }

    public ArrayList<Department> getDepartList() {
        return departList;
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public void addFaculty(Faculty faculty) {
        if (facultyList.contains(faculty)) {
            System.out.println(" you had " + faculty.getName() + " in this " + this.getName() + " before ");
        } else {
            facultyList.add(faculty);
            System.out.println(" you added faculty called " + faculty.getName() + " in the " + this.getName());
        }
    }

    public void removeFaculty(Faculty faculty) {
        if (facultyList.isEmpty()) {
            IsEmptyException isEmpty = new IsEmptyException("the facultyList is empty\n");
            throw isEmpty;
        } else if (!facultyList.contains(faculty)) {
            NotFoundException isNotFound = new NotFoundException("the" + faculty + "is not in the list\n");
            throw isNotFound;
        } else {
            System.out.println(" you deleted faculty called " + faculty.getName());
            for (Department depart : faculty.getDepartmentDetails()) {
                for (Professor professor : depart.getProfessorsList()) {
                    professor.getProfessorCoursesList().clear();
                }
                for (Course course : depart.getCoursesList()) {
                    for (Student student : course.getStudents()) {
                        Iterator<Course> it = student.getCoursesList().iterator();
                        while (it.hasNext()) {
                            Course iteratInCourse = it.next();
                            if (iteratInCourse.equals(course)) {
                                it.remove();
                            }
                        }
                        student.getEnrolledCourses().removeIf(e -> e.getCourse().equals(course));
                    }
                    course.getProfessors().clear();
                    course.getStudents().clear();
                }
                depart.getProfessorsList().clear();
                depart.getCoursesList().clear();
            }
            faculty.getDepartmentDetails().clear();
            facultyList.remove(faculty);
        }
    }

    @Override
    public String toString() {
        String facultyData = "";
        String departsInFaculty = "";
        String studentInFaculty = "";
        for (Faculty faculty : facultyList) {
            facultyData += "{" + faculty.getName() + faculty.getDean() + "}" + ", ";
        }
        for (Department depart : departList) {
            departsInFaculty += "{" + depart.getName() + depart.getHead() + ',' + "}" + ", ";
        }
        for (Student student : studentsList) {
            studentInFaculty += "{" + student.getStudentID() + ',' + student.getName() + ',' + student.getEmail() + "}" + ", ";
        }
        String afterFilteringFacultyData = "";
        if (!facultyData.isEmpty()) {
            afterFilteringFacultyData = facultyData.substring(0, facultyData.length() - 2);
        }
        String afterFilteringDepartsInFaculty = "";
        if (!departsInFaculty.isEmpty()) {
            afterFilteringDepartsInFaculty = departsInFaculty.substring(0, departsInFaculty.length() - 2);
        }
        String afterFilteringStudentInFaculty = "";
        if (!studentInFaculty.isEmpty()) {
            afterFilteringStudentInFaculty = studentInFaculty.substring(0, studentInFaculty.length() - 2);
        }
        return "University{" + "name=" + name + ", location=" + location + ", establishedyear=" + establishedyear + ", facultyList=" + afterFilteringFacultyData + ", departList=" + afterFilteringDepartsInFaculty + ", studentsList=" + afterFilteringStudentInFaculty + '}';
    }
}