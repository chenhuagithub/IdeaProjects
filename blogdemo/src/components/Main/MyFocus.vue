<template>
  <div>
    <el-row>
      <el-col :span="24"><div class="grid-content bg-purple-dark">
        <span class="title">我的关注</span>
      </div></el-col>
    </el-row>

    <div v-for="item in focusInfo">
      <el-row>
        <el-col :span="4"><div class="grid-content"></div></el-col>
        <el-col :span="2">
          <div class="grid-content" style="text-align: right">
            <img :src="item.imageName" width="50px" height="50px" style="border-radius: 50%" @click="goTo(item.id)">
          </div>
        </el-col>
        <el-col :span="4">
          <div class="grid-content">
            &nbsp;&nbsp;<span style="display: inline-block;margin-top: 6%;font-size: 20px">{{item.userName}}</span>
          </div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content">
            <span style="display: inline-block;margin-top:3%;color: #8c939d">个性签名:&nbsp{{item.sign}}</span>
          </div>
        </el-col>
      </el-row>
      <hr style="width: 60%;">

    </div>




  </div>
</template>

<script>
  import qs from 'qs'
  export default {
    data(){
      return{
        focusInfo: []
      }
    },
    methods: {
      getFocusInfo(){
        this.$axios.post("/api/blog_war_exploded/blogFocus/findAllFocus", qs.stringify({
          focusId: this.getCookie("userNameId")
        }),{
          headers:{
            'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
          }
        })
          .then(response=>{
            console.log(response);
            let ret = response.data.data;
            for (let i = 0; i < ret.length ; i++) {
              this.focusInfo.push({
                id: ret[i].id,
                userName: ret[i].userName,
                imageName: ret[i].imageName,
                nickName: ret[i].nickName,
                sign: ret[i].sign

              })
            }
          })
          .catch(err=>{
            console.log(err);
          })
      },
      getCookie(name) { //获取指定名称的cookie值
        // (^| )name=([^;]*)(;|$),match[0]为与整个正则表达式匹配的字符串，match[i]为正则表达式捕获数组相匹配的数组；
        var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
        if(arr != null) {
          console.log(arr);
          return unescape(arr[2]);
        }
        return null;
      },
      goTo(id){
        this.$router.push({path: '/myData/'+id})
      }
    },

    mounted() {
      this.getFocusInfo();
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

</style>
