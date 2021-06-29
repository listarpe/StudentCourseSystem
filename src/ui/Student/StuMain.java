package ui.Student;


import management.action.student.StudentManage;

import management.dao.student.obj.Student;
import ui.Student.dialog.AddStudent;
import ui.Student.dialog.QueryGrade;
import ui.Student.dialog.SelectCourse;
import ui.Student.model.StudentModel;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class StuMain extends JPanel {
    JScrollPane stuJsp = new JScrollPane();
    JPanel stuJp2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JButton stuButton1 = new JButton("添加");
    JButton stuButton2 = new JButton("删除");
    JButton stuButton3 = new JButton("查询成绩");
    JButton stuButton4 = new JButton("选课");

    public StuMain() {
        setLayout(new BorderLayout());

        //初始化Table中的学生信息
        StudentManage studentManage = new StudentManage();
        List<Student> students = studentManage.getStudents();
        StudentModel studentModel = new StudentModel();
        studentModel.setStudents(students);
        JTable table = new JTable();
        table.setModel(studentModel);

        stuJsp.setSize(600, 400);
        stuJsp.setViewportView(table);

        stuJp2.add(stuButton1);
        stuJp2.add(stuButton2);
        stuJp2.add(stuButton3);
        stuJp2.add(stuButton4);

        add(stuJsp, BorderLayout.CENTER);
        add(stuJp2, BorderLayout.SOUTH);

        //添加学生
        stuButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddStudent addStudent = new AddStudent(students, table);

                table.updateUI();
            }
        });

        //删除学生
        stuButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index=table.getSelectedRow();
                if(index>-1) {
                    studentManage.deleteStudent(students.get(index).getSno());
                    students.remove(index);
                    table.updateUI();
                }
            }
        });

        //查询成绩
        stuButton3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index=table.getSelectedRow();
                if(index>-1) {
                    QueryGrade qg = new QueryGrade(students.get(index));
                }
            }
        });

        //选课
        stuButton4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index=table.getSelectedRow();
                if(index>-1) {
                    SelectCourse selectCourse = new SelectCourse(students.get(index));
                }
            }
        });
    }
}
