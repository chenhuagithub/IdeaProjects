import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Register from '@/components/Register'
import Login from "@/components/Login";
import Main from "@/components/Main";
import InfoManager from '@/components/Main/InfoManager'
import WriteBlog from "@/components/Main/WriteBlog";
import BlogInfoManager from "@/components/Main/BlogInfoManager";
import UpdateBlog from "@/components/Main/UpdateBlog";
import UpdateBloggerInfo from "@/components/Main/UpdateBloggerInfo";
import Community from "@/components/Community";
import ReadBlog from "@/components/ReadBlog";
import PasswordChange from "@/components/Main/PasswordChange";
import MyFocus from "@/components/Main/MyFocus";
import MyData from "@/components/Main/MyData";


Vue.use(Router)


export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/readBlog/:aid',
      name: ReadBlog,
      component: ReadBlog
    },
    {
      path: '/community',
      name: Community,
      component: Community
    },
    {
      path: '/hello',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/',
      name: 'Register',
      component: Register
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/main',
      name: 'Main',
      component: Main,
      children:[
        {
          path: '/infoManager',
          name: InfoManager,
          component: InfoManager
        },
        {
          path: '/writeBlog',
          name: WriteBlog,
          component: WriteBlog
        },
        {
          path: '/blogInfoManager',
          name: BlogInfoManager,
          component: BlogInfoManager
        },
        {
          path: '/updateBlog/:aid',
          name: UpdateBlog,
          component: UpdateBlog
        },
        {
          path: '/updateBloggerInfo',
          name: UpdateBloggerInfo,
          component: UpdateBloggerInfo
        },
        {
          path: '/passwordChange',
          name: PasswordChange,
          component: PasswordChange
        },
        {
          path: '/myFocus',
          name: MyFocus,
          component: MyFocus
        },
        {
          path: '/myData/:aid',
          name: MyData,
          component: MyData
        }
      ]
    }
  ]
})
