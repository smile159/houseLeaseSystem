<template>
  <div>
    <el-tabs
      @tab-click="switchTab"
      type="border-card">
      <el-tab-pane label="出租中">
        <el-empty :image-size="200" v-if="myHouseRentList.length <=0"></el-empty>
        <template v-else>
          <!--发布租赁信息-->
          <div class="myHouseOptions">
            <el-button>发布房屋租赁</el-button>
          </div>
          <div class="flex-div">
            <Card v-for="item in myHouseRentList" :key="item.rid"
                  :d="item"
                  anime
                  :favorite-and-tag="1"
            >
              <template slot-scope="data">
                <!--{{aaa.row.rid}}-->
                <el-button type="primary" round @click="editHouseDialog(data.row.rid)">编辑</el-button>
                <template>
                  <el-popconfirm
                    confirm-button-text='好的'
                    cancel-button-text='不用了'
                    icon="el-icon-info"
                    icon-color="red"
                    title="您确定要下架吗？"
                    @confirm="hiddenHouseRent(data.row.rid)"
                  >
                    <!--下架或上架-->
                    <el-button type="warning" slot="reference" round>下架</el-button>
                  </el-popconfirm>
                </template>
                <el-button :disabled="data.row.allowDelete === 0" type="danger" round @click="deleteHouseRent(data.row.rid)">删除</el-button>
              </template>
            </Card>
          </div>
        </template>
      </el-tab-pane>
      <el-tab-pane label="已出租">
        <el-empty :image-size="200" v-if="myHouseRentList.length <=0"></el-empty>
        <div class="flex-div" v-else>
          <Card v-for="item in myHouseRentList" :key="item.rid"
                :d="item"
                anime
                :favorite-and-tag="1"
          >
            <template slot-scope="data">
              <!--{{aaa.row.rid}}-->
              <el-button type="primary" round @click="editHouseDialog(data.row.rid)">编辑</el-button>
              <!--下架或上架-->
              <el-button type="success" round @click="showHouseRent(data.row.rid)">上架</el-button>
              <el-button :disabled="data.row.allowDelete === 0" type="danger" round @click="deleteHouseRent(data.row.rid)">删除</el-button>
            </template>
          </Card>
        </div>
      </el-tab-pane>
      <el-tab-pane label="已租赁">
        <el-empty :image-size="200" v-if="myHouseRentList.length <=0"></el-empty>
        <div class="flex-div" v-else>
          <Card v-for="item in myHouseRentList" :key="item.rid"
                :d="item"
                anime
                :favorite-and-tag="1"
          >
            <template>
              <el-button type="danger" round>解约</el-button>
            </template>
          </Card>
        </div>
      </el-tab-pane>
    </el-tabs>
    <el-dialog
      title="编辑出租信息"
      :visible.sync="editHouseDialogVisble"
      width="50%"
      @close="clsoeEditHosueForm"
    >
      <el-form
        :model="editHouseForm"
        :rules="editHouseFormRules"
        ref="editHouseFormRef"
        label-width="100px"
      >
        <el-form-item label="出租标题" prop="rentTitle">
          <el-input v-model="editHouseForm.rentTitle"></el-input>
        </el-form-item>
        <el-form-item label="出租内容" prop="rentContent">
          <!--<el-input v-model="editHouseForm.rentContent"></el-input>-->
          <el-input
            type="textarea"
            placeholder="请输入出租内容"
            v-model="editHouseForm.rentContent"
            maxlength="100"
            show-word-limit
          >
          </el-input>
        </el-form-item>
        <el-form-item label="出租月数" prop="month">
          <el-input v-model="editHouseForm.month"></el-input>
        </el-form-item>
        <el-form-item label="月租金额" prop="monthMoney">
          <el-input v-model="editHouseForm.monthMoney"></el-input>
        </el-form-item>
        <el-form-item label="联系人" prop="contactName">
          <el-input v-model="editHouseForm.contactName"></el-input>
        </el-form-item>
        <el-form-item label="联系电话" prop="contactPhone">
          <el-input v-model="editHouseForm.contactPhone"></el-input>
        </el-form-item>
        <el-form-item label="发布时间">
          <el-input v-model="editHouseForm.createTime" disabled></el-input>
        </el-form-item>
        <el-form-item label="租客姓名" v-if="nowPage !== 0">
          <el-input v-model="editHouseForm.customName" disabled></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="editHouseDialogVisble = false">取 消</el-button>
        <el-button type="primary" @click="submitHouseRentDialogForm">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<!--
cid: 2
contactName: "小何"
contactPhone: "18228867837"
createTime: "2022-05-04T02:00:17.000+00:00"
customName: "李四"
hid: 1
houseStatus: 1
month: 2
monthMoney: 6666
rentContent: "急租，可随时看房，电话联系"
rentTitle: "合租-世界花园-4居室-C卧"
rid: 1
updateTime: "2022-05-04T02:00:18.000+00:00"
-->
<script>
import Card from '@/components/s-card'

