package management.dao.student;


import management.dao.student.obj.Student;

import java.util.List;

public interface StudentDao {
    Student QueryBySno(String Sno);
    List<Student> Query();
    void insert(String Sno, String Sname, String Smajor, String Ssex, int Sage);
    void delete(String Sno);
}
