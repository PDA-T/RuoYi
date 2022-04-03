package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.GarCleanDianweiGuanlian;

/**
 * 关联Service接口
 * 
 * @author p
 * @date 2022-03-18
 */
public interface IGarCleanDianweiGuanlianService 
{
    /**
     * 查询关联
     * 
     * @param id 关联主键
     * @return 关联
     */
    public GarCleanDianweiGuanlian selectGarCleanDianweiGuanlianById(Long id);

    /**
     * 查询关联列表
     * 
     * @param garCleanDianweiGuanlian 关联
     * @return 关联集合
     */
    public List<GarCleanDianweiGuanlian> selectGarCleanDianweiGuanlianList(GarCleanDianweiGuanlian garCleanDianweiGuanlian);

    /**
     * 新增关联
     * 
     * @param garCleanDianweiGuanlian 关联
     * @return 结果
     */
    public int insertGarCleanDianweiGuanlian(GarCleanDianweiGuanlian garCleanDianweiGuanlian);

    /**
     * 修改关联
     * 
     * @param garCleanDianweiGuanlian 关联
     * @return 结果
     */
    public int updateGarCleanDianweiGuanlian(GarCleanDianweiGuanlian garCleanDianweiGuanlian);

    /**
     * 批量删除关联
     * 
     * @param ids 需要删除的关联主键集合
     * @return 结果
     */
    public int deleteGarCleanDianweiGuanlianByIds(String ids);

    /**
     * 删除关联信息
     * 
     * @param id 关联主键
     * @return 结果
     */
    public int deleteGarCleanDianweiGuanlianById(Long id);
}
