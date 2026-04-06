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
public class Faculty {

    private String name;
    private String dean;
    private ArrayList<Department> departList = new ArrayList<>();

    public Faculty(String name, String dean) {
        this.name = name;
        this.dean = dean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }

    public ArrayList<Department> getDepartmentDetails() {
        return departList;
    }

    public void addDepartment(Department department) {
        if (!department.getFaculty().equals(this)) {
            System.out.println(department.getName() + " doesn't exist in " + this.getName());
            return;
        }
        if (departList.contains(department)) {
            System.out.println(department.getName() + "is in the list before");
        } else {
            departList.add(department);
            System.out.println("the added department is " + department);
        }
    }

    public void removeDepartment(Department department) {
        if (departList.isEmpty()) {
            IsEmptyException isEmpty = new IsEmptyException("your departList is empty\n");
            throw isEmpty;
        } else if (!departList.contains(department)) {
            NotFoundException isNotFound = new NotFoundException("your department doesn't exist in this List");
            throw isNotFound;
        } else {
            System.out.println("the deleted departList is " + department);
            for (Course course : department.getCoursesList()) {
                for (Professor professor : course.getProfessors()) {
                    professor.getProfessorCoursesList().clear();
                }
                for (Student student : course.getStudents()) {
                    student.getCoursesList().remove(course);
                    student.getEnrolledCourses().removeIf(e -> e.getCourse().equals(course));
                }
                course.getProfessors().clear();
                course.getStudents().clear();
                course.getEnrollments().clear();
            }
            department.getCoursesList().clear();
            department.getProfessorsList().clear();
            departList.remove(department);
        }
    }

    @Override
    public String toString() {
        String depart = "";
        for (Department department : departList) {
            depart += "{" + department.getHead() + "," + department.getName() + "}" + ", ";
        }
        String afterFilteringdepart = "";
        if (!depart.isEmpty()) {
            afterFilteringdepart = depart.substring(0, depart.length() - 2);
        }
        return "Faculty{" + "name=" + name + ", dean=" + dean + ", departList=" + afterFilteringdepart + '}';
    }
}
