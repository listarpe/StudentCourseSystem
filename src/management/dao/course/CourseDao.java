package management.dao.course;

import management.dao.course.obj.Course;

import java.util.List;

public interface CourseDao {
    Course QueryByCno(String Cno);
    List<Course> Query();
    void insert(String Cno, String Cname);
    void delete(String Cno);
}
