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
      <div class="main-container">
        <Card v-for="item in RecommendHouseRent" :key="item.rid" :d="item" trigger-event="getRecommendHouseRent"/>
      </div>
      <div class="more-house">
        <el-button type="primary" @click="moreHouse">更多租房信息</el-button>
      </div>
    </div>
    <div class="beianContainer">
      <a href="https://beian.miit.gov.cn/" target="_blank" style="float:left;height:20px;line-height:20px;margin: 0px 0px 0px 5px;color:#939393;">蜀ICP备2022009091号-1</a>
      <a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=51192302000220"
         style="display:inline-block;text-decoration:none;height:20px;line-height:20px;">
        <img src="../assets/images/beian.png" style="float:left;" alt=""/>
        <p style="float:left;height:20px;line-height:20px;margin: 0px 0px 0px 5px; color:#939393;">
          川公网安备 51192302000220号</p>
      </a>
    </div>
  </div>
</template>

<script>
import Card from '@/components/s-card'

export default {
  name: 'IndexPage',
  components: { Card },
  data () {
    return {
      bannerImg: [],
      bannerHeight: '877px',
      // 推荐的租房信息
      RecommendHouseRent: []
    }
  },
  created () {
    this.getRecommendHouseRent()
    this.$bus.$on('getRecommendHouseRent', this.getRecommendHouseRent)
  },
  methods: {
    // 获取推荐数据
    getRecommendHouseRent () {
      this.$http.get('RecommendHouseRent').then(
        res => {
          this.RecommendHouseRent = res.data.data
        }
      ).catch(
        err => {
          console.log(err)
        }
      )
    },
    moreHouse () {
      this.$router.push('/viewHouse')
    }
  },
  mounted () {
    this.bannerImg = this.$imgs.logo
  }
}
</script>

<style scoped>
.more-house {
  margin-top: 10px;
}

.beianContainer a {
  text-decoration: none;
  color: black;
  margin: 0 5px;
}

.beianContainer {
  margin-top: 50px;
  background-color: #f7f9fc;
  display: flex;
  justify-content: center;
}

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

.newest-house {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 1920px;
  flex-flow: wrap;
  flex-direction: column;
}

.newest-house .show-msg {
  margin-top: 30px;
}

.main-container {
  display: flex;
  flex-direction: row;
  flex-flow: wrap;
  justify-content: center;
  align-items: center;
}

</style>
