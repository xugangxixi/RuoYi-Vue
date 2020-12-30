package com.ruoyi.chaindrug.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.chaindrug.mapper.BizCustomDrugMapper;
import com.ruoyi.chaindrug.domain.BizCustomDrug;
import com.ruoyi.chaindrug.service.IBizCustomDrugService;

/**
 * 客户-药品字典Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-28
 */
@Service
public class BizCustomDrugServiceImpl implements IBizCustomDrugService 
{
    @Autowired
    private BizCustomDrugMapper bizCustomDrugMapper;

    /**
     * 查询客户-药品字典
     * 
     * @param id 客户-药品字典ID
     * @return 客户-药品字典
     */
    @Override
    public BizCustomDrug selectBizCustomDrugById(Long id)
    {
        return bizCustomDrugMapper.selectBizCustomDrugById(id);
    }

    /**
     * 查询客户-药品字典列表
     * 
     * @param bizCustomDrug 客户-药品字典
     * @return 客户-药品字典
     */
    @Override
    public List<BizCustomDrug> selectBizCustomDrugList(BizCustomDrug bizCustomDrug)
    {
        return bizCustomDrugMapper.selectBizCustomDrugList(bizCustomDrug);
    }

    /**
     * 新增客户-药品字典
     * 
     * @param bizCustomDrug 客户-药品字典
     * @return 结果
     */
    @Override
    public int insertBizCustomDrug(BizCustomDrug bizCustomDrug)
    {
        return bizCustomDrugMapper.insertBizCustomDrug(bizCustomDrug);
    }

    /**
     * 修改客户-药品字典
     * 
     * @param bizCustomDrug 客户-药品字典
     * @return 结果
     */
    @Override
    public int updateBizCustomDrug(BizCustomDrug bizCustomDrug)
    {
        return bizCustomDrugMapper.updateBizCustomDrug(bizCustomDrug);
    }

    /**
     * 批量删除客户-药品字典
     * 
     * @param ids 需要删除的客户-药品字典ID
     * @return 结果
     */
    @Override
    public int deleteBizCustomDrugByIds(Long[] ids)
    {
        return bizCustomDrugMapper.deleteBizCustomDrugByIds(ids);
    }

    /**
     * 删除客户-药品字典信息
     * 
     * @param id 客户-药品字典ID
     * @return 结果
     */
    @Override
    public int deleteBizCustomDrugById(Long id)
    {
        return bizCustomDrugMapper.deleteBizCustomDrugById(id);
    }
}
