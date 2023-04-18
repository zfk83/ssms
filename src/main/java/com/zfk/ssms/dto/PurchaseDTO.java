package com.zfk.ssms.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ZFK
 */
@Data
public class PurchaseDTO implements Serializable {
    /**
     * 采购编号
     */
    private Long purchaseId;
    /**
     * 采购时间
     */
    private Date purchaseTime;
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
    private String providerName;
    /**
     * 采购数量
     */
    private Integer purchaseCount;
    /**
     * 进货价格
     */
    private BigDecimal purchasePrice;
}
