<template>
    <el-container style="height:100%">
        <el-header>
            <common-header></common-header>
        </el-header>
        <el-container>
            <el-aside width="200px">
                <user-aside></user-aside>
            </el-aside>
            <el-main>
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>
<script>
    import CommonHeader from '../../src/components/CommonHeader.vue'
    import UserAside from '../../src/components/UserAside.vue'
    export default {
        name: 'viewUser',
        components: {
            UserAside,
            CommonHeader,
        },
        data() {
            return {}
        }
    }
</script>
<style lang="less" scoped>
    .el-header {
        background-color: #333;
        padding: 0;
    }
    .el-main {
        padding-top: 0;
    }
</style>