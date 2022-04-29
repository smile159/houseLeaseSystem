<template>
  <!--父容器-->
  <div>
    <!--大图片-->
    <div class="banner">
      <el-input placeholder="请输入城市" v-model="searchKey" class="input-with-select">
        <el-button slot="append" icon="el-icon-search"></el-button>
      </el-input>
    </div>
  <!--  最新租房信息-->
    <div class="newest-house">
      <div class="show-msg">
        <h2>最新租房信息</h2>
      </div>
      <div>
        <el-row :gutter="5" type="flex" justify="center">
          <el-col :span="6">
            <!--卡片-->
            <el-card>
              <!--第一层小图片-->
              <div class="list-one-img">
                <a href="/test">
                  <img src="../assets/images/1.jpg" alt="">
                </a>
              </div>
              <!--第二层租房信息-->
              <div class="house-address">
                <h4>
                  整租-桃苑公寓-3室1厅
                </h4>
                <h6>
                  广东省深圳市南山区南头桃苑公寓12栋602室
                </h6>
                <h3 class="price">
                  <span>¥ 8800</span>/月
                </h3>
              </div>
              <!--收藏和简略信息-->
              <div class="brief-msg">
                <!--左边图标-->
                <div class="left">
                  <ul>
                    <li>
                      <span class="iconfont icon-iconyihuifu-"></span>
                      3卧室
                    </li>
                    <li>
                      <span class="iconfont icon-iconyihuifu-"></span>
                      1卫生间
                    </li>
                  </ul>
                </div>
                <!--右边收藏按钮-->
                <div class="right">
                  <el-tag :type="tagStyle" @click="changeStatus" ref="favorite">标签三</el-tag>
                </div>
              </div>
            </el-card>
          </el-col>
          <el-col :span="6">
            <el-card>
              <!--第一层小图片-->
              <div class="list-one-img">
                <a href="/test">
                  <img src="../assets/images/1.jpg" alt="">
                </a>
              </div>
              <!--第二层租房信息-->
              <div class="house-address">
                <h4>
                  整租-桃苑公寓-3室1厅
                </h4>
                <h6>
                  广东省深圳市南山区南头桃苑公寓12栋602室
                </h6>
                <h3 class="price">
                  <span>¥ 8800</span>/月
                </h3>
              </div>
              <!--收藏和简略信息-->
              <div class="brief-msg">
                <!--左边图标-->
                <div class="left">
                  <ul>
                    <li>
                      <span class="iconfont icon-iconyihuifu-"></span>
                      3卧室
                    </li>
                    <li>
                      <span class="iconfont icon-iconyihuifu-"></span>
                      1卫生间
                    </li>
                  </ul>
                </div>
                <!--右边收藏按钮-->
                <div class="right">
                  <el-tag :type="tagStyle" @click="changeStatus" ref="favorite">标签三</el-tag>
                </div>
              </div>
            </el-card>
          </el-col>
          <el-col :span="6">
            <el-card>
              <!--第一层小图片-->
              <div class="list-one-img">
                <a href="/test">
                  <img src="../assets/images/1.jpg" alt="">
                </a>
              </div>
              <!--第二层租房信息-->
              <div class="house-address">
                <h4>
                  整租-桃苑公寓-3室1厅
                </h4>
                <h6>
                  广东省深圳市南山区南头桃苑公寓12栋602室
                </h6>
                <h3 class="price">
                  <span>¥ 8800</span>/月
                </h3>
              </div>
              <!--收藏和简略信息-->
              <div class="brief-msg">
                <!--左边图标-->
                <div class="left">
                  <ul>
                    <li>
                      <span class="iconfont icon-iconyihuifu-"></span>
                      3卧室
                    </li>
                    <li>
                      <span class="iconfont icon-iconyihuifu-"></span>
                      1卫生间
                    </li>
                  </ul>
                </div>
                <!--右边收藏按钮-->
                <div class="right">
                  <el-tag :type="tagStyle" @click="changeStatus" ref="favorite">标签三</el-tag>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>
        <el-row :gutter="5" type="flex" justify="center">
          <el-col :span="6">
            <!--卡片-->
            <el-card>
              <!--第一层小图片-->
              <div class="list-one-img">
                <a href="/test">
                  <img src="../assets/images/1.jpg" alt="">
                </a>
              </div>
              <!--第二层租房信息-->
              <div class="house-address">
                <h4>
                  整租-桃苑公寓-3室1厅
                </h4>
                <h6>
                  广东省深圳市南山区南头桃苑公寓12栋602室
                </h6>
                <h3 class="price">
                  <span>¥ 8800</span>/月
                </h3>
              </div>
              <!--收藏和简略信息-->
              <div class="brief-msg">
                <!--左边图标-->
                <div class="left">
                  <ul>
                    <li>
                      <span class="iconfont icon-iconyihuifu-"></span>
                      3卧室
                    </li>
                    <li>
                      <span class="iconfont icon-iconyihuifu-"></span>
                      1卫生间
                    </li>
                  </ul>
                </div>
                <!--右边收藏按钮-->
                <div class="right">
                  <el-tag :type="tagStyle" @click="changeStatus" ref="favorite">标签三</el-tag>
                </div>
              </div>
            </el-card>
          </el-col>
          <el-col :span="6">
            <el-card>
              <!--第一层小图片-->
              <div class="list-one-img">
                <a href="/test">
                  <img src="../assets/images/1.jpg" alt="">
                </a>
              </div>
              <!--第二层租房信息-->
              <div class="house-address">
                <h4>
                  整租-桃苑公寓-3室1厅
                </h4>
                <h6>
                  广东省深圳市南山区南头桃苑公寓12栋602室
                </h6>
                <h3 class="price">
                  <span>¥ 8800</span>/月
                </h3>
              </div>
              <!--收藏和简略信息-->
              <div class="brief-msg">
                <!--左边图标-->
                <div class="left">
                  <ul>
                    <li>
                      <span class="iconfont icon-iconyihuifu-"></span>
                      3卧室
                    </li>
                    <li>
                      <span class="iconfont icon-iconyihuifu-"></span>
                      1卫生间
                    </li>
                  </ul>
                </div>
                <!--右边收藏按钮-->
                <div class="right">
                  <el-tag :type="tagStyle" @click="changeStatus" ref="favorite">标签三</el-tag>
                </div>
              </div>
            </el-card>
          </el-col>
          <el-col :span="6">
            <el-card>
              <!--第一层小图片-->
              <div class="list-one-img">
                <a href="/test">
                  <img src="../assets/images/1.jpg" alt="">
                </a>
              </div>
              <!--第二层租房信息-->
              <div class="house-address">
                <h4>
                  整租-桃苑公寓-3室1厅
                </h4>
                <h6>
                  广东省深圳市南山区南头桃苑公寓12栋602室
                </h6>
                <h3 class="price">
                  <span>¥ 8800</span>/月
                </h3>
              </div>
              <!--收藏和简略信息-->
              <div class="brief-msg">
                <!--左边图标-->
                <div class="left">
                  <ul>
                    <li>
                      <span class="iconfont icon-iconyihuifu-"></span>
                      3卧室
                    </li>
                    <li>
                      <span class="iconfont icon-iconyihuifu-"></span>
                      1卫生间
                    </li>
                  </ul>
                </div>
                <!--右边收藏按钮-->
                <div class="right">
                  <el-tag :type="tagStyle" @click="changeStatus" ref="favorite">标签三</el-tag>
                </div>
              </div>
            </el-card>
          </el-col>
        </el-row>

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
      searchKey: '',
      selectKey: '',
      tagStyle: 'success'
    }
  },
  methods: {
    // number是序号，从1开始，idnex是索引从0开始
    changeImg (number, index) {
      console.log('切换img')
      this.$refs.imgRef.src = `../assets/images/banner/banner-${index}.jpg`
    },
    changeStatus () {
      console.log(this.$refs.favorite.$el.classList)
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
  transform: translate(-50%,-50%);
  width: 1000px;
}
/*所有的卡片*/
.el-card {
  width: 370px;
  height: 450px;
  border-radius: .5rem;
}
/*取消卡片中的padding*/
.el-card>/deep/.el-card__body {
  padding: 0!important;
}
/*最新租房信息的文字*/
.newest-house>.show-msg {
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
.brief-msg .left ul li{
  /*变为行内块元素*/
  display: inline-block;
  line-height: 72px;
  padding-left: 15px;
}
.brief-msg .left ul li span {
  font-size: 24px;
}
.brief-msg .right {
  padding-left: 75px;
}
.brief-msg .right .el-tag {
  border-radius: 30px;
}
</style>
