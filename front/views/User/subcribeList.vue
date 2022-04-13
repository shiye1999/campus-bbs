<template>
    <el-row class="userInfo" :gutter="20">
        <el-col :span="24">
            <el-card>
                <el-table :data="tableData">
                    <el-table-column v-for="(val,key) in tableLabel" :key="key" :prop="key" :label="val">
                    </el-table-column>
                    <el-table-column label="操作" :render-header="renderHeader" width="150">
                        <template slot-scope="scope">
                            <el-button type="danger" icon="el-icon-delete" size="mini"
                                @click="handleDel(scope.$index, scope.row)" circle></el-button>
                        </template>
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
                    number: "学号",
                    time: "关注时间",
                },
                tableData: [
                {
                    avatar: "头像",
                    name: "名字",
                    number: 11811202,
                    time: "2022/3/3",
                },
                {
                    avatar: "头像",
                    name: "名字",
                    number: 11811202,
                    time: "2022/3/3",
                    unfollow: "取消关注",
                },
                ]
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