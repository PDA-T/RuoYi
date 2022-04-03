package com.ruoyi.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.GarCleanDianweiMapper;
import com.ruoyi.system.domain.GarCleanDianwei;
import com.ruoyi.system.service.IGarCleanDianweiService;
import com.ruoyi.common.core.text.Convert;

/**
 * 点位单位Service业务层处理
 * 
 * @author q
 * @date 2022-03-16
 */
@Service
public class GarCleanDianweiServiceImpl implements IGarCleanDianweiService 
{
    @Autowired
    private GarCleanDianweiMapper garCleanDianweiMapper;

    /**
     * 查询点位单位
     * 
     * @param id 点位单位主键
     * @return 点位单位
     */
    @Override
    public GarCleanDianwei selectGarCleanDianweiById(Long id)
    {
        return garCleanDianweiMapper.selectGarCleanDianweiById(id);
    }

    /**
     * 查询点位单位列表
     * 
     * @param garCleanDianwei 点位单位
     * @return 点位单位
     */
    @Override
    public List<GarCleanDianwei> selectGarCleanDianweiList(GarCleanDianwei garCleanDianwei)
    {
        return garCleanDianweiMapper.selectGarCleanDianweiList(garCleanDianwei);
    }

    /**
     * 新增点位单位
     * 
     * @param garCleanDianwei 点位单位
     * @return 结果
     */
    @Override
    public int insertGarCleanDianwei(GarCleanDianwei garCleanDianwei)
    {
        Random rando = new Random();
        for (int i=0;i<Integer.MAX_VALUE;i++){
            garCleanDianwei.setDwName(String.valueOf(rando.nextInt(Integer.MAX_VALUE)));
            garCleanDianwei.setbName(String.valueOf(rando.nextInt(Integer.MAX_VALUE)));
            garCleanDianwei.setLxr(String.valueOf(rando.nextInt(Integer.MAX_VALUE)));
            garCleanDianwei.setLxrDianhua(new Long(rando.nextInt(Integer.MAX_VALUE)));
            garCleanDianwei.setAddress(String.valueOf(rando.nextInt(Integer.MAX_VALUE)));
            garCleanDianwei.setJingdu(new Long(rando.nextInt(Integer.MAX_VALUE)));
            garCleanDianwei.setBeizhu(String.valueOf(rando.nextInt(Integer.MAX_VALUE)));

            garCleanDianwei.setChuanjianTime(DateUtils.dateTime());
            garCleanDianweiMapper.insertGarCleanDianwei(garCleanDianwei);
        }
        return garCleanDianweiMapper.insertGarCleanDianwei(garCleanDianwei);
    }

    /**
     * 修改点位单位
     * 
     * @param garCleanDianwei 点位单位
     * @return 结果
     */
    @Override
    public int updateGarCleanDianwei(GarCleanDianwei garCleanDianwei)
    {
        return garCleanDianweiMapper.updateGarCleanDianwei(garCleanDianwei);
    }

    /**
     * 批量删除点位单位
     * 
     * @param ids 需要删除的点位单位主键
     * @return 结果
     */
    @Override
    public int deleteGarCleanDianweiByIds(String ids)
    {
        return garCleanDianweiMapper.deleteGarCleanDianweiByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除点位单位信息
     * 
     * @param id 点位单位主键
     * @return 结果
     */
    @Override
    public int deleteGarCleanDianweiById(Long id)
    {
        return garCleanDianweiMapper.deleteGarCleanDianweiById(id);
    }
}
