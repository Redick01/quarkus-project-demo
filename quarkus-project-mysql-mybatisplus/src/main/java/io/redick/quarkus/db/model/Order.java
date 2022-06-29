package io.redick.quarkus.db.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author Redick01
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Order extends Model<Order> {

    private Integer id;

    private String orderNo;

    private Integer productId;

    private Integer payCount;

    private Date createTime = new Date();
}
