// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router/index.js'
import VueResource from 'vue-resource'
import axios from 'axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

import {setCookie,getCookie,delCookie} from '@/assets/cookie.js'
Vue.prototype.$cookieStore = {setCookie,getCookie,delCookie}
import qs from 'qs'
axios.defaults.withCredentials=true
Vue.prototype.$axios = axios;

axios.default.baseUrl='/api'

Vue.use(VueResource)
Vue.use(ElementUI)

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
