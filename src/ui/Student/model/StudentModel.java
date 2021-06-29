package ui.Student.model;



import management.dao.student.obj.Student;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentModel implements TableModel {
    List<Student> students=new ArrayList<Student>();
    String headers[]= {"学号","姓名","专业","性别","年龄"};

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return students.size();
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return headers.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return headers[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // TODO Auto-generated method stub
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int c) {
        String str="";
        Student s=students.get(rowIndex);
        if(c==0) {
            str=s.getSno();
        }else if(c==1) {
            str=s.getSname();
        }else if(c==2) {
            str=s.getSmajor();
        }else if(c==3) {
            str=s.getSsex()+"";
        }else if(c==4) {
            str=s.getSage()+"";
        }
        return str;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub

    }

}
