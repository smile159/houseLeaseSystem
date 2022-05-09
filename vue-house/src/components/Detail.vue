<template>
  <div>
    <!--房屋信息-->
    <div class="houseData">
      <div class="price">
        <h4>￥{{houseDta.monthMoney}}/月</h4>
      </div>
      <div class="title">
        <h3>{{houseDta.rentTitle}}</h3>
      </div>
      <div class="location">
        <i class="el-icon-location-outline"></i>
        <span>{{houseDta.address}}</span>
      </div>
    </div>
    <!--房屋的数据/预订、留言-->
    <div class="house">
      <div class="left">
        <!--房屋的一些数据-->
        <el-collapse v-model="activeNames">
          <el-collapse-item title="房屋详细信息" name="1">
            <el-descriptions class="houseDescriptions" :column="4">
              <el-descriptions-item label="房屋状态">{{houseStatusText}}</el-descriptions-item>
              <el-descriptions-item label="房屋类型">{{houseDta.type}}</el-descriptions-item>
              <el-descriptions-item label="租金">¥ {{houseDta.monthMoney}}/月</el-descriptions-item>
              <el-descriptions-item label="房屋面积">{{houseDta.area}}平方米</el-descriptions-item>
              <el-descriptions-item label="是否有电梯">
                <el-tag type="success" size="small">有</el-tag>
              </el-descriptions-item>
              <el-descriptions-item label="朝向">{{ houseDta.direction }}</el-descriptions-item>
              <el-descriptions-item label="楼层">{{houseDta.floor}}/{{ houseDta.maxFloor }}</el-descriptions-item>
              <el-descriptions-item label="联系人">{{houseDta.contactName}}</el-descriptions-item>
              <el-descriptions-item label="联系电话">{{houseDta.contactPhone}}</el-descriptions-item>
              <el-descriptions-item label="发布时间">{{houseDta.createTime}}</el-descriptions-item>
              <el-descriptions-item label="最后更新时间">{{houseDta.updateTime}}</el-descriptions-item>
            </el-descriptions>
          </el-collapse-item>
        </el-collapse>
        <!--房屋的设备配置-->
        <el-collapse v-model="activeNames">
          <el-collapse-item title="房屋配置" name="2">
            <el-descriptions class="houseDescriptions" :column="6">
              <el-descriptions-item v-for="item in houseTags" :label="item.name" :key="item.htid">{{item.value}}</el-descriptions-item>
            </el-descriptions>
          </el-collapse-item>
        </el-collapse>
        <!--房屋填写的详细说明/备注-->
        <el-collapse v-model="activeNames">
          <el-collapse-item title="详细描述" name="3">
            <div class="houseDescriptions">{{houseDta.rentContent}}</div>
          </el-collapse-item>
        </el-collapse>
        <!--地图-->
        <el-collapse v-model="activeNames">
          <el-collapse-item title="地图" name="4" class="mapCollapse">
            <div id="container">
              <!--地图-->
              <el-amap
                lang="zh"
                vid="smile"
                :center="nowZb"
              ></el-amap>
            </div>
          </el-collapse-item>
        </el-collapse>
      </div>
      <!--右侧内容：预订、留言-->
      <div class="right">
        <el-card class="house-reserve">
          <div class="house-container">
            <span class="dateTimeText">入住日期</span>
            <el-date-picker
              value-format="yyyy-MM-dd"
              v-model="submitReserveForm.startTime"
              type="date"
              placeholder="选择日期"
              :readonly="startTimeReadyOnly"
            >
            </el-date-picker>
            <span class="dateTimeText">退租日期</span>
            <el-date-picker
              value-format="yyyy-MM-dd"
              v-model="submitReserveForm.endTime"
              type="date"
              placeholder="选择日期"
              :readonly="endTimeReadyOnly"
            >
            </el-date-picker>
            <el-button class="reserveBtn" :type="reserveBtn" :disabled="reserveBtnDisabled" @click="reserveOrder" v-text="reserveBtnText"></el-button>
          </div>
        </el-card>
        <el-card class="house-reserve">
          <div class="house-container">
            留言
            <el-input
              resize="none"
              maxlength="100"
              show-word-limit
              type="textarea"
              :rows="6"
              placeholder="请输入内容"
              v-model="leaveMessage">
            </el-input>
            <el-button class="reserveBtn" type="primary" @click="sendMessage">留言</el-button>
          </div>
        </el-card>
      </div>
    </div>
    <easy-ring
    :open="ringOptions.open"
    :ring="ringOptions.ring"
    :src="ringOptions.src"
    >
    </easy-ring>
  </div>
</template>

