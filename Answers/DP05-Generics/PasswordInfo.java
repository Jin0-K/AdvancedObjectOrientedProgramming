public class PasswordInfo implements DBData<String> {
    private String url;
    private String userId;
    private String password;

    public PasswordInfo(String url, String id, String pw) {
        this.url = url;
        userId = id;
        password = pw;
    }

    public String getUrl() { return url; }

    public String getKey() { return url; }
    public String getUserId() { return userId; }
    public String getPassword() { return password; }

    public void setUrl(String url) { this.url = url; }
    public void setUserId(String id) { userId = id; }
    public void setPassword(String pw) { password = pw; }

    public String toString() {
        return "\nUrl: " + url +
                "\nUserId: " + userId +
                "\nPassword: " + password;
    }
}
