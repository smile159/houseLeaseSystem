import Vue from 'vue'
import App from './App.vue'
import store from './stroe'
// 全局css
import './assets/css/global.css'
// 图标css
import './assets/fonts/iconfont.css'
// 引入图片
import $imgs from './router/img.js'
// 路由
import router from './router'
// 引入UI组件库
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// 引入axios
import axios from 'axios'
/* 设置基本url */
axios.defaults.baseURL = 'http://localhost:8080/'
// 运行携带cookie
axios.defaults.withCredentials = true

// axios响应拦截器
axios.interceptors.response.use(function (res) {
  console.log('拦截器', res)
  if (res.data.status < 0) {
    console.log('登录过期')
    ElementUI.Message.error(res.data.msg)
    router.replace('/login')
  }
  return res
}, function (err) {
  console.log('err', err)
})

// 插件使用
Vue.use(ElementUI)
/* 关闭生产提示 */
Vue.config.productionTip = false
/* 引入请求 */
Vue.prototype.$http = axios
/* 引入图片 */
Vue.prototype.$imgs = $imgs

new Vue({
  store,
  router,
  render: h => h(App),
  beforeCreate () {
    Vue.prototype.$bus = this
  }
}).$mount('#app')
