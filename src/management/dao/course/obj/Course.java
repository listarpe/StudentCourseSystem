package management.dao.course.obj;

public class Course {
    String Cno;
    String Cname;

    public Course(String cno, String cname) {
        Cno = cno;
        Cname = cname;
    }

    public Course() {
    }

    public String getCno() {
        return Cno;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }
}
