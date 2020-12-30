package com.ruoyi.chaindrug.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户-药品字典对象 biz_custom_drug
 * 
 * @author ruoyi
 * @date 2020-12-28
 */
public class BizCustomDrug extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 医院编码 */
    @Excel(name = "医院编码")
    private String hospCode;

    /** 客户-药品编码 */
    @Excel(name = "药品代码")
    private String uCode;

    /** 客户-药品名称 */
    @Excel(name = "药品名称（通用名）")
    private String uName;

    /** 客户-商品名 */
    @Excel(name = "商品名")
    private String uProductName;

    /** 客户-首拼 */
    @Excel(name = "通用名首拼")
    private String uSp;

    /** 客户-规格 */
    @Excel(name = "规格")
    private String uSpec;

    /** 客户-单位  */
    @Excel(name = "单位")
    private String uUnit;

    /** 客户-剂型  */
    @Excel(name = "剂型")
    private String uJx;

    /** 客户-生产厂家 */
    @Excel(name = "生产厂家")
    private String uCj;

    /** 客户-大类 */
    @Excel(name = "大类代码")
    private String uDl;

    /** 客户-是否抗菌药物（1-是，空/0-不是） */
    @Excel(name = "是否抗菌药物", readConverterExp = "1=-是，空/0-不是")
    private String uIsanti;

    /** 客户-抗菌药物分级（1,2,3） */
    @Excel(name = "抗菌药物分级", readConverterExp = "1=,2,3")
    private String uAntitype;

    /** 客户-批准文号 */
    @Excel(name = "客批准文号")
    private String uApprove;

    /** 药品编码 */
    @Excel(name = "sys_药品编码")
    private String drugCode;

    /** 药品名称 */
    @Excel(name = "sys_药品名称")
    private String drugName;

    /** 规格 */
    @Excel(name = "sys_规格")
    private String drugSpec;

    /** 批准文号 */
    @Excel(name = "sys_批准文号")
    private String drugApprove;

    /** 识别程度 */
    @Excel(name = "sys_识别程度")
    private Integer flag;

    /** 生产厂家 */
    @Excel(name = "sys_生产厂家")
    private String cj;

    /** 人工审核 */
    @Excel(name = "人工审核")
    private Integer audit1;

    /** DDD值 */
    @Excel(name = "DDD值")
    private Integer dddValue;

    /** DDD单位 */
    @Excel(name = "DDD单位")
    private String dddUnit;

    /** 分配用户 */
    @Excel(name = "分配用户")
    private String allotUser;

    /** 匹配操作员 */
    @Excel(name = "匹配操作员")
    private String matchUser;

    /** 分配时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "分配时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date allotTime;

    /** 匹配时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "匹配时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date matchTime;

    /** 没有匹配的SDA 药品 */
    @Excel(name = "没有匹配的SDA 药品")
    private Integer notHaveSda;

    /** 标记操作员 */
    @Excel(name = "标记操作员")
    private String markUser;

    /** 状态(0未匹配1未审核2已跳过3降级匹配4审核成功) */
    @Excel(name = "状态(0未匹配1未审核2已跳过3降级匹配4审核成功)")
    private Integer state;

    /** 创建者id */
    @Excel(name = "创建者id")
    private Long createuser;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createtime;

    /** 更新者id */
    @Excel(name = "更新者id")
    private Long updateuser;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatetime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setHospCode(String hospCode) 
    {
        this.hospCode = hospCode;
    }

    public String getHospCode() 
    {
        return hospCode;
    }
    public void setUCode(String uCode)
    {
        this.uCode = uCode;
    }

    public String getuCode() 
    {
        return uCode;
    }
    public void setUName(String uName)
    {
        this.uName = uName;
    }

    public String getuName() 
    {
        return uName;
    }
    public void setUProductName(String uProductName)
    {
        this.uProductName = uProductName;
    }

    public String getuProductName() 
    {
        return uProductName;
    }
    public void setUSp(String uSp)
    {
        this.uSp = uSp;
    }

    public String getuSp() 
    {
        return uSp;
    }
    public void setUSpec(String uSpec)
    {
        this.uSpec = uSpec;
    }

    public String getuSpec() 
    {
        return uSpec;
    }
    public void setUUnit(String uUnit)
    {
        this.uUnit = uUnit;
    }

    public String getuUnit() 
    {
        return uUnit;
    }
    public void setUJx(String uJx)
    {
        this.uJx = uJx;
    }

    public String getuJx() 
    {
        return uJx;
    }
    public void setUCj(String uCj)
    {
        this.uCj = uCj;
    }

    public String getuCj() 
    {
        return uCj;
    }
    public void setUDl(String uDl)
    {
        this.uDl = uDl;
    }

    public String getuDl() 
    {
        return uDl;
    }
    public void setUIsanti(String uIsanti)
    {
        this.uIsanti = uIsanti;
    }

    public String getuIsanti() 
    {
        return uIsanti;
    }
    public void setUAntitype(String uAntitype)
    {
        this.uAntitype = uAntitype;
    }

    public String getuAntitype() 
    {
        return uAntitype;
    }
    public void setUApprove(String uApprove)
    {
        this.uApprove = uApprove;
    }

    public String getuApprove() 
    {
        return uApprove;
    }
    public void setDrugCode(String drugCode) 
    {
        this.drugCode = drugCode;
    }

    public String getDrugCode() 
    {
        return drugCode;
    }
    public void setDrugName(String drugName) 
    {
        this.drugName = drugName;
    }

    public String getDrugName() 
    {
        return drugName;
    }
    public void setDrugSpec(String drugSpec) 
    {
        this.drugSpec = drugSpec;
    }

    public String getDrugSpec() 
    {
        return drugSpec;
    }
    public void setDrugApprove(String drugApprove) 
    {
        this.drugApprove = drugApprove;
    }

    public String getDrugApprove() 
    {
        return drugApprove;
    }
    public void setFlag(Integer flag) 
    {
        this.flag = flag;
    }

    public Integer getFlag() 
    {
        return flag;
    }
    public void setCj(String cj) 
    {
        this.cj = cj;
    }

    public String getCj() 
    {
        return cj;
    }
    public void setAudit1(Integer audit1) 
    {
        this.audit1 = audit1;
    }

    public Integer getAudit1() 
    {
        return audit1;
    }
    public void setDddValue(Integer dddValue) 
    {
        this.dddValue = dddValue;
    }

    public Integer getDddValue() 
    {
        return dddValue;
    }
    public void setDddUnit(String dddUnit) 
    {
        this.dddUnit = dddUnit;
    }

    public String getDddUnit() 
    {
        return dddUnit;
    }
    public void setAllotUser(String allotUser) 
    {
        this.allotUser = allotUser;
    }

    public String getAllotUser() 
    {
        return allotUser;
    }
    public void setMatchUser(String matchUser) 
    {
        this.matchUser = matchUser;
    }

    public String getMatchUser() 
    {
        return matchUser;
    }
    public void setAllotTime(Date allotTime) 
    {
        this.allotTime = allotTime;
    }

    public Date getAllotTime() 
    {
        return allotTime;
    }
    public void setMatchTime(Date matchTime) 
    {
        this.matchTime = matchTime;
    }

    public Date getMatchTime() 
    {
        return matchTime;
    }
    public void setNotHaveSda(Integer notHaveSda) 
    {
        this.notHaveSda = notHaveSda;
    }

    public Integer getNotHaveSda() 
    {
        return notHaveSda;
    }
    public void setMarkUser(String markUser) 
    {
        this.markUser = markUser;
    }

    public String getMarkUser() 
    {
        return markUser;
    }
    public void setState(Integer state) 
    {
        this.state = state;
    }

    public Integer getState() 
    {
        return state;
    }
    public void setCreateuser(Long createuser) 
    {
        this.createuser = createuser;
    }

    public Long getCreateuser() 
    {
        return createuser;
    }
    public void setUpdateuser(Long updateuser) 
    {
        this.updateuser = updateuser;
    }

    public Long getUpdateuser() 
    {
        return updateuser;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("hospCode", getHospCode())
            .append("uCode", getuCode())
            .append("uName", getuName())
            .append("uProductName", getuProductName())
            .append("uSp", getuSp())
            .append("uSpec", getuSpec())
            .append("uUnit", getuUnit())
            .append("uJx", getuJx())
            .append("uCj", getuCj())
            .append("uDl", getuDl())
            .append("uIsanti", getuIsanti())
            .append("uAntitype", getuAntitype())
            .append("uApprove", getuApprove())
            .append("drugCode", getDrugCode())
            .append("drugName", getDrugName())
            .append("drugSpec", getDrugSpec())
            .append("drugApprove", getDrugApprove())
            .append("flag", getFlag())
            .append("cj", getCj())
            .append("audit1", getAudit1())
            .append("dddValue", getDddValue())
            .append("dddUnit", getDddUnit())
            .append("allotUser", getAllotUser())
            .append("matchUser", getMatchUser())
            .append("allotTime", getAllotTime())
            .append("matchTime", getMatchTime())
            .append("notHaveSda", getNotHaveSda())
            .append("markUser", getMarkUser())
            .append("state", getState())
            .append("createuser", getCreateuser())
            .append("createtime", getCreatetime())
            .append("updateuser", getUpdateuser())
            .append("updatetime", getUpdatetime())
            .toString();
    }
}
