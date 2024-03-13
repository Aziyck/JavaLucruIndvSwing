package mvc.model.dao;

import mvc.model.entity.Zile;

import java.util.List;

public interface ZileDAO extends BaseDAO<Integer, Zile>{
    List<Zile> findZileByID(Integer id) throws DaoExeption;
}