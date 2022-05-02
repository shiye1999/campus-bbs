<template>
    <div class="wrapper">
        <el-card class="login-form-layout">
            <el-form autocomplete="on" :model="registerForm" ref="registerForm" label-position="left" :rules="rules">
                <div style="text-align: center"></div>
                <h2 class="login-title color-main">注 册</h2>
                <el-form-item prop="schoolNumber">
                    <el-input name="schoolNumber" type="text" v-model="registerForm.schoolNumber" autocomplete="on"
                        placeholder="请输入学号">
                        <span slot="prefix"></span>
                    </el-input>
                </el-form-item>
                <el-form-item prop="username">
                    <el-input name="username" type="text" v-model="registerForm.username" autocomplete="on"
                        placeholder="请输入用户名">
                        <span slot="prefix"></span>
                    </el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input name="password" :type="pwdType" @keyup.enter.native="register"
                        v-model="registerForm.password" autocomplete="on" placeholder="请输入密码">
                        <span slot="prefix"></span>
                        <span slot="suffix" @click="showPwd"></span>
                    </el-input>
                </el-form-item>
                <el-form-item prop="rePassword">
                    <el-input name="rePassword" :type="pwdType" @keyup.enter.native="register"
                        v-model="registerForm.rePassword" autocomplete="on" placeholder="请重复密码">
                        <span slot="prefix"></span>
                        <span slot="suffix" @click="showPwd"></span>
                    </el-input>
                </el-form-item>
                <el-form-item style="margin-bottom: 60px">
                    <el-button style="width: 100%" type="primary" :loading="loading"
                        @click.native.prevent="register">注册</el-button>
                </el-form-item>
            </el-form>
            <div class="back">
                <el-button @click="comeBack" class="back">返回</el-button>
            </div>
        </el-card>
    </div>
</template>

<script>
    export default {
        name: "viewRegister",
        data() {
            return {
                registerForm: {
                    schoolNumber: "11811212",
                    username: "user9",
                    password: "123456",
                    rePassword: "123456",
                },
                loading: false,
                pwdType: "password",
                rules: {
                    studentNum: [{
                            required: true,
                            message: '请输入学号',
                            trigger: 'blur'
                        },
                        {
                            min: 8,
                            max: 8,
                            message: '长度为 8 个字符',
                            trigger: 'blur'
                        }
                    ],
                    username: [{
                            required: true,
                            message: '请输入用户名',
                            trigger: 'blur'
                        },
                        {
                            min: 3,
                            max: 10,
                            message: '长度在 3 到 10 个字符',
                            trigger: 'blur'
                        }
                    ],
                    password: [{
                            required: true,
                            message: '请输入密码',
                            trigger: 'blur'
                        },
                        {
                            min: 6,
                            max: 20,
                            message: '长度在 6 到 20 个字符',
                            trigger: 'blur'
                        }
                    ],
                    rePassword: [{
                            required: true,
                            message: '请输入密码',
                            trigger: 'blur'
                        },
                        {
                            min: 6,
                            max: 20,
                            message: '长度在 6 到 20 个字符',
                            trigger: 'blur'
                        }
                    ]
                }
            };
        },
        methods: {
            showPwd() {
                if (this.pwdType === "password") {
                    this.pwdType = "";
                } else {
                    this.pwdType = "password";
                }
            },
            register() {
                this.$refs["registerForm"].validate((valid) => {
                    if (valid) {
                        this.request.post("/user/register", this.registerForm).then(res => {
                            console.log(this.registerForm)
                            console.log(res)
                            if (res.code === "200") {
                                this.$router.push("/login")
                                this.$message.success("注册成功")
                            } else {
                                this.$message.error(res.msg)
                            }
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            onSubmit() {},
            comeBack() {
                undefined
                this.$router.go(-1);
            }
        }
    };
</script>

<style scoped>
    .login-form-layout {
        position: absolute;
        left: 0;
        right: 0;
        width: 360px;
        margin: 100px auto;
        border-top: 10px solid #409eff;
    }

    .login-title {
        text-align: center;
    }

    .login-center-layout {
        background: #409eff;
        width: auto;
        height: auto;
        max-width: 100%;
        max-height: 100%;
        margin-top: 200px;
    }

    .back{
        text-align: center;
    }

    a {
        text-align: center;
        text-decoration: none;
    }

    .wrapper {
        height: 100vh;
        background-image: linear-gradient(to bottom right, #FC466B, #3F5EF8);
        overflow: hidden;
    }
</style>