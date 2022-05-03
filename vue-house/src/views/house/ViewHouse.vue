<template>
  <div>
    <!--搜索的-->
    <el-card>
      <div class="header-content">
        <!--<h2 class="msg">全部房源</h2>-->
        <el-divider content-position="left" class="msg">搜索</el-divider>
        <el-input placeholder="请输入要搜索的房屋" v-model="searchKey">
          <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
        <el-button type="primary" round>重置</el-button>
      </div>
    </el-card>
    <div class="flex-div">
      <!--主体内容-->
      <el-card class="main-card">
        <div class="main-content">
          <el-divider content-position="left" class="msg">全部房源</el-divider>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ViewHouse',
  data () {
    return {
      // 用户搜索的关键词
      searchKey: ''
    }
  }
}
</script>

<style scoped>
/*卡片*/
.el-card {
  margin: 10px;
  height: 25%;
}
.header-content {
  margin: 20px;
}
.header-content>.msg,div>.msg {
  font-size: 20px;
  color: gold;
  border-bottom: 2px solid gold;
}
.el-input {
  width: 300px;
  margin-right: 10px;
}

.el-divider>.el-divider__text{
  font-size: 20px;
  color: gold;
}
.main-content {
  margin: 20px;
}
.main-card {
  width: 80%;
  height: 500px;
}
.flex-div {
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
