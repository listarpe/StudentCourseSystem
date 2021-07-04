package ui.login.studentLogin;

import management.action.student.StudentManage;
import ui.Student.dialog.QueryGrade;
import ui.Student.dialog.SelectCourse;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StuLoad extends JFrame {
    JButton jButton1 = new JButton("查询成绩");
    JButton jButton2 = new JButton("选课");
    JPanel jPanel = new JPanel();

    public StuLoad(String userName) {
        setTitle("请选择");
        setBounds(400, 200, 300, 100);


        jPanel.add(jButton1);
        jPanel.add(jButton2);

        add(jPanel);

        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jButton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StudentManage studentManage = new StudentManage();
                JFrame qg = new QueryGrade(studentManage.getStudentBySno(userName));
            }
        });
        jButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StudentManage studentManage = new StudentManage();
                JFrame selectCourse = new SelectCourse(studentManage.getStudentBySno(userName));
            }
        });
    }
}
