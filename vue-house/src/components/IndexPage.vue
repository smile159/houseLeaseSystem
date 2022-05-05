<template>
  <!--父容器-->
  <div>
    <!--大图片-->
    <div class="banner">
    </div>
    <!--  最新租房信息-->
    <div class="newest-house">
      <div class="show-msg">
        <h2>推荐租房信息</h2>
      </div>
      <div>
        <el-row :gutter="5" type="flex" justify="center" v-for="(houseRent,index) in RecommendHouseRent" :key="index">
          <el-col :span="6" v-for="(rent,index2) in houseRent" :key="rent.rid">
            <!--卡片-->
            <el-card>
              <div @click="toDetail" class="clickToDetail">
                <!--第一层小图片-->
                <div class="list-one-img">
                  <img src="../assets/images/1.jpg" alt="">
                </div>
                <!--第二层租房信息-->
                <div class="house-address">
                  <h4>
                    {{rent.rentTitle}}
                  </h4>
                  <h6>
                    {{rent.address}}
                  </h6>
                  <h3 class="price">
                    <span>¥{{rent.money}}</span>/月
                  </h3>
                </div>
              </div>
              <!--收藏和简略信息-->
              <div class="brief-msg">
                <!--左边图标-->
                <div class="left">
                  <ul>
                    <li v-for="item in rent.houseTags" :key="item.hTid">
                     {{item.value}}{{item.name}}
                    </li>
                  </ul>
                </div>
                <!--右边收藏按钮-->
                <div class="right">
                  <el-tag @click="changeStatus(index,index2)" :type="rent.fid===0?'info':'success'">收藏</el-tag>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>
      </div>
      <div class="more-house">
        <el-button type="primary">更多租房信息</el-button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'IndexPage',
  data () {
    return {
      bannerImg: [],
      bannerHeight: '877px',
      // 推荐的租房信息
      RecommendHouseRent: [],
      // 动态控制收藏标签的颜色
      favorite: ['info', 'info', 'info', 'info', 'info', 'info']
    }
  },
  created () {
    this.getRecommendHouseRent()
  },
  methods: {
    // 修改收藏的样式并提交数据到服务器
    changeStatus (index, index2) {
      console.log('index = ', index, 'index2=', index2)
      if (this.RecommendHouseRent[index][index2].fid > 0) {
        this.RecommendHouseRent[index][index2].fid = 0
        return this.$message.success('您已取消收藏')
      }
      // 修改对应对象的fid值
      this.RecommendHouseRent[index][index2].fid = 1
      this.$message.success('收藏成功')
    },
    // 到详情页面
    toDetail () {
      console.log('去详情页面')
    },
    // 获取推荐数据
    getRecommendHouseRent () {
      this.$http.get('RecommendHouseRent').then(
        res => {
          this.RecommendHouseRent.push(res.data.data.slice(0, 3))
          this.RecommendHouseRent.push(res.data.data.slice(3))
        }
      ).catch(
        err => {
          console.log(err)
        }
      )
    }
  },
  mounted () {
    this.bannerImg = this.$imgs.logo
  }
}
</script>

<style scoped>
/*轮播图的图片*/
.banner-img {
  width: 100%;
  height: 100%;
}

/*大图*/
.banner {
  position: relative;
  height: 900px;
  background: url("../assets/images/banner/banner-1.jpg") no-repeat;
  background-size: 100%;
}

/*大图中的搜索框*/
.el-input {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
  width: 1000px;
}

/*所有的卡片*/
.el-card {
  width: 370px;
  height: 450px;
  border-radius: .5rem;
}

/*取消卡片中的padding*/
.el-card > /deep/ .el-card__body {
  padding: 0 !important;
}

/*最新租房信息的文字*/
.newest-house > .show-msg {
  width: 1350px;
  height: 100px;
  margin: 0 240px;
  text-align: center;
  line-height: 100px;
}

/*最新租房信息中的卡片的图片*/
.newest-house .list-one-img {
  width: 370px;
  height: 240px;
}

.newest-house .list-one-img img {
  width: 100%;
  height: 100%;
}

/*设置每一行的上下间距*/
.el-row {
  margin: 20px 0;
}

.el-card h6 {
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

.more-house {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 60px;
}
.clickToDetail {
  cursor: pointer;
}
</style>
