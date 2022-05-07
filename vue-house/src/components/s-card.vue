<template>
  <el-card :class="this.anime === undefined?'hvr-grow-shadow':''" :style="this.anime === undefined?'':'height:490px'">
    <el-tag
      class="rentTagStatus"
      :type="rentType">
      {{ rentStatus }}
    </el-tag>
    <div class="clickToDetail">
      <!--第一层小图片-->
      <div class="list-one-img">
        <img src="../assets/images/1.jpg" alt="">
      </div>
      <!--第二层租房信息-->
      <div class="house-address">
        <h4>
          {{ d.rentTitle }}
        </h4>
        <h6>
          {{ d.address }}
        </h6>
        <h3 class="price">
          <span>￥{{ d.monthMoney }}</span>/月
        </h3>
      </div>
    </div>
    <!--收藏和简略信息-->
    <div class="brief-msg">
      <!--左边图标-->
      <div class="left">
        <ul>
          <li v-for="(item,index) in d.houseTags" :key="index">
            {{ item.name }}{{ item.value }}
          </li>
        </ul>
      </div>
      <!--右边收藏按钮-->
      <div class="right">
        <el-tag :type="tagType" @click="favorite">{{ favoriteOrTag }}</el-tag>
      </div>
    </div>
    <div class="flex-button">
      <slot :row="this.cardData"></slot>
    </div>
    <el-dialog
      title="房屋配置"
      :visible.sync="dialogVisible"
      width="50%">
      <span>这是一段信息</span>
    </el-dialog>
  </el-card>
</template>

<script>
export default {
  name: 'Card',
  props: ['d', 'anime', 'favoriteAndTag'],
  data () {
    return {
      dialogVisible: false,
      cardData: this.d
    }
  },
  mounted () {
    console.log('this.cardData', this.cardData)
  },
  methods: {
    favorite () {
      if (this.favoriteAndTag > 0) {
        // 说明是标签的
        this.dialogVisible = true
      } else {
        if (this.isFavorite) {
          this.$bus.$emit('userCancel', this.d.fid)
        } else {
          this.$bus.$emit('userFavorite', this.d.rid)
        }
      }
    }
  },
  computed: {
    // 计算当前是否已经收藏
    isFavorite () {
      return this.d.fid > 0
    },
    // 计算是否已经出租
    rentStatus () {
      return this.d.houseStatus > 0 ? this.d.houseStatus === 1 ? '出租中' : '已租赁' : '已出租'
    },
    // 出租标签的状态
    rentType () {
      return this.d.houseStatus > 0 ? 'success' : 'info'
    },
    // 是浏览还是管理
    favoriteOrTag () {
      return this.favoriteAndTag > 0 ? '更多标签' : '收藏'
    },
    tagType () {
      if (this.favoriteAndTag > 0) {
        return 'primary'
      } else {
        return this.d.fid > 0 ? 'success' : 'info'
      }
    }
  }
}
</script>

<style scoped>
.rentTagStatus {
  position: absolute;
  top: 5px;
  right: 5px;
}

.flex-button {
  width: 100%;
  display: flex;
  justify-content: center;
  flex: 1;
}

.el-card > /deep/ .el-card__body .el-button {
  margin-left: 10px;
}

/*所有的卡片*/
.el-card {
  position: relative;
  width: 370px;
  height: 450px;
  border-radius: .5rem;
  user-select: none;
}

/*取消卡片中的padding*/
.el-card > /deep/ .el-card__body {
  padding: 0 !important;
}

/*最新租房信息的文字*/
.show-msg {
  width: 1350px;
  height: 100px;
  margin: 0 240px;
  text-align: center;
  line-height: 100px;
}

/*最新租房信息中的卡片的图片*/
.list-one-img {
  width: 370px;
  height: 240px;
}

.list-one-img img {
  width: 100%;
  height: 100%;
}

.el-card {
  margin: 20px !important;
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

.el-card__body .el-button {
  margin: 0 10px;
}

</style>
