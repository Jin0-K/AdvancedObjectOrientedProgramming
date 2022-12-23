import java.util.List;
public interface PasswordDAO{
    public void insert(PasswordInfo p);
    public List<PasswordInfo> findAll();
    public PasswordInfo findByKey(String key);
    public void update(String key, PasswordInfo p);
    public void delete(String key);
    public void delete(PasswordInfo p);
}