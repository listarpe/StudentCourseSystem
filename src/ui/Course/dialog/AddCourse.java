package ui.Course.dialog;

import management.action.course.CourseManage;
import management.action.student.StudentManage;
import management.dao.course.obj.Course;
import management.dao.student.obj.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class AddCourse extends JFrame {
    JPanel addPanel1 = new JPanel();
    JPanel addPanel2 = new JPanel();
    JLabel addLabel1 = new JLabel("课程号：");
    JLabel addLabel2 = new JLabel("课程名：");
    JTextField addText1 = new JTextField("", 10);
    JTextField addText2 = new JTextField("", 10);

    JButton addButton1 = new JButton("确定");

//    Course course = new Course();
    public AddCourse(List<Course> courses, JTable couTable) {

        setTitle("录入信息");
        setLayout(new BorderLayout());
        setBounds(400, 200, 400, 200);

        addPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        addPanel1.add(addLabel1);
        addPanel1.add(addText1);
        addPanel1.add(addLabel2);
        addPanel1.add(addText2);


        addPanel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        addPanel2.add(addButton1);

        add(addPanel1, BorderLayout.CENTER);
        add(addPanel2, BorderLayout.SOUTH);

        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        addButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String no = addText1.getText();
                String name = addText2.getText();


                if (no != null) {
//                    course.setCno(no);
//                    course.setCname(name);

                    CourseManage courseManage = new CourseManage();
                    courseManage.addCourse(new Course(no, name));
                    courses.add(courseManage.getCourseByCno(no));
                    couTable.updateUI();
                    dispose();
                }

            }
        });
    }

//    public Course getCourse() {
//        return course;
//    }
}
