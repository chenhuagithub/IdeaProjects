<template>
  <div>
    <el-row>
      <el-col :span="24"><div class="grid-content bg-purple-dark">
        <span class="title">修改个人信息</span>
      </div></el-col>
    </el-row>

    <el-row>
      <el-col :span="3"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="2"><div class="grid-content bg-purple">
        用户名
      </div></el-col>
      <el-col :span="1"><div class="grid-content bg-purple-light"></div></el-col>
      <el-col :span="17"><div class="grid-content bg-purple-light">
        <input datatype="text" name="userName" v-model="userName"></input>
      </div>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="3"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="2"><div class="grid-content bg-purple">
        个性签名
      </div></el-col>
      <el-col :span="1"><div class="grid-content bg-purple-light"></div></el-col>
      <el-col :span="17"><div class="grid-content bg-purple-light">
        <input datatype="text" name="userName" v-model="sign"></input>
      </div>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="3"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="2"><div class="grid-content bg-purple-light">
        昵称
      </div>
      </el-col>
      <el-col :span="1"><div class="grid-content bg-purple-light"></div></el-col>
      <el-col :span="17">
        <div class="grid-content bg-purple">
          <input datatype="text" name="nickName" v-model="nickName"></input>
        </div>
      </el-col>
    </el-row>



    <el-row>
      <el-col :span="3"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="2"><div class="grid-content bg-purple-light">
        简介
      </div></el-col>
      <el-col :span="9"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="9"><div class="grid-content bg-purple-light"></div></el-col>
    </el-row>

    <el-row>
      <el-col :span="3"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="21"><div class="grid-content bg-purple-light">
        <el-input
          type="textarea"
          :rows="10"
          placeholder="请输入内容"
          v-model="profile" >
        </el-input>
      </div>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="24">
        <div class="grid-content bg-purple btn">
          <el-button type="success" @click="submitData()">提交</el-button>
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
        userName: '',
        nickName: '',
        profile: '',
        sign: ''

      }
    },
    methods: {
      submitData(){
        this.$axios.post("/api/blog_war_exploded/blogger/updateBloggerInfo", qs.stringify({
          userName: this.userName,
          nickName: this.nickName,
          profile: this.profile,
          sign: this.sign
        }),{
          headers: {
            'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8',
            'widthCredentials': true
          }
        })
          .then(response=>{
            console.log(response);
            if(response.data.status == 200){
              this.$message.success("数据已提交");
              this.userName = '';
              this.nickName = '';
              this.profile = '';
              this.sign = '';

            }
          })
          .catch(err=>{
            console.log(err);
          })
      }
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
