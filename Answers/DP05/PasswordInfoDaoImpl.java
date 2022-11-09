import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasswordInfoDaoImpl implements PasswordInfoDao {
    final static String DB_FILE_NAME = "pi.db";
    final static String DB_TABLE_NAME = "passwordinfo";

    Connection connection = null;
    ResultSet rs = null;
    Statement statement = null;

    public PasswordInfoDaoImpl() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_FILE_NAME);
            statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            final String table = " (url text PRIMARY KEY, userId text, password text)";

            // create table
            statement.executeUpdate("DROP TABLE IF EXISTS " + DB_TABLE_NAME);
            statement.executeUpdate("CREATE TABLE " + DB_TABLE_NAME + table);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(PasswordInfo p) {
        try {
            String fmt = "INSERT INTO %s VALUES('%s', '%s', '%s')";
            String q = String.format(fmt, DB_TABLE_NAME, p.getUrl(), p.getUserId(), p.getPassword());
            
            statement.execute(q);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PasswordInfo> findAll() {
        ArrayList<PasswordInfo> list = new ArrayList<PasswordInfo>();
        try {
            rs = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME);
            while (rs.next()) {
                list.add(new PasswordInfo(rs.getString("url"),
                                          rs.getString("userId"),
                                          rs.getString("password")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public PasswordInfo findByKey(String key) {
        PasswordInfo p = null;
        try {
            String fmt = "SELECT * FROM %s WHERE url = '%s'";
            String q = String.format(fmt, DB_TABLE_NAME, key);
            rs = statement.executeQuery(q);
            if (rs.next()) {
                p = new PasswordInfo(rs.getString("url"),
                                     rs.getString("userId"),
                                     rs.getString("password"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public void update(String key, PasswordInfo p) {
        if (p != null) {
            try {
                String fmt = "UPDATE %s SET userId = '%s', password = '%s' WHERE url = '%s'";
                String q = String.format(fmt, DB_TABLE_NAME, p.getUserId(), p.getPassword(), p.getUrl());
                
                statement.execute(q);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(String key) {
        try {
            String fmt = "DELETE FROM %s WHERE url = '%s'";
            String q = String.format(fmt, DB_TABLE_NAME, key);
            
            statement.execute(q);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(PasswordInfo p) {
        delete(p.getUrl());
    }
}
