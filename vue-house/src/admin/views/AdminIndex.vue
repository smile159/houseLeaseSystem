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
    <!--echarts图表展示-->
    <div>
      <div ref="demo1" class="demo1"></div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AdminIndex.vue',
  mounted () {
    this.init()
    this.getStatistics()
  },
  data () {
    return {
      statistics: {}
    }
  },
  methods: {
    init () {
      console.log(this.$refs.demo1)
      // 基于准备好的dom，初始化echarts实例
      var myChart = this.echarts.init(this.$refs.demo1)
      // 绘制图表
      myChart.setOption({
        title: {
          text: 'ECharts 入门示例'
        },
        tooltip: {},
        xAxis: {
          data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
        },
        yAxis: {},
        series: [
          {
            name: '销量',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20]
          }
        ]
      })
    },
    async getStatistics () {
      const { data: r } = await this.$http.get('admin/getStatistics')
      console.log(r)
      if (r.status !== 1) return this.$message.error(r.msg)
      this.statistics = r.data
    }
  }
}
</script>

<style scoped>
.el-card /deep/ .el-card__body{
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
