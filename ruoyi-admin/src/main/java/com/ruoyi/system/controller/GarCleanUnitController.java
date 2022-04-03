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
import com.ruoyi.system.domain.GarCleanUnit;
import com.ruoyi.system.service.IGarCleanUnitService;
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
@RequestMapping("/system/unit")
public class GarCleanUnitController extends BaseController
{
    private String prefix = "system/unit";

    @Autowired
    private IGarCleanUnitService garCleanUnitService;

    @RequiresPermissions("system:unit:view")
    @GetMapping()
    public String unit(ModelMap map)
    {

        return prefix + "/unit";
    }

    /**
     * 查询清运单位列表
     */
    @RequiresPermissions("system:unit:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GarCleanUnit garCleanUnit)
    {
        startPage();
        List<GarCleanUnit> list = garCleanUnitService.selectGarCleanUnitList(garCleanUnit);
        return getDataTable(list);
    }

    /**
     * 导出清运单位列表
     */
    @RequiresPermissions("system:unit:export")
    @Log(title = "清运单位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GarCleanUnit garCleanUnit)
    {
        List<GarCleanUnit> list = garCleanUnitService.selectGarCleanUnitList(garCleanUnit);
        ExcelUtil<GarCleanUnit> util = new ExcelUtil<GarCleanUnit>(GarCleanUnit.class);
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
    @RequiresPermissions("system:unit:add")
    @Log(title = "清运单位", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GarCleanUnit garCleanUnit)
    {
        return toAjax(garCleanUnitService.insertGarCleanUnit(garCleanUnit));
    }

    /**
     * 修改清运单位
     */
    @RequiresPermissions("system:unit:edit")
    @GetMapping("/edit/{cuid}")
    public String edit(@PathVariable("cuid") Long cuid, ModelMap mmap)
    {
        GarCleanUnit garCleanUnit = garCleanUnitService.selectGarCleanUnitByCuid(cuid);
        mmap.put("garCleanUnit", garCleanUnit);
        return prefix + "/edit";
    }

    /**
     * 修改保存清运单位
     */
    @RequiresPermissions("system:unit:edit")
    @Log(title = "清运单位", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GarCleanUnit garCleanUnit)
    {
        return toAjax(garCleanUnitService.updateGarCleanUnit(garCleanUnit));
    }

    /**
     * 删除清运单位
     */
    @RequiresPermissions("system:unit:remove")
    @Log(title = "清运单位", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(garCleanUnitService.deleteGarCleanUnitByCuids(ids));
    }
}
