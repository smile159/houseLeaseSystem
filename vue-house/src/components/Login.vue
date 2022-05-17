<template>
  <div class="login-container">
    <el-card class="loginCard" :body-style="loginCardStyle">
      <el-form
        :model="loginForm"
        label-width="100px"
        ref="loginFormRef"
      >
        <el-form-item label="用户名">
          <el-input v-model="loginForm.userName"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="loginForm.password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="login">登录</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      // 登录表单数据
      loginForm: {
        userName: 'smile',
        password: '123456'
      },
      // 卡片body体样式
      loginCardStyle: {
        width: '100%',
        'padding-left': 0
      }
    }
  },
  methods: {
    login () {
      // 判断表单是否校验通过
      this.$http.post('login', this.loginForm).then(res => {
        if (res.data.status === 1) {
          // 登录成功的提示消息
          this.$message.success(res.data.msg)
          // 将数据存储到localStorage中
          localStorage.setItem('userInfo', JSON.stringify(res.data.data))
          // 跳转
          this.$router.replace('/home')
        } else {
          if (res.data.status < 4000) this.$message.error(res.data.msg)
        }
      })
    }
  }
}
</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  background-image: url('../assets/images/loginBackground.jpg');
  background-size: 1920px;
  background-repeat: no-repeat;
}

.loginCard {
  opacity: 0.8;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 500px;
  height: 320px;
}
</style>
