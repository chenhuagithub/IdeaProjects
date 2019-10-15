<template>
  <div>
    <div class="head">
      <span class="welocome">欢迎登录</span>
    </div>
    <div class="foot">
      <div class="login">
        <br><br>
        <el-form  status-icon  label-width="100px" class="demo-ruleForm">

          <el-form-item label="用户名">
            <el-input v-model="userName" placeholder="请输入用户名"></el-input>
          </el-form-item>
          <el-form-item label="手机号">
            <el-input v-model="phone" placeholder="请输入手机号"></el-input>
          </el-form-item>
          <el-form-item label="验证码">
            <el-input v-model="phoneCode" style="width: 72%" placeholder="请输入验证码"></el-input>
            <el-button type="info" @click="getPhoneCode()">获取验证码</el-button>
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="password" type="password"  autocomplete="off" placeholder="请输入密码"></el-input>
          </el-form-item>
          <el-form-item label="确认密码">
            <el-input v-model="passwordagain" type="password"  autocomplete="off" placeholder="请确认密码"></el-input>
          </el-form-item>
          <el-form-item>

            <el-button class="btn" type="primary" @click="submitData()">登录</el-button>
            <el-button class="btn2" @click="reEmpty()">重置</el-button>
            <span class="sp">没有有帐号, <router-link to="/">去注册</router-link></span>
          </el-form-item>
        </el-form>
      </div>


    </div>

  </div>
</template>

<script>
  import qs from 'qs'
  export default {
    data () {
      return {
        userName: '',
        password: '',
        passwordagain: '',
        phoneCode: '',
        phone: ''
      }
    },
    methods:{
      getPhoneCode(){
        alert(this.phone);
        this.$axios.post("/api/blog_war_exploded/blogger/sendPhone",qs.stringify({
          phone: this.phone
        }),{
          headers: {
            'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
          }
        })
          .then(response=>{
            console.log(response);
            if(response.data.status == 200){
              this.$message({
                showClose: true,
                message: '验证码发送成功, 请注意查收',
                type: 'success'
              });
            }
          })
          .catch(err=>{
            console.log(err);
          })
      },
      reEmpty(){
        this.userName = '';
        this.password = '';
        this.passwordagain = '';
      },
      submitData(){
        //密码验证
        if(this.password == this.passwordagain){
          this.$axios.post('api/blog_war_exploded/blogger/login',qs.stringify({
            userName: this.userName,
            password: this.password,
            phone: this.phone,
            phoneCode: this.phoneCode
          }),{
            headers: {
              'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
            }
          })
            .then(response=> {
              console.log(response);
              if(response.data.status == 200){
                this.$router.push({path: '/main'})

              }else {
                alert("亲, 你还没有注册帐号哦");
                this.userName = '';
                this.password = '';
                this.passwordagain = ' ';
              }

            })
            .catch(err=> {
              console.log(err);
            })
        }else {
          alert("两次密码输入不一致");
          this.password = '';
          this.passwordagain = '';
        }
      },
      aaa(){
        this.userName = '';
        this.password = '';
        this.passwordagain = '';
        this.$router.push({path: '/login'})
      }

    },
    mounted() {

    }
  }
</script>

<style  scoped>
  .head{
    width:100%;
    height: 500px;
    background-color: deepskyblue;
  }

  .foot{
    height: 450px;
    background-color: darkgrey;
  }
  .login{

    background-color: white;
    width: 30%;
    position: relative;
    left: 35%;
    top: -20%;
  }

  .demo-ruleForm{
    margin-right: 50px;
  }

  .sp{
    display: block;
    text-align: right;
  }

  .welocome{
    display: block;
    position: relative;
    top: 43%;
    left: 43%;
    font-size: 60px;
  }

</style>
