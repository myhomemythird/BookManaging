import Vue from 'vue'
import Router from 'vue-router'
import BookManaging from '@/components/BookManaging'
import BookDetails from '@/components/BookDetails'

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
    }
  ]
})
