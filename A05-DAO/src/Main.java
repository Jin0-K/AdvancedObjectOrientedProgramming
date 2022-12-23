import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        PasswordInfo p;
        PasswordInfoDaoImpl pwinfodao = new PasswordInfoDaoImpl();

        System.out.println("--- inserting...");
        p = new PasswordInfo("https://www.smu.ac.kr", "smu", "abcde");
        pwinfodao.insert(p);
        p = new PasswordInfo("https://www.smu2.ac.kr", "smu2", "abcde");
        pwinfodao.insert(p);

        System.out.println("--- finding all...");
        for (PasswordInfo passwordInfo : pwinfodao.findAll()) {
            System.out.println("reading... " + passwordInfo);
        }

        System.out.println("--- updating...");
        p = pwinfodao.findAll().get(1);
        p.setId("smu1");
        pwinfodao.update(p.getUrl(), p);

        System.out.println("--- see if updated...");
        p = pwinfodao.findByKey("https://www.smu2.ac.kr");
        if (p != null) {
            System.out.println(p);
        }

        System.out.println("--- deleting...");
        p = pwinfodao.findByKey("https://www.smu.ac.kr");
        pwinfodao.delete(p);

        System.out.println("--- finding all after deleting...");
        for (PasswordInfo passwordInfo : pwinfodao.findAll()) {
            System.out.println("reading... " + passwordInfo);
        }
    }
}