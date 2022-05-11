<template>
  <div>
    <!--面包屑-->
    <el-card>
      <!--操作-->
      <!--数据展示-->
      <!--
      identity: 1
      password: "123456"
      status: 1
      uid: 1
      userName: "smile"
      -->
      <div class="main-container">
        <el-table
          :data="userList"
          border
          style="width: 100%"
        >
          <el-table-column
            align="center"
            type="index"
            label="#">
          </el-table-column>
          <el-table-column
            prop="uid"
            label="uid"
          >
          </el-table-column>
          <el-table-column
            prop="userName"
            label="用户名"
          >
          </el-table-column>
          <el-table-column
            prop="password"
            label="密码"
          >
          </el-table-column>
          <el-table-column
            prop="status"
            label="账号状态">
            <template slot-scope="scope">
              <el-tag type="success" v-if="scope.row.status === 1">正常</el-tag>
              <el-tag type="warning" v-else-if="scope.row.status === 2">异常</el-tag>
              <el-tag type="info" v-else>封禁</el-tag>
            </template>
          </el-table-column>
          <!--操作-->
          <el-table-column
            label="操作"
          >
            <el-button type="primary">编辑</el-button>
            <el-button type="warning">禁言</el-button>
            <el-button type="danger">删除</el-button>
          </el-table-column>
        </el-table>
      </div>
      <div class="bottom-pagination">
        <!--分页-->
        <el-pagination
          background
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage4"
          :page-sizes="[100, 200, 300, 400]"
          :page-size="100"
          layout="total, sizes, prev, pager, next, jumper"
          :total="400">
        </el-pagination>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'ManageUser',
  data () {
    return {
      // 用户查询分页参数
      queryUserParams: {
        pageSize: 10,
        pageNum: 1
      },
      userList: []
    }
  },
  mounted () {
    this.getAllUser()
  },
  methods: {
    async getAllUser () {
      const { data: r } = await this.$http.get('adminGetUser', { params: this.queryUserParams })
      if (r.status !== 1) return this.$message.error(r.msg)
      // 请求成功
      this.userList = r.data
    }
  }
}
</script>

<style scoped>
/*底部分页*/
.bottom-pagination {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}
</style>
