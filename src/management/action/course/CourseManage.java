package management.action.course;

import management.dao.course.CourseDao;
import management.dao.course.impl.CourseDaoImpl;
import management.dao.course.obj.Course;

import java.util.List;

public class CourseManage {
    CourseDao courseDao = new CourseDaoImpl();

    public List<Course> getCourses(){
        List<Course> courses = courseDao.Query();
        return courses;
    }

    public Course getCourseByCno(String Cno){
        Course course = courseDao.QueryByCno(Cno);
        return course;
    }

    public void deleteCourse(String Cno){
        courseDao.delete(Cno);
    }

    public void addCourse(String Cno, String Cname){
        courseDao.insert(Cno, Cname);
    }

    public void addCourse(Course course){
        String Cno = course.getCno();
        String Cname = course.getCname();
        courseDao.insert(Cno, Cname);
    }
}
