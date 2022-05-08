<template>
  <div>
    <!--搜索的-->
    <el-card>
      <div class="header-content">
        <el-divider content-position="left" class="msg">搜索</el-divider>
        <!--城市搜索-->
        <span>城市</span>
        <el-select
          v-model="searchForm.selectCityName"
          placeholder="请选择城市"
          filterable
          :filter-method="searchCity"
        >
          <el-option
            v-for="item in hotCity"
            :key="item.name"
            :label="item.name"
            :value="item.name">
          </el-option>
        </el-select>
        <span>所在街道</span>
        <el-input v-model="searchForm.address" placeholder="请输入街道"></el-input>
        <span>出租价格</span>
        <el-input v-model="searchForm.priceStart" class="priceStart"></el-input>
        元
        <span>----</span>
        <el-input v-model="searchForm.priceEnd" class="priceEnd"></el-input>
        元
        <el-button type="primary" round>搜索</el-button>
        <el-button type="primary" round>重置</el-button>
      </div>
    </el-card>
    <!--主体内容-->
    <div class="flex-div">
      <!--分割线-->
      <Card v-for="item in cardDataList" :key="item.rid" :d="item" trigger-event="refreshCradList"/>
    </div>
  </div>
</template>

<script>
import citys from '@/stroe/citys'
import Card from '@/components/s-card'

export default {
  name: 'ViewHouse',
  components: { Card },
  mounted () {
    // 获取最新的出租信息
    this.getHouseRentList()
    console.log('viewHouse', this)
    this.$bus.$on('refreshCradList', this.getHouseRentList)
  },
  data () {
    return {
      // 热门城市数据
      // '北京', '上海', '广州', '深圳', '重庆', '成都', '武汉'
      hotCity: [
        {
          name: '北京'
        },
        {
          name: '上海'
        },
        {
          name: '广州'
        },
        {
          name: '深圳'
        },
        {
          name: '重庆'
        },
        {
          name: '成都'
        },
        {
          name: '武汉'
        }
      ],
      // 城市数据
      cityList: citys.city,
      searchForm: {
        // 用户选择的城市
        selectCityName: '',
        // 街道
        address: '',
        // 价格开始
        priceStart: '',
        // 价格结束
        priceEnd: ''
      },
      // 浏览的租房信息
      viewHouseRent: [],
      // 卡片模拟数据
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
      // 查询参数
      queryHouseRent: {
        pageSize: 6,
        pageNum: 1
      },
      // 出租房屋的数据
      cardDataList: [],
      // 收藏表单数据
      favoriteFrom: {
        rid: -1,
        uid: -1
      }
    }
  },
  methods: {
    // 搜索城市
    searchCity (value) {
      // 自定义搜索逻辑
      console.log('searchCity', value)
      // 过滤数据
      this.hotCity = this.cityList.filter((v) => {
        return v.name === value
      })
    },
    getHouseRentList () {
      this.$http.get('getHouseRent', {
        params: this.queryHouseRent
      }).then(
        res => {
          // 请求成功
          this.cardDataList = res.data.data
          console.log(this.cardDataList)
        }
      ).catch(
        err => {
          console.log(err.message)
        }
      )
    }
  }
}
</script>

<style scoped>
/*卡片*/
.el-card {
  margin: 10px;
  height: 25%;
}

.header-content {
  margin: 20px;
}

.header-content > .msg, div > .msg {
  font-size: 20px;
  color: gold;
  border-bottom: 2px solid gold;
}

.el-input {
  width: 300px;
  margin-right: 10px;
}

.el-divider > .el-divider__text {
  font-size: 20px;
  color: gold;
}

.main-content {
  margin: 20px;
}

.main-card {
  width: 80%;
  height: 500px;
}
/*卡片的父元素，flex布局*/
.flex-div {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 1920px;
  flex-flow: wrap;
}

/*span的左右内边距*/
.header-content span {
  padding: 0 15px;
}
/*价格开始和结束*/
.priceStart, .priceEnd {
  width: 100px;
}
.hvr-grow-shadow {
  display: inline-block;
  vertical-align: middle;
  -webkit-transform: perspective(1px) translateZ(0);
  transform: perspective(1px) translateZ(0);
  box-shadow: 0 0 1px rgba(0, 0, 0, 0);
  -webkit-transition-duration: 0.3s;
  transition-duration: 0.3s;
  -webkit-transition-property: box-shadow, transform;
  transition-property: box-shadow, transform;
}
.hvr-grow-shadow:hover, .hvr-grow-shadow:focus, .hvr-grow-shadow:active {
  box-shadow: 0 10px 10px -10px rgba(0, 0, 0, 0.5);
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}
</style>
