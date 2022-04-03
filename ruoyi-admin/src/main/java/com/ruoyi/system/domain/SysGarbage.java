package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 清运单位对象 sys_garbage
 * 
 * @author p
 * @date 2022-03-15
 */
public class SysGarbage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID自增 */
    private Long cuid;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 区 */
    @Excel(name = "区")
    private String region;

    /** 街道 */
    @Excel(name = "街道")
    private String street;

    /** 区域CODE */
    @Excel(name = "区域CODE")
    private String regionCode;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 别名 */
    @Excel(name = "别名")
    private String alias;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String unitName;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contacts;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactsPhone;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 经度 */
    @Excel(name = "经度")
    private BigDecimal lon;

    /** 纬度 */
    @Excel(name = "纬度")
    private BigDecimal lat;

    /** 删除（0 正常 1 删除） */
    private Long delFlag;

    /** 状态(0 启用 1 禁用) */
    @Excel(name = "状态(0 启用 1 禁用)")
    private Long status;

    /** 单位类型 (学校、食堂、饭馆等) */
    @Excel(name = "单位类型 (学校、食堂、饭馆等)")
    private String unitType;

    /** 单位类别(QY 清运公司/DW 点位单位) */
    @Excel(name = "单位类别(QY 清运公司/DW 点位单位)")
    private String unitLeibie;

    /** 营业执照号 */
    @Excel(name = "营业执照号")
    private String licenseNo;

    /** 车辆地址配置 */
    @Excel(name = "车辆地址配置")
    private String carUrl;

    public void setCuid(Long cuid) 
    {
        this.cuid = cuid;
    }

    public Long getCuid() 
    {
        return cuid;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setRegion(String region) 
    {
        this.region = region;
    }

    public String getRegion() 
    {
        return region;
    }
    public void setStreet(String street) 
    {
        this.street = street;
    }

    public String getStreet() 
    {
        return street;
    }
    public void setRegionCode(String regionCode) 
    {
        this.regionCode = regionCode;
    }

    public String getRegionCode() 
    {
        return regionCode;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setAlias(String alias) 
    {
        this.alias = alias;
    }

    public String getAlias() 
    {
        return alias;
    }
    public void setUnitName(String unitName) 
    {
        this.unitName = unitName;
    }

    public String getUnitName() 
    {
        return unitName;
    }
    public void setContacts(String contacts) 
    {
        this.contacts = contacts;
    }

    public String getContacts() 
    {
        return contacts;
    }
    public void setContactsPhone(String contactsPhone) 
    {
        this.contactsPhone = contactsPhone;
    }

    public String getContactsPhone() 
    {
        return contactsPhone;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setLon(BigDecimal lon) 
    {
        this.lon = lon;
    }

    public BigDecimal getLon() 
    {
        return lon;
    }
    public void setLat(BigDecimal lat) 
    {
        this.lat = lat;
    }

    public BigDecimal getLat() 
    {
        return lat;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setUnitType(String unitType) 
    {
        this.unitType = unitType;
    }

    public String getUnitType() 
    {
        return unitType;
    }
    public void setUnitLeibie(String unitLeibie) 
    {
        this.unitLeibie = unitLeibie;
    }

    public String getUnitLeibie() 
    {
        return unitLeibie;
    }
    public void setLicenseNo(String licenseNo) 
    {
        this.licenseNo = licenseNo;
    }

    public String getLicenseNo() 
    {
        return licenseNo;
    }
    public void setCarUrl(String carUrl) 
    {
        this.carUrl = carUrl;
    }

    public String getCarUrl() 
    {
        return carUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cuid", getCuid())
            .append("city", getCity())
            .append("region", getRegion())
            .append("street", getStreet())
            .append("regionCode", getRegionCode())
            .append("address", getAddress())
            .append("alias", getAlias())
            .append("unitName", getUnitName())
            .append("contacts", getContacts())
            .append("contactsPhone", getContactsPhone())
            .append("remarks", getRemarks())
            .append("lon", getLon())
            .append("lat", getLat())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("delFlag", getDelFlag())
            .append("status", getStatus())
            .append("unitType", getUnitType())
            .append("unitLeibie", getUnitLeibie())
            .append("licenseNo", getLicenseNo())
            .append("carUrl", getCarUrl())
            .toString();
    }
}
