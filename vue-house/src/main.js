import Vue from 'vue'
import App from './App.vue'
// 全局css
import './assets/css/global.css'

// 路由
import router from './router'
// 引入UI组件库
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// 引入axios
import axios from 'axios'
axios.defaults.baseURL = 'http://localhost:8080/'
// 运行携带cookie
axios.defaults.withCredentials = true

// 插件使用
Vue.use(ElementUI)

Vue.config.productionTip = false
Vue.prototype.$http = axios

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
