package com.ruoyi.chaindrug.service;

import java.util.List;
import com.ruoyi.chaindrug.domain.BizCustomDrug;

/**
 * 客户-药品字典Service接口
 * 
 * @author ruoyi
 * @date 2020-12-28
 */
public interface IBizCustomDrugService 
{
    /**
     * 查询客户-药品字典
     * 
     * @param id 客户-药品字典ID
     * @return 客户-药品字典
     */
    public BizCustomDrug selectBizCustomDrugById(Long id);

    /**
     * 查询客户-药品字典列表
     * 
     * @param bizCustomDrug 客户-药品字典
     * @return 客户-药品字典集合
     */
    public List<BizCustomDrug> selectBizCustomDrugList(BizCustomDrug bizCustomDrug);

    /**
     * 新增客户-药品字典
     * 
     * @param bizCustomDrug 客户-药品字典
     * @return 结果
     */
    public int insertBizCustomDrug(BizCustomDrug bizCustomDrug);

    /**
     * 修改客户-药品字典
     * 
     * @param bizCustomDrug 客户-药品字典
     * @return 结果
     */
    public int updateBizCustomDrug(BizCustomDrug bizCustomDrug);

    /**
     * 批量删除客户-药品字典
     * 
     * @param ids 需要删除的客户-药品字典ID
     * @return 结果
     */
    public int deleteBizCustomDrugByIds(Long[] ids);

    /**
     * 删除客户-药品字典信息
     * 
     * @param id 客户-药品字典ID
     * @return 结果
     */
    public int deleteBizCustomDrugById(Long id);
}
