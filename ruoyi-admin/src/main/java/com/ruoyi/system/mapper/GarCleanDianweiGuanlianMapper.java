package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.GarCleanDianweiGuanlian;

/**
 * 关联Mapper接口
 * 
 * @author p
 * @date 2022-03-18
 */
public interface GarCleanDianweiGuanlianMapper 
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
     * 删除关联
     * 
     * @param id 关联主键
     * @return 结果
     */
    public int deleteGarCleanDianweiGuanlianById(Long id);

    /**
     * 批量删除关联
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGarCleanDianweiGuanlianByIds(String[] ids);
}
