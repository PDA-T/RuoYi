package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 线路点位对象 gar_clean_route_travel
 * 
 * @author p
 * @date 2022-03-15
 */
public class GarCleanRouteTravel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID自增 */
    private Long id;

    /** 路线ID外键 */
    @Excel(name = "路线ID外键")
    private Long crid;

    /** 点位ID外键 */
    @Excel(name = "点位ID外键")
    private Long poid;

    /** 收运开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收运开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 收运结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收运结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entTime;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 时间间隔 （几分钟） */
    @Excel(name = "时间间隔 ", readConverterExp = "几=分钟")
    private Long timeCell;

    /** 垃圾分类ID */
    @Excel(name = "垃圾分类ID")
    private Long tid;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCrid(Long crid) 
    {
        this.crid = crid;
    }

    public Long getCrid() 
    {
        return crid;
    }
    public void setPoid(Long poid) 
    {
        this.poid = poid;
    }

    public Long getPoid() 
    {
        return poid;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEntTime(Date entTime) 
    {
        this.entTime = entTime;
    }

    public Date getEntTime() 
    {
        return entTime;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }
    public void setTimeCell(Long timeCell) 
    {
        this.timeCell = timeCell;
    }

    public Long getTimeCell() 
    {
        return timeCell;
    }
    public void setTid(Long tid) 
    {
        this.tid = tid;
    }

    public Long getTid() 
    {
        return tid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("crid", getCrid())
            .append("poid", getPoid())
            .append("startTime", getStartTime())
            .append("entTime", getEntTime())
            .append("sort", getSort())
            .append("timeCell", getTimeCell())
            .append("tid", getTid())
            .toString();
    }
}
