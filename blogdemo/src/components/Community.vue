<template>
  <div>
    <el-row>
      <el-col :span="2">
        <div class="grid-content ">

        </div>
      </el-col>
      <el-col :span="16">
        <div class="grid-content bg-purple-dark head">
          <span style="display: inline-block;" @click="retuPage()"><i class="el-icon-arrow-left"></i>返回</span>
          <span class="headsp">欢迎来到社区</span>
        </div>
      </el-col>
      <el-col :span="2"><div class="grid-content "></div></el-col>
    </el-row>

    <div v-for="item in blogList">
      <el-row>
        <el-col :span="8"><div class="grid-content "></div></el-col>
        <el-col :span="8" >
          <div class="grid-content">

            <el-card class="box-card">
              <div slot="header" class="clearfix">
                标题:&nbsp<span>{{item.title}}</span>
                <router-link v-bind:to="'/readBlog/'+item.id"><el-button style="float: right; padding: 3px 0" type="text">阅读</el-button></router-link>
              </div>
              <div class="text item">
                关键字:&nbsp{{item.keyWord}}
              </div>
              <div class="text item">
                发表日期:&nbsp{{item.releaseDate}}
              </div>
            </el-card>
          </div>
        </el-col>
        <el-col :span="8"><div class="grid-content "></div></el-col>
      </el-row>
    </div>
    <div class="foot">
      <span class="footsp" @click="getMoreData()"><i class="el-icon-arrow-down"></i>加载更多</span>
    </div>

  </div>

</template>


<script>
    export default {
      data(){
        return{
          blogList: [],
          page: 1,
        }
      },
      methods:{
        getBlogInfo(){
          this.$axios.get("/api/blog_war_exploded/blog/findAllBlog?pageSize=4&page="+this.page).then(response=>{
            console.log(response);
            var ret = response.data.data;
            for(var i = 0; i<ret.length; i++){
              this.blogList.push({
                id: ret[i].id,
                title: ret[i].title,
                keyWord: ret[i].keyWord,
                releaseDate: this.timestampToTime(ret[i].releaseDate)
              })
            }
          })
            .catch(err=>{
              console.log(err);
            })
        },
        getMoreData(){

          ++this.page;
          this.getBlogInfo();
        },
        retuPage(){
          this.$router.push({path: '/main'})
        },
        timestampToTime(timestamp) {
          var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
          var Y = date.getFullYear() + '-';
          var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
          var D = (date.getDate() < 10 ? '0'+date.getDate() : date.getDate()) + ' ';
          var h = (date.getHours() < 10 ? '0'+date.getHours() : date.getHours()) + ':';
          var m = (date.getMinutes() < 10 ? '0'+date.getMinutes() : date.getMinutes()) + ':';
          var s = (date.getSeconds() < 10 ? '0'+date.getSeconds() : date.getSeconds());
          return Y+M+D+h+m+s;
        }
      },
      mounted() {
        this.getBlogInfo();
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
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }

  .head{
    width: 80%;
    /*text-align: center;*/
    position: fixed;
    z-index: 100;
    margin-top: -8px;
  }
  .headsp{
    display: inline-block;
    margin-left: 37%;
    font-size: 20px;
  }
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 480px;
  }
  .content{
    text-align: center;
  }
  .footsp{
    margin-left: 45%;
    color: deepskyblue;
  }
</style>
