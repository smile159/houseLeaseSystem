<template>
  <el-container>
    <!--导航栏-->
    <el-header>
      <el-menu
        router
        mode="horizontal"
      >
        <!--网站图标-->
        <el-menu-item index="/home">
          <template>
            <a href="/">
              <img src="../assets/images/logo1.png" alt="" class="logo">
            </a>
          </template>
        </el-menu-item>
        <el-menu-item index="/home">首页</el-menu-item>
        <el-menu-item index="/viewHouse">租房</el-menu-item>
        <!--登录注册-->
        <div>
          <el-menu-item>
            <el-button type="primary">注册</el-button>
          </el-menu-item>
          <!--<el-submenu index="2" class="userinfoMenu">-->
          <!--  <template slot="title">-->
          <!--    <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>-->
          <!--    <span class="userName">用户名</span>-->
          <!--  </template>-->
          <!--  <el-menu-item index="2-1">我的房屋</el-menu-item>-->
          <!--  <el-menu-item index="2-2">我的收藏</el-menu-item>-->
          <!--  <el-menu-item index="2-3">我的留言</el-menu-item>-->
          <!--  <el-menu-item index="2-4">退出</el-menu-item>-->
          <!--</el-submenu>-->
        </div>
      </el-menu>
    </el-header>
    <el-container>
      <!--侧边栏-->
      <!--<el-aside width="200px">Aside</el-aside>-->
      <!--主体内容-->
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: 'Home',
  data () {
    return {
      // 默认选中的菜单
      activeIndex: '0'
    }
  },
  methods: {
  }
}
</script>

<style scoped>
.el-container {
  height: 100%;
}
.el-container>.el-header {
  padding: 0;
}
.el-header>ul {
  display: flex;
  justify-content: center;
}

.el-aside {
  background-color: pink;
}
.el-main {
  padding: 0;
  background-color: #f7f9fc;
}
/*用户信息区域*/
.el-menu--horizontal>.userinfoMenu {
  float: right;
}
.userinfoMenu .userName {
  margin-left: 10px;
}
/*网站logo*/
.logo{
  width: 140px;
  height: 120px;
  margin-top: -32px;
}
</style>
