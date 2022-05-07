<template>
  <div>
    <!--发布租赁信息-->
    <div>
      <el-button>发布房屋租赁</el-button>
    </div>
    <div class="flex-div">
      <!--<Card-->
      <!--  :d="cardData"-->
      <!--  anime-->
      <!--  :favorite-and-tag="1"-->
      <!--&gt;-->
      <!--  <template slot-scope="">-->
      <!--    &lt;!&ndash;{{row}}&ndash;&gt;-->
      <!--    <el-button type="primary" round>编辑</el-button>-->
      <!--    &lt;!&ndash;下架或上架&ndash;&gt;-->
      <!--    <el-button type="info" round>下架</el-button>-->
      <!--    <el-button type="danger" round>删除</el-button>-->
      <!--  </template>-->
      <!--</Card>-->
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
          <el-button type="info" round v-else-if="data.row.houseStatus === 0">下架</el-button>
          <el-button type="danger" round>删除</el-button>
        </template>
      </Card>
    </div>
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
      myHouseRentList: []
    }
  },
  mounted () {
    this.getMyHouseRent()
  },
  methods: {
    // 获取我发布的租赁信息
    getMyHouseRent () {
      this.$http.get('getMyHouseRent').then(
        res => {
          console.log('我发布的租赁信息为：', res.data.data)
          this.myHouseRentList = res.data.data
        }
      ).catch(
        err => {
          console.log('出错了', err.message)
        }
      )
    }
  }
}
</script>

<style scoped>
.el-card {
  height: 96%;
  margin: 15px;
}

.flex-div {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 1920px;
  flex-flow: wrap;
}
</style>
