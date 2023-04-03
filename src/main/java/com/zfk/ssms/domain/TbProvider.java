package com.zfk.ssms.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 用于记录供应商相关信息，例如供应商名称、联系方式、地址、账户信息等。在系统中，采购人员可以根据需要添加、编辑或删除供应商
 * @TableName tb_provider
 */
@TableName(value ="tb_provider")
@Data
public class TbProvider implements Serializable {
    /**
     * 供应商编号
     */
    @TableId
    private Long providerId;

    /**
     * 供应商名称
     */
    private String providerName;

    /**
     * 供应商地址
     */
    private String providerAddress;

    /**
     * 联系电话
     */
    private String contactPhone;

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
        TbProvider other = (TbProvider) that;
        return (this.getProviderId() == null ? other.getProviderId() == null : this.getProviderId().equals(other.getProviderId()))
            && (this.getProviderName() == null ? other.getProviderName() == null : this.getProviderName().equals(other.getProviderName()))
            && (this.getProviderAddress() == null ? other.getProviderAddress() == null : this.getProviderAddress().equals(other.getProviderAddress()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProviderId() == null) ? 0 : getProviderId().hashCode());
        result = prime * result + ((getProviderName() == null) ? 0 : getProviderName().hashCode());
        result = prime * result + ((getProviderAddress() == null) ? 0 : getProviderAddress().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", providerId=").append(providerId);
        sb.append(", providerName=").append(providerName);
        sb.append(", providerAddress=").append(providerAddress);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}