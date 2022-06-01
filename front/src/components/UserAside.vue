<template>
    <el-menu default-active="$route.path" class="el-menu-vertical-demo" router @open="handleOpen" @close="handleClose"
        :unique-opened="true" :collapse="false" style="text-align:center">
        <el-menu-item @click=clickMenu(item) v-for="item in menu" :index="item.path" :key="item.path">
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
                    },
                    // {
                    //     path: '/user/controlList',
                    //     name: 'controlList',
                    //     label: '管理列表',
                    // }
                ],
                authority:1
            }
        },
        // created(){
            
        // },
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

<style lang="less" scoped>
    a {
        text-decoration: none;
    }

    .router-link-active {
        text-decoration: none;
    }
</style>