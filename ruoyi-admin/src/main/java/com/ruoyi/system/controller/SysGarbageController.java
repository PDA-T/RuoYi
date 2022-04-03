package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysGarbage;
import com.ruoyi.system.service.ISysGarbageService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 清运单位Controller
 * 
 * @author p
 * @date 2022-03-15
 */
@Controller
@RequestMapping("/system/garbage")
public class SysGarbageController extends BaseController
{
    private String prefix = "system/garbage";

    @Autowired
    private ISysGarbageService sysGarbageService;

    @RequiresPermissions("system:garbage:view")
    @GetMapping()
    public String garbage()
    {
        return prefix + "/garbage";
    }

    /**
     * 查询清运单位列表
     */
    @RequiresPermissions("system:garbage:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysGarbage sysGarbage)
    {
        startPage();
        List<SysGarbage> list = sysGarbageService.selectSysGarbageList(sysGarbage);
        return getDataTable(list);
    }

    /**
     * 导出清运单位列表
     */
    @RequiresPermissions("system:garbage:export")
    @Log(title = "清运单位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysGarbage sysGarbage)
    {
        List<SysGarbage> list = sysGarbageService.selectSysGarbageList(sysGarbage);
        ExcelUtil<SysGarbage> util = new ExcelUtil<SysGarbage>(SysGarbage.class);
        return util.exportExcel(list, "清运单位数据");
    }

    /**
     * 新增清运单位
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存清运单位
     */
    @RequiresPermissions("system:garbage:add")
    @Log(title = "清运单位", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysGarbage sysGarbage)
    {
        return toAjax(sysGarbageService.insertSysGarbage(sysGarbage));
    }

    /**
     * 修改清运单位
     */
    @RequiresPermissions("system:garbage:edit")
    @GetMapping("/edit/{cuid}")
    public String edit(@PathVariable("cuid") Long cuid, ModelMap mmap)
    {
        SysGarbage sysGarbage = sysGarbageService.selectSysGarbageByCuid(cuid);
        mmap.put("sysGarbage", sysGarbage);
        return prefix + "/edit";
    }

    /**
     * 修改保存清运单位
     */
    @RequiresPermissions("system:garbage:edit")
    @Log(title = "清运单位", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysGarbage sysGarbage)
    {
        return toAjax(sysGarbageService.updateSysGarbage(sysGarbage));
    }

    /**
     * 删除清运单位
     */
    @RequiresPermissions("system:garbage:remove")
    @Log(title = "清运单位", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysGarbageService.deleteSysGarbageByCuids(ids));
    }
}
