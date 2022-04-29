<template>
  <div>
    <el-carousel
      trigger="click"
      :height="bannerHeight"
      @change="changeImg"
    >
      <el-carousel-item v-for="item in bannerImg" :key="item">
        <img :src='item' class="banner-img" alt="房屋" ref="imgRef">
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  name: 'IndexPage',
  data () {
    return {
      bannerImg: [],
      bannerHeight: '877px'
    }
  },
  methods: {
    // number是序号，从1开始，idnex是索引从0开始
    changeImg (number, index) {
      console.log('切换img')
      this.$refs.imgRef.src = `../assets/images/banner/banner-${index}.jpg`
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
</style>
