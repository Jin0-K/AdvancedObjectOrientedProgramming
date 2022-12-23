import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasswordInfoDaoImpl implements PasswordDAO {
    final static String DB_FILE_NAME = "password.db";
    final static String DB_TABLE_NAME = "passwords";

    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;

    // Constructor
    public PasswordInfoDaoImpl() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_FILE_NAME);
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            final String table = " (url text PRIMARY KEY, userId text, password text)";
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Methods
    @Override
    public void insert(PasswordInfo p) {
        try {
            String fmt = "INSERT INTO %s VALUES('%s', '%s', '%s')";
            String q = String.format(fmt, DB_TABLE_NAME, p.getUrl(), p.getId(), p.getPassword());
            statement.execute(q);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PasswordInfo> findAll() {
        ArrayList<PasswordInfo> list = new ArrayList<PasswordInfo>();
        try {
            resultSet = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME);
            while (resultSet.next()) {
                list.add(new PasswordInfo(  resultSet.getString("url"),
                                            resultSet.getString("id"),
                                            resultSet.getString("password")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public PasswordInfo findByKey(String key) {
        PasswordInfo p = null;
        try {
            String fmt = "SELECT * FROM %s WHERE url = '%s'";
            String q = String.format(fmt ,DB_TABLE_NAME, key);
            resultSet = statement.executeQuery(q);
            if (resultSet.next()) {
                p = new PasswordInfo(   resultSet.getString("url"),
                                        resultSet.getString("id"),
                                        resultSet.getString("password"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void update(String key, PasswordInfo p) {
        if (p == null) {
            return;
        }
        try {
            String fmt = "UPDATE %s SET userId = '%s', password = '%s' WHERE url = '%s'";
            String q = String.format(fmt, DB_TABLE_NAME, p.getId(), p.getPassword(), p.getUrl());
            statement.execute(q);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
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

    @Override
    public void delete(PasswordInfo p) {
        delete(p.getUrl());
    }
}
