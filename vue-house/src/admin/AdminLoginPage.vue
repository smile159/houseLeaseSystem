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
            <el-form-item prop="adminName">
              <el-input v-model="adminLoginForm.adminName" prefix-icon="el-icon-user" placeholder="请输入账号"></el-input>
            </el-form-item>
            <el-form-item prop="adminPassword">
              <el-input v-model="adminLoginForm.adminPassword" prefix-icon="el-icon-key" placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" class="login-btn" @click="login">登录</el-button>
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
      adminLoginForm: {
        adminName: '',
        adminPassword: ''
      },
      // 表单校验规则
      adminLoginRules: {
        adminName: [
          { required: true, message: '请输入账号', trigger: 'blur' },
          { min: 1, max: 8, message: '长度在 1 到 8 个字符', trigger: 'blur' }
        ],
        adminPassword: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    login () {
      this.$router.replace('/adminHome')
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
  transform: translate(-50%,-50%);
}
/*背景*/
.bj {
  width: 100%;
  height: 100%;
  background-color: #84AF9B;
}
</style>
