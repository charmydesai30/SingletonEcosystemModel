/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Student;

import java.util.ArrayList;

/**
 *
 * @author Ami Gandhi
 */
public class StudentDirectory {
    
    private ArrayList<Student> studentList;

    public StudentDirectory() {
        studentList = new ArrayList();
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }
    
    public Student createStudent(String name){
        Student stud = new Student();
        stud.setName(name);
        studentList.add(stud);
        return stud;
    }
}