package management.dao.student.obj;

public class Student {
    String Sno;
    String Sname;
    String Smajor;
    String Ssex;
    int Sage;

    public Student() {
    }

    public Student(String sno, String sname, String smajor, String ssex, int sage) {
        Sno = sno;
        Sname = sname;
        Smajor = smajor;
        Ssex = ssex;
        Sage = sage;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSmajor() {
        return Smajor;
    }

    public void setSmajor(String smajor) {
        Smajor = smajor;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public int getSage() {
        return Sage;
    }

    public void setSage(int sage) {
        Sage = sage;
    }
}
