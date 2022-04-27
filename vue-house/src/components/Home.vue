<template>
  <el-container>
    <el-header>Header</el-header>
    <el-container>
      <el-aside width="200px">Aside</el-aside>
      <el-main>
        <el-button @click="test">测试一下token</el-button>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: 'Home',
  methods: {
    test () {
      this.$http.get('test').then(res => {
        console.log(res)
      }).catch(err => {
        console.log(err)
      })
    }
  }
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
