import Vue from 'vue'
// import Vuex from 'vuex'
import './plugins/axios'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import router from '../router'
import request from '../utils/request';

Vue.config.productionTip = false
Vue.use(ElementUI);
// Vue.use(Vuex)
Vue.prototype.request = request

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
