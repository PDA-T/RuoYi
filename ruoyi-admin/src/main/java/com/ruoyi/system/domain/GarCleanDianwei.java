package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 点位单位对象 gar_clean_dianwei
 * 
 * @author q
 * @date 2022-03-16
 */
public class GarCleanDianwei extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    private Long id;

    /** 别名 */
    @Excel(name = "别名")
    private String bName;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String dwName;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 联系人 */
    @Excel(name = "联系人")
    private String lxr;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private Long lxrDianhua;

    /** 单位类型 */
    @Excel(name = "单位类型")
    private String danweiType;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String chuanjianTime;

    /** 状态 */
    @Excel(name = "状态")
    private Long zhuangTai;

    /** 所属区域 */
    private String quyu;

    /** 经维度 */
    private Long jingdu;

    /** 维度 */
    private Long weidu;

    /** 备注 */
    private String beizhu;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setbName(String bName) 
    {
        this.bName = bName;
    }

    public String getbName() 
    {
        return bName;
    }
    public void setDwName(String dwName) 
    {
        this.dwName = dwName;
    }

    public String getDwName() 
    {
        return dwName;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setLxr(String lxr) 
    {
        this.lxr = lxr;
    }

    public String getLxr() 
    {
        return lxr;
    }
    public void setLxrDianhua(Long lxrDianhua) 
    {
        this.lxrDianhua = lxrDianhua;
    }

    public Long getLxrDianhua() 
    {
        return lxrDianhua;
    }
    public void setDanweiType(String danweiType) 
    {
        this.danweiType = danweiType;
    }

    public String getDanweiType() 
    {
        return danweiType;
    }
    public void setChuanjianTime(String chuanjianTime)
    {
        this.chuanjianTime = chuanjianTime;
    }

    public String getChuanjianTime()
    {
        return chuanjianTime;
    }
    public void setZhuangTai(Long zhuangTai) 
    {
        this.zhuangTai = zhuangTai;
    }

    public Long getZhuangTai() 
    {
        return zhuangTai;
    }
    public void setQuyu(String quyu) 
    {
        this.quyu = quyu;
    }

    public String getQuyu() 
    {
        return quyu;
    }
    public void setJingdu(Long jingdu) 
    {
        this.jingdu = jingdu;
    }

    public Long getJingdu() 
    {
        return jingdu;
    }
    public void setWeidu(Long weidu) 
    {
        this.weidu = weidu;
    }

    public Long getWeidu() 
    {
        return weidu;
    }
    public void setBeizhu(String beizhu) 
    {
        this.beizhu = beizhu;
    }

    public String getBeizhu() 
    {
        return beizhu;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bName", getbName())
            .append("dwName", getDwName())
            .append("address", getAddress())
            .append("lxr", getLxr())
            .append("lxrDianhua", getLxrDianhua())
            .append("danweiType", getDanweiType())
            .append("chuanjianTime", getChuanjianTime())
            .append("zhuangTai", getZhuangTai())
            .append("quyu", getQuyu())
            .append("jingdu", getJingdu())
            .append("weidu", getWeidu())
            .append("beizhu", getBeizhu())
            .toString();
    }
}
