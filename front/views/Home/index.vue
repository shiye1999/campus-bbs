<template>
    <el-container style="height:100%">
        <el-header>
            <common-header @refreshSearch="getResult($event)"></common-header>
        </el-header>
        <el-container>
            <el-aside width="200px">
                <common-aside @refreshSection="getSection($event)"></common-aside>
            </el-aside>
            <el-main>
                <router-view 
                :postListData="postListData" 
                :commentListData="commentListData" 
                :userListData="userListData"
                @refreshSearch="getResult($event)">
                </router-view>
            </el-main>
        </el-container>
    </el-container>
</template>
<script>
    import CommonHeader from '../../src/components/CommonHeader.vue'
    import CommonAside from '../../src/components/CommonAside.vue'
    export default {
        name: 'viewHome',
        components: {
            CommonAside,
            CommonHeader,
        },
        
        data() {
            return {
                postListData: [],
                userListData : [],
                commentListData:[],
                total: 0,
                pageNum: 1,
                pageSize: 8,
            }
        },
        methods:{
            getSection(sectionName){
                this.request.get("/section/" + sectionName).then(
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
                    }
                )
                this.postListData.forEach(element => {
                    this.request.get("/user/"+element.creatorId).then(
                        res => {
                            element.creatorName = res.data.username
                        }
                    )
                })
            },
            getResult(postName){

            }
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