package management.dao.student.impl;

import management.dao.student.StudentDao;

import management.dao.student.obj.Student;
import management.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public Student QueryBySno(String Sno) {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        Student stu=null;
        try {
            conn= JDBCUtil.getConnection();//获取数据库连接
            st=conn.createStatement();
            String sql="select * from Student where Sno='"+Sno+"'";
            rs=st.executeQuery(sql);//执行查询语句
            if(rs.next()) {//对记录集进行处理
                //根据字段名获取字段内容
                String no=rs.getString("Sno");
                String name=rs.getString("Sname");
                String major=rs.getString("Smajor");
                String sex=rs.getString("Ssex");
                int age=rs.getInt("Sage");
                //构造学生对象对其属性赋值
                stu=new Student(no, name, major, sex, age);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.ReleaseAll(conn, st, rs);
        }
        return stu;
    }

    @Override
    public List<Student> Query() {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        List<Student> students=new ArrayList<Student>();
        try {
            conn= JDBCUtil.getConnection();
            st=conn.createStatement();
            String sql="select * from Student";
            rs=st.executeQuery(sql);
            while(rs.next()) {//由于可能查询到多个成绩，所以使用while
                String no=rs.getString("Sno");
                String name=rs.getString("Sname");
                String major=rs.getString("Smajor");
                String sex=rs.getString("Ssex");
                int age=rs.getInt("Sage");
                //构造学生对象对其属性赋值
                Student stu=new Student(no, name, major, sex, age);
                students.add(stu);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.ReleaseAll(conn, st, rs);
        }
        return students;
    }

    @Override
    public void insert(String Sno, String Sname, String Smajor, String Ssex, int Sage) {
        Connection conn=null;
        Statement st=null;
        try {
            conn= JDBCUtil.getConnection();//获取数据库连接
            st=conn.createStatement();
            String sql="insert into Student values('"
                    +Sno+"','"+Sname+"','"+Smajor+"','"+Ssex+"','"+Sage+"')";
            st.executeUpdate(sql);//执行插入语句
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.Release(conn, st);
        }
    }

    @Override
    public void delete(String Sno) {
        Connection conn=null;
        Statement st=null;
        try {
            conn= JDBCUtil.getConnection();//获取数据库连接
            st=conn.createStatement();
            String sql="delete from Student where Sno='"+Sno+"'";
            st.executeUpdate(sql);//执行删除语句
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.Release(conn, st);
        }
    }
}
