<template>
    <el-row :gutter="20">
        <el-col :span="24">
            <el-card>
                <router-link to="/home/upPost">
                    <el-button type="primary">发表帖子</el-button>
                </router-link>
                <el-table :data="postListData" stripe>
                    <el-table-column prop="postName" label="帖子名字" @click="intoPost">
                    <template slot-scope="scope">
                        <a href="/postMain" target="_blank" class="buttonText">{{scope.row.postName}}</a>
                    </template>
                    </el-table-column>
                    <el-table-column prop="creatorId" label="发表者"></el-table-column>
                    <el-table-column prop="clickNum" label="点击量" sortable></el-table-column>
                    <el-table-column prop="lastTime" label="最新回复时间" sortable></el-table-column>
                    <el-table-column prop="createTime" label="创建时间" sortable></el-table-column>
                </el-table>
                <el-pagination background 
                    layout="total,prev, pager, next" 
                    :page-size="pageSize" 
                    :current-page="pageNum"
                    :total="total" >
                </el-pagination>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>
    export default {
        data() {
            return {
            }
        },
        props: ['postListData','userListData','total','pageNum','pageSize'],
        methods: {
            intoPost(){

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