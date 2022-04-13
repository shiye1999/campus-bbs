<template>
    <el-menu default-active="1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
        :unique-opened="true" :collapse="false">
        <el-menu-item v-for="item in menu" :key="item.path">
            <router-link :to="item.path">
                <el-menu-item :index="subIndex">
                    <span class="item">
                        {{item.label}}
                    </span>
                </el-menu-item>
            </router-link>
        </el-menu-item>
    </el-menu>
</template>

<script>
    export default {
        data() {
            return {
                menu: [
                    {
                        path: '/home/notice',
                        name: 'notice',
                        label: '首页',
                        icon: '',
                    },
                    {
                        path: '/home/study',
                        name: 'study',
                        label: '学术探讨',
                        icon: '',
                    },
                    {
                        path: '/home/daily',
                        name: 'daily',
                        label: '日常生活',
                        icon: '',
                    },
                    {
                        path: '/home/test',
                        name: 'test',
                        label: '测试页面',
                        icon: '',
                    },
                ]
            }
        },
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            }
        }
    }
</script>

<style lang="less" scoped>
    .subItem {
        color: #c0c0c0;
    }

    a {
        text-decoration: none;
    }

    .router-link-active {
        text-decoration: none;
    }
</style>