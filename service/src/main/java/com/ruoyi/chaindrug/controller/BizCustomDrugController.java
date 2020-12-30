package com.ruoyi.chaindrug.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.chaindrug.domain.BizCustomDrug;
import com.ruoyi.chaindrug.service.IBizCustomDrugService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户-药品字典Controller
 * 
 * @author ruoyi
 * @date 2020-12-28
 */
@Api(value="药品字典信息")
@RestController
@RequestMapping("/chaindrug/drug")
public class BizCustomDrugController extends BaseController
{
    @Autowired
    private IBizCustomDrugService bizCustomDrugService;

    /**
     * 查询客户-药品字典列表
     */
    @ApiOperation("根据医院获取药品字典列表")
    //@PreAuthorize("@ss.hasPermi('chaindrug:drug:list')")
    @GetMapping("/list")
    public TableDataInfo list(BizCustomDrug bizCustomDrug)
    {
        startPage();
        List<BizCustomDrug> list = bizCustomDrugService.selectBizCustomDrugList(bizCustomDrug);
        return getDataTable(list);
    }

    /**
     * 导出客户-药品字典列表
     */
    //@PreAuthorize("@ss.hasPermi('chaindrug:drug:export')")
    @Log(title = "客户-药品字典", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BizCustomDrug bizCustomDrug)
    {
        List<BizCustomDrug> list = bizCustomDrugService.selectBizCustomDrugList(bizCustomDrug);
        ExcelUtil<BizCustomDrug> util = new ExcelUtil<BizCustomDrug>(BizCustomDrug.class);
        return util.exportExcel(list, "drug");
    }

    /**
     * 获取客户-药品字典详细信息
     */

    //@PreAuthorize("@ss.hasPermi('chaindrug:drug:query')")
    @ApiOperation("根据id药品字典的详细信息")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(bizCustomDrugService.selectBizCustomDrugById(id));
    }

    /**
     * 新增客户-药品字典
     */
    @ApiOperation("新增药品字典")
    //@PreAuthorize("@ss.hasPermi('chaindrug:drug:add')")
    @Log(title = "客户-药品字典", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BizCustomDrug bizCustomDrug)
    {
        return toAjax(bizCustomDrugService.insertBizCustomDrug(bizCustomDrug));
    }

    /**
     * 修改客户-药品字典
     */
    @PreAuthorize("@ss.hasPermi('chaindrug:drug:edit')")
    @Log(title = "客户-药品字典", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BizCustomDrug bizCustomDrug)
    {
        return toAjax(bizCustomDrugService.updateBizCustomDrug(bizCustomDrug));
    }

    /**
     * 删除客户-药品字典
     */
    @PreAuthorize("@ss.hasPermi('chaindrug:drug:remove')")
    @Log(title = "客户-药品字典", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bizCustomDrugService.deleteBizCustomDrugByIds(ids));
    }
}
