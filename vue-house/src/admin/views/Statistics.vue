<template>
  <div>
    <!--面包屑-->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>数据统计</el-breadcrumb-item>
    </el-breadcrumb>
    <div class="main-flex">
      <!--房屋出租排行榜-->
      <el-card class="main-left">
        <h2>房屋出租浏览统计</h2>
        <ul>
          <li v-for="(item,index) in statisticsList.houseRentGlance" :key="index">{{index+1}}.{{ item.houseName }}:<span>{{item.glanceCount}}</span></li>
        </ul>
      </el-card>
      <el-card class="main-right">
        <h2>用户访问数量统计</h2>
        <ul>
          <li v-for="(item,index) in statisticsList.userGlance" :key="index">{{index+1}}.{{ item.userName }}:<span>{{item.count}}</span></li>
        </ul>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Statistics',
  mounted () {
    this.getStatistics()
  },
  data () {
    return {
      statisticsList: []
    }
  },
  methods: {
    async getStatistics () {
      const { data: r } = await this.$http.get('getHouseRentAndUserGlance')
      if (r.status !== 1) return this.$message.error(r.msg)
      this.statisticsList = r.data
    }
  }
}
</script>

<style scoped>
.el-breadcrumb {
  margin-bottom: 20px;
}
ul>li span {
  float: right;
}
ul>li{
  color: skyblue;
  font-size: 24px;
  list-style: none;
  margin: 10px 0;
}
.main-flex {
  display: flex;
  justify-content: center;
}
.main-left{
  flex: 1;
}
.main-right{
  flex: 1;
}
.el-card {
  margin: 0 20px;
}
</style>
