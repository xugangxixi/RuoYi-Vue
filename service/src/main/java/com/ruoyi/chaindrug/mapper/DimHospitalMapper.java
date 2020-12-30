package com.ruoyi.chaindrug.mapper;

import java.util.List;

import com.ruoyi.chaindrug.domain.DimHospital;

/**
 * 医院信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-12-22
 */
public interface DimHospitalMapper 
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
     * 删除医院信息
     * 
     * @param id 医院信息ID
     * @return 结果
     */
    public int deleteDimHospitalById(Long id);

    /**
     * 批量删除医院信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDimHospitalByIds(Long[] ids);
}
