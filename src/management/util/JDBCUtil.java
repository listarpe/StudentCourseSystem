package management.util;

import management.load.Config;

import java.sql.*;

public class JDBCUtil {
    static String ip=null;
    static String port=null;
    static String username=null;
    static String password=null;
    static String Database=null;
    static String JDBC_DRIVER = null;
    static String DB_URL=null;

    static{
        Config.load();
        ip= Config.getIp();
        port=Config.getPort();
        username=Config.getUsername();
        password=Config.getPassword();
        Database=Config.getDatabase();
        JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        DB_URL = "jdbc:mysql://"+ip+":"+port+"/"+Database+"?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    }

    public static Connection getConnection(){
        Connection conn=null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void ReleaseAll(Connection conn, Statement st, ResultSet rs) {
        CloseRs(rs);
        CloseSt(st);
        CloseConn(conn);
    }
    public static void Release(Connection conn, Statement st) {
        CloseSt(st);
        CloseConn(conn);
    }

    private static void CloseConn(Connection conn) {
        try {
            if(conn != null) {
                conn.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private static void CloseRs(ResultSet rs) {
        try {
            if(rs  != null) {
                rs.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private static void CloseSt(Statement st) {
        try {
            if(st  != null) {
                st.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
