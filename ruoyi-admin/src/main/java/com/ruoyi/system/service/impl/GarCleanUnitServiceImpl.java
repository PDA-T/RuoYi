package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GarCleanUnitMapper;
import com.ruoyi.system.domain.GarCleanUnit;
import com.ruoyi.system.service.IGarCleanUnitService;
import com.ruoyi.common.core.text.Convert;

/**
 * 清运单位Service业务层处理
 * 
 * @author p
 * @date 2022-03-15
 */
@Service
public class GarCleanUnitServiceImpl implements IGarCleanUnitService 
{
    @Autowired
    private GarCleanUnitMapper garCleanUnitMapper;

    /**
     * 查询清运单位
     * 
     * @param cuid 清运单位主键
     * @return 清运单位
     */
    @Override
    public GarCleanUnit selectGarCleanUnitByCuid(Long cuid)
    {
        return garCleanUnitMapper.selectGarCleanUnitByCuid(cuid);
    }

    /**
     * 查询清运单位列表
     * 
     * @param garCleanUnit 清运单位
     * @return 清运单位
     */
    @Override
    public List<GarCleanUnit> selectGarCleanUnitList(GarCleanUnit garCleanUnit)
    {
        return garCleanUnitMapper.selectGarCleanUnitList(garCleanUnit);
    }

    /**
     * 新增清运单位
     * 
     * @param garCleanUnit 清运单位
     * @return 结果
     */
    @Override
    public int insertGarCleanUnit(GarCleanUnit garCleanUnit)
    {
        garCleanUnit.setCreateTime(DateUtils.getNowDate());
        return garCleanUnitMapper.insertGarCleanUnit(garCleanUnit);
    }

    /**
     * 修改清运单位
     * 
     * @param garCleanUnit 清运单位
     * @return 结果
     */
    @Override
    public int updateGarCleanUnit(GarCleanUnit garCleanUnit)
    {
        garCleanUnit.setUpdateTime(DateUtils.getNowDate());
        return garCleanUnitMapper.updateGarCleanUnit(garCleanUnit);
    }

    /**
     * 批量删除清运单位
     * 
     * @param cuids 需要删除的清运单位主键
     * @return 结果
     */
    @Override
    public int deleteGarCleanUnitByCuids(String cuids)
    {
        return garCleanUnitMapper.deleteGarCleanUnitByCuids(Convert.toStrArray(cuids));
    }

    /**
     * 删除清运单位信息
     * 
     * @param cuid 清运单位主键
     * @return 结果
     */
    @Override
    public int deleteGarCleanUnitByCuid(Long cuid)
    {
        return garCleanUnitMapper.deleteGarCleanUnitByCuid(cuid);
    }
}
