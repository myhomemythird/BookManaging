import Vue from 'vue'
import Router from 'vue-router'
import BookManaging from '@/components/BookManaging'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'BookManaging',
      component: BookManaging
    }
  ]
})
