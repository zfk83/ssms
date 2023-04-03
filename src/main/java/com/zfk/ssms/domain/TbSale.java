package com.zfk.ssms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 用于记录每次销售的详细信息，例如销售编号、销售日期、销售员、商品编号、商品数量、销售金额等。这些信息可以帮助超市了解每次
 * @TableName tb_sale
 */
@TableName(value ="tb_sale")
@Data
public class TbSale implements Serializable {
    /**
     * 销售编号
     */
    @TableId
    private Long saleId;

    /**
     * 销售日期
     */
    private Date saleDate;

    /**
     * 净利润
     */
    private BigDecimal profit;

    /**
     * 商品编号
     */
    private Long productId;

    /**
     * 销售数量
     */
    private Integer saleCount;

    /**
     * 销售价格
     */
    private BigDecimal salePrice;

    /**
     * 商品名称
     */
    private String productName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbSale other = (TbSale) that;
        return (this.getSaleId() == null ? other.getSaleId() == null : this.getSaleId().equals(other.getSaleId()))
            && (this.getSaleDate() == null ? other.getSaleDate() == null : this.getSaleDate().equals(other.getSaleDate()))
            && (this.getProfit() == null ? other.getProfit() == null : this.getProfit().equals(other.getProfit()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getSaleCount() == null ? other.getSaleCount() == null : this.getSaleCount().equals(other.getSaleCount()))
            && (this.getSalePrice() == null ? other.getSalePrice() == null : this.getSalePrice().equals(other.getSalePrice()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSaleId() == null) ? 0 : getSaleId().hashCode());
        result = prime * result + ((getSaleDate() == null) ? 0 : getSaleDate().hashCode());
        result = prime * result + ((getProfit() == null) ? 0 : getProfit().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getSaleCount() == null) ? 0 : getSaleCount().hashCode());
        result = prime * result + ((getSalePrice() == null) ? 0 : getSalePrice().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", saleId=").append(saleId);
        sb.append(", saleDate=").append(saleDate);
        sb.append(", profit=").append(profit);
        sb.append(", productId=").append(productId);
        sb.append(", saleCount=").append(saleCount);
        sb.append(", salePrice=").append(salePrice);
        sb.append(", productName=").append(productName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}