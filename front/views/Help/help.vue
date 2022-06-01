<template>
    <el-row :gutter="20">
        <el-col :span="24">
            <el-card class="box-card">
                <div slot="header" class="clearfix" style="margin-top:20px">
                    <span>Q & A</span>
                </div>
                <b>
                    如何关注用户？
                </b>
                <br>
                <div>
                    可以在用户中心输入关注用户的学号，或者在回复界面点击关注。
                </div>
                <br>
                <b>
                    如何成为认证用户或管理员？
                </b>
                <br>
                <div>
                    论坛还没有添加在线认证功能，联系管理者qq2532880745，发送认证材料（学号，证明图片等）。
                </div>
                <br>
                <b>
                    如何查看论坛代码？
                </b>
                <br>
                <div>
                    GitHub地址：https://github.com/shiye1999/campus-bbs
                </div>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>
    export default {
        name: "helpPage",
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