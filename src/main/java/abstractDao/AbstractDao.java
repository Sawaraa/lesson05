package abstractDao;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDao<T> {

    T create(T t) ;

    T read(int id) ;

    T update(T t);

    void delete(int id) ;

    List<T> readAll() ;
}
