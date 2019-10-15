<template>
  <div>
    <el-row>
      <el-col :span="24"><div class="grid-content bg-purple-dark">
        <span class="title">密码修改</span>
      </div></el-col>
    </el-row>

    <el-row>
      <el-col :span="24">
        <div class="grid-content">

        <el-steps :active="active" finish-status="success">
          <el-step title="输入旧密码"></el-step>
          <el-step title="输入新密码"></el-step>
          <el-step title="再次输入新密码"></el-step>
        </el-steps>
        <br><br><br><br>
          <el-input
            style="width: 80%;"
            placeholder="请输入旧密码"
            v-model="oldPassword"
            clearable v-if="flag1">
          </el-input>
          <el-input
            style="width: 80%;"
            placeholder="请输入新密码"
            v-model="newPassword"
            clearable v-if="flag2">
          </el-input>

          <el-input
            style="width: 80%;"
            placeholder="请再次输入新密码"
            v-model="newPasswordAgain"
            clearable v-if="flag3">
          </el-input>


          <el-button style="margin-top: 12px;" @click="next" v-if="!sub">下一步</el-button>
          <el-button style="margin-top: 12px;" @click="next" v-if="sub">提交</el-button>

      </div>
      </el-col>
    </el-row>

  </div>
</template>

<script>
  import qs from 'qs'
  export default {
    data(){
      return{
        drawer: false,
        active: 0,
        flag1: true,
        flag2: false,
        flag3: false,
        sub: false,
        oldPassword: '',
        newPassword: '',
        newPasswordAgain: ''
      }
    },
    methods: {
      next() {
        if(this.active++ >= 2){
          this.$axios.post("/api/blog_war_exploded/blogger/passwordChange", qs.stringify({
            bloggerId: this.getCookie("userNameId"),
            oldPassword: this.oldPassword,
            newPassword: this.newPassword,
            newPasswordAgain: this.newPasswordAgain
          }),{
            headers:{
              'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
            }
          })
            .then(response=>{
              console.log(response);
              if(response.data.status == 200){
                this.$message.success("密码修改成功");
                setTimeout(()=>{
                  this.drawer = false;
                }, 2000);
                this.oldPassword = '';
                this.newPassword = '';
                this.newPasswordAgain = '';
              }
              if(response.data.status == 300){
                this.$message.warning("旧密码不正确");
                setTimeout(()=>{
                  this.drawer = false;
                }, 2000);
              }
              if(response.data.status == 301){
                this.$message.warning("两次新密码输入不一致");
                setTimeout(()=>{
                  this.drawer = false;
                }, 2000);
              }
            })
            .catch(err=>{
              console.log(err);
            });
          this.active = 0;
        }
        if(this.active == 0){
          this.flag1 = true;
          this.flag2 = false;
          this.flag3 = false
          this.sub = false;
        }
        if(this.active == 1){
          this.flag1 = false;
          this.flag2 = true;
          this.flag3 = false;
          this.sub = false;
        }
        if(this.active == 2){
          this.flag1 = false;
          this.flag2 =false;
          this.flag3 = true;
          this.sub =true;
        }
      },
      getCookie(name) { //获取指定名称的cookie值
        // (^| )name=([^;]*)(;|$),match[0]为与整个正则表达式匹配的字符串，match[i]为正则表达式捕获数组相匹配的数组；
        let arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
        if(arr != null) {
          console.log(arr);
          return unescape(arr[2]);
        }
        return null;
      },
    },

    mounted() {

    }

  }
</script>

<style scoped>
  .el-row {
    margin-bottom: 20px;
  &:last-child {
     margin-bottom: 0;
   }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: deepskyblue;
  }
  .bg-purple {
    background: white;
  }
  .bg-purple-light {
    background: white;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
  .title{
    display: block;
    padding-top: 5px;
    padding-left: 5px;
  }
  .btn{
    text-align: right;
  }
  input{
    height: 25px;
    width: 70%;
  }
</style>
