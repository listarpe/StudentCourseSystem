package ui.Course;


import management.action.course.CourseManage;
import management.dao.course.obj.Course;
import ui.Course.Model.CourseModel;
import ui.Course.dialog.AddCourse;
import ui.Course.dialog.QueryStudent;
import ui.Student.dialog.AddStudent;
import ui.Student.dialog.QueryGrade;
import ui.Student.model.StudentModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class CouMain extends JPanel {
    JScrollPane couJsp = new JScrollPane();
    JPanel couJP2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JButton couButton1 = new JButton("添加");
    JButton couButton2 = new JButton("删除");
    JButton couButton3 = new JButton("查询学生");


    public CouMain() {
        setLayout(new BorderLayout());

        //初始化Table中的课程信息
        CourseManage courseManage = new CourseManage();
        List<Course> courses = courseManage.getCourses();
        CourseModel courseModel = new CourseModel();
        courseModel.setCourses(courses);
        JTable couTable = new JTable();
        couTable.setModel(courseModel);

        couJsp.setSize(600, 400);
        couJsp.setViewportView(couTable);

        couJP2.add(couButton1);
        couJP2.add(couButton2);
        couJP2.add(couButton3);


        add(couJsp, BorderLayout.CENTER);
        add(couJP2, BorderLayout.SOUTH);

        //添加课程
        couButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddCourse addCourse = new AddCourse(courses, couTable);
                couTable.updateUI();
            }
        });

        //删除课程
        couButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index=couTable.getSelectedRow();
                if(index>-1) {
                    courseManage.deleteCourse(courses.get(index).getCno());
                    courses.remove(index);
                    couTable.updateUI();
                }
            }
        });

        //查询选课学生
        couButton3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index=couTable.getSelectedRow();
                if(index>-1) {
                    QueryStudent qs = new QueryStudent(courses.get(index));
                }
            }
        });


    }
}
