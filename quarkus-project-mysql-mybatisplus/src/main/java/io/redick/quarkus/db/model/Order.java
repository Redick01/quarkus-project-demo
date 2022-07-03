package io.redick.quarkus.db.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * @author Redick01
 */
@Data
public class Order extends Model<Order> {

    private Integer id;

    private String orderNo;

    private Integer productId;

    private Integer payCount;

    private Date createTime = new Date();
}
