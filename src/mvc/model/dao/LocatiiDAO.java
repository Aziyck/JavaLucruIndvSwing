package mvc.model.dao;

import mvc.model.entity.Locatii;

import java.util.List;

public interface LocatiiDAO extends BaseDAO<Integer, Locatii>{
    List<Locatii> findLocatiiByID(Integer id) throws DaoExeption;
}
