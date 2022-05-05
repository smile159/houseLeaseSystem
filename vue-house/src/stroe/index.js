import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

// 类似controller
const actions = {

}
// 类似持久层
const mutations = {
  // 设置用户信息
  SETUSERINFO (state, value) {
    console.log('拿到的数据为：', value)
    state.userinfo = value
  }
}

const state = {
  // 登录用户信息，如果没有则表示还没登录
  userinfo: {}
}

const getters = {}

export default new Vuex.Store({
  actions,
  mutations,
  state,
  getters
})
