<template>
    <el-row class="userInfo" :gutter="20">
        <el-col :span="24">
            <el-card>
                <el-table :data="tableData">
                    <el-table-column v-for="(val,key) in tableLabel" :key="key" :prop="key" :label="val">
                    </el-table-column>
                </el-table>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>
    export default {
        data() {
            return {
                userImg: require("../../src/assets/user.png"),
                tableLabel: {
                    avatar: "头像",
                    name: "用户名",
                    type: "类型",
                    postName: "帖子名字",
                    region: "板块",
                    section: "分区",
                    time: "发表时间",
                },
                tableData: [{
                    avatar: "头像",
                    name: "用户名",
                    type: "类型",
                    postName: "帖子名字",
                    postLink: "帖子链接",
                    region: "板块",
                    section: "分区",
                    time: "2022/3/3",
                }]
            }
        }
    }
</script>

<style lang="less" scoped>
    .el-card {
        height: 600px;

        .user {
            margin-top: 10px;
            width: 80px;
            height: 80px;
            border-radius: 50%;
        }

        .userInfo {
            margin-top: 20px;
        }
    }

    .el-col {
        margin-top: 20px;
    }
</style>