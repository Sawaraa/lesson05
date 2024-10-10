package service.impl;

import dao.BasketDao;
import dao.Imlp.BasketDaoImpl;
import domain.Basket;
import service.BasketService;

import java.sql.SQLException;
import java.util.List;

public class BasketServerImpl implements BasketService{

    private BasketDao basketDao;

    public BasketServerImpl() throws SQLException {
        basketDao = new BasketDaoImpl();
    }


    @Override
    public Basket create(Basket basket) throws SQLException {
        return basketDao.create(basket);
    }

    @Override
    public Basket read(int id) throws SQLException {
        return basketDao.read(id);
    }

    @Override
    public Basket update(Basket basket) {
        return basketDao.update(basket);
    }

    @Override
    public void delete(int id) throws SQLException {
        basketDao.delete(id);
    }

    @Override
    public List<Basket> readAll() throws SQLException {
        return basketDao.readAll();
    }
}
