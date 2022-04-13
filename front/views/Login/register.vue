<template>
    <div>
        <el-card class="login-form-layout">
            <el-form autocomplete="on" :model="registerForm" ref="registerForm" label-position="left">
                <div style="text-align: center">
                    <svg-icon icon-class="login-mall" style="width: 56px;height: 56px;color: #409EFF"></svg-icon>
                </div>
                <h2 class="login-title color-main">注册页面</h2>
                <el-form-item prop="studentnum">
                    <el-input name="studentnum" type="text" v-model="registerForm.studentnum" autocomplete="on"
                        placeholder="请输入学号">
                        <span slot="prefix">
                            <svg-icon icon-class="user" class="color-main"></svg-icon>
                        </span>
                    </el-input>
                </el-form-item>
                <el-form-item prop="username">
                    <el-input name="username" type="text" v-model="registerForm.username" autocomplete="on"
                        placeholder="请输入用户名">
                        <span slot="prefix">
                            <svg-icon icon-class="user" class="color-main"></svg-icon>
                        </span>
                    </el-input>
                </el-form-item>
                <el-form-item prop="firstpassword">
                    <el-input name="firstpassword" :type="pwdType" @keyup.enter.native="handleRegister"
                        v-model="registerForm.firstpassword" autocomplete="on" placeholder="请输入密码">
                        <span slot="prefix">
                            <svg-icon icon-class="firstpassword" class="color-main"></svg-icon>
                        </span>
                        <span slot="suffix" @click="showPwd">
                            <svg-icon icon-class="eye" class="color-main"></svg-icon>
                        </span>
                    </el-input>
                </el-form-item>
                <el-form-item prop="secondpassword">
                    <el-input name="secondpassword" :type="pwdType" @keyup.enter.native="handleRegister"
                        v-model="registerForm.secondpassword" autocomplete="on" placeholder="请重复密码">
                        <span slot="prefix">
                            <svg-icon icon-class="secondpassword" class="color-main"></svg-icon>
                        </span>
                        <span slot="suffix" @click="showPwd">
                            <svg-icon icon-class="eye" class="color-main"></svg-icon>
                        </span>
                    </el-input>
                </el-form-item>
                <el-form-item style="margin-bottom: 60px">
                    <el-button style="width: 100%" type="primary" :loading="loading"
                        @click.native.prevent="handleRegister">注册</el-button>
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
                    studentnum: "",
                    username: "",
                    firstpassword: "",
                    secondpassword: "",
                },
                loading: false,
                pwdType: "password",
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
            handleRegister() {
                this.$router.push({
                    path: "/login",
                });
                // this.$refs.registerForm.validate(valid => {
                //     if (valid) {
                //         this.loading = true;
                //         this.$store
                //             .dispatch("Login", this.registerForm)
                //             .then(response => {
                //                 this.loading = false;
                //                 let code = response.data.code;
                //                 if (code == 200) {
                //                     this.$router.push({
                //                         path: "/success",
                //                         query: {
                //                             data: response.data.data
                //                         }
                //                     });
                //                 } else {
                //                     this.$router.push({
                //                         path: "/fail",
                //                         query: {
                //                             message: response.data.message
                //                         }
                //                     });
                //                 }
                //             })
                //             .catch(() => {
                //                 this.loading = false;
                //             });
                //     } else {
                //         // eslint-disable-next-line no-console
                //         console.log("参数验证不合法！");
                //         return false;
                //     }
                // });
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
</style>