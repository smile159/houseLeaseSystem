<template>
  <div>
    <!--卡片数据展示-->
    <div class="card-data">
      <!--用户数量-->
      <el-card>
        <h3>用户数量为：{{statistics.userCount}}</h3>
      </el-card>
      <el-card>
        <h3>发布的租赁数量：{{statistics.houseRentCount}}</h3>
      </el-card>
      <el-card>
        <h3>房屋数量：{{statistics.houseCount}}</h3>
      </el-card>
    </div>
    <div class="main-content">
      <!--消息通知-->
      <div class="main-left">
        <el-card>
          <h2 style="color: red">系统实时推送</h2>
          <div>
            <span>[2022-5-16 13:21:10]今日24:00执行网站维护</span>
          </div>
        </el-card>
      </div>
      <div class="main-right">
        <el-calendar v-model="value">
        </el-calendar>
      </div>
    </div>
    <!--echarts图表展示-->
    <!--<div>-->
    <!--  <div ref="demo1" class="demo1"></div>-->
    <!--</div>-->
  </div>
</template>

<script>
export default {
  name: 'AdminIndex.vue',
  mounted () {
    this.getStatistics()
  },
  data () {
    return {
      statistics: {},
      value: new Date()
    }
  },
  methods: {
    async getStatistics () {
      console.log('获取数据')
      const { data: r } = await this.$http.get('admin/getStatistics')
      if (r.status !== 1) return this.$message.error(r.msg)
      this.statistics = r.data
    }
  }
}
</script>

<style scoped>
.main-left .el-card {
  width: 94%;
  height: 100%;
}
.main-content {
  display: flex;
  justify-content: space-between;
}
.main-content .main-left {
  flex: 1;
}
.main-content .main-right {
  flex: 1;
}
.el-card /deep/ .el-card__body{
  width: 100%;
  height: 100%;
}
.el-card {
  display: flex;
  align-items: center;
  width: 300px;
  height: 150px;
  margin: 0 20px 20px 20px;
}
.card-data {
  display: flex;
  justify-content: space-between;
}
.demo1 {
  width: 500px;
  height: 500px;
}
</style>
