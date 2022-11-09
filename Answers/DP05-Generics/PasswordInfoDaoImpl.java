import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordInfoDaoImpl extends DaoImpl<PasswordInfo, String> {
    public PasswordInfoDaoImpl(String fileName, String tableName) {
        super(fileName, tableName);
    }

    @Override
    public String getTableString() {
        return " (url text PRIMARY KEY, userId text, password text)";
    }

    @Override
    public String getInsertValueString(PasswordInfo p) {
        String fmt = "'%s', '%s', '%s'";
        String q = String.format(fmt, p.getUrl(), p.getUserId(), p.getPassword());
        return q;
    }

    @Override
    public PasswordInfo getNewData(ResultSet rs) {
        try {
            return new PasswordInfo(rs.getString("url"),
                    rs.getString("userId"),
                    rs.getString("password"));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getUpdateValueString(PasswordInfo p) {
        String fmt = "userId = '%s', password = '%s'";
        String q = String.format(fmt, p.getUserId(), p.getPassword());
        return q;
    }

    @Override
    public String getKeyColumnName() {
        return "url";
    }
}
