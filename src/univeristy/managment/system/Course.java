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
public class Course {

    private String code;
    private String title;
    private int credits;
    private ArrayList<Enrollment> enrollments = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Professor> professors = new ArrayList<>();

    public Course(String code, String title, int credits) {
        this.code = code;
        this.title = title;
        if (credits == 0 || credits > 5) {
            throw new IllegalArgumentException("credits must be between 1 and 5");
        }
        this.credits = credits;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public ArrayList<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void addStudent(Student student) {
        if (students.contains(student)) {
            System.out.println(student.getName() + " and his id " + student.getStudentID() + " existed before in the list ");
            return;
        }
        boolean enrolled = false;
        for (Enrollment enrollment : student.getEnrolledCourses()) {
            if (enrollment.getCourse().equals(this)) {
                enrolled = true;
                break;
            }
        }
        if (!enrolled) {
            throw new RuntimeException("Student is not enrolled in this course!\n");
        } else {
            System.out.println("you successfully added : " + student.getName() + " and his id " + student.getStudentID());
            students.add(student);
        }
    }

    public void removeStudent(Student student) {
        if (students.isEmpty()) {
            throw new IsEmptyException("your student List is Empty");
        }
        if (!students.contains(student)) {
            throw new NotFoundException("your student List doesn't contain this : " + student.getName());
        } else {
            System.out.println("You removed a student : " + student.getName() + " and his id is " + student.getStudentID());
            students.remove(student);
            Iterator<Enrollment> it = student.getEnrolledCourses().iterator();
            while (it.hasNext()) {
                Enrollment e = it.next();
                if (e.getCourse().equals(this)) {
                    student.getCoursesList().remove(this);
                    it.remove();
                }
            }
        }
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void assignProfessor(Professor professor) {
        if (professors.contains(professor)) {
            System.out.println(" professor " + professor.getName() + " and his id " + professor.getProfessorID() + " is in the list before");
        } else {
            System.out.println("you assign professor " + professor.getName() + " and his id " + professor.getProfessorID());
            professors.add(professor);
        }
    }

    public void deleteProfessor(Professor professor) {
        if (professors.isEmpty()) {
            IsEmptyException isEmpty = new IsEmptyException("your professor List is Empty\n");
            throw isEmpty;
        } else if (!professors.contains(professor)) {
            NotFoundException isNotFound = new NotFoundException("your professor List doesn't contain this : " + professor.getName() + " and his id " + professor.getProfessorID());
            throw isNotFound;
        } else {
            System.out.println("You removed a professor : " + professor.getName() + " and his id is " + professor.getProfessorID());
            for (Course course : professor.getProfessorCoursesList()) {
                for (Student student : course.getStudents()) {
                    Iterator<Course> it = student.getCoursesList().iterator();
                    while (it.hasNext()) {
                        Course itreatInCourse = it.next();
                        if (itreatInCourse.getProfessors().contains(professor)) {
                            it.remove();
                        }
                    }
                    student.getEnrolledCourses().removeIf(e -> e.getCourse().equals(course));
                }
                Iterator<Professor> it = course.getProfessors().iterator();
                while (it.hasNext()) {
                    Professor itreatInProfessor = it.next();
                    if (itreatInProfessor.equals(professor)) {
                        it.remove();
                    }
                }
            }
            professors.remove(professor);
            professor.getProfessorCoursesList().remove(this);
        }
    }

    @Override
    public String toString() {
        String profName = "";
        for (Professor professor : professors) {
            profName += "{" + professor.getName() + "," + professor.getProfessorID() + "}" + ", ";
        }
        String studentName = "";
        for (Student student : students) {
            studentName += "{" + student.getName() + ',' + student.getStudentID() + "}" + ", ";
        }
        String afterFilteringProfName = "";
        if (!profName.isEmpty()) {
            afterFilteringProfName = profName.substring(0, profName.length() - 2);
        }
        String afterFilteringStudentName = "";
        if (!studentName.isEmpty()) {
            afterFilteringStudentName = studentName.substring(0, studentName.length() - 2);
        }
        return "Course{" + "code=" + code + ", title=" + title + ", credits=" + credits + ", students=" + afterFilteringStudentName + ", professors=" + afterFilteringProfName + '}';
    }

    
}