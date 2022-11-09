import java.util.List;

public interface Dao<D, K> {
    public void insert(D p);
    public List<D> findAll();
    public D findByKey(K key);
    public void update(K key, D p);
    public void deleteByKey(K key);
    public void deleteByData(D p);
}
