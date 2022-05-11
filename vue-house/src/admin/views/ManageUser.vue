<template>
  <div>
    <!--面包屑-->
    <el-card>
      <!--操作-->
      <div class="main-container">
        <el-table
          v-loading="loading"
          :data="userList"
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
            prop="uid"
            label="uid"
            width="50px"
          >
          </el-table-column>
          <el-table-column
            align="center"
            prop="userName"
            label="用户名"
          >
          </el-table-column>
          <el-table-column
            align="center"
            prop="password"
            label="密码"
          >
          </el-table-column>
          <el-table-column
            align="center"
            prop="status"
            label="账号状态">
            <template slot-scope="scope">
              <el-tag type="success" v-if="scope.row.status === 1">正常</el-tag>
              <el-tag type="warning" v-else-if="scope.row.status === 2">异常</el-tag>
              <el-tag type="info" v-else>封禁</el-tag>
            </template>
          </el-table-column>
          <!--操作-->
          <el-table-column
            align="center"
            label="操作"
          >
            <template slot-scope="scope">
              <el-button type="primary" @click="editUser(scope.row)">编辑</el-button>
              <el-button type="success" @click="relieveUser(scope.row.uid)" v-if="scope.row.status === 0">解禁</el-button>
              <el-button type="warning" @click="banUser(scope.row)" v-else>封禁</el-button>
              <el-button type="danger" @click="deleteUser(scope.row.uid)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <div class="bottom-pagination">
        <!--分页-->
        <el-pagination
          background
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="queryUserParams.pageNum"
          :page-sizes="[1, 5, 10, 20]"
          :page-size="queryUserParams.pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
        </el-pagination>
      </div>
    </el-card>
    <!--用户封禁-->
    <el-dialog
      title="封禁"
      :visible.sync="banUserDialogVisible"
      width="30%"
      @close="closeBanUserDialog"
    >
      <el-form :model="banUserForm" :rules="banUserRules" ref="banUserFormRef" label-width="100px">
        <el-form-item label="封禁用户名">
          <el-input v-model="userinfo.userName" disabled class="input-userName"></el-input>
        </el-form-item>
        <el-form-item label="封禁措施">
          <el-select v-model="banUserForm.measure" placeholder="请选择封禁措施">
            <el-option label="封号" :value="4000"></el-option>
            <el-option label="禁言" :value="4001"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="封禁理由">
          <el-input
            type="textarea"
            placeholder="请输入封禁理由"
            v-model="banUserForm.reason"
            maxlength="100"
            show-word-limit
            resize="none"
            :rows="3"
          >
          </el-input>
        </el-form-item>
        <el-form-item label="封禁开始时间">
          <el-date-picker
            value-format="yyyy-MM-dd HH:mm:ss"
            v-model="banUserForm.startTime"
            type="datetime"
            placeholder="选择日期时间"
            align="center"
            :picker-options="pickerOptions">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="封禁结束时间">
          <el-date-picker
            value-format="yyyy-MM-dd HH:mm:ss"
            v-model="banUserForm.endTime"
            type="datetime"
            placeholder="选择日期时间"
            align="center"
            :picker-options="pickerOptions">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="banUserDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitBanUserForm">确 定</el-button>
      </span>
    </el-dialog>
    <!--用户编辑-->
    <el-dialog
      title="提示"
      :visible.sync="editUserDialogVisible"
      width="30%"
      @close="closeEditUserDialog"
    >
      <el-form :model="editUserForm" :rules="editUserRules" ref="editUserRef" label-width="100px">
        <el-form-item label="用户名称" prop="userName">
          <el-input v-model="editUserForm.userName"></el-input>
        </el-form-item>
        <el-form-item label="用户密码" prop="password">
          <el-input v-model="editUserForm.password"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
    <el-button @click="editUserDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="submitEditUserForm">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'ManageUser',
  data () {
    return {
      // 用户查询分页参数
      queryUserParams: {
        pageSize: 10,
        pageNum: 1
      },
      // 用户数据
      userList: [],
      // 所有用户数量
      total: 0,
      // 表格加载
      loading: false,
      // 封禁用户的对话框
      banUserDialogVisible: false,
      // 提交的用户数据
      userinfo: {},
      banUserForm: {
        operationUid: 0,
        measure: '',
        reason: '',
        startTime: '',
        endTime: ''
      },
      // 表单校验
      banUserRules: {},
      pickerOptions: {
        shortcuts: [{
          text: '今天',
          onClick (picker) {
            picker.$emit('pick', new Date())
          }
        }]
      },
      // 编辑用户对话框
      editUserDialogVisible: false,
      // 用户数据
      editUserForm: {},
      // 编辑用户表单校验规则
      editUserRules: {
        userName: [
          { required: true, message: '请输入用户名称', trigger: 'blur' },
          { min: 1, max: 12, message: '长度在 1 到 12 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入用户密码', trigger: 'blur' },
          { min: 1, max: 18, message: '长度在 1 到 18 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  mounted () {
    this.getAllUser()
  },
  methods: {
    async getAllUser () {
      // 开始加载loading
      this.loading = true
      const { data: r } = await this.$http.get('admin/getUser', { params: this.queryUserParams })
      if (r.status !== 1) return this.$message.error(r.msg)
      // 请求成功
      this.userList = r.data.result
      this.total = r.data.total
      this.loading = false
    },
    handleSizeChange (value) {
      this.queryUserParams.pageSize = value
      this.getAllUser()
    },
    handleCurrentChange (value) {
      this.queryUserParams.pageNum = value
      this.getAllUser()
    },
    // 封禁用户
    banUser (userData) {
      this.userinfo = userData
      this.banUserForm.banId = userData.uid
      this.banUserDialogVisible = true
    },
    async submitBanUserForm () {
      // 填充操作人id
      const operationUser = JSON.parse(localStorage.getItem('userInfo'))
      this.banUserForm.operationUid = operationUser.uid
      const { data: r } = await this.$http.post('admin/banUser', this.banUserForm)
      if (r.status !== 1) return this.$message.error(r.msg)
      this.$message.success(r.msg)
      // 重新加载数据
      this.getAllUser()
      this.banUserDialogVisible = false
    },
    closeBanUserDialog () {
      console.log('表单重置')
      // 手动表单重置
      this.banUserForm = {
        operationUid: 0,
        measure: '',
        reason: '',
        startTime: '',
        endTime: ''
      }
      this.banUserDialogVisible = false
    },
    tableRowClassName ({ row, rowIndex }) {
      console.log('row = ', row, 'rowIndex =', rowIndex)
      if (row.status === 0) {
        console.log('封禁')
        return 'danger-row'
      } else if (row.status === 2) {
        console.log('警告')
        return 'warning-row'
      } else {
        console.log('正常')
        return ''
      }
    },
    deleteUser (uid) {
      console.log('删除的用户id为：', uid)
      this.$confirm('您真的要删除该用户吗？', '确认信息', {
        distinguishCancelAndClose: true,
        confirmButtonText: '确定',
        cancelButtonText: '取消'
      })
        .then(async () => {
          const { data: r } = await this.$http.get('admin/deleteUser', { params: { uid: uid } })
          if (r.status !== 1) return this.$message.error(r.msg)
          // 删除成功
          this.$message.success(r.msg)
          // 刷新数据
          this.getAllUser()
        })
    },
    editUser (data) {
      console.log('用户数据为：', data)
      const { identity, status, ...otherData } = data
      this.editUserForm = otherData
      this.editUserDialogVisible = true
    },
    // 编辑用户表单提交
    submitEditUserForm () {
      // 校验规则
      this.$refs.editUserRef.validate(async valid => {
        if (!valid) return this.$message.warning('数据格式错误，请重新填写')
        const { data: r } = await this.$http.post('admin/editUser', this.editUserForm)
        if (r.status !== 1) return this.$message.error(r.msg)
        // 操作成功
        this.$message.success(r.msg)
        this.editUserDialogVisible = false
        // 刷新数据
        this.getAllUser()
      })
    },
    closeEditUserDialog () {
      // 重置表单
      this.$refs.editUserRef.resetFields()
    },
    relieveUser (uid) {
      this.$confirm('您真的要解除该用户的限制吗？', '确认信息', {
        distinguishCancelAndClose: true,
        confirmButtonText: '确定',
        cancelButtonText: '取消'
      })
        .then(async () => {
          const { data: r } = await this.$http.get('admin/relieveUser', { params: { uid: uid } })
          if (r.status !== 1) return this.$message.error(r.msg)
          // 解除成功
          this.$message.success(r.msg)
          // 刷新数据
          this.getAllUser()
        })
    }
  }
}
</script>

<style scoped>
.input-userName {
  width: 100px;
}
/*底部分页*/
.bottom-pagination {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}
</style>