<script>
export default {
  name: 'Detail',
  mounted () {
    console.log(this.$route)
    // 获取当前日期
    const date = new Date()
    const nowDateTime = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate()
    this.submitReserveForm.startTime = nowDateTime
    // 根据rid获取房屋数据
    this.getHouseDetailData()
  },
  data () {
    return {
      reserveBtnText: '立即预订',
      reserveBtnDisabled: false,
      // 预订按钮样式
      reserveBtn: 'primary',
      startTimeReadyOnly: false,
      endTimeReadyOnly: false,
      // 音效
      ringOptions: {
        open: false,
        ring: false,
        src: 'media/easy-ring-default.wav'
      },
      // 默认选中的折叠项
      activeNames: ['1', '2', '3', '4'],
      // 留言
      leaveMessage: '',
      nowZb: [
        114.5215319,
        38.04831193
      ],
      // 房屋的所有数据
      houseDta: {},
      houseTags: [],
      // 预订提交表单
      submitReserveForm: {
        // 开始日期
        startTime: '',
        // 结束日期
        endTime: ''
      }
    }
  },
  computed: {
    rid () {
      return this.$route.query.rid
    },
    // 计算房屋的出租状态
    houseStatusText () {
      return this.houseDta.houseStatus > 0 ? this.houseDta.houseStatus === 1 ? '出租中' : '已下架' : '未出租'
    }
  },
  methods: {
    // 获取房屋的所有数据
    getHouseDetailData () {
      this.$http.get('getHouseDetail', {
        params: {
          rid: this.rid
        }
      }).then(
        res => {
          console.log(res.data.status)
          if (res.data.status === 1) {
            // this.$message.success(res.data.msg)
            this.houseDta = res.data.data
            this.getHouseAllTag(res.data.data.hid)
          }
        }
      ).catch(
        err => {
          this.$message.error(err.message)
        }
      )
    },
    // 获取所有的房屋配置
    getHouseAllTag (hid) {
      this.$http.get('getHouseAllTag', {
        params: {
          hid: hid
        }
      }).then(
        res => {
          if (res.data.status === 1) {
            // this.$message.success(res.data.msg)
            this.houseTags = res.data.data
          }
        }
      ).catch(
        err => {
          this.$message.error(err.message)
        }
      )
    },
    // 预订房屋
    reserveOrder () {
      this.$confirm('您确认要预订吗, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.ringOptions.src = this.$sound.reserve
        this.ringOptions.open = true
        // 数据校验
        if (this.submitReserveForm.startDateTime === '' || this.submitReserveForm.endDateTime === '') {
          return this.$message.warning('请选择入住日期和退租日期')
        }
        // 数据组合
        const data = {
          rid: this.rid,
          ...this.submitReserveForm
        }
        console.log('data = ', data)
        this.$http.post('reserveHouse', data).then(
          res => {
            if (res.data.status === 1) {
              // 开始播放提示音
              this.ringOptions.ring = true
              // 修改文字
              this.reserveBtnText = '预订成功'
              // 禁用按钮并修改样式
              this.reserveBtn = 'success'
              // 禁止点击
              this.reserveBtnDisabled = true
              // 禁用日期选择
              this.startTimeReadyOnly = this.endTimeReadyOnly = true
              // 成功提示
              this.$message.success(res.data.msg)
              // 2秒后关闭提示音
              setTimeout(() => {
                this.ringOptions.ring = false
              }, 1800)
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
          message: '您已取消'
        })
      })
    },
    // 用户留言
    sendMessage () {
      this.$confirm('您确定要留言吗, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.ringOptions.src = this.$sound.message
        this.ringOptions.open = true
        // 数据校验
        if (this.leaveMessage.length <= 0) return this.$message.warning('请输入留言内容')
        // 数据组合
        const data = {
          rid: this.rid,
          message: this.leaveMessage
        }
        console.log('留言提交数据：', data)
        this.$http.post('userMessage', data).then(
          res => {
            if (res.data.status === 1) {
              this.$message.success(res.data.msg)
              this.ringOptions.ring = true
              // 情况留言内容
              this.leaveMessage = ''
              // 2秒后关闭提示音
              setTimeout(() => {
                this.ringOptions.ring = false
              }, 1800)
            }
          }
        ).catch(
          err => {
            this.$message.error(err.message)
          }
        )
      })
    }

  }
}
</script>

<style scoped>
.mapCollapse .el-collapse-item__content {
  padding-bottom: 0;
}
#container {
  width: 100%;
  height: 500px;
}

.reserveBtn, .dateTimeText {
  margin-top: 10px;
}

.dateTimeText {
  display: block;
  margin-bottom: 10px;
}

.right {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.house-container {
  display: flex;
  flex-direction: column;
}

/*房屋预订*/
.house-reserve {
  margin-top: 10px;
  width: 350px;
  height: 270px;
  margin-bottom: 30px;
}

/*房屋描述列表*/
.houseDescriptions {
  padding-left: 15px;
}

.el-collapse-item /deep/ .el-collapse-item__header {
  font-size: 20px;
  padding-left: 15px;
  font-weight: bold;
}

.houseData {
  display: flex;
  height: 260px;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  background-color: #ffffff;
}

.houseData .price {
  font-size: 30px;
  height: 38px;
  color: gold;
  /*background-color: red;*/
}

.houseData .title {
  font-size: 30px;
  height: 45px;
}

.houseData .location {
  margin-top: 20px;
}

.house {
  width: 100%;
  height: 600px;
  display: flex;
}

.house .left {
  width: 1172px;
  /*background-color: yellow;*/
  margin-left: 10%;
}

.house .right {
  flex: 1;
  /*background-color: skyblue;*/
  margin-right: 10%;
}

.el-collapse {
  margin: 10px 30px;
}
</style>
