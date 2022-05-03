<template>
  <el-container>
    <!--导航栏-->
    <el-header>
      <el-menu
        router
        mode="horizontal"
      >
        <!--网站图标-->
        <el-menu-item index="/">
          <template>
            <a href="/">
              <img src="../assets/images/logo1.png" alt="" class="logo">
            </a>
          </template>
        </el-menu-item>
        <el-menu-item index="/home">首页</el-menu-item>
        <el-menu-item index="/viewHouse">租房</el-menu-item>
        <div class="login-item"></div>
        <template v-if="showLoginAndRegister">
          <!--登录注册-->
          <el-menu-item index="/login">
            登录
          </el-menu-item>
          <el-menu-item @click="register">
            注册
          </el-menu-item>
        </template>
        <el-submenu index="2" class="userinfoMenu" v-if="!showLoginAndRegister">
          <template slot="title">
            <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
            <span class="userName">用户名</span>
          </template>
          <el-menu-item index="2-1">我的房屋</el-menu-item>
          <el-menu-item index="2-2">我的收藏</el-menu-item>
          <el-menu-item index="2-3">我的留言</el-menu-item>
          <el-menu-item index="2-4">退出</el-menu-item>
        </el-submenu>
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
    <!--注册对话框-->
    <el-dialog
      title="注册"
      :visible.sync="registerDialogVisble"
      width="500px"
      >
      <el-form
        :model="registerForm"
        :rules="registerRules"
        ref="registerFormDialogRef"
      >
        <el-form-item label="用户名" prop="userName">
          <el-input v-model="registerForm.userName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="registerForm.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="affirmPassword">
          <el-input v-model="registerForm.affirmPassword" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="registerDialogVisble = false">取 消</el-button>
        <el-button type="primary" @click="submitRegisterForm">确 定</el-button>
      </div>
    </el-dialog>
  </el-container>
</template>

<script>
export default {
  name: 'Home',
  data () {
    return {
      // 默认选中的菜单
      activeIndex: '0',
      showLoginAndRegister: true,
      // 注册对话框控制
      registerDialogVisble: false,
      registerForm: {
        userName: '',
        password: '',
        affirmPassword: ''
      },
      // 注册表单校验规则
      registerRules: {
        userName: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 1, max: 12, message: '长度在 1 到 12 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, max: 18, message: '长度在 6 到 18 个字符', trigger: 'blur' }
        ],
        affirmPassword: [
          { required: true, message: '请确认密码', trigger: 'blur' },
          { min: 6, max: 18, message: '长度在 6 到 18 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    register () {
      this.registerDialogVisble = true
    },
    submitRegisterForm () {
      this.$refs.registerFormDialogRef.validate(async valid => {
        if (!valid) return this.$message.error('注册失败')
        console.log('注册的数据为：', this.registerForm)
        // 校验密码和确认密码是否一致
        if (this.registerForm.password !== this.registerForm.affirmPassword) return this.$message.error('密码不一致')
        /*        const { data: res } = await this.$http.post('register', this.registerForm)
        console.log(res)
        if (res.status > 0) {
          this.$message.success(res.msg)
        } else {
          this.$message.error(res.msg)
        } */
        this.$http.post('register', this.registerForm).then(
          res => {
            if (res.data.status > 0) {
              this.$message.success(res.data.msg)
            } else {
              this.$message.error(res.data.msg)
            }
          }
        ).catch(
          err => {
            this.$message.error(err.message)
          }
        )
        this.registerDialogVisble = false
      })
    }
  }
}
</script>

<style scoped>
.el-container {
  height: 100%;
}

.el-container > .el-header {
  padding: 0;
}

.el-header > ul {
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
.el-menu--horizontal > .userinfoMenu {
  float: right;
}

.userinfoMenu .userName {
  margin-left: 10px;
}

/*网站logo*/
.logo {
  width: 140px;
  height: 120px;
  margin-top: -32px;
}
.login-item {
  width: 650px;
}
</style>
