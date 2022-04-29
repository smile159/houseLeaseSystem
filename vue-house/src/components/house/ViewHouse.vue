<template>
  <el-card>
    <div class="show-msg">
      <h2 class="msg">全部房源</h2>
      <el-input placeholder="请输入要搜索的房屋" v-model="searchKey">
        <el-button slot="append" icon="el-icon-search"></el-button>
      </el-input>
      <el-button type="primary">重置</el-button>
    </div>
  </el-card>
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
  height: 100%;
}
.show-msg {
  margin: 20px;
}
.show-msg>.msg {
  color: gold;
  margin-bottom: 10px;
  border-bottom: 2px solid gold;
}
.el-input {
  width: 300px;
  margin-right: 10px;
}
</style>
