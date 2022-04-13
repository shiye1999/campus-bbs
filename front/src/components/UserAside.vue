<template>
    <el-menu default-active="$route.path" class="userMenu" router @open="handleOpen" @close="handleClose">
        <el-menu-item @click=clikcMenu(item) v-for="item in menu" :index="item.path" :key="item.path">
            <template slot="title">
                <span>{{item.label}}</span>
            </template>
        </el-menu-item>
    </el-menu>
</template>

<script>
    export default {
        data() {
            return {
                menu: [{
                        path: '/user/basicInfo',
                        name: 'basicInfo',
                        label: '基本资料',
                    },
                    {
                        path: '/user/noticeList',
                        name: 'noticeList',
                        label: '消息列表',
                    },
                    {
                        path: '/user/subscribeList',
                        name: 'subscribeList',
                        label: '关注列表',
                    },
                    {
                        path: '/user/fanList',
                        name: 'fanList',
                        label: '粉丝列表',
                    }
                ]
            }
        },
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },
            clickMenu(item) {
                this.$router.push({
                    name: item.name
                })
            }
        }
    }
</script>