package mvc.model.dao;


import mvc.model.entity.Rute;

import java.util.List;

public interface RuteDAO extends BaseDAO<Integer, Rute>{
    List<Rute> findRuteByID(Integer id) throws DaoExeption;
}