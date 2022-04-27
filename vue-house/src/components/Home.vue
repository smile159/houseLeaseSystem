<template>
  <el-container>
    <el-header>Header</el-header>
    <el-container>
      <el-aside width="200px">Aside</el-aside>
      <el-main>Main</el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: 'Home'
}
</script>

<style scoped>
.el-container {
  height: 100%;
}
.el-header {
  background-color: skyblue;
  text-align: center;
  line-height: 60px;
}
.el-aside {
  background-color: pink;
}
.el-main {
  background-color: rebeccapurple;
}
</style>
