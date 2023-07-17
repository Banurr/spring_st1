package kz.bitlab.demo.db;

import kz.bitlab.demo.entities.Student;

import java.util.ArrayList;
import java.util.Objects;

public class DBManager
{
    public static ArrayList<Student> students = new ArrayList<>();
    public static Long id = 4L;
    static
    {
        students.add(new Student(1L,"Iliyas","Zhuanyshev",95,"A"));
        students.add(new Student(2L,"Bekzat","Amanbay",49,"D"));
        students.add(new Student(3L,"Alikhan","Uzakbayev",70,"C"));
    }
    public static void addStudent(Student student)
    {
        student.setId(id++);
        students.add(student);
    }

    public static Student getStudent(Long id)
    {
        Student student = null;
        for(Student student1 : students)
        {
            if(Objects.equals(student1.getId(), id))
            {
                student = student1;
            }
        }
        return student;
    }
    public static ArrayList<Student> allStudents()
    {
        return students;
    }
}
