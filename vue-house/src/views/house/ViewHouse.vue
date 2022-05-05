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
        <el-row :gutter="5" type="flex" justify="center">
          <el-col :span="6">
            <!--卡片-->
            <el-card>
              <div class="clickToDetail">
                <!--第一层小图片-->
                <div class="list-one-img">
                  <img src="../../assets/images/1.jpg" alt="">
                </div>
                <!--第二层租房信息-->
                <div class="house-address">
                  <h4>
                    合租-测试测试
                  </h4>
                  <h6>
                    四川省成都市金牛区
                  </h6>
                  <h3 class="price">
                    <span>￥6666</span>/月
                  </h3>
                </div>
              </div>
              <!--收藏和简略信息-->
              <div class="brief-msg">
                <!--左边图标-->
                <div class="left">
                  <ul>
                    <li>
                      卧室3
                    </li>
                    <li>
                      洗手间2
                    </li>
                  </ul>
                </div>
                <!--右边收藏按钮-->
                <div class="right">
                  <el-tag type="info">收藏</el-tag>
                </div>
              </div>
            </el-card>
          </el-col>
          <el-col :span="6">
            <!--卡片-->
            <el-card>
              <div class="clickToDetail">
                <!--第一层小图片-->
                <div class="list-one-img">
                  <img src="../../assets/images/1.jpg" alt="">
                </div>
                <!--第二层租房信息-->
                <div class="house-address">
                  <h4>
                    合租-测试测试
                  </h4>
                  <h6>
                    四川省成都市金牛区
                  </h6>
                  <h3 class="price">
                    <span>￥6666</span>/月
                  </h3>
                </div>
              </div>
              <!--收藏和简略信息-->
              <div class="brief-msg">
                <!--左边图标-->
                <div class="left">
                  <ul>
                    <li>
                      卧室3
                    </li>
                    <li>
                      洗手间2
                    </li>
                  </ul>
                </div>
                <!--右边收藏按钮-->
                <div class="right">
                  <el-tag type="info">收藏</el-tag>
                </div>
              </div>
            </el-card>
          </el-col>
          <el-col :span="6">
            <!--卡片-->
            <el-card>
              <div class="clickToDetail">
                <!--第一层小图片-->
                <div class="list-one-img">
                  <img src="../../assets/images/1.jpg" alt="">
                </div>
                <!--第二层租房信息-->
                <div class="house-address">
                  <h4>
                    合租-测试测试
                  </h4>
                  <h6>
                    四川省成都市金牛区
                  </h6>
                  <h3 class="price">
                    <span>￥6666</span>/月
                  </h3>
                </div>
              </div>
              <!--收藏和简略信息-->
              <div class="brief-msg">
                <!--左边图标-->
                <div class="left">
                  <ul>
                    <li>
                      卧室3
                    </li>
                    <li>
                      洗手间2
                    </li>
                  </ul>
                </div>
                <!--右边收藏按钮-->
                <div class="right">
                  <el-tag type="info">收藏</el-tag>
                </div>
              </div>
            </el-card>
          </el-col>
          <el-col :span="6">
            <!--卡片-->
            <el-card>
              <div class="clickToDetail">
                <!--第一层小图片-->
                <div class="list-one-img">
                  <img src="../../assets/images/1.jpg" alt="">
                </div>
                <!--第二层租房信息-->
                <div class="house-address">
                  <h4>
                    合租-测试测试
                  </h4>
                  <h6>
                    四川省成都市金牛区
                  </h6>
                  <h3 class="price">
                    <span>￥6666</span>/月
                  </h3>
                </div>
              </div>
              <!--收藏和简略信息-->
              <div class="brief-msg">
                <!--左边图标-->
                <div class="left">
                  <ul>
                    <li>
                      卧室3
                    </li>
                    <li>
                      洗手间2
                    </li>
                  </ul>
                </div>
                <!--右边收藏按钮-->
                <div class="right">
                  <el-tag type="info">收藏</el-tag>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>
    </div>
  </div>
</template>

<script>
import citys from '@/stroe/citys'

export default {
  name: 'ViewHouse',
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
      viewHouseRent: []
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

.flex-div {
  display: flex;
  justify-content: center;
  align-items: center;
}

.header-content span {
  padding: 0 15px;
}

.priceStart, .priceEnd {
  width: 100px;
}
/*所有的卡片*/
.flex-div .el-card {
  width: 370px;
  height: 450px;
  border-radius: .5rem;
}
/*取消卡片中的padding*/
.flex-div .el-card > /deep/ .el-card__body {
  padding: 0 !important;
}
/*最新租房信息的文字*/
.flex-div > .show-msg {
  width: 1350px;
  height: 100px;
  margin: 0 240px;
  text-align: center;
  line-height: 100px;
}

/*最新租房信息中的卡片的图片*/
.flex-div .list-one-img {
  width: 370px;
  height: 240px;
}

.flex-div .list-one-img img {
  width: 100%;
  height: 100%;
}
/*设置每一行的上下间距*/
.el-row {
  margin: 20px 0;
}

.flex-div .el-card h6 {
  font-weight: 200;
}

.house-address {
  width: 370px;
  height: 130px;
  padding: 15px 0 0 15px;
}

.house-address h4 {
  padding-bottom: 10px;
}

.house-address h6 {
  padding-bottom: 15px;
}

.house-address span {
  color: gold;
  font-weight: 700;
  font-size: 22px;
  padding-right: 5px;
}

.house-address h3 {
  font-weight: 200;
  font-size: 16px;
}

.brief-msg {
  width: 370px;
  height: 72px;
  border-top: 1px solid #eee;
}

.brief-msg div {
  display: inline-block;
}

.brief-msg .left ul li {
  /*变为行内块元素*/
  display: inline-block;
  line-height: 72px;
  padding-left: 15px;
}

.brief-msg .left ul li span {
  font-size: 24px;
}

.brief-msg .right {
  float: right;
  line-height: 72px;
  padding-right: 15px;
  cursor: pointer;
}

.brief-msg .right .el-tag {
  border-radius: 30px;
}
</style>
