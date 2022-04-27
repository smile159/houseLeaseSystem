<template>
  <div class="login-container">
    <el-card class="loginCard" :body-style="loginCardStyle">
      <el-form
        :model="loginForm"
        :rules="loginRules"
        label-width="100px"
        ref="loginFormRef"
      >
        <el-form-item label="用户名" prop="userName">
          <el-input v-model="loginForm.userName"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
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
      // 登录表单校验规则
      loginRules: {
        userName: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 1, max: 12, message: '长度在 1 到 12 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, max: 18, message: '长度在 6 到 18 个字符', trigger: 'blur' }
        ]
      },
      // 卡片body体样式
      loginCardStyle: {
        width: '100%',
        'padding-left': 0
      }
    }
  },
  mounted () {
    // eslint-disable-next-line no-undef
    VANTA.CLOUDS({
      el: '.login-container',
      mouseControls: true,
      touchControls: true,
      gyroControls: false,
      minHeight: 200.00,
      minWidth: 200.00
    })
  },
  methods: {
    login () {
      // 判断表单是否校验通过
      this.$refs.loginFormRef.validate(valid => {
        console.log('校验是否通过？', valid)
        if (valid) {
          this.$http.post('login', this.loginForm).then(res => {
            this.$message.success(res.data.msg)
            console.log(res)
            this.$router.replace('/home')
          }).catch(err => {
            console.log(err)
            this.$message.error('登录错误')
          })
        } else {
          this.$message.error('数据校验失败')
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

.el-card__body {

}

</style>
