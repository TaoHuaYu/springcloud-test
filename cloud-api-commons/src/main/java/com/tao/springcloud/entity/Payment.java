package com.tao.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author makejava
 * @since 2023-07-04 16:18:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionUID = -25625769987041339L;
    /**
     * id
     */
    private Long id;
    /**
     * 流水号
     */
    private String serial;
}

