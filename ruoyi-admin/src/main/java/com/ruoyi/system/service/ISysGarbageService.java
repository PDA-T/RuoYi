package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysGarbage;

/**
 * 清运单位Service接口
 * 
 * @author p
 * @date 2022-03-15
 */
public interface ISysGarbageService 
{
    /**
     * 查询清运单位
     * 
     * @param cuid 清运单位主键
     * @return 清运单位
     */
    public SysGarbage selectSysGarbageByCuid(Long cuid);

    /**
     * 查询清运单位列表
     * 
     * @param sysGarbage 清运单位
     * @return 清运单位集合
     */
    public List<SysGarbage> selectSysGarbageList(SysGarbage sysGarbage);

    /**
     * 新增清运单位
     * 
     * @param sysGarbage 清运单位
     * @return 结果
     */
    public int insertSysGarbage(SysGarbage sysGarbage);

    /**
     * 修改清运单位
     * 
     * @param sysGarbage 清运单位
     * @return 结果
     */
    public int updateSysGarbage(SysGarbage sysGarbage);

    /**
     * 批量删除清运单位
     * 
     * @param cuids 需要删除的清运单位主键集合
     * @return 结果
     */
    public int deleteSysGarbageByCuids(String cuids);

    /**
     * 删除清运单位信息
     * 
     * @param cuid 清运单位主键
     * @return 结果
     */
    public int deleteSysGarbageByCuid(Long cuid);
}
