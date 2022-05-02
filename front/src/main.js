import Vue from 'vue'
// import Vuex from 'vuex'
import './plugins/axios'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import router from '../router'
import request from '../utils/request';

import VueRouter from 'vue-router'
 
Vue.use(VueRouter)
 
// 解决ElementUI导航栏中的vue-router在3.0版本以上重复点菜单报错问题
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

Vue.config.productionTip = false
Vue.use(ElementUI);
// Vue.use(Vuex)
Vue.prototype.request = request

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
