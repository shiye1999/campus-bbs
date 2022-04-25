<template>
    <el-row :gutter="20">
        <el-col :span="24">
            <el-card>
                <router-link to="/home/upPost">
                    <el-button type="primary">发表帖子</el-button>
                </router-link>
                <el-table :data="tableData">
                    <el-table-column prop="schoolNumber" label="学号"></el-table-column>
                    <el-table-column prop="username" label="名字"></el-table-column>
                    <el-table-column prop="createTime" label="创建时间"></el-table-column>
                </el-table>
                <el-pagination background layout="total,prev, pager, next" page-size="8" :current-page="pageNum"
                    :total="total" @current-change="handleCurrentChange">
                </el-pagination>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>
    export default {
        data() {
            return {
                tableData: [],
                total: 0,
                pageNum: 1,
            }
        },
        created() {
            this.load()
        },
        
        methods: {
            load(){
                //请求分页查询数据
                this.request.get("/user/page",{
                    params:{
                        pageNum:1,
                        pageSize:8,
                    }
                }).then(
                    res =>{
                        console.log(res)
                        this.tableData=res.records
                        this.total=res.total
                    }
                )
            },
            handleCurrentChange(pageNum) {
                this.pageNum=pageNum
                this.load()
            }
        }

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