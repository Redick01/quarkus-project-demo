package io.redick.quarkus.hibernate.db.stock;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Redick01
 */
@Entity
@Table(name = "stock")
@NamedQuery(name = "Stock.findAll",
        query = "SELECT f FROM Stock f",
        hints = @QueryHint(name = "org.hibernate.cacheable", value = "true") )
@Cacheable
@PersistenceUnit(name = "stock")
public class Stock {

    @Id
    @Column(name = "id", length = 20, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id", length = 11)
    private Long productId;

    @Column(name = "total_count", length = 11)
    private Integer totalCount;

    @Column(name = "create_time")
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", productId=" + productId +
                ", totalCount=" + totalCount +
                ", createTime=" + createTime +
                '}';
    }
}
