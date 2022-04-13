<template>
    <div>
        <h1>登录成功：{{msg}}</h1>
    </div>
</template>
<script>
    export default {
        name:"viewSuccess",
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