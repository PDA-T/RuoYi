package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 测试对象 sys_test
 * 
 * @author ruoyi
 * @date 2022-03-15
 */
public class SysTest extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 测试 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "测试", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createTame;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCreateTame(Date createTame) 
    {
        this.createTame = createTame;
    }

    public Date getCreateTame() 
    {
        return createTame;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createBy", getCreateBy())
            .append("createTame", getCreateTame())
            .toString();
    }
}
