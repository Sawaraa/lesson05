package abstractDao;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDao<T> {

    T create(T t) throws SQLException;

    T read(int id) throws SQLException;

    T update(T t);

    void delete(int id) throws SQLException;

    List<T> readAll() throws SQLException;
}
