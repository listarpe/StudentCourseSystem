package ui.Student.dialog;

import management.action.sc.SCManage;
import management.dao.course.obj.Course;
import management.dao.sc.obj.SC;
import management.dao.student.obj.Student;
import ui.Course.Model.CourseModel;
import ui.Student.model.StuCourseModel;
import ui.Student.model.StuQueryModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class SelectCourse extends JFrame {
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel(new BorderLayout());
    JPanel jp3 = new JPanel(new BorderLayout());
    JPanel jp4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JPanel jp5 = new JPanel();
    JPanel jp6 = new JPanel();
    JPanel jp7 = new JPanel(new GridLayout());
    JScrollPane jsp1 = new JScrollPane();
    JScrollPane jsp2 = new JScrollPane();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel("已选");
    JLabel label3 = new JLabel("未选");

    JTable table1 = new JTable();
    JTable table2  = new JTable();
    JButton button1 = new JButton("选课");
    JButton button2 = new JButton("退课");

    public SelectCourse(Student student) {
        setTitle("选课");
        setLayout(new BorderLayout());
        setBounds(400, 200, 500, 300);

        String Sno = student.getSno();
        String Sname = student.getSname();

        label1.setText(Sno+"   "+Sname);

        SCManage scManage = new SCManage();
        List<SC> scs1 = scManage.getSCBySno(Sno);
        StuCourseModel stuCourseModel1 = new StuCourseModel();
        stuCourseModel1.setScs(scs1);
        table1.setModel(stuCourseModel1);

        List<Course> courses2 = scManage.notSelected(Sno);
        CourseModel courseModel = new CourseModel();
        courseModel.setCourses(courses2);
        table2.setModel(courseModel);

        jsp1.setViewportView(table1);
        jsp2.setViewportView(table2);

        jp1.add(label1);

        jsp1.setViewportView(table1);
        jsp2.setViewportView(table2);

        jp5.add(label2);
        jp6.add(label3);
        jp2.add(jp5, BorderLayout.NORTH);
        jp2.add(jsp1, BorderLayout.CENTER);

        jp3.add(jp6, BorderLayout.NORTH);
        jp3.add(jsp2, BorderLayout.CENTER);

        jp4.add(button1);
        jp4.add(button2);
        jp7.add(jp2);
        jp7.add(jp3);
        add(jp1, BorderLayout.NORTH);
        add(jp7, BorderLayout.CENTER);
        add(jp4, BorderLayout.SOUTH);

        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index=table2.getSelectedRow();
                if(index>-1) {
                   Course course = courses2.get(index);
                   scs1.add(new SC(student, course, 0));
                   courses2.remove(index);
                   scManage.addSC(Sno, course.getCno());
                   table1.updateUI();
                   table2.updateUI();
                }
            }
        });

        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index=table1.getSelectedRow();
                if(index>-1) {
                    SC sc = scs1.get(index);
                    courses2.add(sc.getCourse());
                    scs1.remove(index);
                    scManage.delete(sc);
                    table1.updateUI();
                    table2.updateUI();
                }
            }
        });
    }
}
