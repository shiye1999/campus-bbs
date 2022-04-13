<template>
    <el-row :gutter="20">
        <el-col :span="24">
            <el-card>
                <router-link to="/home/upPost">
                    <el-button type="primary">发表帖子</el-button>
                </router-link>
                <el-table :data="tableData">
                    <el-table-column v-for="(val,key) in tableLabel" :key="key" :prop="key" :label="val">
                    </el-table-column>
                </el-table>
                <el-pagination background layout="prev, pager, next" :total="100">
                </el-pagination>
                <el-input></el-input>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>
    export default {
        data() {
            return {
                tableLabel: {
                    name: "帖子名字",
                    creaetor: "创建者",
                    clickNum: "点击量",
                    lastTime: "最近回复",
                    creatTime: "发表时间",
                },
                tableData: [{
                    name: "帖子名字",
                    creaetor: "创建者",
                    clickNum: "点击量",
                    lastTime: "最近回复",
                    creatTime: "发表时间",
                }]
            }
        },
        
    }
</script>

<style lang="less" scoped>
    .el-card {
        height: 600px;

    }

    .el-col {
        margin-top: 20px;
    }

    .el-table {
        margin-top: 20px;
        height: 460px;
    }

    .el-pagination {
        text-align: center;
    }
</style>