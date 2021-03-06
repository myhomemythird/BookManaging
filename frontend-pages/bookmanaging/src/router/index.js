import Vue from 'vue'
import Router from 'vue-router'
import BookManaging from '@/components/BookManaging'
import BookDetails from '@/components/BookDetails'
import UserManaging from '@/components/UserManaging'
import UserDetails from '@/components/UserDetails'
import NewUser from '@/components/NewUser'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'BookManaging',
      component: BookManaging
    },
    {
      path: '/bookdetails/:bookid',
      name: 'BookDetails',
      component: BookDetails
    },
    {
      path: '/users',
      name: 'UserManaging',
      component: UserManaging
    },
    {
      path: '/userdetails/:userid',
      name: 'UserDetails',
      component: UserDetails
    },
    {
      path: '/newuser',
      name: 'NewUser',
      component: NewUser
    }
  ]
})
