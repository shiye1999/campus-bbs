<template>
    <el-row :gutter="20">
        <el-col :span="24">
            <el-card class="box-card">
                <div slot="header" class="clearfix">
                    <span>更新日志</span>
                </div>
                <div class="text item">
                    <p>前端基本框架 完成</p>
                    <p>后端基本框架 完成</p>
                    <p>帖子列表（加分页器） 完成</p>
                    <p>水楼和回复界面（加返回和分页器）完成</p>
                    <p>连接前后端 完成</p>
                    <p>代码生成器 完成</p>
                    <p>上云 完成</p>
                    <p>实现注册 完成</p>
                    <p>实现粉丝关注列表 完成</p>
                    <p>实现头像上传 完成</p>
                    <p>实现头像修改 完成</p>
                    <p>实现用户专业认证，用户名前加标即可 完成</p>

                    <p>实现根据帖子名字搜索</p>
                    <p>实现发帖</p>
                    <p>实现评论时通知粉丝</p>
                    <p>添加管理员相关功能，用户中心里加</p>
                    <p>修改论文</p>

                    <p>去掉匿名功能 完成</p>
                    <p>父子组件传值问题 完成</p>
                    <p>多表查询构建表格数据 完成</p>
                </div>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>
    export default {
        name: "noticePage",
        data() {
            return {

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

    .text {
        font-size: 14px;
    }

    .item {
        margin-bottom: 18px;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }

    .clearfix:after {
        clear: both
    }
</style>