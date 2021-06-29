package ui.Course.dialog;

import management.action.sc.SCManage;
import management.dao.sc.obj.SC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EnterGrade extends JFrame {
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JLabel label = new JLabel("分数：");
    JTextField textField = new JTextField("", 10);
    JButton button = new JButton("确定");
    public EnterGrade(SC sc) {
        setTitle("登分");
        setLayout(new BorderLayout());
        setBounds(400, 200, 400, 200);

        jp1.add(label);
        jp1.add(textField);

        jp2.add(button);

        add(jp1, BorderLayout.CENTER);
        add(jp2, BorderLayout.SOUTH);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int grade = Integer.parseInt(textField.getText());
                SCManage scManage = new SCManage();
                String Sno = sc.getStudent().getSno();
                String Cno = sc.getCourse().getCno();
                scManage.addGrade(Sno, Cno, grade);
                sc.setGrade(grade);
                dispose();
            }
        });
    }
}
