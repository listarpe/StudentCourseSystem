package management.dao.sc.impl;

import management.dao.course.impl.CourseDaoImpl;
import management.dao.course.obj.Course;
import management.dao.sc.SCDao;
import management.dao.sc.obj.SC;
import management.dao.student.impl.StudentDaoImpl;

import management.dao.student.obj.Student;
import management.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SCDaoImpl implements SCDao {
    @Override
    public List<SC> QueryBySno(String Sno) {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        List<SC> scs=new ArrayList<SC>();
        try {
            conn= JDBCUtil.getConnection();
            st=conn.createStatement();
            String sql="select * from SC where Sno='"+Sno+"'";
            rs=st.executeQuery(sql);
            while(rs.next()) {//由于可能查询到多个成绩，所以使用while
                String cno=rs.getString("Cno");
                int grade=rs.getInt("grade");
                StudentDaoImpl sdi = new StudentDaoImpl();
                Student stu= sdi.QueryBySno(Sno);
                CourseDaoImpl cdi = new CourseDaoImpl();
                Course cou = cdi.QueryByCno(cno);
                SC sc=new SC(stu, cou, grade);
                scs.add(sc);//添加到list中
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.ReleaseAll(conn, st, rs);
        }
        return scs;
    }

    @Override
    public List<SC> QueryByCno(String Cno) {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        List<SC> scs=new ArrayList<SC>();
        try {
            conn= JDBCUtil.getConnection();
            st=conn.createStatement();
            String sql="select * from SC where Cno='"+Cno+"'";
            rs=st.executeQuery(sql);
            while(rs.next()) {//由于可能查询到多个成绩，所以使用while
                String sno=rs.getString("Sno");
                int grade=rs.getInt("grade");
                StudentDaoImpl sdi = new StudentDaoImpl();
                Student stu= sdi.QueryBySno(sno);
                CourseDaoImpl cdi = new CourseDaoImpl();
                Course cou = cdi.QueryByCno(Cno);
                SC sc=new SC(stu, cou, grade);
                scs.add(sc);//添加到list中
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.ReleaseAll(conn, st, rs);
        }
        return scs;
    }

    @Override
    public List<Course> notSelected(String Sno) {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        List<Course> courses=new ArrayList<Course>();
        try {
            conn= JDBCUtil.getConnection();
            st=conn.createStatement();
            String sql="select * from Course where Cno not in " +
                    "(select Cno from SC where Sno='"+Sno+"')";
            rs=st.executeQuery(sql);
            while(rs.next()) {//由于可能查询到多个成绩，所以使用while
                String no=rs.getString("Cno");
                String name=rs.getString("Cname");
                //构造学生对象对其属性赋值
                Course cou = new Course(no, name);
                courses.add(cou);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.ReleaseAll(conn, st, rs);
        }
        return courses;
    }

    @Override
    public void insert(String Sno, String Cno) {
        Connection conn=null;
        Statement st=null;
        try {
            conn= JDBCUtil.getConnection();//获取数据库连接
            st=conn.createStatement();
            String sql="insert into SC values('"
                    +Sno+"','"+Cno+"', -1)";
            st.executeUpdate(sql);//执行插入语句
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.Release(conn, st);
        }
    }

    @Override
    public void updateGrade(String Sno, String Cno, int grade) {
        Connection conn=null;
        Statement st=null;
        try {
            conn= JDBCUtil.getConnection();//获取数据库连接
            st=conn.createStatement();
            String sql="update SC set grade = "+grade+" where Sno='"+Sno
                    +"' and Cno = '"+Cno+"'";
            st.executeUpdate(sql);//执行更新语句
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.Release(conn, st);
        }
    }

    @Override
    public void delete(String Sno, String Cno) {
        Connection conn=null;
        Statement st=null;
        try {
            conn= JDBCUtil.getConnection();//获取数据库连接
            st=conn.createStatement();
            String sql="delete from SC where Sno='"+Sno
                    +"' and Cno='"+Cno+"'";
            st.executeUpdate(sql);//执行更新语句
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.Release(conn, st);
        }
    }
}
