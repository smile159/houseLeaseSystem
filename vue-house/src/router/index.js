import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/components/Home'
import Login from '@/components/Login'
import IndexPage from '@/components/IndexPage'
import ViewHouse from '@/views/house/ViewHouse'
import MyHouse from '@/views/house/MyHouse'
import MyHouseRent from '@/views/house/MyHouseRent'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/home',
    component: Home,
    redirect: '/index',
    children: [
      {
        path: '/index',
        component: IndexPage
      },
      {
        path: '/viewHouse',
        component: ViewHouse
      },
      {
        path: '/myHouse',
        component: MyHouse
      },
      {
        path: '/myhouseRent',
        component: MyHouseRent
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
