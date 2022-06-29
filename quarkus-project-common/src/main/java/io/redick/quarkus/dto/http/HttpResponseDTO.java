package io.redick.quarkus.dto.http;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Redick01
 */
@Data
@Builder
public class HttpResponseDTO<T> implements Serializable {

    private String resCode;

    private String resMessage;

    private T resData;
}
