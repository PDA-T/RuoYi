package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GarCleanRouteTravelMapper;
import com.ruoyi.system.domain.GarCleanRouteTravel;
import com.ruoyi.system.service.IGarCleanRouteTravelService;
import com.ruoyi.common.core.text.Convert;

/**
 * 线路点位Service业务层处理
 * 
 * @author p
 * @date 2022-03-15
 */
@Service
public class GarCleanRouteTravelServiceImpl implements IGarCleanRouteTravelService 
{
    @Autowired
    private GarCleanRouteTravelMapper garCleanRouteTravelMapper;

    /**
     * 查询线路点位
     * 
     * @param id 线路点位主键
     * @return 线路点位
     */
    @Override
    public GarCleanRouteTravel selectGarCleanRouteTravelById(Long id)
    {
        return garCleanRouteTravelMapper.selectGarCleanRouteTravelById(id);
    }

    /**
     * 查询线路点位列表
     * 
     * @param garCleanRouteTravel 线路点位
     * @return 线路点位
     */
    @Override
    public List<GarCleanRouteTravel> selectGarCleanRouteTravelList(GarCleanRouteTravel garCleanRouteTravel)
    {
        return garCleanRouteTravelMapper.selectGarCleanRouteTravelList(garCleanRouteTravel);
    }

    /**
     * 新增线路点位
     * 
     * @param garCleanRouteTravel 线路点位
     * @return 结果
     */
    @Override
    public int insertGarCleanRouteTravel(GarCleanRouteTravel garCleanRouteTravel)
    {
        return garCleanRouteTravelMapper.insertGarCleanRouteTravel(garCleanRouteTravel);
    }

    /**
     * 修改线路点位
     * 
     * @param garCleanRouteTravel 线路点位
     * @return 结果
     */
    @Override
    public int updateGarCleanRouteTravel(GarCleanRouteTravel garCleanRouteTravel)
    {
        return garCleanRouteTravelMapper.updateGarCleanRouteTravel(garCleanRouteTravel);
    }

    /**
     * 批量删除线路点位
     * 
     * @param ids 需要删除的线路点位主键
     * @return 结果
     */
    @Override
    public int deleteGarCleanRouteTravelByIds(String ids)
    {
        return garCleanRouteTravelMapper.deleteGarCleanRouteTravelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除线路点位信息
     * 
     * @param id 线路点位主键
     * @return 结果
     */
    @Override
    public int deleteGarCleanRouteTravelById(Long id)
    {
        return garCleanRouteTravelMapper.deleteGarCleanRouteTravelById(id);
    }
}
