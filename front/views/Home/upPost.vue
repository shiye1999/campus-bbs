<template>
    <el-row class="info" :gutter="24">
        <el-col :span="24" style="margin-top:20px">
            <el-card style="height:600px;">
                <el-form ref="form" :model="form" label-width="80px">
                    <el-form-item label="帖子名称">
                        <el-input v-model="form.name"></el-input>
                    </el-form-item>
                    <el-form-item label="所属板块">
                        <el-select v-model="form.region" placeholder="所属板块">
                            <el-option label="学术研讨" value="study"></el-option>
                            <el-option label="日常生活" value="daily"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="发表内容">
                        <el-input type="textarea" v-model="form.content" :rows="8"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">发表</el-button>
                        <el-button @click="comeBack">返回</el-button>
                    </el-form-item>
                </el-form>
            </el-card>
        </el-col>
    </el-row>
</template>

<script>
    export default {
        name: "upPost",
        data() {
            return {
                form: {
                    name: '',
                    region: '',
                    section: '',
                    hidden: false,
                    type: [],
                    content: ''
                },
                value: [],

            };
        },
        methods: {
            handleChange(value) {
                console.log(value);
            },
            onSubmit() {
                
            },
            comeBack() {
                undefined
                this.$router.go(-1);
            }
        }
    }
</script>