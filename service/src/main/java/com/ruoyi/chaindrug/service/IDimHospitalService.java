package com.ruoyi.chaindrug.service;

import java.util.List;

import com.ruoyi.chaindrug.domain.BizCustomDrug;
import com.ruoyi.chaindrug.domain.DimHospital;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 医院信息Service接口
 * 
 * @author ruoyi
 * @date 2020-12-22
 */
public interface IDimHospitalService 
{
    /**
     * 查询医院信息
     * 
     * @param id 医院信息ID
     * @return 医院信息
     */
    public DimHospital selectDimHospitalById(Long id);

    /**
     * 查询医院信息列表
     * 
     * @param dimHospital 医院信息
     * @return 医院信息集合
     */
    public List<DimHospital> selectDimHospitalList(DimHospital dimHospital);

    /**
     * 新增医院信息
     * 
     * @param dimHospital 医院信息
     * @return 结果
     */
    public int insertDimHospital(DimHospital dimHospital);

    /**
     * 修改医院信息
     * 
     * @param dimHospital 医院信息
     * @return 结果
     */
    public int updateDimHospital(DimHospital dimHospital);

    /**
     * 批量删除医院信息
     * 
     * @param ids 需要删除的医院信息ID
     * @return 结果
     */
    public int deleteDimHospitalByIds(Long[] ids);

    /**
     * 删除医院信息信息
     * 
     * @param id 医院信息ID
     * @return 结果
     */
    public int deleteDimHospitalById(Long id);

    /**
     * 导入客户-医院数据
     *
     * @param drugList 药品数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importDrug(List<BizCustomDrug> drugList, Boolean isUpdateSupport, String operName);
}
