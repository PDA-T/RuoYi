package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 关联对象 gar_clean_dianwei_guanlian
 * 
 * @author p
 * @date 2022-03-18
 */
public class GarCleanDianweiGuanlian extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 登录账号 */
    @Excel(name = "登录账号")
    private String user;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date chuanjianTime;

    /** 用户状态 */
    @Excel(name = "用户状态")
    private Long zhuangTai;

    /** 邮箱 */
    private String mail;

    /** 手机号 */
    private String shouji;

    /** 性别 */
    private String xingbie;

    /** 备注 */
    private String beizhu;

    /** 联系人id */
    private int lxrId;

    public int getLxrId() {
        return lxrId;
    }

    public void setLxrId(int lxrId) {
        this.lxrId = lxrId;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setUser(String user) 
    {
        this.user = user;
    }

    public String getUser() 
    {
        return user;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setChuanjianTime(Date chuanjianTime) 
    {
        this.chuanjianTime = chuanjianTime;
    }

    public Date getChuanjianTime() 
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
    public void setMail(String mail) 
    {
        this.mail = mail;
    }

    public String getMail() 
    {
        return mail;
    }
    public void setShouji(String shouji) 
    {
        this.shouji = shouji;
    }

    public String getShouji() 
    {
        return shouji;
    }
    public void setXingbie(String xingbie) 
    {
        this.xingbie = xingbie;
    }

    public String getXingbie() 
    {
        return xingbie;
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
        return "GarCleanDianweiGuanlian{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", chuanjianTime=" + chuanjianTime +
                ", zhuangTai=" + zhuangTai +
                ", mail='" + mail + '\'' +
                ", shouji='" + shouji + '\'' +
                ", xingbie='" + xingbie + '\'' +
                ", beizhu='" + beizhu + '\'' +
                ", lxrId=" + lxrId +
                '}';
    }
}
