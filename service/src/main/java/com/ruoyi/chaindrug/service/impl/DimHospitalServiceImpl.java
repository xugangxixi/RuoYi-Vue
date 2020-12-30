package com.ruoyi.chaindrug.service.impl;

import java.util.List;

import com.ruoyi.chaindrug.domain.BizCustomDrug;
import com.ruoyi.chaindrug.domain.DimHospital;
import com.ruoyi.chaindrug.mapper.DimHospitalMapper;
import com.ruoyi.chaindrug.service.IBizCustomDrugService;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chaindrug.service.IDimHospitalService;

/**
 * 医院信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-22
 */
@Service
public class DimHospitalServiceImpl implements IDimHospitalService 
{
    @Autowired
    private DimHospitalMapper dimHospitalMapper;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private IBizCustomDrugService iBizCustomDrugService;

    @Autowired
    private SysUserMapper userMapper;

    /**
     * 查询医院信息
     * 
     * @param id 医院信息ID
     * @return 医院信息
     */
    @Override
    public DimHospital selectDimHospitalById(Long id)
    {
        return dimHospitalMapper.selectDimHospitalById(id);
    }

    /**
     * 查询医院信息列表
     * 
     * @param dimHospital 医院信息
     * @return 医院信息
     */
    @Override
    public List<DimHospital> selectDimHospitalList(DimHospital dimHospital)
    {
        return dimHospitalMapper.selectDimHospitalList(dimHospital);
    }

    /**
     * 新增医院信息
     * 
     * @param dimHospital 医院信息
     * @return 结果
     */
    @Override
    public int insertDimHospital(DimHospital dimHospital)
    {
        return dimHospitalMapper.insertDimHospital(dimHospital);
    }

    /**
     * 修改医院信息
     * 
     * @param dimHospital 医院信息
     * @return 结果
     */
    @Override
    public int updateDimHospital(DimHospital dimHospital)
    {
        return dimHospitalMapper.updateDimHospital(dimHospital);
    }

    /**
     * 批量删除医院信息
     * 
     * @param ids 需要删除的医院信息ID
     * @return 结果
     */
    @Override
    public int deleteDimHospitalByIds(Long[] ids)
    {
        return dimHospitalMapper.deleteDimHospitalByIds(ids);
    }

    /**
     * 删除医院信息信息
     * 
     * @param id 医院信息ID
     * @return 结果
     */
    @Override
    public int deleteDimHospitalById(Long id)
    {
        return dimHospitalMapper.deleteDimHospitalById(id);
    }


    /**
     *
     *
     * @param drugList 药品数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importDrug(List<BizCustomDrug> drugList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(drugList) || drugList.size() == 0)
        {
            throw new CustomException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        String password = configService.selectConfigByKey("sys.user.initPassword");
        for (BizCustomDrug drug : drugList)
        {
            try
            {
                iBizCustomDrugService.insertBizCustomDrug(drug);
                successMsg.append("导入成功");
            }
            catch (Exception e)
            {
                String msg = "导入失败";
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
