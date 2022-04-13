<template>
    <el-row :gutter="20">
        <el-col :span="24">
            <el-card>
                <el-button @click="comeBack"> 返回</el-button>
                <div class="postDetail">
                    <ul>
                        <li>
                            <div class="postItem">
                                <div class="left">
                                    <div class="no">
                                        1L
                                    </div>
                                    <img class="user" src="../../src/assets/default.jpg" alt="">
                                    <p>Ace</p>
                                </div>
                                <div class="right">
                                    <div class="sendTime">
                                        发表于 2022-3-7 15:07
                                    </div>
                                    <div class="content">
                                        内容
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="postItem">
                                <div class="left">
                                    <div class="no">
                                        1L
                                    </div>
                                    <img class="user" src="../../src/assets/default.jpg" alt="">
                                    <p>Ace</p>
                                </div>
                                <div class="right">
                                    <div class="sendTime">
                                        发表于 2022-3-7 15:07
                                    </div>
                                    <div class="content">
                                        内容
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="postItem">
                                <div class="left">
                                    <div class="no">
                                        1L
                                    </div>
                                    <img class="user" src="../../src/assets/default.jpg" alt="">
                                    <p>Ace</p>
                                </div>
                                <div class="right">
                                    <div class="sendTime">
                                        发表于 2022-3-7 15:07
                                    </div>
                                    <div class="content">
                                        内容
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
                <el-card style="height:300px;">
                    <el-form ref="form" :model="form" label-width="80px">
                        <el-form-item label="开启匿名">
                            <el-switch v-model="form.hidden"></el-switch>
                        </el-form-item>
                        <el-form-item label="发表评论">
                            <el-input type="textarea" v-model="form.content" :rows="5"></el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="onSubmit" size="big">提交</el-button>
                        </el-form-item>
                    </el-form>
                </el-card>
                <el-pagination background layout="prev, pager, next" :total="1000">
                </el-pagination>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>
    export default {
        data() {
            return {
                form: {
                    name: '',
                    hidden:false,
                    content: '',
                },
            }
        },
        methods: {
            onSubmit() {
                console.log('submit!');
            },
            comeBack() {
                undefined
                this.$router.go(-1);
            }
            
        }
    }
</script>

<style lang="less" scoped>
    .user {
        border: 6px #fff solid;
        margin-top: 10px;
        width: 120px;
        height: 120px;
    }

    .el-card {
        height: 1400px;

    }

    .el-col {
        margin-top: 20px;
    }

    .postDetail {
        height: 900px;
    }

    .postItem {
        border-bottom: 6px solid #c2d5e3;
    }

    .left {
        width: 200px;
        height: 216px;
        padding: 0px;
        float: left;
        text-align: center;
        background-color: #e5edf2;
    }

    .left .no {
        width: 200px;
        height: 36px;
        line-height: 36px;
        border-bottom: 1px #ccc dashed;
        background-color: #e5edf2;
        text-align: center;
    }

    .right {
        min-height: 216px;
        background-color: #fffbf0;
        overflow: hidden;
        padding: 0 6px;
    }

    .right .sendTime {
        height: 36px;
        line-height: 36px;
        border-bottom: #ccc dashed;
    }

    .right .content {}

    ul {
        margin: 0;
        padding: 0;
        margin-top: 10px;
        list-style: none;
    }

    p {
        margin: 0;
        padding: 0;
    }

    .el-pagination {
        padding: 20px;
        text-align: center;
    }
</style>