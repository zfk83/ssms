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
 * 用于存储和管理超市的商品信息，包括商品名称、价格、生产商、生产日期、保质期、分类、库存数量、销售量等。通过对商品表的管理
 * @TableName tb_product
 */
@TableName(value ="tb_product")
@Data
public class TbProduct implements Serializable {
    /**
     * 商品编号
     */
    @TableId
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
     * 分类编号
     */
    private Long groupId;

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

    /**
     * 图片
     */
    private String photo;

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
        TbProduct other = (TbProduct) that;
        return (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getProviderId() == null ? other.getProviderId() == null : this.getProviderId().equals(other.getProviderId()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getSalePrice() == null ? other.getSalePrice() == null : this.getSalePrice().equals(other.getSalePrice()))
            && (this.getSaleCount() == null ? other.getSaleCount() == null : this.getSaleCount().equals(other.getSaleCount()))
            && (this.getStock() == null ? other.getStock() == null : this.getStock().equals(other.getStock()))
            && (this.getYieldTime() == null ? other.getYieldTime() == null : this.getYieldTime().equals(other.getYieldTime()))
            && (this.getPhoto() == null ? other.getPhoto() == null : this.getPhoto().equals(other.getPhoto()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getProviderId() == null) ? 0 : getProviderId().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getSalePrice() == null) ? 0 : getSalePrice().hashCode());
        result = prime * result + ((getSaleCount() == null) ? 0 : getSaleCount().hashCode());
        result = prime * result + ((getStock() == null) ? 0 : getStock().hashCode());
        result = prime * result + ((getYieldTime() == null) ? 0 : getYieldTime().hashCode());
        result = prime * result + ((getPhoto() == null) ? 0 : getPhoto().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", productId=").append(productId);
        sb.append(", productName=").append(productName);
        sb.append(", providerId=").append(providerId);
        sb.append(", groupId=").append(groupId);
        sb.append(", createTime=").append(createTime);
        sb.append(", salePrice=").append(salePrice);
        sb.append(", saleCount=").append(saleCount);
        sb.append(", stock=").append(stock);
        sb.append(", yieldTime=").append(yieldTime);
        sb.append(", photo=").append(photo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}