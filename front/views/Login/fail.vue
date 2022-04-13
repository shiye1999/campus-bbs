<template>
    <div>
        <h1>登录失败：{{msg}}</h1>
    </div>
</template>
<script>
    export default {
        name:"viewFail",
        data() {
            return {
                msg: null
            };
        },
        created() {
            this.msg = this.$route.query.message;
        }
    };
</script>