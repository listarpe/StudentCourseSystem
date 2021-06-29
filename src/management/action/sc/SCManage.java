package management.action.sc;


import management.dao.course.obj.Course;
import management.dao.sc.SCDao;
import management.dao.sc.impl.SCDaoImpl;
import management.dao.sc.obj.SC;


import java.util.List;

public class SCManage {
    SCDao scDao = new SCDaoImpl();

    public List<SC> getSCBySno(String Sno) {
        List<SC> scs  = scDao.QueryBySno(Sno);
        return scs;
    }

    public List<Course> notSelected(String Sno) {
        List<Course> courses = scDao.notSelected(Sno);

        return courses;
    }
    public List<SC> getSCByCno(String Cno) {
        List<SC> scs = scDao.QueryByCno(Cno);
        return scs;
    }

    public void addSC(SC sc) {
        String Sno = sc.getStudent().getSno();
        String Cno = sc.getCourse().getCno();
        scDao.insert(Sno, Cno);
    }
    public void addSC(String Sno, String Cno) {
        scDao.insert(Sno, Cno);
    }

    public void addGrade(SC sc) {
        String Sno = sc.getStudent().getSno();
        String Cno = sc.getCourse().getCno();
        int grade = sc.getGrade();
        scDao.updateGrade(Sno, Cno, grade);
    }

    public void addGrade(String Sno, String Cno, int grade) {

        scDao.updateGrade(Sno, Cno, grade);
    }

    public void delete(SC sc) {
        String Sno = sc.getStudent().getSno();
        String Cno = sc.getCourse().getCno();
        scDao.delete(Sno, Cno);
    }

}
