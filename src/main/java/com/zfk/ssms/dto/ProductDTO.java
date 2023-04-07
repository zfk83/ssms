package com.zfk.ssms.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ZFK
 */
@Data
public class ProductDTO implements Serializable {
    /**
     * 商品编号
     */
    private Long productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 供应商编号
     */
    private Long providerId;

    /**
     * 供应商名称
     */

    private String provider;

    /**
     * 分类编号
     */
    private Long groupId;

    /**
     * 分类名称
     */
    private String group;

    /**
     * 图片
     */
    private String photo;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 销售价格
     */
    private BigDecimal salePrice;

    /**
     * 销售数量
     */
    private Integer saleCount;

    /**
     * 库存数量
     */
    private Long stock;

    /**
     * 生产日期
     */
    private Date yieldTime;
}
