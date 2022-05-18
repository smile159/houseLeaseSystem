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
        <template v-if="!isLogin">
          <!--登录注册-->
          <el-menu-item index="/login">
            登录
          </el-menu-item>
          <el-menu-item @click="register">
            注册
          </el-menu-item>
        </template>
        <el-submenu index="2" class="userinfoMenu" v-if="isLogin">
          <template slot="title">
            <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
            <el-badge :value="messageNum" :hidden="hiddenMessageNum" class="nameBadge"><span
              class="userName">{{ user.userName }}</span></el-badge>
          </template>
          <el-menu-item index="/myHouse">我的房屋</el-menu-item>
          <el-menu-item index="/myhouseRent">我的租赁</el-menu-item>
          <el-menu-item index="/collectHouse">我的收藏</el-menu-item>
          <el-menu-item index="/myComment">
            <el-badge :value="messageNum" :hidden="hiddenMessageNum">我的留言</el-badge>
          </el-menu-item>
          <el-menu-item @click="logOut">退出</el-menu-item>
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
      @close="closeRegisterFormDialog"
    >
      <el-form
        :model="registerForm"
        :rules="registerRules"
        ref="registerFormDialogRef"
        status-icon
      >
        <el-form-item label="用户名" prop="userName">
          <el-input v-model="registerForm.userName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input v-model="registerForm.password" autocomplete="off" show-password></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="affirmPassword">
          <el-input v-model="registerForm.affirmPassword" autocomplete="off" show-password></el-input>
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
  mounted () {
    this.init()
    // 绑定全局事件总线，用于收藏出租信息
    this.$bus.$on('userFavorite', this.globalUserFavorite)
    this.$bus.$on('userCancel', this.globalUserCancel)
    this.$bus.$on('setBadeg', this.setBadeg)
    if (this.isLogin) {
      this.setBadeg()
    }
  },
  data () {
    /* 二次密码校验 */
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else {
        if (this.registerForm.affirmPassword !== '') {
          this.$refs.registerFormDialogRef.validateField('affirmPassword')
        }
        callback()
      }
    }
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'))
      } else if (value !== this.registerForm.password) {
        callback(new Error('两次输入密码不一致!'))
      } else {
        callback()
      }
    }
    return {
      // 隐藏徽章
      hiddenMessageNum: true,
      // 留言数量
      messageNum: 0,
      // 是否登录
      isLogin: false,
      // 用户数据
      user: {},
      // 默认选中的菜单
      activeIndex: '0',
      // 注册对话框控制
      registerDialogVisble: false,
      // 注册表单
      registerForm: {
        // 用户名
        userName: '',
        // 密码
        password: '',
        // 二次确认密码
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
          { min: 6, max: 18, message: '长度在 6 到 18 个字符', trigger: 'blur' },
          { validator: validatePass, trigger: 'blur' }
        ],
        affirmPassword: [
          { required: true, message: '请确认密码', trigger: 'blur' },
          { min: 6, max: 18, message: '长度在 6 到 18 个字符', trigger: 'blur' },
          { validator: validatePass2, trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    // 初始化方法，moutend挂载则触发
    init () {
      // 读取localStorage中的userinfo数据，判断是否存在
      if (localStorage.getItem('userInfo')) {
        // 如果存在则写入user
        this.user = JSON.parse(localStorage.getItem('userInfo'))
        // 修改登录状态
        this.isLogin = true
      } else {
        this.isLogin = false
      }
    },
    register () {
      this.registerDialogVisble = true
    },
    submitRegisterForm () {
      this.$refs.registerFormDialogRef.validate(async valid => {
        if (!valid) return this.$message.error('数据格式有误！请重新填写')
        // 校验密码和确认密码是否一致
        if (this.registerForm.password !== this.registerForm.affirmPassword) return this.$message.error('密码不一致')
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
    },
    // 关闭表单
    closeRegisterFormDialog () {
      // 关闭表单提交对话框
      this.registerDialogVisble = false
      // 在关闭前对表单进行重置并移除校验结果
      this.$refs.registerFormDialogRef.resetFields()
    },
    // 用户退出
    async logOut () {
      // 向服务器发送请求，清空cookie
      const { data: r } = await this.$http.get('logOut')
      if (r.status !== 1) return this.$message.error('退出失败')
      this.$message.success(r.msg)
      // 清空data中的user
      this.user = {}
      // 清除localStorage中的userInfo
      localStorage.removeItem('userInfo')
      // 修改登录状态
      this.isLogin = false
      this.$bus.$emit('userLogOut')
    },
    // 全局事件：用户收藏出租信息
    globalUserFavorite (rid, triggerEvent) {
      console.log('test tt', this)
      // 收藏是登录后的功能，先判断是否登录
      if (!this.isLogin) return this.$message.error('请先登录')
      const data = { rid: rid, uid: this.user.uid }
      this.$http.post('favoriteHouseRent', data).then(
        res => {
          if (res.data.status === 1) {
            // 刷新数据
            // this.$bus.$emit('refreshCradList')
            this.$bus.$emit(triggerEvent)
            this.$message.success(res.data.msg)
          }
        }
      ).catch(
        err => {
          this.$message.error(err.message)
        }
      )
    },
    // 全局事件，用户取消收藏
    globalUserCancel (fid, triggerEvent) {
      if (!this.isLogin) return this.$message.error('请先登录')
      const data = { fid }
      this.$http.post('cancelHouseRent', data).then(
        res => {
          if (res.data.status === 1) {
            // 刷新数据
            this.$bus.$emit(triggerEvent)
            this.$message.success(res.data.msg)
          }
        }
      ).catch(
        err => {
          this.$message.error(err.message)
        }
      )
    },
    // 修改徽章数量
    setBadeg (value) {
      console.log(this.$route)
      this.$http.get('getMessageNum').then(
        res => {
          if (res.data.status === 1) {
            this.messageNum = res.data.data
            this.hiddenMessageNum = res.data.data <= 0
            if (!sessionStorage.getItem('isShow')) {
              sessionStorage.setItem('isShow', true)
              this.$notify({
                title: '温馨提示',
                message: '您有新的留言，请及时查看',
                duration: 0
              })
            }
          }
        }
      ).catch(
        err => {
          this.$message.error(err.message)
        }
      )
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
  user-select: none;
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

.nameBadge /deep/ sup {
  margin-top: 13px;
}
</style>
