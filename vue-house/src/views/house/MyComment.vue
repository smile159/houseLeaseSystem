<template>
  <el-tabs v-model="activeName" @tab-click="handleClick" class="container-tab">
    <el-tab-pane label="已读" name="first">
      <div class="main-container">

        <el-card v-for="item in userMessageList" :key="item.mid">
          <div slot="header">
            <div class="avatar">
              <div class="div-avatar">
                <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                <span>{{ item.userName }}</span>
              </div>
              <el-button style="float: right" type="text">已读</el-button>
            </div>
          </div>
          {{ item.message }}
          <span class="message-time">
           {{ item.createTime}}
          </span>
        </el-card>
      </div>
    </el-tab-pane>
    <el-tab-pane label="未读" name="second">配置管理</el-tab-pane>
  </el-tabs>
</template>

<script>
export default {
  name: 'MyComment',
  data () {
    return {
      activeName: 'first',
      queryParams: {
        pageSize: 10,
        pageNum: 1
      },
      userMessageList: []
    }
  },
  mounted () {
    this.getAllMessage()
  },
  methods: {
    handleClick () {
      console.log('switch tab')
    },
    getAllMessage () {
      this.$http.get('getAllMessage', {
        params: this.queryParams
      }).then(
        res => {
          if (res.data.status === 1) {
            this.userMessageList = res.data.data
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
.message-time {
  position: absolute;
  float: right;
  bottom: 10px;
  right: 10px;
  font-size: 16px;
}
/*选择第二个span加左外边距*/
.div-avatar span:nth-child(2) {
  margin-left: 10px;
}
.div-avatar {
  display: flex;
  align-items: center;
}

/*flex布局解决头像和用户名对不齐的问题*/
.avatar {
  display: flex;
  justify-content: space-between;
}

.container-tab {
  margin: 0 10px;
}

.main-container {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.el-card {
  position: relative;
  margin: 20px 0;
  width: 60%;
  height: 230px;
}
</style>
