package ui.Course.Model;

import management.dao.sc.obj.SC;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class CouQueryModel implements TableModel {
    List<SC> scs = new ArrayList<SC>();
    String headers[] = {"学号","姓名", "成绩"};

    public List<SC> getScs() {
        return scs;
    }

    public void setScs(List<SC> scs) {
        this.scs = scs;
    }

    @Override
    public int getRowCount() {
        return scs.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return headers[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String str="";
        SC sc = scs.get(rowIndex);
        if (columnIndex==0){
            str = sc.getStudent().getSno();
        }else if (columnIndex==1){
            str = sc.getStudent().getSname();
        }else if (columnIndex==2){
            str = sc.getGrade()+"";
        }
        return str;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
