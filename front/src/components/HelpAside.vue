<template>
    <el-menu default-active="$route.path" class="userMenu" router @open="handleOpen" @close="handleClose">
        <el-menu-item @click=clikcMenu(item) v-for="item in menu" :index="item.path" :key="item.path">
            <template slot="title">
                <span>{{item.label}}</span>
            </template>
        </el-menu-item>
    </el-menu>
</template>

<script>
    export default {
        data() {
            return {
                menu: [{
                        path: '/help/help',
                        name: 'help',
                        label: '帮助',
                    }
                ]
            }
        },
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },
            clickMenu(item) {
                this.$router.push({
                    name: item.name
                })
            }
        }
    }
</script>