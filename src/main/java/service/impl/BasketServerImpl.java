package service.impl;

import dao.BasketDao;
import dao.Imlp.BasketDaoImpl;
import domain.Basket;
import service.BasketService;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class BasketServerImpl implements BasketService{

    private BasketDao basketDao;
    private static Logger logger = Logger.getLogger(BasketServerImpl.class);

    public BasketServerImpl() {
        try {
            basketDao = new BasketDaoImpl();
        } catch (SQLException e) {
            logger.error(e);
        }
    }


    @Override
    public Basket create(Basket basket) {
        return basketDao.create(basket);
    }

    @Override
    public Basket read(int id)  {
        return basketDao.read(id);
    }

    @Override
    public Basket update(Basket basket) {
        return basketDao.update(basket);
    }

    @Override
    public void delete(int id)  {
        basketDao.delete(id);
    }

    @Override
    public List<Basket> readAll()  {
        return basketDao.readAll();
    }
}
