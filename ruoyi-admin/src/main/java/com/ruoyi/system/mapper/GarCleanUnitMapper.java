package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.GarCleanUnit;

/**
 * 清运单位Mapper接口
 * 
 * @author p
 * @date 2022-03-15
 */
public interface GarCleanUnitMapper 
{
    /**
     * 查询清运单位
     * 
     * @param cuid 清运单位主键
     * @return 清运单位
     */
    public GarCleanUnit selectGarCleanUnitByCuid(Long cuid);

    /**
     * 查询清运单位列表
     * 
     * @param garCleanUnit 清运单位
     * @return 清运单位集合
     */
    public List<GarCleanUnit> selectGarCleanUnitList(GarCleanUnit garCleanUnit);

    /**
     * 新增清运单位
     * 
     * @param garCleanUnit 清运单位
     * @return 结果
     */
    public int insertGarCleanUnit(GarCleanUnit garCleanUnit);

    /**
     * 修改清运单位
     * 
     * @param garCleanUnit 清运单位
     * @return 结果
     */
    public int updateGarCleanUnit(GarCleanUnit garCleanUnit);

    /**
     * 删除清运单位
     * 
     * @param cuid 清运单位主键
     * @return 结果
     */
    public int deleteGarCleanUnitByCuid(Long cuid);

    /**
     * 批量删除清运单位
     * 
     * @param cuids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGarCleanUnitByCuids(String[] cuids);
}
