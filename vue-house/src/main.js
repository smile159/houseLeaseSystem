import Vue from 'vue'
import App from './App.vue'
import store from './stroe'
import EasyRing from 'easy-ring'

// 默认提示音效
import 'easy-ring/easy-ring-default.wav'
// 引入自定义音效
import sound from './router/successSound'
// 引入高德地图
import VueAMap from 'vue-amap'

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
Vue.use(VueAMap)
Vue.use(EasyRing)

/* 关闭生产提示 */
Vue.config.productionTip = false
/* 引入请求 */
Vue.prototype.$http = axios
/* 引入图片 */
Vue.prototype.$imgs = $imgs
Vue.prototype.$sound = sound
// 初始化vue-amap
VueAMap.initAMapApiLoader({
  // 高德的key
  key: '2462cb3c8850a51f2d6760a21ea8e775',
  // 插件集合
  plugin: ['AMap.Autocomplete', 'AMap.PlaceSearch', 'AMap.Scale', 'AMap.OverView', 'AMap.ToolBar', 'AMap.MapType', 'AMap.PolyEditor', 'AMap.CircleEditor'],
  // 高德 sdk 版本，默认为 1.4.4
  v: '1.4.15'
})
new Vue({
  store,
  router,
  render: h => h(App),
  beforeCreate () {
    Vue.prototype.$bus = this
  }
}).$mount('#app')
