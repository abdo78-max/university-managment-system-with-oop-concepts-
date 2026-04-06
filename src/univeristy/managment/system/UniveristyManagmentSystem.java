/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package univeristy.managment.system;

import java.time.LocalDate;

/**
 *
 * @author Compu City
 */
public class UniveristyManagmentSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("========== FULL UNIVERSITY MANAGEMENT TEST ==========\n");
        University university = new University("Cairo university", "Egypt", 1908);
        System.out.println("The university is " + university.toString());
        Professor header = new Professor("dr nasim", "nasim@gmail.com");
        System.out.println("The university is " + university.getName() + " and its location " + university.getLocation() + " and its etablished year is " + university.getEstablishedyear());
        Faculty faculty1 = new Faculty("faculty of computer science", "dr Ali");
        Faculty faculty2 = new Faculty("faculty of business", "dr Hosham");
        Department department = new Department("ai", header, faculty1);
        System.out.println(department.toString());
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);
        System.out.println("the added facilites are : " + university.getFacultyList());
        Professor headAccounting = new Professor("dr kamal", "kamal@gmail.com");
        Professor headeconomics = new Professor("dr wael", "wael@gmail.com");
        Professor headManagement = new Professor("dr adel", "adel@gmail.com");
        Professor headStatistics = new Professor("dr mahmoud", "adel@gmail.com");
        Professor headDS = new Professor("dr Aziza", "Aziza@gmail.com");
        Professor headIT = new Professor("dr Mohamed", "Mohamed@gmail.com");
        Professor professor1 = new Professor("dr Abdallah", "Abdallah@gmail.com");
        Professor professor2 = new Professor("dr Ahmed", "Ahmed@gmail.com");
        Professor professor3 = new Professor("dr Galal", "Galal@gmail.com");
        Professor professor4 = new Professor("dr Hany", "Hany@gmail.com");
        Professor professor5 = new Professor("dr mariem", "mariem@gmail.com");
        Professor professor6 = new Professor("dr waled", "waled@gmail.com");
        Professor professor7 = new Professor("dr marwan", "marwan@gmail.com");
        Professor professor8 = new Professor("dr fared", "fared@gmail.com");
        Department department1 = new Department("programming", headIT, faculty1);
        Department department2 = new Department(" Data science ", headDS, faculty1);
        Department department3 = new Department("Acconting", headAccounting, faculty2);
        Department department4 = new Department("economics", headeconomics, faculty2);
        faculty1.addDepartment(department1);
        faculty1.addDepartment(department2);
        faculty2.addDepartment(department3);
        faculty2.addDepartment(department4);
        Course courseJava = new Course("JA101", "fundenmentals of java programming", 4);
        Course courseDS = new Course("DS101", "Data Structures and algorithms", 5);
        Course courseAC = new Course("AC103", "Cost Accounting", 5);
        Course courseEC = new Course("EC316", "GovermentEconomics", 4);
        department1.addProfessor(professor1);
        department2.addProfessor(professor2);
        department3.addProfessor(professor3);
        department4.addProfessor(professor4);
        department1.addProfessor(professor5);
        department2.addProfessor(professor6);
        department3.addProfessor(professor7);
        department4.addProfessor(professor8);
        department1.addCourse(courseJava);
        department2.addCourse(courseDS);
        department3.addCourse(courseAC);
        department4.addCourse(courseEC);
        department1.assignProfessorToCourse(professor1, courseJava);
        System.out.println(professor1.getProfessorCoursesList());
        System.out.println(courseJava.getProfessors());
        department2.assignProfessorToCourse(professor2, courseDS);
        department3.assignProfessorToCourse(professor3, courseAC);
        department4.assignProfessorToCourse(professor4, courseEC);
        department1.assignProfessorToCourse(professor5, courseJava);
        department2.assignProfessorToCourse(professor6, courseDS);
        department3.assignProfessorToCourse(professor7, courseAC);
        department4.assignProfessorToCourse(professor8, courseEC);
        System.out.println("the depart1courses");
        System.out.println(department1.getCoursesList());
        System.out.println("the depart2courses");
        System.out.println(department2.getCoursesList());
        System.out.println("the depart3courses");
        System.out.println(department3.getCoursesList());
        System.out.println("the depart4courses");
        System.out.println(department4.getCoursesList());
        Student student1 = new Student("Khaled", "Khaled@gmail.com", LocalDate.of(2018, 9, 1));
        System.out.println(student1.toString());
        Student student2 = new Student("Ali", "Ali@gmail.com", LocalDate.of(2017, 7, 2));
        Student student3 = new Student("Abdallah", "Abdallah@gmail.com", LocalDate.of(2016, 5, 3));
        Student student4 = new Student("abdalziz", "abdalziz@gmail.com", LocalDate.of(2015, 7, 8));
        Enrollment enrollment1 = new Enrollment(student1, courseJava, LocalDate.of(2018, 9, 5));
        Enrollment enrollment2 = new Enrollment(student2, courseDS, LocalDate.of(2017, 7, 4));
        Enrollment enrollment3 = new Enrollment(student3, courseAC, LocalDate.of(2016, 5, 5));
        Enrollment enrollment4 = new Enrollment(student4, courseEC, LocalDate.of(2015, 7, 10));
        student1.enrollCourse(enrollment1);
        student2.enrollCourse(enrollment2);
        student3.enrollCourse(enrollment3);
        student4.enrollCourse(enrollment4);
        try {
            courseJava.addStudent(student3);
        } catch (RuntimeException rt) {
            System.out.println(rt);
            courseJava.addStudent(student1);
        }
        System.out.println(student1.getEnrolledCourses());
        try {
            professor1.removeCourses(courseJava);
        } catch (IsEmptyException isEmpty) {
            System.out.println(isEmpty);
        } catch (NotFoundException isNotFound) {
            System.out.println(isNotFound);
        }
        System.out.println(courseJava.getProfessors());
        try {
            courseJava.addStudent(student1);
        } catch (RuntimeException Rt) {
            System.out.println(Rt);
        }
        try {
            courseDS.addStudent(student2);
        } catch (RuntimeException Rt) {
            System.out.println(Rt);
        }
        try {
            courseAC.addStudent(student3);
        } catch (RuntimeException Rt) {
            System.out.println(Rt);
        }
        try {
            courseEC.addStudent(student4);
        } catch (RuntimeException Rt) {
            System.out.println(Rt);
        }
        try {
            courseJava.removeStudent(student1);
        } catch (IsEmptyException isEmpty) {
            System.out.println(isEmpty);
        } catch (NotFoundException isNotFound) {
            System.out.println(isNotFound);
        }
        System.out.println(student1.getCoursesList());
        try {
            student2.dropCourse(enrollment2);
        } catch (IsEmptyException isEmpty) {
            System.out.println(isEmpty);
        } catch (NotFoundException isNotFound) {
            System.out.println(isNotFound);
        }
        try {
            student4.dropCourse(enrollment4);
        } catch (IsEmptyException isEmpty) {
            System.out.println(isEmpty);
        } catch (NotFoundException isNotFound) {
            System.out.println(isNotFound);
        }
        try {
            department1.removeCourse(courseJava);
        } catch (IsEmptyException isEmpty) {
            System.out.println(isEmpty);
        } catch (NotFoundException isNotFound) {
            System.out.println(isNotFound);
        }
        System.out.println(courseJava.getProfessors());
        try {
            department1.removeProfessor(professor1);
        } catch (IsEmptyException isEmpty) {
            System.out.println(isEmpty);
        } catch (NotFoundException isNotFound) {
            System.out.println(isNotFound);
        }
        try {
            faculty1.removeDepartment(department1);
        } catch (IsEmptyException isEmpty) {
            System.out.println(isEmpty);
        } catch (NotFoundException isNotFound) {
            System.out.println(isNotFound);
        }
    }
}
