<template>
  <el-tabs v-model="activeName" @tab-click="handleClick" class="container-tab">
    <el-tab-pane label="未读" name="first">
      <div class="main-container">
        <el-card v-for="item in userMessageList.result" :key="item.mid">
          <div slot="header">
            <div class="avatar">
              <div class="div-avatar">
                <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                <span>{{ item.userName }}</span>
              </div>
              <el-button style="float: right" type="text" @click="readUserMessage(item.mid)">已读</el-button>
            </div>
          </div>
          {{ item.message }}
          <span class="message-time">
           {{ item.createTime}}
          </span>
        </el-card>
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="queryParams.pageNum"
          :page-sizes="[1, 5, 10, 20]"
          :page-size="queryParams.pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="userMessageList.total">
        </el-pagination>
      </div>
    </el-tab-pane>
    <el-tab-pane label="已读" name="second">
      <div class="main-container">
        <el-card v-for="item in userMessageList.result" :key="item.mid">
          <div slot="header">
            <div class="avatar">
              <div class="div-avatar">
                <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                <span>{{ item.userName }}</span>
              </div>
            </div>
          </div>
          {{ item.message }}
          <span class="message-time">
           {{ item.createTime}}
          </span>
        </el-card>
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="queryParams.pageNum"
          :page-sizes="[1, 5, 10, 20]"
          :page-size="queryParams.pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="userMessageList.total">
        </el-pagination>
      </div>
    </el-tab-pane>
  </el-tabs>
</template>

<script>
export default {
  name: 'MyComment',
  data () {
    return {
      activeName: 'first',
      queryParams: {
        pageSize: 5,
        pageNum: 1
      },
      userMessageList: {},
      read: 0
    }
  },
  mounted () {
    this.getAllMessage()
  },
  methods: {
    // 选项卡的切换
    handleClick (tabObject) {
      if (tabObject.name === 'second') {
        this.read = 1
      } else {
        this.read = 0
      }
      this.getAllMessage()
    },
    // 获取所有的数据
    getAllMessage () {
      this.$http.get('getAllMessage', {
        params: {
          read: this.read,
          ...this.queryParams
        }
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
    },
    // 每页条数改变的时候
    handleSizeChange (size) {
      this.queryParams.pageSize = size
      this.getAllMessage()
    },
    // 用户点击了页数
    handleCurrentChange (num) {
      this.queryParams.pageNum = num
      this.getAllMessage()
    },
    // 用户点击了已读
    readUserMessage (mid) {
      this.$http.get('readMessage', {
        params: {
          mid: mid
        }
      }).then(
        res => {
          if (res.data.status === 1) {
            this.$message.success(res.data.msg)
            // 重新获取数据
            this.getAllMessage()
            // 更新一下徽章
            this.$bus.$emit('setBadeg')
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
.el-pagination {
  margin-bottom: 20px;
}
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
