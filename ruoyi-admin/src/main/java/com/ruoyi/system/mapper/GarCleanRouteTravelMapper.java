package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.GarCleanRouteTravel;

/**
 * 线路点位Mapper接口
 * 
 * @author p
 * @date 2022-03-15
 */
public interface GarCleanRouteTravelMapper 
{
    /**
     * 查询线路点位
     * 
     * @param id 线路点位主键
     * @return 线路点位
     */
    public GarCleanRouteTravel selectGarCleanRouteTravelById(Long id);

    /**
     * 查询线路点位列表
     * 
     * @param garCleanRouteTravel 线路点位
     * @return 线路点位集合
     */
    public List<GarCleanRouteTravel> selectGarCleanRouteTravelList(GarCleanRouteTravel garCleanRouteTravel);

    /**
     * 新增线路点位
     * 
     * @param garCleanRouteTravel 线路点位
     * @return 结果
     */
    public int insertGarCleanRouteTravel(GarCleanRouteTravel garCleanRouteTravel);

    /**
     * 修改线路点位
     * 
     * @param garCleanRouteTravel 线路点位
     * @return 结果
     */
    public int updateGarCleanRouteTravel(GarCleanRouteTravel garCleanRouteTravel);

    /**
     * 删除线路点位
     * 
     * @param id 线路点位主键
     * @return 结果
     */
    public int deleteGarCleanRouteTravelById(Long id);

    /**
     * 批量删除线路点位
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGarCleanRouteTravelByIds(String[] ids);
}
