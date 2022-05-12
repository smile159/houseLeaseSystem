<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item>房屋管理</el-breadcrumb-item>
    </el-breadcrumb>
    <el-card>
      <el-table
        v-loading="isLoading"
        :data="houseList"
        border
        style="width: 100%"
      >
        <el-table-column
          align="center"
          type="index"
          label="#">
        </el-table-column>
        <el-table-column
          align="center"
          prop="hid"
          label="id"
          width="50px"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="houseName"
          label="备注"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="type"
          label="房屋类型"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="city"
          label="城市"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="address"
          label="房屋具体地址"
          width="200px"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="area"
          label="面积"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="floor"
          label="所在楼层"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="maxFloor"
          label="最大楼层"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="direction"
          label="朝南"
        >
        </el-table-column>
        <el-table-column
          align="center"
          prop="houseStatus"
          label="出租状态"
        >
          <template slot-scope="scope">
            <el-tag type="info" v-if="scope.row.houseStatus === 0">未出租</el-tag>
            <el-tag type="success" v-else-if="scope.row.houseStatus === 1">已出租</el-tag>
            <el-tag type="warning" v-else-if="scope.row.houseStatus === 2">隐藏</el-tag>
            <el-tag v-else>未发布</el-tag>
          </template>
        </el-table-column>
        <!--隐藏状态-->
        <el-table-column
          align="center"
          prop="allowHidden"
          label="隐藏状态"
        >
          <template slot-scope="scope">
            <el-tag type="success" v-if="scope.row.allowHidden === 0">未隐藏</el-tag>
            <el-tag type="info" v-else-if="scope.row.allowHidden === 1">隐藏</el-tag>
            <el-tag v-else>暂无</el-tag>
          </template>
        </el-table-column>
        <el-table-column
          align="center"
          prop="allowDelete"
          label="是否允许删除"
        >
          <template slot-scope="scope">
            <el-tag type="danger" v-if="scope.row.allowDelete === 0">禁止</el-tag>
            <el-tag type="success" v-else-if="scope.row.allowDelete === 1">允许</el-tag>
            <el-tag v-else>暂无</el-tag>
          </template>
        </el-table-column>

        <el-table-column
          align="center"
          label="操作"
          width="380px"
        >
          <template slot-scope="scope">
            <el-button size="small" type="primary">编辑</el-button>
            <el-button size="small" type="warning" v-if="scope.row.allowHidden === 0" @click="hiddenHouse(scope.row.hid)">隐藏</el-button>
            <el-button size="small" type="success" v-else-if="scope.row.allowHidden === 1" @click="showHouse(scope.row.hid)">显示</el-button>
            <el-button size="small" type="success" v-if="scope.row.allowDelete === 0" @click="allowDelete(scope.row.hid)">允许删除</el-button>
            <el-button size="small" type="danger" v-else-if="scope.row.allowDelete === 1" @click="disableDelete(scope.row.hid)">禁止删除</el-button>
            <el-button size="small" type="danger" @click="deleteUserHouse(scope.row.hid)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <!--分页-->
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="queryHouseParams.pageNum"
        :page-sizes="[1, 5, 10, 20]"
        :page-size="queryHouseParams.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
      </el-pagination>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'HouseManage',
  mounted () {
    // console.log(this.$route.query.adminUser)
    this.adminUserInfo = JSON.parse(this.$route.query.adminUser)
    this.getAllHouseByPaging()
  },
  data () {
    return {
      houseList: [],
      adminUserInfo: {},
      queryHouseParams: {
        pageSize: 10,
        pageNum: 1
      },
      // 表格加载
      isLoading: false,
      total: 0
    }
  },
  methods: {
    async getAllHouseByPaging () {
      this.isLoading = true
      const { data: r } = await this.$http.get('admin/getHousePaging', {
        params: {
          ...this.queryHouseParams
        }
      })
      if (r.status !== 1) return this.$message.error(r.msg)
      console.log('r', r)
      // 保存数据
      this.houseList = r.data.result
      // 总条数
      this.total = r.data.total
      this.isLoading = false
    },
    async hiddenHouse (hid) {
      console.log('操作的房屋id为：', hid)
      const { data: r } = await this.$http.get('admin/hiddenHouse', {
        params: {
          hid: hid
        }
      })
      if (r.status !== 1) return this.$message.error(r.msg)
      this.$message.success(r.msg)
      this.getAllHouseByPaging()
    },
    async showHouse (hid) {
      const { data: r } = await this.$http.get('admin/showHouse', {
        params: {
          hid: hid
        }
      })
      if (r.status !== 1) return this.$message.error(r.msg)
      this.$message.success(r.msg)
      this.getAllHouseByPaging()
    },
    handleSizeChange (value) {
      this.queryHouseParams.pageSize = value
      this.getAllHouseByPaging()
    },
    handleCurrentChange (value) {
      this.queryHouseParams.pageNum = value
      this.getAllHouseByPaging()
    },
    // 禁止删除
    async disableDelete (hid) {
      const { data: r } = await this.$http.get('admin/disableDelete', {
        params: {
          hid: hid
        }
      })
      if (r.status !== 1) return this.$message.error(r.msg)
      this.$message.success(r.msg)
      this.getAllHouseByPaging()
    },
    async allowDelete (hid) {
      const { data: r } = await this.$http.get('admin/allowDelete', {
        params: {
          hid: hid
        }
      })
      if (r.status !== 1) return this.$message.error(r.msg)
      this.$message.success(r.msg)
      this.getAllHouseByPaging()
    },
    deleteUserHouse (hid) {
      this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(async () => {
        const { data: r } = await this.$http.get('admin/deleteUserHouse', {
          params: {
            hid: hid
          }
        })
        if (r.status !== 1) return this.$message.error(r.msg)
        this.$message.success(r.msg)
        this.getAllHouseByPaging()
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '出错了'
        })
      })
    }
  }
}
</script>

<style scoped>
.el-breadcrumb {
  margin-bottom: 20px;
}
</style>
