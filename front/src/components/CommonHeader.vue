<template>
    <el-menu router="router" class="el-menu" mode="horizontal" background-color="#071E3A" text-color="#fff"
        active-text-color="#ffd04b">
        <el-menu-item index="/home/notice">
            <template>
                <img :src="logoImg" height="90%" width="100%">
            </template>
        </el-menu-item>
        <el-menu-item v-for="item in menu" :index="item.path" :key="item.path">
            <i class="'el-icon-' + item.icon"></i>
            <span slot="title">{{item.label}}</span>
        </el-menu-item>
        <div class="r-content">
            <!-- 搜索栏 -->
            <div class="search-box">
                <form action="" @submit.prevent="search">
                    <input type="text" v-model="searchText" placeholder="搜索帖子名字">
                    <el-button icon="el-icon-search" size="mini"></el-button>
                </form>
            </div>
            <el-dropdown trigger="click" size="mini">
                <span>
                    <img class="user" :src="userImg">
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item>
                        <router-link to="/user/basicInfo">
                            用户中心
                        </router-link>
                    </el-dropdown-item>
                    <el-dropdown-item>
                        <span @click="logout">注销</span>
                    </el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </div>
    </el-menu>
</template>

<script>
    export default {
        data() {
            return {
                searchText: '',
                logoImg: require("../assets/logo.png"),
                userImg: null,
                user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")):{},
                menu: [{
                        path: '/home/notice',
                        name: 'home',
                        label: '首页',
                        icon: 's-home',
                    },
                    {
                        path: '/user/basicInfo',
                        name: 'user',
                        label: '用户中心',
                        icon: 'user',
                    },
                    {
                        path: '/help/help',
                        name: 'help',
                        label: '帮助',
                        icon: 'help',
                    }
                ]
            };
        },
        created(){
            this.userImg=this.user.avatarUrl
        },
        methods: {
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            },
            logout(){
                this.$router.push("/login")
                localStorage.removeItem("user")
                this.$message.success("退出成功")
            }
        }
    }
</script>
<style lang="less" scoped>
    header {
        display: flex;
        height: 100%;
        justify-content: space-between;
        align-items: center;
    }

    .r-content {
        float: right;

        .user {
            float: right;
            margin: 10px 40px 0 50px;
            width: 40px;
            height: 40px;
            border-radius: 50%;
        }

        .search-box {
            float: left;
            height: 20x;
            margin: 15px 0 0 50px;
            border-radius: 5px;
            background-color: #fff;

            input {
                background: none;
                border: none;
                outline: none;
                height: 20px;
                line-height: 20px;
                font-size: 16px;
                margin: 5px 25px 0 25px;
            }

            &:hover {
                box-shadow: 0 0 6px rgba(0, 0, 0, 0.5);
            }
        }
    }

    a {
        text-decoration: none;
    }

    .router-link-active {
        text-decoration: none;
    }
</style>