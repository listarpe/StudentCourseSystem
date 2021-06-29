package ui.Student.dialog;



import management.action.student.StudentManage;
import management.dao.student.obj.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class AddStudent extends JFrame{
    JPanel addPanel1 = new JPanel();
    JPanel addPanel2 = new JPanel();
    JLabel addLabel1 = new JLabel("学号：");
    JLabel addLabel2 = new JLabel("姓名：");
    JLabel addLabel3 = new JLabel("专业：");
    JLabel addLabel4 = new JLabel("性别：");
    JLabel addLabel5 = new JLabel("年龄：");
    JTextField addText1 = new JTextField("", 10);
    JTextField addText2 = new JTextField("", 10);
    JTextField addText3 = new JTextField("", 10);
    JTextField addText4 = new JTextField("", 10);
    JTextField addText5 = new JTextField("", 10);
    JButton addButton1 = new JButton("确定");

//    Student student = new Student();
//    Boolean clicked = false;
    public AddStudent(List<Student> students, JTable table) {

        setTitle("录入信息");
        setLayout(new BorderLayout());
        setBounds(400, 200, 400, 200);

        addPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        addPanel1.add(addLabel1);
        addPanel1.add(addText1);
        addPanel1.add(addLabel2);
        addPanel1.add(addText2);
        addPanel1.add(addLabel3);
        addPanel1.add(addText3);
        addPanel1.add(addLabel4);
        addPanel1.add(addText4);
        addPanel1.add(addLabel5);
        addPanel1.add(addText5);

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
//                clicked = true;
                String no = addText1.getText();
                String name = addText2.getText();
                String major = addText3.getText();
                String sex = addText4.getText();
                int age = Integer.parseInt(addText5.getText());
                if (no != null) {
//                    student.setSno(no);
//                    student.setSname(name);
//                    student.setSmajor(major);
//                    student.setSsex(sex);
//                    student.setSage(age);

                    StudentManage studentManage = new StudentManage();
                    studentManage.addStudent(no, name, major, sex, age);
                    students.add(studentManage.getStudentBySno(no));

                    table.updateUI();
                    dispose();
                }

            }
        });
    }

//    public Student getStudent() {
//        return student;
//    }
//
//    public Boolean getClicked() {
//        return clicked;
//    }
}
