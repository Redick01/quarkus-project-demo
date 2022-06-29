package io.redick.quarkus.db;

import java.util.Date;

/**
 * @author Redick01
 */
public class Order {

    public Order() {}

    private Integer id;

    private String orderNo;

    private Integer productId;

    private Integer payCount;

    private Date createTime;

    public Order(Integer id, String orderNo, Integer productId, Integer payCount, Date createTime) {
        this.id = id;
        this.orderNo = orderNo;
        this.productId = productId;
        this.payCount = payCount;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPayCount() {
        return payCount;
    }

    public void setPayCount(Integer payCount) {
        this.payCount = payCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", productId='" + productId + '\'' +
                ", payCount=" + payCount +
                ", createTime=" + createTime +
                '}';
    }
}
