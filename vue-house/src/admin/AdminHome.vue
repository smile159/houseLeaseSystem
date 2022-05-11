<template>
  <el-container>
    <!--侧边栏-->
    <el-aside width="200px">
      <el-menu
        router
        default-active="1"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b"
      >
        <el-menu-item index="/adminHome/adminIndex">
          <i class="el-icon-menu"></i>
          <span slot="title">首页</span>
        </el-menu-item>

        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span>用户管理</span>
          </template>
          <el-menu-item index="/adminHome/manageUser">用户浏览</el-menu-item>
        </el-submenu>

        <el-menu-item index="3">
          <i class="el-icon-document"></i>
          <span slot="title">房屋管理</span>
        </el-menu-item>
        <el-menu-item index="4">
          <i class="el-icon-setting"></i>
          <span slot="title">统计</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-container>
      <!--头部-->
      <el-header>
        <el-menu
          class="top-header"
          mode="horizontal">
          <el-menu-item index="1" class="logo">房屋租赁管理系统</el-menu-item>
          <el-menu-item class="logout-btn">
            <!--用户信息-->
            <span class="userName" v-if="adminData.identity === 1" style="color: red">开发者 {{adminData.account}}</span>
            <span class="userName" v-else style="color: gold">管理员 {{adminData.account}}</span>
            <el-button type="info">退出</el-button>
          </el-menu-item>
        </el-menu>
      </el-header>
      <el-main>
        <!--主页展示-->
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: 'AdminHome',
  mounted () {
    this.init()
  },
  data () {
    return {
      adminData: {}
    }
  },
  methods: {
    init () {
      const adminData = JSON.parse(sessionStorage.getItem('adminUserInfo'))
      this.adminData = adminData
    }
  }
}
</script>

<style scoped>
.userName {
  font-size: 20px;
  color: black;
  margin-right: 20px;
}
.top-header>.el-menu-item.is-active{
  border-bottom: 0;
  cursor: auto;
  user-select: none;
}
.logo {
  font-size: 24px;
}
/*菜单高度*/
.el-menu {
  height: 100%;
}
/*退出按钮*/
.logout-btn {
  cursor: default;
  float: right!important;
}
/*容器*/
.el-container {
  width: 100%;
  height: 100%;
}
/*头部导航栏*/
.el-header {
  padding: 0;
  background-color: #939393;
}
/*主体内容*/
.el-main {
  background-color: gold;
}
</style>
