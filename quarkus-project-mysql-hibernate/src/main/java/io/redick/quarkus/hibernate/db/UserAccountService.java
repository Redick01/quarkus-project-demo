package io.redick.quarkus.hibernate.db;

import io.redick.quarkus.hibernate.db.bank.UserAccount;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Redick01
 */
@Singleton
public class UserAccountService {

    @Inject
    @Named("bank01")
    EntityManager manager;

    @Transactional(rollbackOn = Exception.class)
    public void createUserCount() {
        UserAccount userCount = new UserAccount();
        userCount.setAccountName("刘p辉");
        userCount.setAccountNo("1003");
        userCount.setTransformBalance(100.0);
        userCount.setAccountBalance(1000.0);
        manager.persist(userCount);
    }

    public List<UserAccount> getUserCount() {
        return manager.createNamedQuery("UserAccount.findAll", UserAccount.class).getResultList();
    }
}
