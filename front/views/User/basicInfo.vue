<template>
    <el-row class="userInfo" :gutter="20">
        <el-col :span="6">
            <el-card>
                <el-row>
                    <div align="center">
                        <img class="user" :src="userImg">
                    </div>
                    <el-descriptions class="userInfo" title="" :column="1" border>
                        <el-descriptions-item label="用户名">admin</el-descriptions-item>
                        <el-descriptions-item label="学号">11811202</el-descriptions-item>
                        <el-descriptions-item label="角色">管理员</el-descriptions-item>
                        <el-descriptions-item label="关注数">0</el-descriptions-item>
                        <el-descriptions-item label="粉丝数">0</el-descriptions-item>
                        <el-descriptions-item label="总发帖数">0</el-descriptions-item>
                        <el-descriptions-item label="创建时间">2022/2/22</el-descriptions-item>
                    </el-descriptions>
                </el-row>
            </el-card>
        </el-col>
        <el-col :span="18">
            <el-card>
                <div class="changeAvatar">
                    <div slot="header" class="clearfix">
                        <span>修改头像</span>
                    </div>
                    <el-upload class="avatar-uploader" action="https://jsonplaceholder.typicode.com/posts/"
                        :show-file-list="false" :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload">
                        <img v-if="imageUrl" :src="imageUrl" class="avatar">
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                </div>
                <hr>
                <div class="changeName">
                    <p class="newName">
                        新用户名<el-input v-model="input" placeholder="请输入新的用户名"></el-input>
                    </p>
                    <el-button type="primary">提交</el-button>
                </div>
                <hr>
                <div class="changePwd">
                    <p class="oldPwd">
                        旧密码<el-input v-model="input" placeholder="请输入旧的密码"></el-input>
                    </p>
                    <p class="newPwd">
                        新密码<el-input v-model="input" placeholder="请输入新的密码"></el-input>
                    </p>
                    <el-button type="primary">提交</el-button>
                </div>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>
    export default {
        data() {
            return {
                userImg: require("../../src/assets/user.png"),
            }
        },
        metheds: {
            handleAvatarSuccess(res, file) {
                this.imageUrl = URL.createObjectURL(file.raw);
            },
            beforeAvatarUpload(file) {
                const isJPG = file.type === 'image/jpeg';
                const isLt2M = file.size / 1024 / 1024 < 2;

                if (!isJPG) {
                    this.$message.error('上传头像图片只能是 JPG 格式!');
                }
                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 2MB!');
                }
                return isJPG && isLt2M;
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

    .el-input {
        margin-top: 10px;
    }

    .el-button {
        margin-top: 10px;
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
    }
</style>
