package com.ruoyi.system.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
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
import com.ruoyi.system.domain.GarCleanDianwei;
import com.ruoyi.system.service.IGarCleanDianweiService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 点位单位Controller
 * 
 * @author q
 * @date 2022-03-16
 */
@Controller
@RequestMapping("/system/dianwei")
public class GarCleanDianweiController extends BaseController
{
    private String prefix = "system/dianwei";

    @Autowired
    private IGarCleanDianweiService garCleanDianweiService;

    @RequiresPermissions("system:dianwei:view")
    @GetMapping()
    public String dianwei()
    {
        return prefix + "/dianwei";
    }

    /**
     * 查询点位单位列表
     */
    @RequiresPermissions("system:dianwei:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(GarCleanDianwei garCleanDianwei)
    {
        startPage();
        List<GarCleanDianwei> list = garCleanDianweiService.selectGarCleanDianweiList(garCleanDianwei);
        return getDataTable(list);
    }

    /**
     * 更改状态
     * @param id
     * @param status
     * @return
     */
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(int id,int status){
        int row = 0;
        GarCleanDianwei jg = garCleanDianweiService.selectGarCleanDianweiById((long) id);
        Long zt = jg.getZhuangTai();
        if (zt == 1){
            jg.setZhuangTai((long) 0);
            row = garCleanDianweiService.updateGarCleanDianwei(jg);
            return AjaxResult.success(row);
        }else if (zt == 0){
            jg.setZhuangTai((long) 1);
            row = garCleanDianweiService.updateGarCleanDianwei(jg);
            return AjaxResult.success(row);
        }
        return AjaxResult.error("error");
    }

    /**
     * getTime
     */
    @PostMapping("/getTime")
    @ResponseBody
    public void getTime(){
        GarCleanDianwei garCleanDianwei = new GarCleanDianwei();
        garCleanDianwei.setChuanjianTime(DateUtils.getTime());
    }

    /**
     * 导出点位单位列表
     */
    @RequiresPermissions("system:dianwei:export")
    @Log(title = "点位单位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(GarCleanDianwei garCleanDianwei)
    {
        List<GarCleanDianwei> list = garCleanDianweiService.selectGarCleanDianweiList(garCleanDianwei);
        ExcelUtil<GarCleanDianwei> util = new ExcelUtil<GarCleanDianwei>(GarCleanDianwei.class);
        return util.exportExcel(list, "点位单位数据");
    }

    /**
     * 新增点位单位
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存点位单位
     */
    @RequiresPermissions("system:dianwei:add")
    @Log(title = "点位单位", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(GarCleanDianwei garCleanDianwei)
    {
        return toAjax(garCleanDianweiService.insertGarCleanDianwei(garCleanDianwei));
    }

    /**
     * 修改点位单位
     */
    @RequiresPermissions("system:dianwei:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        GarCleanDianwei garCleanDianwei = garCleanDianweiService.selectGarCleanDianweiById(id);
        mmap.put("garCleanDianwei", garCleanDianwei);
        return prefix + "/edit";
    }

    /**
     * 修改保存点位单位
     */
    @RequiresPermissions("system:dianwei:edit")
    @Log(title = "点位单位", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(GarCleanDianwei garCleanDianwei)
    {
        return toAjax(garCleanDianweiService.updateGarCleanDianwei(garCleanDianwei));
    }

    /**
     * 删除点位单位
     */
    @RequiresPermissions("system:dianwei:remove")
    @Log(title = "点位单位", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(garCleanDianweiService.deleteGarCleanDianweiByIds(ids));
    }
}
