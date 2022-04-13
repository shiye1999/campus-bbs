import Vue from 'vue'
import VuRouter from 'vue-router'

Vue.use(VuRouter)

const routes = [
    {
        path: '/',
        component: () => import("../views/Login/index.vue"),
    },
    {
        path: '/login',
        name: 'Login',
        component: () => import("../views/Login/index.vue"),
    },
    {
        path: '/register',
        name: 'Login',
        component: () => import("../views/Login/register.vue"),
    },
    {
        path: '/fail',
        component: () => import("../views/Login/fail.vue"),
        hidden: true
    },
    {
        path: '/help',
        component: () => import("../views/Help/index.vue"),
        children: [
            {
                path: 'help',
                name: 'help',
                component: () => import("../views/Help/help.vue")
            }
        ]
    },
    {
        path: '/home',
        name: 'Home',
        component: () => import("../views/Home/index.vue"),
        children: [
            {
                path: 'notice',
                name: 'notice',
                component: () => import("../views/Home/notice.vue"),
            },
            {
                path: 'upPost',
                name: 'upPost',
                component: () => import("../views/Home/upPost.vue"),
            },
            {
                path: 'test',
                name: 'test',
                component: () => import("../views/Home/postMain.vue"),
            },
            {
                path: 'study',
                name: 'study',
                component: () => import("../views/Home/postList.vue"),
            },
            {
                path: 'daily',
                name: 'daily',
                component: () => import("../views/Home/postList.vue"),
            },
        ]
    },
    {
        path: '/user',
        name: 'User',
        component: () => import('../views/User/index.vue'),
        children: [
            {
                path: 'basicInfo',
                name: 'basicInfo',
                component: () => import("../views/User/basicInfo")
            },
            {
                path: 'noticeList',
                name: 'noticeList',
                component: () => import("../views/User/noticeList")
            },
            {
                path: 'subscribeList',
                name: 'subscribeList',
                component: () => import("../views/User/subcribeList")
            },
            {
                path: 'fanList',
                name: 'fanList',
                component: () => import("../views/User/fanList")
            }
        ]
    }
]

const router = new VuRouter({
    mode: 'history',
    scrollBehavior: () => ({
        y: 0
    }),
    routes
})

export default router