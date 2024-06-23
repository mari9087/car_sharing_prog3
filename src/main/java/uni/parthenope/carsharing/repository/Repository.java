package uni.parthenope.carsharing.repository;

import java.util.List;

public interface Repository <K,T>{
    List<K> getAll() throws Exception;
    K getById(T id) throws Exception;
    K save(K object) throws Exception;
    K update(K object) throws Exception;
    void delete(T id) throws Exception;
}