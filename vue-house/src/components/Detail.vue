<template>
  <div>
    <!--房屋信息-->
    <div class="houseData">
      <div class="price">
        <h4>¥ 8800/月</h4>
      </div>
      <div class="title">
        <h3>合租-世界花园-4居室-C卧-666</h3>
      </div>
      <div class="location">
        <i class="el-icon-location-outline"></i>
        <span>广东省深圳市南山区南头桃苑公寓12栋602室</span>
      </div>
    </div>
    <!--房屋的数据/预订、留言-->
    <div class="house">
      <div class="left">
        <el-collapse v-model="activeNames" @change="handleChange">
          <el-collapse-item title="房屋详细信息" name="1">
            <div>与现实生活一致：与现实生活的流程、逻辑保持一致，遵循用户习惯的语言和概念；</div>
            <div>在界面中一致：所有的元素和结构需保持一致，比如：设计样式、图标和文本、元素的位置等。</div>
          </el-collapse-item>
        </el-collapse>
        <el-collapse>
          <el-collapse-item title="详细描述" name="2">
            <div>控制反馈：通过界面样式和交互动效让用户可以清晰的感知自己的操作；</div>
            <div>页面反馈：操作后，通过页面元素的变化清晰地展现当前状态。</div>
          </el-collapse-item>
        </el-collapse>
      </div>
      <div class="right">

      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Detail',
  mounted () {
    console.log(this.$route)
  },
  data () {
    return {
      activeNames: ['1', '2']
    }
  }
}
</script>

<style scoped>
.houseData {
  display: flex;
  height: 260px;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  background-color: #ffffff;
}

.houseData .price {
  font-size: 30px;
  height: 38px;
  color: gold;
  /*background-color: red;*/
}

.houseData .title {
  font-size: 30px;
  height: 45px;
}

.houseData .location {
  margin-top: 20px;
}

.house {
  width: 100%;
  height: 600px;
  display: flex;
}

.house .left {
  flex: 1;
  /*background-color: yellow;*/
  margin-left: 10%;
}

.house .right {
  flex: 1;
  background-color: skyblue;
  margin-right: 10%;
}
.el-collapse {
  margin: 10px 30px;
}
</style>
