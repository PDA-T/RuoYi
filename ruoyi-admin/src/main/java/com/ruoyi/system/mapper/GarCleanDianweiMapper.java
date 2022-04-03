package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.GarCleanDianwei;

/**
 * 点位单位Mapper接口
 * 
 * @author q
 * @date 2022-03-16
 */
public interface GarCleanDianweiMapper 
{
    /**
     * 查询点位单位
     * 
     * @param id 点位单位主键
     * @return 点位单位
     */
    public GarCleanDianwei selectGarCleanDianweiById(Long id);

    /**
     * 查询点位单位列表
     * 
     * @param garCleanDianwei 点位单位
     * @return 点位单位集合
     */
    public List<GarCleanDianwei> selectGarCleanDianweiList(GarCleanDianwei garCleanDianwei);

    /**
     * 新增点位单位
     * 
     * @param garCleanDianwei 点位单位
     * @return 结果
     */
    public int insertGarCleanDianwei(GarCleanDianwei garCleanDianwei);

    /**
     * 修改点位单位
     * 
     * @param garCleanDianwei 点位单位
     * @return 结果
     */
    public int updateGarCleanDianwei(GarCleanDianwei garCleanDianwei);

    /**
     * 删除点位单位
     * 
     * @param id 点位单位主键
     * @return 结果
     */
    public int deleteGarCleanDianweiById(Long id);

    /**
     * 批量删除点位单位
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGarCleanDianweiByIds(String[] ids);
}
