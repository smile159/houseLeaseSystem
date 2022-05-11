import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/components/Home'
import Login from '@/components/Login'
import IndexPage from '@/components/IndexPage'
import ViewHouse from '@/views/house/ViewHouse'
import MyHouse from '@/views/house/MyHouse'
import MyHouseRent from '@/views/house/MyHouseRent'
import CollectHouse from '@/views/house/CollectHouse'
import Detail from '@/components/Detail'
import MyComment from '@/views/house/MyComment'
import AdminHome from '@/admin/AdminHome'
import AdminLoginPage from '@/admin/AdminLoginPage'
// 后台
import AdminIndex from '@/admin/views/AdminIndex'
import ManageUser from '@/admin/views/ManageUser'
import HouseManage from '@/admin/views/HouseManage'
import Statistics from '@/admin/views/Statistics'

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
      },
      {
        path: '/collectHouse',
        component: CollectHouse
      },
      {
        path: '/detail',
        component: Detail
      },
      {
        path: '/myComment',
        component: MyComment
      }
    ]
  },
  {
    path: '/admin',
    component: AdminLoginPage
  },
  {
    path: '/adminHome',
    component: AdminHome,
    redirect: '/adminHome/adminIndex',
    children: [
      {
        path: 'adminIndex',
        component: AdminIndex
      },
      {
        path: 'manageUser',
        component: ManageUser
      },
      {
        path: 'houseManage',
        component: HouseManage
      },
      {
        path: 'statistics',
        component: Statistics
      }
    ]
  }
]

const router = new VueRouter({
  routes
})

export default router
