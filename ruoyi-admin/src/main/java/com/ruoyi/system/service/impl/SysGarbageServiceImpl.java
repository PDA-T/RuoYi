package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysGarbageMapper;
import com.ruoyi.system.domain.SysGarbage;
import com.ruoyi.system.service.ISysGarbageService;
import com.ruoyi.common.core.text.Convert;

/**
 * 清运单位Service业务层处理
 * 
 * @author p
 * @date 2022-03-15
 */
@Service
public class SysGarbageServiceImpl implements ISysGarbageService 
{
    @Autowired
    private SysGarbageMapper sysGarbageMapper;

    /**
     * 查询清运单位
     * 
     * @param cuid 清运单位主键
     * @return 清运单位
     */
    @Override
    public SysGarbage selectSysGarbageByCuid(Long cuid)
    {
        return sysGarbageMapper.selectSysGarbageByCuid(cuid);
    }

    /**
     * 查询清运单位列表
     * 
     * @param sysGarbage 清运单位
     * @return 清运单位
     */
    @Override
    public List<SysGarbage> selectSysGarbageList(SysGarbage sysGarbage)
    {
        return sysGarbageMapper.selectSysGarbageList(sysGarbage);
    }

    /**
     * 新增清运单位
     * 
     * @param sysGarbage 清运单位
     * @return 结果
     */
    @Override
    public int insertSysGarbage(SysGarbage sysGarbage)
    {
        sysGarbage.setCreateTime(DateUtils.getNowDate());
        return sysGarbageMapper.insertSysGarbage(sysGarbage);
    }

    /**
     * 修改清运单位
     * 
     * @param sysGarbage 清运单位
     * @return 结果
     */
    @Override
    public int updateSysGarbage(SysGarbage sysGarbage)
    {
        sysGarbage.setUpdateTime(DateUtils.getNowDate());
        return sysGarbageMapper.updateSysGarbage(sysGarbage);
    }

    /**
     * 批量删除清运单位
     * 
     * @param cuids 需要删除的清运单位主键
     * @return 结果
     */
    @Override
    public int deleteSysGarbageByCuids(String cuids)
    {
        return sysGarbageMapper.deleteSysGarbageByCuids(Convert.toStrArray(cuids));
    }

    /**
     * 删除清运单位信息
     * 
     * @param cuid 清运单位主键
     * @return 结果
     */
    @Override
    public int deleteSysGarbageByCuid(Long cuid)
    {
        return sysGarbageMapper.deleteSysGarbageByCuid(cuid);
    }
}
