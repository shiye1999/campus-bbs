<template>
    <el-row :gutter="20">
        <el-col :span="24">
            <el-card class="box-card">
                <div slot="header" class="clearfix">
                    <span>通知</span>
                </div>
                <div v-for="o in 4" :key="o" class="text item">
                    {{'更新 ' + o }}
                </div>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>
    export default {
        name:"noticePage",
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