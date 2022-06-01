<template>
    <el-row :gutter="20">
        <el-col :span="24">
            <el-card>
                <div class="search-box">
                <form action="" @submit.prevent="search">
                        <input type="text" v-model="searchText" placeholder="搜索帖子名字">
                        <el-button primary icon="el-icon-search" size="mini" ></el-button>
                    </form>
                </div>
                <el-table :data="postListData">
                    <el-table-column prop="postName" label="帖子名字"></el-table-column>
                    <el-table-column prop="creatorId" label="发表者"></el-table-column>
                    <el-table-column prop="lastTime" label="最新回复时间"></el-table-column>
                    <el-table-column prop="clickNum" label="点击量"></el-table-column>
                    <el-table-column prop="createTime" label="创建时间"></el-table-column>
                </el-table>
                <el-pagination background 
                    layout="total,prev, pager, next" 
                    :page-size="pageSize" 
                    :current-page="pageNum"
                    :total="total">
                </el-pagination>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>
    export default {
        data() {
            return {
                tableData:[]
            }
        },
        methods: {
            search(searchName){
                this.request.get("/post/" + searchName).then(
                    res =>{
                        localStorage.setItem('section',JSON.stringify(res.data))
                        this.request.get("/post/page",{
                            params:{
                                // pageNum:this.pageNum,
                                // pageSize:this.pageSize,
                                sectionId:JSON.parse(localStorage.getItem("section")).id
                            }
                        }).then(
                            res =>{
                                this.postListData=[]
                                for(var i = 0; i < res.data.postList.length; i++){
                                    this.postListData.push(res.data.postList[i])
                                    this.postListData[i].creatorName = res.data.userList[i].username
                                }
                                // this.postListData = res.data.postList
                                // this.userListData = res.data.userList
                                this.total=res.data.total
                            }
                        )
                    })
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