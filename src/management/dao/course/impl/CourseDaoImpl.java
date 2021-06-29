package management.dao.course.impl;

import management.dao.course.CourseDao;
import management.dao.course.obj.Course;
import management.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    @Override
    public Course QueryByCno(String Cno) {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        Course course=null;
        try {
            conn= JDBCUtil.getConnection();//获取数据库连接
            st=conn.createStatement();
            String sql="select * from Course where Cno='"+Cno+"'";
            rs=st.executeQuery(sql);//执行查询语句
            if(rs.next()) {//对记录集进行处理
                //根据字段名获取字段内容
                String no=rs.getString("Cno");
                String name=rs.getString("Cname");
                //构造学生对象对其属性赋值
                course=new Course(no, name);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.ReleaseAll(conn, st, rs);
        }
        return course;
    }

    @Override
    public List<Course> Query() {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        List<Course> courses=new ArrayList<Course>();
        try {
            conn= JDBCUtil.getConnection();
            st=conn.createStatement();
            String sql="select * from Course";
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
    public void insert(String Cno, String Cname) {
        Connection conn=null;
        Statement st=null;
        try {
            conn= JDBCUtil.getConnection();//获取数据库连接
            st=conn.createStatement();
            String sql="insert into Course values('"+Cno+"','"+Cname+"')";
            st.executeUpdate(sql);//执行插入语句
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.Release(conn, st);
        }
    }

    @Override
    public void delete(String Cno) {
        Connection conn=null;
        Statement st=null;
        try {
            conn= JDBCUtil.getConnection();//获取数据库连接
            st=conn.createStatement();
            String sql="delete from Course where Cno='"+Cno+"'";
            st.executeUpdate(sql);//执行删除语句
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.Release(conn, st);
        }
    }
}
