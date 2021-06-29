package management.dao.sc;

import management.dao.course.obj.Course;
import management.dao.sc.obj.SC;

import java.util.List;

public interface SCDao {
    List<SC> QueryBySno(String Sno);
    List<SC> QueryByCno(String Cno);
    List<Course> notSelected(String Sno);
    void insert(String Sno, String Cno);
    void updateGrade(String Sno, String Cno, int grade);
    void delete(String Sno, String Cno);
}
