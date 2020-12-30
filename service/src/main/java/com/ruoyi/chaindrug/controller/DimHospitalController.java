package com.ruoyi.chaindrug.controller;

import java.util.List;

import com.ruoyi.chaindrug.domain.BizCustomDrug;
import com.ruoyi.chaindrug.domain.BizCustomDrug;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
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
import com.ruoyi.chaindrug.domain.DimHospital;
import com.ruoyi.chaindrug.service.IDimHospitalService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 医院信息Controller
 * 
 * @author ruoyi
 * @date 2020-12-22
 */
@Api(value="医院信息")
@RestController
@RequestMapping("/hospital/hospital")
public class DimHospitalController extends BaseController
{
    @Autowired
    private IDimHospitalService dimHospitalService;


    @Autowired
    private TokenService tokenService;

    /**
     * 查询医院信息列表
     */
    @ApiOperation("获取医院信息列表")
    //@PreAuthorize("@ss.hasPermi('hospital:hospital:list')")
    @GetMapping("/list")
    public TableDataInfo list(DimHospital dimHospital)
    {
        startPage();
        List<DimHospital> list = dimHospitalService.selectDimHospitalList(dimHospital);
        return getDataTable(list);
    }

    /**
     * 导出医院信息列表
     */
    //@PreAuthorize("@ss.hasPermi('hospital:hospital:export')")
    @Log(title = "医院信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DimHospital dimHospital)
    {
        List<DimHospital> list = dimHospitalService.selectDimHospitalList(dimHospital);
        ExcelUtil<DimHospital> util = new ExcelUtil<DimHospital>(DimHospital.class);
        return util.exportExcel(list, "hospital");
    }

    /**
     * 导入医院信息列表
     */
    @ApiOperation("上传医院字典信息")
    //@Log(title = "医院信息", businessType = BusinessType.IMPORT)
    //@PreAuthorize("@ss.hasPermi('hospital:hospital:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<BizCustomDrug> util = new ExcelUtil<BizCustomDrug>(BizCustomDrug.class);
        List<BizCustomDrug> drugList = util.importExcel(file.getInputStream());
        //LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        //String operName = loginUser.getUsername();
        String operName ="操作用户";
        String message = dimHospitalService.importDrug(drugList, updateSupport, operName);
         return AjaxResult.success(message);
    }

    /**
     * 获取医院信息详细信息
     */
    @ApiOperation("根据id获取医院详细信息")
    //@PreAuthorize("@ss.hasPermi('hospital:hospital:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dimHospitalService.selectDimHospitalById(id));
    }

    /**
     * 新增医院信息
     */
    @ApiOperation("新增医院")
    //@PreAuthorize("@ss.hasPermi('hospital:hospital:add')")
    @Log(title = "医院信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DimHospital dimHospital)
    {
        return toAjax(dimHospitalService.insertDimHospital(dimHospital));
    }

    /**
     * 修改医院信息
     */
    @ApiOperation("修改医院信息")
    //@PreAuthorize("@ss.hasPermi('hospital:hospital:edit')")
    @Log(title = "医院信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DimHospital dimHospital)
    {
        return toAjax(dimHospitalService.updateDimHospital(dimHospital));
    }

    /**
     * 删除医院信息
     */
    @ApiOperation("删除医院信息")
    //@PreAuthorize("@ss.hasPermi('hospital:hospital:remove')")
    @Log(title = "医院信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dimHospitalService.deleteDimHospitalByIds(ids));
    }
}
