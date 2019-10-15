<template>
  <div>
    <el-row>
      <el-col :span="24"><div class="grid-content bg-purple-dark">
        <span class="title">{{userName}}的资料</span>
      </div></el-col>
    </el-row>

    <el-row>
      <el-col :span="4"><div class="grid-content"></div></el-col>
      <el-col :span="2">
        <div class="grid-content">
          <img :src="imageName" width="60px" height="60px" style="border-radius: 50%">
        </div>
      </el-col>
      <el-col :span="4">
        <div class="grid-content" style="display: inline-block;margin-top: 10%;font-size: 20px">
          {{userName}}
        </div>
      </el-col>
    </el-row>
    <hr style="width: 70%">

    <el-row>
      <el-col :span="4">
        <div class="grid-content">
        </div>
      </el-col>
      昵称:
      <el-col :span="20"><div class="grid-content" style="margin-left: 5%">
        <span class="con">{{nickName}}</span>
      </div></el-col>
    </el-row>

    <el-row>
      <el-col :span="4">
        <div class="grid-content">
      </div>
      </el-col>
      电话号码:
      <el-col :span="20"><div class="grid-content" style="margin-left: 5%">
       <span class="con">{{phone}}</span>
      </div></el-col>
    </el-row>

    <el-row>
      <el-col :span="4"><div class="grid-content">
        <span></span>
      </div></el-col>
      个性签名:
      <el-col :span="20"><div class="grid-content" style="margin-left: 5%">
        <span class="con">{{sign}}</span>
      </div></el-col>
    </el-row>

    <el-row>
      <el-col :span="4"><div class="grid-content">
      </div>
      </el-col>
      简介:
      <el-col :span="20">
        <div class="grid-content" style="margin-left: 5%">
        <span class="con">{{profile}}</span>
      </div>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="4"><div class="grid-content">

      </div>
      </el-col>
      我发表博客的数量
      <el-col :span="20"><div class="grid-content" style="margin-left: 5%">
        <span class="con">{{blogCount}}</span>
      </div></el-col>
    </el-row>

    <el-row>
      <el-col :span="4"><div class="grid-content">

      </div>
      </el-col>
      我关注的数量
      <el-col :span="20"><div class="grid-content" style="margin-left:5%">
        <span class="con">{{focusCount}}</span>
      </div></el-col>
    </el-row>

    </div>


</template>

<script>
  import qs from 'qs'
  export default {
    data(){
      return{
        id: '',
        imageName: '',
        nickName: '',
        phone: '',
        profile: '',
        userName: '',
        sign: '',
        focusCount: '',
        blogCount: ''
      }
    },
    methods: {
      getInfo(){
        let aid = this.$route.params.aid;
        this.$axios.post("/api/blog_war_exploded/blogger/findAllInfo", qs.stringify({
          id: aid
        }),{
          headers:{
            'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
          }
        })
          .then(response=>{
            console.log(response);
            if(response.status == 200){
              let ret = response.data.data;

              this.id = ret.id;
              this.imageName = ret.imageName;
              this.nickName = ret.nickName,
              this.phone = ret.phone;
              this.profile = ret.profile;
              this.userName = ret.userName;
              this.sign = ret.sign;

            }

          })
          .catch(err=>{
            console.log(err);
          })
      },
      getBlogCount(){
        let aid = this.$route.params.aid;
        this.$axios.post("/api/blog_war_exploded/blog/findAllBlogByIdCount", qs.stringify({
          id: aid
        }),{
          headers:{
            'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
          }
        })
          .then(response=>{
            console.log(response);
            if(response.data.status == 200){
              this.blogCount = response.data.data;
            }
          })
          .catch(err=>{
            console.log(err);
          })
      },
      getFocusCount(){
        let aid = this.$route.params.aid;
        this.$axios.post("/api/blog_war_exploded/blogFocus/findAllBlogFocusCount", qs.stringify({
          id: aid
        }),{
          headers:{
            'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
          }
        })
          .then(response=>{
            console.log(response);
            if(response.data.status == 200){
              this.focusCount = response.data.data;
            }
          })
          .catch(err=>{
            console.log(err);
          })
      }
    },

    mounted() {
      this.getInfo();
      this.getBlogCount();
      this.getFocusCount();
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
  input{
    height: 25px;
    width: 70%;
  }
  .con{
    color: gray;
  }
</style>
