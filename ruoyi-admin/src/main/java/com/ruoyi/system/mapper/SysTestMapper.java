package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysTest;

/**
 * 测试Mapper接口
 * 
 * @author ruoyi
 * @date 2022-03-15
 */
public interface SysTestMapper 
{
    /**
     * 查询测试
     * 
     * @param id 测试主键
     * @return 测试
     */
    public SysTest selectSysTestById(Long id);

    /**
     * 查询测试列表
     * 
     * @param sysTest 测试
     * @return 测试集合
     */
    public List<SysTest> selectSysTestList(SysTest sysTest);

    /**
     * 新增测试
     * 
     * @param sysTest 测试
     * @return 结果
     */
    public int insertSysTest(SysTest sysTest);

    /**
     * 修改测试
     * 
     * @param sysTest 测试
     * @return 结果
     */
    public int updateSysTest(SysTest sysTest);

    /**
     * 删除测试
     * 
     * @param id 测试主键
     * @return 结果
     */
    public int deleteSysTestById(Long id);

    /**
     * 批量删除测试
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysTestByIds(String[] ids);
}
