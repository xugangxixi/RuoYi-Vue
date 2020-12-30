<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="医院编号" prop="hospCode">
        <el-input
          v-model="queryParams.hospCode"
          placeholder="请输入医院编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="医院名字" prop="hospName">
        <el-input
          v-model="queryParams.hospName"
          placeholder="请输入医院名字"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!--<el-form-item label="服务器\u IP" prop="serverIp">
        <el-input
          v-model="queryParams.serverIp"
          placeholder="请输入服务器\u IP"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="服务器\u MAC" prop="serverMac">
        <el-input
          v-model="queryParams.serverMac"
          placeholder="请输入服务器\u MAC"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="服务器许可证

" prop="serverLic">
        <el-input
          v-model="queryParams.serverLic"
          placeholder="请输入服务器许可证"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="服务器超时" prop="serverOvertime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.serverOvertime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择服务器超时">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="创建者id" prop="createuser">
        <el-input
          v-model="queryParams.createuser"
          placeholder="请输入创建者id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间" prop="createtime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.createtime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="更新者id" prop="updateuser">
        <el-input
          v-model="queryParams.updateuser"
          placeholder="请输入更新者id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="更新时间" prop="updatetime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.updatetime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择更新时间">
        </el-date-picker>
      </el-form-item>-->
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['hospital:hospital:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['hospital:hospital:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['hospital:hospital:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['hospital:hospital:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="hospitalList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="医院编号" align="center" prop="hospCode" />
      <el-table-column label="医院名字" align="center" prop="hospName" />
      <!--<el-table-column label="服务器\u IP" align="center" prop="serverIp" />
      <el-table-column label="服务器\u MAC" align="center" prop="serverMac" />
      <el-table-column label="服务器许可证

" align="center" prop="serverLic" />
      <el-table-column label="服务器超时" align="center" prop="serverOvertime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.serverOvertime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="创建者id" align="center" prop="createuser" />-->
      <el-table-column label="创建时间" align="center" prop="createtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createtime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <!--<el-table-column label="更新者id" align="center" prop="updateuser" />
      <el-table-column label="更新时间" align="center" prop="updatetime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updatetime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['hospital:hospital:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['hospital:hospital:remove']"
          >删除</el-button>
        </template>
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-show"
            @click="handleShow(scope.row)"
            v-hasPermi="['hospital:hospital:show']"
          >查看</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-show"
            @click="handlePiPei(scope.row)"
            v-hasPermi="['hospital:hospital:pipei']"
          >匹配</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改医院信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="医院编号" prop="hospCode">
          <el-input v-model="form.hospCode" placeholder="请输入医院编号" />
        </el-form-item>
        <el-form-item label="医院名字" prop="hospName">
          <el-input v-model="form.hospName" placeholder="请输入医院名字" />
        </el-form-item>
        <el-form-item label="服务器\u IP" prop="serverIp">
          <el-input v-model="form.serverIp" placeholder="请输入服务器\u IP" />
        </el-form-item>
        <el-form-item label="服务器\u MAC" prop="serverMac">
          <el-input v-model="form.serverMac" placeholder="请输入服务器\u MAC" />
        </el-form-item>
        <el-form-item label="服务器许可证" prop="serverLic">
          <el-input v-model="form.serverLic" placeholder="请输入服务器许可证" />
        </el-form-item>
        <el-form-item label="服务器超时" prop="serverOvertime">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.serverOvertime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择服务器超时">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="创建者id" prop="createuser">
          <el-input v-model="form.createuser" placeholder="请输入创建者id" />
        </el-form-item>
        <el-form-item label="更新者id" prop="updateuser">
          <el-input v-model="form.updateuser" placeholder="请输入更新者id" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listHospital, getHospital, delHospital, addHospital, updateHospital, exportHospital } from "@/api/hospital/hospital";

export default {
  name: "Hospital",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 医院信息表格数据
      hospitalList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        hospCode: null,
        hospName: null,
        serverIp: null,
        serverMac: null,
        serverLic: null,
        serverOvertime: null,
        createuser: null,
        createtime: null,
        updateuser: null,
        updatetime: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询医院信息列表 */
    getList() {
      this.loading = true;
      listHospital(this.queryParams).then(response => {
        this.hospitalList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        hospCode: null,
        hospName: null,
        serverIp: null,
        serverMac: null,
        serverLic: null,
        serverOvertime: null,
        createuser: null,
        createtime: null,
        updateuser: null,
        updatetime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "新建医院";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getHospital(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改医院信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateHospital(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addHospital(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除医院信息编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delHospital(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有医院信息数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportHospital(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
