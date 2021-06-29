package ui.Student.dialog;

import management.action.sc.SCManage;
import management.dao.sc.obj.SC;
import management.dao.student.obj.Student;
import ui.Student.model.StuQueryModel;

import java.util.List;

import javax.swing.*;
import java.awt.*;

public class QueryGrade extends JFrame {
    JPanel jp1 = new JPanel();
    JScrollPane jsp1 = new JScrollPane();
    JLabel label1 = new JLabel();
    JTable table = new JTable();

    public QueryGrade(Student student) throws HeadlessException {
        setTitle("成绩");
        setLayout(new BorderLayout());
        setBounds(400, 200, 500, 300);


        String Sno = student.getSno();
        label1.setText(Sno+"   "+student.getSname());
        jp1.add(label1);

        SCManage scManage = new SCManage();
        List<SC> scs = scManage.getSCBySno(Sno);
        StuQueryModel stuQueryModel = new StuQueryModel();
        stuQueryModel.setScs(scs);
        table.setModel(stuQueryModel);

        jsp1.setViewportView(table);

        add(jp1, BorderLayout.NORTH);
        add(jsp1, BorderLayout.CENTER);

        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
