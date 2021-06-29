package management.action.student;

import management.dao.student.StudentDao;
import management.dao.student.impl.StudentDaoImpl;
import management.dao.student.obj.Student;


import java.util.List;

public class StudentManage {
    StudentDao studentDao=new StudentDaoImpl();
    public Student getStudentBySno(String Sno){
        Student s = studentDao.QueryBySno(Sno);
        return s;
    }
    public List<Student> getStudents(){
        List<Student> students = studentDao.Query();
        return students;
    }

    public void deleteStudent(String Sno){
        studentDao.delete(Sno);
    }
    public void addStudent(String Sno, String Sname, String Smajor, String Ssex, int Sage){
        studentDao.insert(Sno, Sname, Smajor, Ssex, Sage);
    }
    public void addStudent(Student student){
        String Sno = student.getSno();
        String Sname = student.getSname();
        String Smajor = student.getSmajor();
        String Ssex = student.getSsex();
        int Sage = student.getSage();
        studentDao.insert(Sno, Sname, Smajor, Ssex, Sage);
    }
}
