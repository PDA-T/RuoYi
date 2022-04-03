package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GarCleanDianweiGuanlianMapper;
import com.ruoyi.system.domain.GarCleanDianweiGuanlian;
import com.ruoyi.system.service.IGarCleanDianweiGuanlianService;
import com.ruoyi.common.core.text.Convert;

/**
 * 关联Service业务层处理
 * 
 * @author p
 * @date 2022-03-18
 */
@Service
public class GarCleanDianweiGuanlianServiceImpl implements IGarCleanDianweiGuanlianService 
{
    @Autowired
    private GarCleanDianweiGuanlianMapper garCleanDianweiGuanlianMapper;

    /**
     * 查询关联
     * 
     * @param id 关联主键
     * @return 关联
     */
    @Override
    public GarCleanDianweiGuanlian selectGarCleanDianweiGuanlianById(Long id)
    {
        return garCleanDianweiGuanlianMapper.selectGarCleanDianweiGuanlianById(id);
    }

    /**
     * 查询关联列表
     * 
     * @param garCleanDianweiGuanlian 关联
     * @return 关联
     */
    @Override
    public List<GarCleanDianweiGuanlian> selectGarCleanDianweiGuanlianList(GarCleanDianweiGuanlian garCleanDianweiGuanlian)
    {
        return garCleanDianweiGuanlianMapper.selectGarCleanDianweiGuanlianList(garCleanDianweiGuanlian);
    }

    /**
     * 新增关联
     * 
     * @param garCleanDianweiGuanlian 关联
     * @return 结果
     */
    @Override
    public int insertGarCleanDianweiGuanlian(GarCleanDianweiGuanlian garCleanDianweiGuanlian)
    {
        return garCleanDianweiGuanlianMapper.insertGarCleanDianweiGuanlian(garCleanDianweiGuanlian);
    }

    /**
     * 修改关联
     * 
     * @param garCleanDianweiGuanlian 关联
     * @return 结果
     */
    @Override
    public int updateGarCleanDianweiGuanlian(GarCleanDianweiGuanlian garCleanDianweiGuanlian)
    {
        return garCleanDianweiGuanlianMapper.updateGarCleanDianweiGuanlian(garCleanDianweiGuanlian);
    }

    /**
     * 批量删除关联
     * 
     * @param ids 需要删除的关联主键
     * @return 结果
     */
    @Override
    public int deleteGarCleanDianweiGuanlianByIds(String ids)
    {
        return garCleanDianweiGuanlianMapper.deleteGarCleanDianweiGuanlianByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除关联信息
     * 
     * @param id 关联主键
     * @return 结果
     */
    @Override
    public int deleteGarCleanDianweiGuanlianById(Long id)
    {
        return garCleanDianweiGuanlianMapper.deleteGarCleanDianweiGuanlianById(id);
    }
}
