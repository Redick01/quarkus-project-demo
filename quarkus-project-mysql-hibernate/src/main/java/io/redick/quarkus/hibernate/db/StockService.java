package io.redick.quarkus.hibernate.db;

import io.redick.quarkus.hibernate.db.stock.Stock;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author Redick01
 */
@ApplicationScoped
public class StockService {

    @Inject
    @Named("stock")
    EntityManager manager;

    @Transactional(rollbackOn = Exception.class)
    public void createUserCount() {
        Stock stock = new Stock();
        stock.setCreateTime(new Date());
        stock.setTotalCount(10000);
        stock.setProductId(2L);
        manager.persist(stock);
    }

    public List<Stock> findAll() {
        return manager.createNamedQuery("Stock.findAll", Stock.class).getResultList();
    }
}