export default {
  name: 'MyHouseRent',
  components: { Card },
  data () {
    return {
      cardData: {
        rentTitle: '合租-测试用的',
        address: '四川省成都市金牛区',
        price: 9999,
        houseTags: [
          { name: '卫生间', value: '5', htid: 4 },
          { name: '卧室', value: '6', htid: 5 }
        ],
        fid: 0
      },
      // 租赁数据
      myHouseRentList: [],
      // 查询的类型，出租中1，已出租0，已签约2
      type: 1,
      // 编辑对话框控制
      editHouseDialogVisble: false,
      // 出租详细数据
      editHouseForm: {},
      // 数据校验规则
      editHouseFormRules: {
        rentTitle: [
          { required: true, message: '请输入出租标题', trigger: 'blur' },
          { min: 1, max: 50, message: '长度在 1 到 50 个字符', trigger: 'blur' }
        ],
        rentContent: [
          { required: true, message: '请输入出租内容', trigger: 'blur' },
          { min: 1, max: 100, message: '长度在 1 到 100 个字符', trigger: 'blur' }
        ],
        month: [
          { required: true, message: '请输入出租月数', trigger: 'blur' },
          {
            type: 'number',
            min: 1,
            max: 99,
            message: '月份必须在1~99之间',
            trigger: 'blur',
            transform: (value) => Number(value)
          }
        ],
        monthMoney: [
          { required: true, message: '请输入月租金额', trigger: 'blur' },
          {
            type: 'number',
            min: 1,
            max: 999999,
            message: '月租金额在1~999999之间',
            trigger: 'blur',
            transform: (value) => Number(value)
          }
        ],
        contactName: [
          { required: true, message: '请输入联系人', trigger: 'blur' },
          { min: 2, max: 10, message: '长度在 2 到 10 个字符', trigger: 'blur' }
        ],
        contactPhone: [
          { required: true, message: '请输入联系人电话', trigger: 'blur' },
          { min: 5, max: 11, message: '长度在 5 到 11 个字符', trigger: 'blur' }
        ]
      },
      // 当前的tab页
      nowPage: 0
    }
  },
  mounted () {
    this.getMyHouseRent()
  },
  methods: {
    // 删除发布的信息
    deleteHouseRent (rid) {
      this.$confirm('此操作将删除该出租信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$http.get('deleteHouseRent', { params: { rid: rid } }).then(
          res => {
            if (res.data.status === 1) {
              this.$message.success(res.data.msg)
              this.getMyHouseRent()
            }
          }
        ).catch(
          err => {
            console.log('出错了', err.message)
          }
        )
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    // 获取我发布的租赁信息
    getMyHouseRent () {
      this.$http.get('getMyHouseRent', {
        params: {
          type: this.type
        }
      }).then(
        res => {
          console.log('我发布的租赁信息为：', res.data.data)
          this.myHouseRentList = res.data.data
        }
      ).catch(
        err => {
          console.log('出错了', err.message)
        }
      )
    },
    // 切换tab的回调方法
    switchTab (target) {
      this.nowPage = Number(target.paneName)
      console.log('nowPage = ', this.nowPage)
      console.log(target)
      if (target.paneName === '0') {
        this.type = 1
      } else if (target.paneName === '1') {
        this.type = 0
      } else {
        this.type = 2
      }
      this.getMyHouseRent()
    },
    // 编辑按钮触发方法，获取id，取得详细数据后展示对话框
    editHouseDialog (rid) {
      // 获取详细数据
      this.getHouseRentDetailData(rid)
      this.editHouseDialogVisble = true
    },
    // 获取房屋租赁的详细数据
    getHouseRentDetailData (rid) {
      this.$http.get('getMyHouseRentDetail', {
        params: {
          rid: rid
        }
      }).then(
        res => {
          this.editHouseForm = res.data.data
        }
      ).catch(
        err => {
          console.log('出错了...getHouseRentDetailData', err.message)
        }
      )
    },
    // 编辑表单的提交
    submitHouseRentDialogForm () {
      // 校验是否通过?
      this.$refs.editHouseFormRef.validate(valid => {
        if (!valid) return this.$message.error('数据校验失败')
        // 提交数据到服务器
        this.$http.post('editMyHouseRent', this.editHouseForm).then(
          res => {
            if (res.data.status === 1) {
              this.$message.success(res.data.msg)
              // 获取最新的数据
              this.getMyHouseRent()
            }
          }
        ).catch(
          err => {
            this.$message.error(err.message)
          }
        )
        this.editHouseDialogVisble = false
      })
    },
    // 关闭编辑对话框
    clsoeEditHosueForm () {
      console.log('关闭对话框')
      // 关闭前重置表单
      this.$refs.editHouseFormRef.resetFields()
      // 关闭对话框
      this.editHouseDialogVisble = false
    },
    // 下架出租信息
    hiddenHouseRent (rid) {
      console.log('下架,rid=', rid)
      this.$http.get('hiddenMyHouseRent', {
        params: {
          rid: rid
        }
      }).then(
        res => {
          if (res.data.status === 1) {
            this.$message.success(res.data.msg)
            // 刷新数据
            this.getMyHouseRent()
          }
        }
      ).catch(
        err => {
          this.$message.error(err.message)
        }
      )
    },
    showHouseRent (rid) {
      console.log('上架,rid=', rid)
      this.$http.get('showMyHouseRent', {
        params: {
          rid: rid
        }
      }).then(
        res => {
          if (res.data.status === 1) {
            this.$message.success(res.data.msg)
            // 刷新数据
            this.getMyHouseRent()
          }
        }
      ).catch(
        err => {
          this.$message.error(err.message)
        }
      )
    }
  }
}
</script>

<style scoped>
.el-tab-pane {
  height: 85vh;
}

.flex-div {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 1920px;
  flex-flow: wrap;
}

/*发布租赁按钮*/
.myHouseOptions {
  margin-left: 9%;
  margin-top: 20px;
}
</style>
