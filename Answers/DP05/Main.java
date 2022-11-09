public class Main {
    public static void main(String[] args) {
        PasswordInfo p;
        PasswordInfoDao passwordInfoDao = new PasswordInfoDaoImpl();

        System.out.println("--- inserting...");
        p = new PasswordInfo("https://www.smu.ac.kr", "smu", "abcde");
        passwordInfoDao.insert(p);
        p = new PasswordInfo("https://www.smu2.ac.kr", "smu2", "abcde");
        passwordInfoDao.insert(p);

        System.out.println("--- finding all...");
        for (PasswordInfo pi : passwordInfoDao.findAll()) {
            System.out.println("reading... " + pi);
        }

        System.out.println("--- updating...");
        p = passwordInfoDao.findAll().get(1);
        p.setUserId("smu1");
        passwordInfoDao.update(p.getUrl(), p);

        System.out.println("--- see if updated...");
        p = passwordInfoDao.findByKey("https://www.smu2.ac.kr");
        if (p != null) {
            System.out.println(p);
        }

        System.out.println("--- deleting...");
        passwordInfoDao.delete("https://www.smu.ac.kr");  // or personDao.delete(p);

        System.out.println("--- finding all after deleting...");
        for (PasswordInfo pi : passwordInfoDao.findAll()) {
            System.out.println("reading... " + pi);
        }
    }
}
