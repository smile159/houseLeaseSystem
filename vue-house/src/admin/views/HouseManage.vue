<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>房屋管理</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card>
      <el-table
        v-loading="isLoading"
        :data="houseList"
        border
        style="width: 100%"
      >
        <el-table-column
          align="center"
          type="index"
          label="#">
        </el-table-column>
        <el-table-column
          align="center"
          prop="hid"
          label="id"
          width="50px"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="houseName"
          label="备注"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="type"
          label="房屋类型"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="city"
          label="城市"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="address"
          label="房屋具体地址"
          width="200px"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="area"
          label="面积"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="floor"
          label="所在楼层"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="maxFloor"
          label="最大楼层"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="direction"
          label="朝南"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="houseStatus"
          label="出租状态"
        >
          <template slot-scope="scope">
            <el-tag type="info" v-if="scope.row.houseStatus === 0">未出租</el-tag>
            <el-tag type="success" v-else-if="scope.row.houseStatus === 1">已出租</el-tag>
            <el-tag type="warning" v-else-if="scope.row.houseStatus === 2">隐藏</el-tag>
            <el-tag v-else>未发布</el-tag>
          </template>
        </el-table-column>
        <!--隐藏状态-->
        <el-table-column
          align="center"
          prop="allowHidden"
          label="隐藏状态"
        >
          <template slot-scope="scope">
            <el-tag type="success" v-if="scope.row.allowHidden === 0">未隐藏</el-tag>
            <el-tag type="info" v-else-if="scope.row.allowHidden === 1">隐藏</el-tag>
            <el-tag v-else>暂无</el-tag>
          </template>
        </el-table-column>
        <el-table-column
          align="center"
          prop="allowDelete"
          label="是否允许删除"
        >
          <template slot-scope="scope">
            <el-tag type="danger" v-if="scope.row.allowDelete === 0">禁止</el-tag>
            <el-tag type="success" v-else-if="scope.row.allowDelete === 1">允许</el-tag>
            <el-tag v-else>暂无</el-tag>
          </template>
        </el-table-column>

        <el-table-column
          align="center"
          label="操作"
          width="380px"
        >
          <template slot-scope="scope">
            <el-button size="small" type="primary" @click="openEditHouseDialog(scope.row)">编辑</el-button>
            <el-button size="small" type="warning" v-if="scope.row.allowHidden === 0" @click="hiddenHouse(scope.row.hid)">隐藏</el-button>
            <el-button size="small" type="success" v-else-if="scope.row.allowHidden === 1" @click="showHouse(scope.row.hid)">显示</el-button>
            <el-button size="small" type="success" v-if="scope.row.allowDelete === 0" @click="allowDelete(scope.row.hid)">允许删除</el-button>
            <el-button size="small" type="danger" v-else-if="scope.row.allowDelete === 1" @click="disableDelete(scope.row.hid)">禁止删除</el-button>
            <el-button size="small" type="danger" @click="deleteUserHouse(scope.row.hid)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div class="bottom-pagination">
        <!--分页-->
        <el-pagination
          background
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="queryHouseParams.pageNum"
          :page-sizes="[1, 5, 10, 20]"
          :page-size="queryHouseParams.pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
        </el-pagination>
      </div>
    </el-card>
    <!--编辑对话框-->
    <el-dialog
      title="提示"
      :visible.sync="updateHouseDialogVisible"
      width="50%"
      @close="closeUpdateHouseDialog"
    >
      <el-form :model="updateHouseForm" :rules="updateHouseFormRules" ref="updateHouseFormRef" label-width="100px">
        <el-form-item label="房屋名称" prop="houseName">
          <el-input v-model="updateHouseForm.houseName"></el-input>
        </el-form-item>
        <el-form-item label="房屋类型" prop="type">
          <el-input v-model="updateHouseForm.type"></el-input>
        </el-form-item>
        <el-form-item label="所在城市" prop="city">
          <el-input v-model="updateHouseForm.city"></el-input>
        </el-form-item>
        <el-form-item label="详细地址" prop="address">
          <el-input v-model="updateHouseForm.address"></el-input>
        </el-form-item>
        <el-form-item label="房屋面积" prop="area">
          <el-input v-model="updateHouseForm.area"></el-input>
        </el-form-item>
        <el-form-item label="房屋楼层" prop="floor">
          <el-input v-model="updateHouseForm.floor"></el-input>
        </el-form-item>
        <el-form-item label="最大楼层" prop="maxFloor">
          <el-input v-model="updateHouseForm.maxFloor"></el-input>
        </el-form-item>
        <el-form-item label="房屋朝向" prop="direction">
          <el-input v-model="updateHouseForm.direction"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="updateHouseDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitUpdateHouseForm">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'HouseManage',
  mounted () {
    this.adminUserInfo = JSON.parse(this.$route.query.adminUser)
    this.getAllHouseByPaging()
  },
  data () {
    return {
      houseList: [],
      adminUserInfo: {},
      queryHouseParams: {
        pageSize: 10,
        pageNum: 1
      },
      // 表格加载
      isLoading: false,
      total: 0,
      // 更新房屋的表单
      updateHouseForm: {},
      // 控制添加房屋的对话框显示和隐藏
      updateHouseDialogVisible: false,
      // 添加房屋表单的校验规则
      updateHouseFormRules: {
        houseName: [
          { required: true, message: '请输入房屋名称', trigger: 'blur' },
          { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
        ],
        type: [
          { required: true, message: '请输入房屋类型', trigger: 'blur' },
          { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
        ],
        city: [
          { required: true, message: '请输入所在城市', trigger: 'blur' },
          { min: 1, max: 6, message: '长度在 1 到 6 个字符', trigger: 'blur' }
        ],
        address: [
          { required: true, message: '请输入详细地址', trigger: 'blur' },
          { min: 1, max: 30, message: '长度在 1 到 30 个字符', trigger: 'blur' }
        ],
        area: [
          { required: true, message: '请输入房屋面积', trigger: 'blur' },
          {
            type: 'number',
            min: 1,
            max: 999,
            message: '数值在1-999之间',
            trigger: 'blur',
            transform: (value) => Number(value)
          }
        ],
        floor: [
          { required: true, message: '请输入房屋楼层', trigger: 'blur' },
          {
            type: 'number',
            min: 1,
            max: 100,
            message: '数值在1-100之间',
            trigger: 'blur',
            transform: (value) => Number(value)
          }
        ],
        maxFloor: [
          { required: true, message: '请输入最大楼层', trigger: 'blur' },
          {
            type: 'number',
            min: 1,
            max: 100,
            message: '数值在1-100之间',
            trigger: 'blur',
            transform: (value) => Number(value)
          }
        ],
        direction: [
          { required: true, message: '请输入房屋朝向', trigger: 'blur' },
          { min: 1, max: 11, message: '长度在 1 到 11 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    submitUpdateHouseForm () {
      this.$refs.updateHouseFormRef.validate(valid => {
        if (!valid) return this.$message.error('请输入正确的数据')
        this.$http.post('updateHouse', this.updateHouseForm).then(
          res => {
            if (res.data.status === 1) {
              this.$message.success(res.data.msg)
              this.updateHouseDialogVisible = false
              // 刷新数据
              this.getAllHouseByPaging()
            }
          }
        ).catch(
          err => {
            this.$message.error(err.message)
          }
        )
      })
    },
    closeUpdateHouseDialog () {
      // 重置表单
      this.$refs.updateHouseFormRef.resetFields()
      // 关闭对话框
      this.updateHouseDialogVisible = false
    },
    openEditHouseDialog (row) {
      this.updateHouseForm = row
      this.updateHouseDialogVisible = true
    },
    async getAllHouseByPaging () {
      this.isLoading = true
      const { data: r } = await this.$http.get('admin/getHousePaging', {
        params: {
          ...this.queryHouseParams
        }
      })
      if (r.status !== 1) return this.$message.error(r.msg)
      // 保存数据
      this.houseList = r.data.result
      // 总条数
      this.total = r.data.total
      this.isLoading = false
    },
    async hiddenHouse (hid) {
      const { data: r } = await this.$http.get('admin/hiddenHouse', {
        params: {
          hid: hid
        }
      })
      if (r.status !== 1) return this.$message.error(r.msg)
      this.$message.success(r.msg)
      this.getAllHouseByPaging()
    },
    async showHouse (hid) {
      const { data: r } = await this.$http.get('admin/showHouse', {
        params: {
          hid: hid
        }
      })
      if (r.status !== 1) return this.$message.error(r.msg)
      this.$message.success(r.msg)
      this.getAllHouseByPaging()
    },
    handleSizeChange (value) {
      this.queryHouseParams.pageSize = value
      this.getAllHouseByPaging()
    },
    handleCurrentChange (value) {
      this.queryHouseParams.pageNum = value
      this.getAllHouseByPaging()
    },
    // 禁止删除
    async disableDelete (hid) {
      const { data: r } = await this.$http.get('admin/disableDelete', {
        params: {
          hid: hid
        }
      })
      if (r.status !== 1) return this.$message.error(r.msg)
      this.$message.success(r.msg)
      this.getAllHouseByPaging()
    },
    async allowDelete (hid) {
      const { data: r } = await this.$http.get('admin/allowDelete', {
        params: {
          hid: hid
        }
      })
      if (r.status !== 1) return this.$message.error(r.msg)
      this.$message.success(r.msg)
      this.getAllHouseByPaging()
    },
    deleteUserHouse (hid) {
      this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(async () => {
        const { data: r } = await this.$http.get('admin/deleteUserHouse', {
          params: {
            hid: hid
          }
        })
        if (r.status !== 1) return this.$message.error(r.msg)
        this.$message.success(r.msg)
        this.getAllHouseByPaging()
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '出错了'
        })
      })
    }
  }
}
</script>

<style scoped>
/*底部分页*/
.bottom-pagination {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}
.el-breadcrumb {
  margin-bottom: 20px;
}
</style>
