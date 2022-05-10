<template>
  <div>
    <el-card>
      <el-button type="primary" icon="el-icon-house" @click="createHouse">添加房屋</el-button>
    </el-card>
    <el-card v-for="item in myHouseList" :key="item.hid">
      <!--数据展示-->
      <el-descriptions :column="4" border>
        <template slot="extra">
          <el-button type="primary" icon="el-icon-setting" @click="updateHouse(item.hid)">编辑</el-button>
          <el-button type="danger" icon="el-icon-delete" @click="deleteHouse(item.hid)">删除</el-button>
        </template>
        <el-descriptions-item>
          <template slot="label">
            房屋名称
          </template>
          {{ item.houseName }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            房屋类型
          </template>
          {{ item.type }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            所在城市
          </template>
          {{ item.city }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            房屋面积
          </template>
          {{ item.area }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            房屋楼层
          </template>
          {{ item.floor }}/{{ item.maxFloor }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            房屋朝向
          </template>
          {{ item.direction }}
        </el-descriptions-item>
        <el-descriptions-item content-style="width:200px">
          <template slot="label">
            详细地址
          </template>
          {{ item.address }}
        </el-descriptions-item>
      </el-descriptions>
    </el-card>
    <el-dialog
      title="提示"
      :visible.sync="addHouseDialogVisible"
      width="50%"
      @close="closeAddHouseDialog"
    >
      <el-form :model="addHouseForm" :rules="addHouseFormRules" ref="addHouseFormRef" label-width="100px">
        <el-form-item label="房屋名称" prop="houseName">
          <el-input v-model="addHouseForm.houseName"></el-input>
        </el-form-item>
        <el-form-item label="房屋类型" prop="type">
          <el-input v-model="addHouseForm.type"></el-input>
        </el-form-item>
        <el-form-item label="所在城市" prop="city">
          <el-input v-model="addHouseForm.city"></el-input>
        </el-form-item>
        <el-form-item label="详细地址" prop="address">
          <el-input v-model="addHouseForm.address"></el-input>
        </el-form-item>
        <el-form-item label="房屋面积" prop="area">
          <el-input v-model="addHouseForm.area"></el-input>
        </el-form-item>
        <el-form-item label="房屋楼层" prop="floor">
          <el-input v-model="addHouseForm.floor"></el-input>
        </el-form-item>
        <el-form-item label="最大楼层" prop="maxFloor">
          <el-input v-model="addHouseForm.maxFloor"></el-input>
        </el-form-item>
        <el-form-item label="房屋朝向" prop="direction">
          <el-input v-model="addHouseForm.direction"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="addHouseDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitAddHouseForm">确 定</el-button>
      </span>
    </el-dialog>
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
  name: 'MyHouse',
  mounted () {
    this.getAllHouse()
  },
  data () {
    return {
      // 获取的所有用户的房屋数据
      myHouseList: [],
      // 添加房屋的表单
      addHouseForm: {},
      // 控制添加房屋的对话框显示和隐藏
      addHouseDialogVisible: false,
      // 添加房屋表单的校验规则
      addHouseFormRules: {
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
      },
      // 添加房屋的表单
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
    getAllHouse () {
      this.$http.get('getAllHouse').then(
        res => {
          if (res.data.status === 1) {
            this.myHouseList = res.data.data
          }
        }
      ).catch(
        err => {
          this.$message.error(err.message)
        }
      )
    },
    // 打开添加房屋的对话框
    createHouse () {
      this.addHouseDialogVisible = true
    },
    closeAddHouseDialog () {
      // 重置表单
      this.$refs.addHouseFormRef.resetFields()
      // 关闭对话框
      this.addHouseDialogVisible = false
    },
    closeUpdateHouseDialog () {
      // 重置表单
      this.$refs.updateHouseFormRef.resetFields()
      // 关闭对话框
      this.updateHouseDialogVisible = false
    },
    submitAddHouseForm () {
      this.$refs.addHouseFormRef.validate(valid => {
        if (!valid) return this.$message.error('请输入正确的数据')
        this.$http.post('createHouse', this.addHouseForm).then(
          res => {
            if (res.data.status === 1) {
              this.$message.success(res.data.msg)
              this.addHouseDialogVisible = false
              // 刷新数据
              this.getAllHouse()
            }
          }
        ).catch(
          err => {
            this.$message.error(err.message)
          }
        )
      })
    },
    deleteHouse (hid) {
      this.$confirm('此操作将永久删除该房屋, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$http.get('deleteHouse', {
          params: {
            hid: hid
          }
        }).then(
          res => {
            if (res.data.status === 1) {
              this.$message.success(res.data.msg)
              // 刷新数据
              this.getAllHouse()
            }
          }
        ).catch(
          err => {
            this.$message.error(err.message)
          }
        )
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    submitUpdateHouseForm () {
      this.$refs.updateHouseFormRef.validate(valid => {
        if (!valid) return this.$message.error('请输入正确的数据')
        this.$http.post('updateHouse', this.updateHouseForm).then(
          res => {
            if (res.data.status === 1) {
              this.$message.success(res.data.msg)
              this.updateHouseDialogVisible = false
              // 刷新数据
              this.getAllHouse()
            }
          }
        ).catch(
          err => {
            this.$message.error(err.message)
          }
        )
      })
    },
    updateHouse (hid) {
      // 打开前获取数据
      this.$http.get('getHouse', { params: { hid: hid } }).then(
        res => {
          if (res.data.status === 1) {
            this.updateHouseForm = res.data.data
          }
        }
      ).catch(
        err => {
          this.$message.error(err.message)
        }
      )
      this.updateHouseDialogVisible = true
    }
  }
}
</script>

<style scoped>
.el-card {
  margin: 10px 20px;
}
</style>
