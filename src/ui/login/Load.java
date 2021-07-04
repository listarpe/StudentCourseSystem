package ui.login;

import management.action.student.StudentManage;
import management.dao.student.obj.Student;
import ui.Main.MainGUI;
import ui.login.studentLogin.StuLoad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Load extends JFrame {
    JLabel jLabel1 = new JLabel("用户名：");
    JLabel jLabel2 = new JLabel("  密码：");
    JLabel jLabel3 = new JLabel("");
    JTextField jTextField = new JTextField("", 20);
    JPasswordField jPasswordField = new JPasswordField("", 20);
    JButton jButton = new JButton("登录");
    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();

    public Load() {
        setTitle("登录界面");
        setBounds(400, 200, 300, 200);

        jPanel1.setLayout(new FlowLayout());
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField);
        jPanel1.add(jLabel2);
        jPanel1.add(jPasswordField);

        jPanel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jPanel2.add(jLabel3);
        jPanel2.add(jButton);

        setLayout(new BorderLayout());

        add(jPanel1, BorderLayout.CENTER);
        add(jPanel2, BorderLayout.SOUTH);

        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String userName = jTextField.getText();
                String password = new String(jPasswordField.getPassword());
                StudentManage studentManage = new StudentManage();
                List<Student> students = studentManage.getStudents();
                Boolean flag = false;

                for (Student student:students) {
                    if (userName.equals(student.getSno())){
                        flag = true;
                    }
                }

                if (userName.equals("admin") && password.equals("123456")) {
                    dispose();
                    JFrame mainGUI = new MainGUI();
                }else if (flag && password.equals("123456")){
                    dispose();
                    JFrame stuLoad = new StuLoad(userName);
                } else {
//                    jLabel3.setText(userName == "admin"? "yes":"no");
//                    jLabel3.setText(password == "123456"? "yes":"no")
                    jLabel3.setText("登录失败");
                }
            }
        });
    }
}
