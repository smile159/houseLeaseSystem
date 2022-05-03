import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/components/Home'
import Login from '@/components/Login'
import IndexPage from '@/components/IndexPage'
import ViewHouse from '@/views/house/ViewHouse'

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
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
