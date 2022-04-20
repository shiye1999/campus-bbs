<template>
    <el-menu default-active="$route.path" class="el-menu-vertical-demo" router @open="handleOpen" @close="handleClose"
        :unique-opened="true" :collapse="false" style="text-align:center">
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
            },
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            },
            clickMenu(item) {
                this.$router.push({
                    name: item.name,
                    activeIndex: item.path
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