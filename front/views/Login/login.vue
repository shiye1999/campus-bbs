<template>
    <div class="wrapper">
        <el-card class="login-form-layout">
            <el-form autocomplete="on" :model="loginForm" ref="loginForm" label-position="left" :rules="rules">
                <h2 class="login-title color-main">登 录</h2>
                <el-form-item prop="username">
                    <el-input name="username" type="text" @keyup.enter.native="login"
                        v-model="loginForm.username" autocomplete="on" placeholder="请输入用户名">
                        <span slot="prefix"></span>
                    </el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input name="password" :type="pwdType" @keyup.enter.native="login"
                        v-model="loginForm.password" autocomplete="on" placeholder="请输入密码">
                        <span slot="prefix"></span>
                        <span slot="suffix" @click="showPwd"></span>
                    </el-input>
                </el-form-item>
                <el-form-item style="margin-bottom: 60px">
                    <el-button style="width: 100%" type="primary" :loading="loading" @click.native.prevent="login">登录
                    </el-button>
                </el-form-item>
            </el-form>
            <div class="register">
                还没有注册？<a href="/register">注册</a>
            </div>
        </el-card>
    </div>
</template>

<script>
    export default {
        name: "viewLogin",
        data() {
            return {
                loginForm: {
                    username: "",
                    password: ""
                },
                loading: false,
                pwdType: "password",
                rules: {
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
                }
            }
        },
        methods: {
            showPwd() {
                if (this.pwdType === "password") {
                    this.pwdType = "";
                } else {
                    this.pwdType = "password";
                }
            },
            login() {
                this.$refs["loginForm"].validate((valid) => {
                    if (valid) {
                        this.request.post("/user/login", this.loginForm).then(res => {
                            console.log(res)
                            if (res.code === "200") {
                                localStorage.setItem("user",JSON.stringify(res.data)) // 存储用户信息到浏览器
                                this.$router.push("/home/notice")
                                this.$message.success("登陆成功")
                            } else {
                                this.$message.error(res.msg)
                            }
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
                
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
        margin: 140px auto;
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

    .register {
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