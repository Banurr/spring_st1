package kz.bitlab.demo.controllers;

import kz.bitlab.demo.db.DBManager;
import kz.bitlab.demo.entities.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController
{
    @GetMapping("/")
    public String HomePage()
    {
        return "home";
    }

    @GetMapping("/allstudents")
    public String AllStudents(Model model)
    {
        ArrayList<Student> students = DBManager.allStudents();
        model.addAttribute("ucheniki",students);
        return "allstudents";
    }

    @GetMapping("/add-student")
    public String addPage()
    {
        return "addstudent";
    }

    @PostMapping("/add-student")
    public String addStudent(@RequestParam (name="name") String name,
                             @RequestParam (name="surname") String surname,
                             @RequestParam (name="exam") int exam)
    {
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        String mark = "";
        if(exam >= 90) mark = "A";
        else if(exam >= 75) mark = "B";
        else if(exam >= 60) mark = "C";
        else if(exam >= 50) mark = "D";
        else mark = "F";
        student.setMark(mark);
        DBManager.addStudent(student);
        return "redirect:/allstudents";
    }
}
