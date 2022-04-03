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
import com.ruoyi.system.domain.GarCleanRouteTravel;
import com.ruoyi.system.service.IGarCleanRouteTravelService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 线路点位Controller
 * 
 * @author p
 * @date 2022-03-15
 */
@Controller
@RequestMapping("/system/travel")
public class GarCleanRouteTravelController extends BaseController
{
    private String prefix = "system/travel";

    @Autowired
    private IGarCleanRouteTravelService garCleanRouteTravelService;

    @RequiresPermissions("system:travel:view")
    @GetMapping()
    public String travel()
    {
        return prefix + "/travel";
    }

    /**
     * 查询线路点位列表
     */
    @RequiresPermissions("system:travel:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GarCleanRouteTravel garCleanRouteTravel)
    {
        startPage();
        List<GarCleanRouteTravel> list = garCleanRouteTravelService.selectGarCleanRouteTravelList(garCleanRouteTravel);
        return getDataTable(list);
    }

    /**
     * 导出线路点位列表
     */
    @RequiresPermissions("system:travel:export")
    @Log(title = "线路点位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GarCleanRouteTravel garCleanRouteTravel)
    {
        List<GarCleanRouteTravel> list = garCleanRouteTravelService.selectGarCleanRouteTravelList(garCleanRouteTravel);
        ExcelUtil<GarCleanRouteTravel> util = new ExcelUtil<GarCleanRouteTravel>(GarCleanRouteTravel.class);
        return util.exportExcel(list, "线路点位数据");
    }

    /**
     * 新增线路点位
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存线路点位
     */
    @RequiresPermissions("system:travel:add")
    @Log(title = "线路点位", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GarCleanRouteTravel garCleanRouteTravel)
    {
        return toAjax(garCleanRouteTravelService.insertGarCleanRouteTravel(garCleanRouteTravel));
    }

    /**
     * 修改线路点位
     */
    @RequiresPermissions("system:travel:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GarCleanRouteTravel garCleanRouteTravel = garCleanRouteTravelService.selectGarCleanRouteTravelById(id);
        mmap.put("garCleanRouteTravel", garCleanRouteTravel);
        return prefix + "/edit";
    }

    /**
     * 修改保存线路点位
     */
    @RequiresPermissions("system:travel:edit")
    @Log(title = "线路点位", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GarCleanRouteTravel garCleanRouteTravel)
    {
        return toAjax(garCleanRouteTravelService.updateGarCleanRouteTravel(garCleanRouteTravel));
    }

    /**
     * 删除线路点位
     */
    @RequiresPermissions("system:travel:remove")
    @Log(title = "线路点位", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(garCleanRouteTravelService.deleteGarCleanRouteTravelByIds(ids));
    }
}
