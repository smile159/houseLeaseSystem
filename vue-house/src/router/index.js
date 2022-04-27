import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/components/Home'
import Login from '@/components/Login'
import IndexPage from '@/components/IndexPage'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/home',
    component: Home,
    children: [
      {
        path: '/index',
        component: IndexPage
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
