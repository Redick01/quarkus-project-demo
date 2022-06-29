package io.redick.quarkus.resource.dto;

import lombok.Data;

/**
 * @author Redick01
 */
@Data
public class AddOrderRequest {

    private Integer productId;

    private Integer count;
}
