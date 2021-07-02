package ui.Course.dialog;

import management.action.sc.SCManage;
import management.dao.course.obj.Course;
import management.dao.sc.obj.SC;
import ui.Course.Model.CouQueryModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class QueryStudent extends JFrame {
    JPanel jp1 = new JPanel();
    JScrollPane jsp1 = new JScrollPane();
    JLabel label1 = new JLabel();
    JTable table = new JTable();
    JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JButton button = new JButton("登分");

    public QueryStudent(Course course) {
        setTitle("选课学生");
        setLayout(new BorderLayout());
        setBounds(400, 200, 500, 300);


        String Cno = course.getCno();
        label1.setText(Cno+"   "+course.getCname());
        jp1.add(label1);

        SCManage scManage = new SCManage();
        List<SC> scs = scManage.getSCByCno(Cno);
        CouQueryModel couQueryModel = new CouQueryModel();
        couQueryModel.setScs(scs);
        table.setModel(couQueryModel);

        jsp1.setViewportView(table);

        jp2.add(button);

        add(jp1, BorderLayout.NORTH);
        add(jsp1, BorderLayout.CENTER);
        add(jp2, BorderLayout.SOUTH);

        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index=table.getSelectedRow();
                if(index>-1) {
                    EnterGrade eg = new EnterGrade(scs.get(index), table);
                    table.updateUI();
                }
            }
        });
    }
}
