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
 * 用于记录超市采购商品的相关信息，包括商品名称、数量、价格、供应商信息、采购时间等。采购表的作用是帮助超市管理人员实时了解
 * @TableName tb_purchase
 */
@TableName(value ="tb_purchase")
@Data
public class  TbPurchase implements Serializable {
    /**
     * 采购编号
     */
    @TableId
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
     * 供应商编号
     */
    private Long providerId;

    /**
     * 采购数量
     */
    private Integer purchaseCount;

    /**
     * 进货价格
     */
    private BigDecimal goodsPrice;

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
        TbPurchase other = (TbPurchase) that;
        return (this.getPurchaseId() == null ? other.getPurchaseId() == null : this.getPurchaseId().equals(other.getPurchaseId()))
            && (this.getPurchaseTime() == null ? other.getPurchaseTime() == null : this.getPurchaseTime().equals(other.getPurchaseTime()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProviderId() == null ? other.getProviderId() == null : this.getProviderId().equals(other.getProviderId()))
            && (this.getPurchaseCount() == null ? other.getPurchaseCount() == null : this.getPurchaseCount().equals(other.getPurchaseCount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPurchaseId() == null) ? 0 : getPurchaseId().hashCode());
        result = prime * result + ((getPurchaseTime() == null) ? 0 : getPurchaseTime().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProviderId() == null) ? 0 : getProviderId().hashCode());
        result = prime * result + ((getPurchaseCount() == null) ? 0 : getPurchaseCount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", purchaseId=").append(purchaseId);
        sb.append(", purchaseTime=").append(purchaseTime);
        sb.append(", productId=").append(productId);
        sb.append(", providerId=").append(providerId);
        sb.append(", purchaseCount=").append(purchaseCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}