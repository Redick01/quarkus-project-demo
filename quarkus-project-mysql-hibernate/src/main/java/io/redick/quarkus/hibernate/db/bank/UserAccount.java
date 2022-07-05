package io.redick.quarkus.hibernate.db.bank;

import javax.persistence.*;

/**
 * @author Redick01
 */
@Entity
@Table(name = "user_account")
@NamedQuery(name = "UserAccount.findAll",
        query = "SELECT f FROM UserAccount f",
        hints = @QueryHint(name = "org.hibernate.cacheable", value = "true") )
@Cacheable
@PersistenceUnit(name = "bank01")
public class UserAccount {

    @Id
    @Column(name = "id", length = 11, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "account_no", length = 64, unique = true)
    private String accountNo;

    @Column(name = "account_name", length = 50)
    private String accountName;

    @Column(name = "account_balance", length = 10)
    private Double accountBalance;

    @Column(name = "transform_balance", length = 10)
    private Double transformBalance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Double getTransformBalance() {
        return transformBalance;
    }

    public void setTransformBalance(Double transformBalance) {
        this.transformBalance = transformBalance;
    }

    @Override
    public String toString() {
        return "UserCount{" +
                "id=" + id +
                ", accountNo='" + accountNo + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountBalance='" + accountBalance + '\'' +
                ", transformBalance='" + transformBalance + '\'' +
                '}';
    }
}
