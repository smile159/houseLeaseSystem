<template>
  <div class="bj">
    <div class="login-container">
      <el-card class="box-card">
        <!--头部-->
        <div class="main-header">
          <h2>房屋租赁管理系统</h2>
        </div>
        <!--主体-->
        <div class="main-login">
          <el-form ref="adminLoginFormRef" :model="adminLoginForm" label-width="80px" :rules="adminLoginRules">
            <el-form-item prop="account">
              <el-input v-model="adminLoginForm.account" prefix-icon="el-icon-user" placeholder="请输入账号"></el-input>
            </el-form-item>
            <el-form-item prop="password">
              <el-input v-model="adminLoginForm.password" prefix-icon="el-icon-key" placeholder="请输入密码"
                        type="password"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button
                :icon="loginBtnIcon"
                :type="loginStyle"
                class="login-btn"
                @click="login"
                :disabled="loginDisabled"
              >登录</el-button>
            </el-form-item>
          </el-form>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AdminLoginPage',
  data () {
    return {
      // 登录按钮样式
      loginBtnIcon: '',
      loginStyle: 'info',
      loginDisabled: true,
      adminLoginForm: {
        account: 'smile',
        password: '123456'
      },
      // 表单校验规则
      adminLoginRules: {
        account: [
          { required: true, message: '请输入账号', trigger: 'blur' },
          { min: 1, max: 8, message: '长度在 1 到 8 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, max: 15, message: '长度在 6 到 15 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  watch: {
    adminLoginForm: {
      immediate: true,
      deep: true,
      handler (newValue) {
        if (newValue.account.length > 0 && newValue.password.length >= 6) {
          this.loginStyle = 'primary'
          this.loginDisabled = false
        } else {
          this.loginStyle = 'info'
          this.loginDisabled = true
        }
      }
    }
  },
  methods: {
    async login () {
      this.loginBtnIcon = 'el-icon-loading'
      const { data: r } = await this.$http.post('adminLogin', this.adminLoginForm)
      if (r.status !== 1) this.$message.error(r.msg)
      // 拿到数据以后存储
      sessionStorage.setItem('adminUserInfo', JSON.stringify(r.data))
      this.$message.success(r.msg)
      // 关闭加载图标
      this.loginBtnIcon = ''
      // 跳转主页
      await this.$router.replace('/adminHome')
    }
  }
}
</script>

<style scoped>
.login-btn {
  width: 80%;
  margin-top: 20px;
}

/*登录表单*/
.main-login {
  margin-top: 30px;
}

/*输入框大小*/
.el-input {
  width: 80%;
}

/*主体内容头部标题*/
.main-header {
  height: 80px;
  /*background-color: skyblue;*/
  text-align: center;
  line-height: 80px;
}

/*取消卡片内边距*/
.el-card /deep/ .el-card__body {
  padding: 0;
}

/*登录卡片*/
.el-card {
  width: 450px;
  height: 320px;
}

/*父容器*/
.login-container {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}

/*背景*/
.bj {
  width: 100%;
  height: 100%;
  background-color: #84AF9B;
}
</style>
