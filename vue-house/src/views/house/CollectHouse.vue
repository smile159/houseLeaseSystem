<template>
  <div>
    <!--主体内容-->
    <div class="flex-div">
      <!--分割线-->
      <Card v-for="item in userAllFavoriteList" :key="item.rid" :d="item" trigger-event="getUserAllFavorite"/>
    </div>
  </div>
</template>

<script>
import Card from '@/components/s-card'
export default {
  name: 'CollectHouse',
  components: { Card },
  mounted () {
    this.$bus.$on('getUserAllFavorite', this.getUserAllFavorite)
    this.getUserAllFavorite()
  },
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
        fid: 0,
        rid: 6666
      },
      userAllFavoriteList: []
    }
  },
  methods: {
    getUserAllFavorite () {
      this.$http.get('getAllFavorite').then(
        res => {
          if (res.data.status === 1) {
            this.userAllFavoriteList = res.data.data
          }
        }
      ).catch(
        err => {
          this.$message.error(err.message)
        }
      )
    }
  }
}
</script>

<style scoped>
.flex-div{
  display: flex;
  justify-content: center;
  align-items: center;
  width: 1920px;
  flex-flow: wrap;
}
</style>
