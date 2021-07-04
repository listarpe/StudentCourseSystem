package ui.Main;

import ui.Course.CouMain;
import ui.Student.StuMain;

import javax.swing.*;


public class MainGUI extends JFrame{
    JTabbedPane jt = new JTabbedPane();

    public MainGUI() {
        setTitle("选课系统");
        setBounds(300, 100, 800, 600);

        JPanel stuMain = new StuMain();
        JPanel couMain = new CouMain();

        jt.addTab("学生", stuMain);
        jt.addTab("课程", couMain);

        add(jt);

        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
