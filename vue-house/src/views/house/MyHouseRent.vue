<template>
  <div>
    <el-tabs
      @tab-click="switchTab"
      type="border-card">
      <el-tab-pane label="出租中">
        <el-empty :image-size="200" v-if="myHouseRentList.length <=0"></el-empty>
        <template v-else>
          <!--发布租赁信息-->
          <div class="myHouseOptions">
            <el-button>发布房屋租赁</el-button>
          </div>
          <div class="flex-div">
            <Card v-for="item in myHouseRentList" :key="item.rid"
                  :d="item"
                  anime
                  :favorite-and-tag="1"
            >
              <template scope="data">
                <!--{{aaa.row.rid}}-->
                <el-button type="primary" round @click="editHouseDialog(data.row.rid)">编辑</el-button>
                <!--下架或上架-->
                <el-button type="warning" round v-if="data.row.houseStatus > 0">下架</el-button>
                <el-button type="success" round v-else-if="data.row.houseStatus === 0">上架</el-button>
                <el-button type="danger" round>删除</el-button>
              </template>
            </Card>
          </div>
        </template>
      </el-tab-pane>
      <el-tab-pane label="已出租">
        <el-empty :image-size="200" v-if="myHouseRentList.length <=0"></el-empty>
        <div class="flex-div" v-else>
          <Card v-for="item in myHouseRentList" :key="item.rid"
                :d="item"
                anime
                :favorite-and-tag="1"
          >
            <template scope="data">
              <!--{{aaa.row.rid}}-->
              <el-button type="primary" round>编辑</el-button>
              <!--下架或上架-->
              <el-button type="warning" round v-if="data.row.houseStatus > 0">下架</el-button>
              <el-button type="success" round v-else-if="data.row.houseStatus === 0">上架</el-button>
              <el-button type="danger" round>删除</el-button>
            </template>
          </Card>
        </div>
      </el-tab-pane>
      <el-tab-pane label="已租赁">
        <el-empty :image-size="200" v-if="myHouseRentList.length <=0"></el-empty>
        <div class="flex-div" v-else>
          <Card v-for="item in myHouseRentList" :key="item.rid"
                :d="item"
                anime
                :favorite-and-tag="1"
          >
            <template>
              <el-button type="danger" round>解约</el-button>
            </template>
          </Card>
        </div>
      </el-tab-pane>
    </el-tabs>
    <el-dialog
      title="编辑出租信息"
      :visible.sync="editHouseDialogVisble"
      width="50%"
    >
      <span>编辑对话框</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="editHouseDialogVisble = false">取 消</el-button>
        <el-button type="primary" @click="editHouseDialogVisble = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import Card from '@/components/s-card'

export default {
  name: 'MyHouseRent',
  components: { Card },
  data () {
    return {
      cardData: {
        rentTitle: '合租-测试用的',
        address: '四川省成都市金牛区',
        price: 9999,
        houseTags: [
          { name: '卫生间', value: '5', htid: 4 },
          { name: '卧室', value: '6', htid: 5 }
        ],
        fid: 0
      },
      // 租赁数据
      myHouseRentList: [],
      // 查询的类型，出租中1，已出租0，已签约2
      type: 1,
      // 编辑对话框控制
      editHouseDialogVisble: false,
      // 出租详细数据
      houseRentDetail: {}
    }
  },
  mounted () {
    this.getMyHouseRent()
  },
  methods: {
    // 获取我发布的租赁信息
    getMyHouseRent () {
      this.$http.get('getMyHouseRent', {
        params: {
          type: this.type
        }
      }).then(
        res => {
          console.log('我发布的租赁信息为：', res.data.data)
          this.myHouseRentList = res.data.data
        }
      ).catch(
        err => {
          console.log('出错了', err.message)
        }
      )
    },
    // 切换tab的回调方法
    switchTab (target) {
      console.log(target)
      if (target.paneName === '0') {
        this.type = 1
      } else if (target.paneName === '1') {
        this.type = 0
      } else {
        this.type = 2
      }
      this.getMyHouseRent()
    },
    // 编辑按钮触发方法，获取id，取得详细数据后展示对话框
    editHouseDialog (rid) {
      // 获取详细数据
      this.getHouseRentDetailData(rid)
      this.editHouseDialogVisble = true
    },
    // 获取房屋租赁的详细数据
    getHouseRentDetailData (rid) {
      this.$http.get('getMyHouseRentDetail', {
        params: {
          rid: rid
        }
      }).then(
        res => {
          this.houseRentDetail = res.data.data
        }
      ).catch(
        err => {
          console.log('出错了...getHouseRentDetailData', err.message)
        }
      )
    }
  }
}
</script>

<style scoped>
.el-tab-pane {
  height: 85vh;
}

.flex-div {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 1920px;
  flex-flow: wrap;
}

/*发布租赁按钮*/
.myHouseOptions {
  margin-left: 9%;
  margin-top: 20px;
}
</style>
