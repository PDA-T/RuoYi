package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysTestMapper;
import com.ruoyi.system.domain.SysTest;
import com.ruoyi.system.service.ISysTestService;
import com.ruoyi.common.core.text.Convert;

/**
 * 测试Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-03-15
 */
@Service
public class SysTestServiceImpl implements ISysTestService 
{
    @Autowired
    private SysTestMapper sysTestMapper;

    /**
     * 查询测试
     * 
     * @param id 测试主键
     * @return 测试
     */
    @Override
    public SysTest selectSysTestById(Long id)
    {
        return sysTestMapper.selectSysTestById(id);
    }

    /**
     * 查询测试列表
     * 
     * @param sysTest 测试
     * @return 测试
     */
    @Override
    public List<SysTest> selectSysTestList(SysTest sysTest)
    {
        return sysTestMapper.selectSysTestList(sysTest);
    }

    /**
     * 新增测试
     * 
     * @param sysTest 测试
     * @return 结果
     */
    @Override
    public int insertSysTest(SysTest sysTest)
    {
        return sysTestMapper.insertSysTest(sysTest);
    }

    /**
     * 修改测试
     * 
     * @param sysTest 测试
     * @return 结果
     */
    @Override
    public int updateSysTest(SysTest sysTest)
    {
        return sysTestMapper.updateSysTest(sysTest);
    }

    /**
     * 批量删除测试
     * 
     * @param ids 需要删除的测试主键
     * @return 结果
     */
    @Override
    public int deleteSysTestByIds(String ids)
    {
        return sysTestMapper.deleteSysTestByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除测试信息
     * 
     * @param id 测试主键
     * @return 结果
     */
    @Override
    public int deleteSysTestById(Long id)
    {
        return sysTestMapper.deleteSysTestById(id);
    }
}
