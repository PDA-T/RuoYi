package com.ruoyi.system.controller;

import java.util.Date;
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
import com.ruoyi.system.domain.GarCleanDianweiGuanlian;
import com.ruoyi.system.service.IGarCleanDianweiGuanlianService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 关联Controller
 * 
 * @author p
 * @date 2022-03-18
 */
@Controller
@RequestMapping("/system/guanlian")
public class GarCleanDianweiGuanlianController extends BaseController
{
    private String prefix = "system/guanlian";

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Autowired
    private IGarCleanDianweiGuanlianService garCleanDianweiGuanlianService;
    @RequiresPermissions("system:guanlian:view")
    @GetMapping("/{id}")
    public String guanlian(@PathVariable("id") Long id,ModelMap map)
    {
        setId(Math.toIntExact(id));
        map.put("lxrId",id);
        return prefix + "/guanlian";
    }

    /**
     * 查询关联列表
     */
    @RequiresPermissions("system:guanlian:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GarCleanDianweiGuanlian garCleanDianweiGuanlian)
    {
        startPage();
        List<GarCleanDianweiGuanlian> list = garCleanDianweiGuanlianService.selectGarCleanDianweiGuanlianList(garCleanDianweiGuanlian);
        return getDataTable(list);
    }

    @RequestMapping("resetPwd/{id}")
    public String resetPwd(){
        return prefix + "/resetPwd";
    }

    /**
     * 导出关联列表
     */
    @RequiresPermissions("system:guanlian:export")
    @Log(title = "关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GarCleanDianweiGuanlian garCleanDianweiGuanlian)
    {
        List<GarCleanDianweiGuanlian> list = garCleanDianweiGuanlianService.selectGarCleanDianweiGuanlianList(garCleanDianweiGuanlian);
        ExcelUtil<GarCleanDianweiGuanlian> util = new ExcelUtil<GarCleanDianweiGuanlian>(GarCleanDianweiGuanlian.class);
        return util.exportExcel(list, "关联数据");
    }

    /**
     * 新增关联
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存关联
     */
    @RequiresPermissions("system:guanlian:add")
    @Log(title = "关联", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GarCleanDianweiGuanlian garCleanDianweiGuanlian)
    {
        garCleanDianweiGuanlian.setChuanjianTime(new Date());
        garCleanDianweiGuanlian.setLxrId(getId());
        return toAjax(garCleanDianweiGuanlianService.insertGarCleanDianweiGuanlian(garCleanDianweiGuanlian));
    }

    /**
     * 修改关联
     */
    @RequiresPermissions("system:guanlian:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GarCleanDianweiGuanlian garCleanDianweiGuanlian = garCleanDianweiGuanlianService.selectGarCleanDianweiGuanlianById(id);
        mmap.put("garCleanDianweiGuanlian", garCleanDianweiGuanlian);
        return prefix + "/edit";
    }

    /**
     * 修改保存关联
     */
    @RequiresPermissions("system:guanlian:edit")
    @Log(title = "关联", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GarCleanDianweiGuanlian garCleanDianweiGuanlian)
    {
        return toAjax(garCleanDianweiGuanlianService.updateGarCleanDianweiGuanlian(garCleanDianweiGuanlian));
    }

    /**
     * 删除关联
     */
    @RequiresPermissions("system:guanlian:remove")
    @Log(title = "关联", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(garCleanDianweiGuanlianService.deleteGarCleanDianweiGuanlianByIds(ids));
    }
}
