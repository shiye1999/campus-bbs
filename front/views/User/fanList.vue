<template>
    <el-row class="userInfo" :gutter="20">
        <el-col :span="24">
            <el-card>
                <el-table :data="tableData" stripe>
                    <el-table-column prop="avatarUrl" label="头像" width="300px">
                        <template v-slot:default="scope">
                            <el-image class="userImg" :src="scope.row.avatarUrl"/>
                        </template>
                    </el-table-column>
                    <el-table-column v-for="(val,key) in tableLabel" :key="key" :prop="key" :label="val">
                    </el-table-column>
                    <el-table-column label="操作" width="150">
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
                userImg: require("../../src/assets/default.jpg"),
                avatarLabel:{
                    avatarUrl:"头像"
                },
                tableLabel: {
                    username: "用户名",
                    schoolNumber: "学号",
                },
                tableData: [
                ]
            }
        },
        created() {
            this.load()
        },
        methods: {
            load(){
                this.request.get("/user/relation/subscriberList").then(
                    res =>{
                        console.log(res)
                        this.tableData=res.data
                    }
                )
            },
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

    .userImg {
        width: 40px;
        height: 40px;
        border-radius: 50%;
    }
</style>