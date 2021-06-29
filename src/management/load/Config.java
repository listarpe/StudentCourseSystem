package management.load;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static String ip;
    private static String port;
    private static String username;
    private static String password;
    private static String Database;

    public static void load(){
        InputStream input = null;
        try {
            input=Config.class.getResourceAsStream("/config/config.properties");
            Properties p=new Properties();
            p.load(input);
            ip=p.getProperty("ip");
            port=p.getProperty("port");
            username=p.getProperty("username");
            password=p.getProperty("password");
            Database=p.getProperty("Database");
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            if(input!=null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        Config.ip = ip;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        Config.port = port;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Config.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Config.password = password;
    }

    public static String getDatabase() {
        return Database;
    }

    public static void setDatabase(String database) {
        Database = database;
    }
}
