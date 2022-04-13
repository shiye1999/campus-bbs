<template>
    <el-row :gutter="20">
        <el-col :span="24">
            <el-card class="box-card">
                <el-card class="box">
                    <div>
                        问题
                    </div>
                    <br>
                    <div>
                        解答
                    </div>
                </el-card>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>
    export default {
        name:"helpPage",
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