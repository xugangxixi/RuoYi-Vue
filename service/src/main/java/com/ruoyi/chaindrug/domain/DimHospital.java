package com.ruoyi.chaindrug.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 医院信息对象 dim_hospital
 * 
 * @author ruoyi
 * @date 2020-12-22
 */
public class DimHospital extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 医院编号 */
    @Excel(name = "医院编号")
    private String hospCode;

    /** 医院名字 */
    @Excel(name = "医院名字")
    private String hospName;

    /** 服务器u IP */
    @Excel(name = "服务器IP")
    private String serverIp;



    /** 服务器u MAC */
    @Excel(name = "服务器MAC")
    private String serverMac;

    /** 服务器许可证

 */
    @Excel(name = "服务器许可证 ")
    private String serverLic;

    /** 服务器超时 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "服务器超时", width = 30, dateFormat = "yyyy-MM-dd")
    private Date serverOvertime;

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
    public void setHospName(String hospName) 
    {
        this.hospName = hospName;
    }

    public String getHospName() 
    {
        return hospName;
    }
    public void setServerIp(String serverIp) 
    {
        this.serverIp = serverIp;
    }

    public String getServerIp() 
    {
        return serverIp;
    }
    public void setServerMac(String serverMac) 
    {
        this.serverMac = serverMac;
    }

    public String getServerMac() 
    {
        return serverMac;
    }
    public void setServerLic(String serverLic) 
    {
        this.serverLic = serverLic;
    }

    public String getServerLic() 
    {
        return serverLic;
    }
    public void setServerOvertime(Date serverOvertime) 
    {
        this.serverOvertime = serverOvertime;
    }

    public Date getServerOvertime() 
    {
        return serverOvertime;
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
            .append("hospName", getHospName())
            .append("serverIp", getServerIp())
            .append("serverMac", getServerMac())
            .append("serverLic", getServerLic())
            .append("serverOvertime", getServerOvertime())
            .append("createuser", getCreateuser())
            .append("createtime", getCreatetime())
            .append("updateuser", getUpdateuser())
            .append("updatetime", getUpdatetime())
            .toString();
    }
}
