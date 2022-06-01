<template>
    <el-row class="userInfo" :gutter="20">
        <el-col :span="6" style="height:600px">
            <el-card>
                <el-row>
                    <div align="center">
                        <img class="user" :src="userImg">
                    </div>
                    <el-descriptions class="userInfo" title="" :column="1" border>
                        <el-descriptions-item label="用户名">
                            <i class="el-icon-user-solid" v-if="userInfo.authority == 1"></i>
                            <i class="el-icon-star-on" v-if="userInfo.authority == 2"></i>
                            {{userInfo.username}}
                        </el-descriptions-item>
                        <el-descriptions-item label="学号">{{userInfo.schoolNumber}}</el-descriptions-item>
                        <el-descriptions-item label="角色" v-if="userInfo.authority == 1">管理员</el-descriptions-item>
                        <el-descriptions-item label="角色" v-if="userInfo.authority == 2">认证用户</el-descriptions-item>
                        <el-descriptions-item label="角色" v-if="userInfo.authority == 3">普通用户</el-descriptions-item>
                        <el-descriptions-item label="关注数">{{subscriberNumber}}</el-descriptions-item>
                        <el-descriptions-item label="粉丝数">{{publisherNumber}}</el-descriptions-item>
                        <el-descriptions-item label="总发帖数">{{userInfo.commentNumber}}</el-descriptions-item>
                        <el-descriptions-item label="创建时间">{{userInfo.createTime}}</el-descriptions-item>
                    </el-descriptions>
                </el-row>
            </el-card>
        </el-col>
        <el-col :span="18" class="box">
            <el-card style="height:250px">
                <div slot="header" class="clearfix" style="margin-top:20px">
                    <span>修改头像</span>
                </div>
                <div class="changeAvatar">
                    <el-upload
                        class="avatar-uploader"
                        action="http://localhost:8081/file/upload"
                        :show-file-list="false"
                        :on-success="handleAvatarSuccess"
                    >
                        <img v-if="userImg" :src="userImg" class="avatar">
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                </div>
            </el-card>
            <el-card style="height:300px padding:20px">
                <div slot="header" class="clearfix" style="margin-top:20px">
                    <span>修改用户名</span>
                </div>
                <el-form autocomplete="on" :model="usernameForm" ref="usernameForm" label-position="left">
                    <el-form-item prop="username">
                        <el-input name="username" type="text" v-model="usernameForm.username" autocomplete="on"
                            placeholder="请输入新的用户名">
                            <span slot="prefix"></span>
                        </el-input>
                    </el-form-item>
                    <el-form-item style="margin-bottom: 20px">
                        <el-button style="width: 10%" type="primary" :loading="loading"
                            @click.native.prevent="changeName">提交
                        </el-button>
                    </el-form-item>
                </el-form>
            </el-card>
            <el-card style="height:300px margin-top:20px">
                <div slot="header" class="clearfix">
                    <span>修改密码</span>
                </div>
                <el-form autocomplete="on" :model="passwordForm" ref="passwordForm" label-position="left">
                    <el-form-item prop="password">
                        <el-input name="password" type="text" v-model="passwordForm.password" autocomplete="on"
                            placeholder="请输入旧的密码">
                            <span slot="prefix"></span>
                        </el-input>
                    </el-form-item>
                    <el-form-item prop="rePassword">
                        <el-input name="rePassword" type="text" v-model="passwordForm.rePassword" autocomplete="on"
                            placeholder="请输入新的密码">
                            <span slot="prefix"></span><span slot="suffix"></span>
                        </el-input>
                    </el-form-item>
                    <el-form-item style="margin-bottom: 20px">
                        <el-button style="width: 10%" type="primary" :loading="loading"
                            @click.native.prevent="changePWD">提交</el-button>
                    </el-form-item>
                </el-form>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>
    export default {
        data() {
            return {
                userImg:null,
                user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
                userInfo: {},
                subscriberNumber: 0,
                publisherNumber: 0,
                commentNumber: 0,
                usernameForm: {
                    username: "",
                },
                passwordForm: {
                    password: "",
                    rePassword: ""
                },
                loading: false,
            }
        },
        created() {
            this.request.get("/user/" + this.user.id).then(
                res => {
                    console.log(res)
                    this.userInfo = res.data
                }
            )
            this.request.get("/user/relation/subscriberNumber").then(
                res => {
                    console.log(res)
                    this.publisherNumber = res.data
                }
            )
            this.request.get("/user/relation/publisherNumber").then(
                res => {
                    console.log(res)
                    this.subscriberNumber = res.data
                }
            )
            this.request.get("/comment/commentNumber/" + this.user.id).then(
                res => {
                    console.log(res)
                    this.commentNumber = res.data
                }
            )
            this.userImg=this.user.avatarUrl
        },
        methods: {
            async getUser() {
                return (await this.request.get("/user/username/" + this.user.username)).data
            },
            changePWD() {
                this.request.post("/user/updatePWD", this.passwordForm).then(res => {
                    console.log(res)
                    if (res.code === "200") {
                        this.$message.success("修改成功，请重新登录")
                    } else {
                        this.$message.error(res.msg)
                    }
                    if (res.code === "200") {
                        location.reload()
                    }
                })
            },
            changeName() {
                this.request.post("/user/updateName", this.usernameForm).then(res => {
                    console.log(res)
                    if (res.code === "200") {
                        this.$message.success("修改成功")
                    } else {
                        this.$message.error(res.msg)
                    }
                    location.reload()
                })
            },
            handleAvatarSuccess(res) {
                this.userImg = res
                this.user.avatarUrl = res
                localStorage.setItem("user",JSON.stringify(this.user))
                this.request.post("/user/updateAvatarUrl?avatarUrl="+res).then(
                    res => {
                        console.log(res)
                    }
                )
                location.reload()
            }
        }
    }
</script>

<style lang="less" scoped>
    .el-card {

        .user {
            margin-top: 10px;
            width: 80px;
            height: 80px;
            border-radius: 50%;
        }

        .userInfo {
            margin-top: 20px;
        }

        margin-bottom:20px; //下边距
    }

    .el-col {
        margin-top: 20px;
    }

    .el-input {
        margin-top: 10px;
    }

    .el-button {
        margin-top: 10px;
    }

    .box {
        height: 80%;
        display: flex;
        flex-direction: column; //起作用的是这个，没有的话会变成下图的样子，卡片跑到右边去了
    }


    .changeAvatar {
        margin-top: 10px;
    }

    .changeName {
        margin-top: 10px;
    }

    .changePwd {
        margin-top: 10px;
    }

    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }

    .avatar-uploader .el-upload:hover {
        border-color: #409EFF;
    }

    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 98px;
        height: 98px;
        line-height: 98px;
        text-align: center;
    }

    .avatar {
        width: 98px;
        height: 98px;
        display: block;
        border-radius: 50%;
    }
</style>