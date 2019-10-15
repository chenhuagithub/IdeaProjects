<template>
  <div>
    <div>
      <el-row>
        <el-col :span="24"><div class="grid-content bg-purple-dark">
          <span class="title" >博客信息管理</span>
        </div></el-col>
      </el-row>
    </div>
    <div>
      <el-row>
        <el-col :span="2">
          <div sty class="grid-content bg-purple-dark">
            &nbsp;&nbsp;标题
         </div>
        </el-col>
        <el-col :span="4">
          <div class="grid-content bg-purple-dark">
            <input datatype="text" name="title" v-model="title"></input>
          </div>
        </el-col>

        <el-col :span="18">
          <div class="grid-content bg-purple-dark">
            <span @click="searchData()"><i class="el-icon-search"></i>搜索</span>
          </div>
        </el-col>

      </el-row>

    </div>
    <br>
    <el-button type="text" @click="dialogFormVisible = true">添加</el-button>
    <div>
      <table cellpadding="5px" cellspacing="0px" border="1px">
        <th>编号</th>
        <th>标题</th>
        <th>发布时间</th>
        <th>博客类别</th>
        <th>修改操作</th>
        <th>删除操作</th>
        <tr v-for="(item, key) in blogList">
          <td>{{item.id}}</td>
          <td>{{item.title}}</td>
          <td>{{item.releaseDate}}</td>
          <td>{{item.typeId}}</td>
          <td><router-link v-bind:to="'/updateBlog/'+item.id">修改</router-link></td>
          <td><span @click="deleteBlog(item.id, key)" style="color: deepskyblue">删除</span></td>
        </tr>
      </table>
    </div>
    <div class="block">
      <br>
      <span class="sp" @click="first()">首页</span>&nbsp;&nbsp;&nbsp;
      <i class="el-icon-arrow-left"></i>
      <span class="sp" @click="previous()">上一页</span>&nbsp;&nbsp;&nbsp;
      <span class="sp">{{cupage}}</span>/{{totalpage}}&nbsp;&nbsp;&nbsp;
      <span class="sp" @click="next()">下一页</span>
      <i class="el-icon-arrow-right"></i>
      <span class="sp" @click="last()">末页</span>&nbsp;&nbsp;&nbsp;
      <span class="sp" @click="go()">GO</span>&nbsp;第<input datatype="text" name="pageName" style="width: 30px;" v-model="pageValue"></input>页
    </div>
  </div>

</template>

<script>
  import qs from 'qs'
    export default {
        data(){
          return{
            page: 1,
            blogList: [],
            cupage: 1,
            totalpage:'',
            firstPage: 1,
            lastPage: '',
            pageValue: 1,
            title: '',
            flag: false
          }
        },
      methods: {
        previous(){
          // flag=true表示搜索
          if(this.page != 1 && !this.flag){
            --this.page;
            this.blogList = [];
            this.getData();
            --this.pageValue;
          }
          if(this.page != 1 && this.flag){
            --this.page;
            this.blogList = [];
            this.getSearchData();
            --this.pageValue;
          }

        },
        next(){
          if(this.page != this.totalpage && !this.flag){
            ++this.page;
            this.blogList = [];
            this.getData();
            ++this.pageValue;
          }
          if(this.page != this.totalpage && this.flag){
            ++this.page;
            this.blogList = [];
            this.getSearchData();
            ++this.pageValue;
          }
        },
        first(){
          if(!this.flag){
            this.page = 1;
            this.blogList = [];
            this.getData();
            this.pageValue = 1;
          }
          if(this.flag){
            this.page = 1;
            this.blogList = [];
            this.getSearchData();
            this.pageValue = 1;
          }

        },
        last(){
          if(!this.flag){
            this.page = this.totalpage;
            this.blogList = [];
            this.getData();
            this.pageValue = this.totalpage;
          }
          if(this.flag){
            this.page = this.totalpage;
            this.blogList = [];
            this.getSearchData();
            this.pageValue = this.totalpage;
          }

        },

        go(){
          if(this.pageValue>=1 && this.pageValue<= this.totalpage && !this.flag){
            this.page = this.pageValue;
            this.blogList = [];
            this.getData();
          }
          if(this.pageValue>=1 && this.pageValue<= this.totalpage && this.flag){
            this.page = this.pageValue;
            this.blogList = [];
            this.getSearchData();
          }

        },
        changeFlag(){
          if(this.flag){
            this.flag = false;
          }else {
            this.flag = true;
          }
        },
        getSearchData(){
          this.$axios.get("/api/blog_war_exploded/blog/findAllBlogByTitle?title="+this.title+"&page="+this.page).then(response=>{
            console.log(response);
            // 当前页
            this.cupage = response.data.info[0];
            // 尾页
            this.totalpage = response.data.info[1];

            this.blogList = [];
            var ret = response.data.data;
            for(var i = 0; i<ret.length; i++){
              this.blogList.push({
                id: ret[i].id,
                title: ret[i].title,
                releaseDate: this.timestampToTime(ret[i].releaseDate),
                typeId: ret[i].typeId
              });
            }
          })
            .catch(err=>{
              console.log(err);
            })
        },
        searchData(){
          this.flag = true;
          this.getSearchData();
        },
        getData(){
          this.$axios.get("/api/blog_war_exploded/blog/findAllBlog?page="+this.page).then(response=>{
            console.log(response);

            // 当前页
            this.cupage = response.data.info[0];
            // 尾页
            this.totalpage = response.data.info[1];

            let ret = response.data.data;
            for(var i = 0; i<ret.length; i++){
              this.blogList.push({
                id: ret[i].id,
                title: ret[i].title,
                releaseDate: this.timestampToTime(ret[i].releaseDate),
                typeId: ret[i].typeId
              });
            }
          })
            .catch(err=>{
              console.log(err);
            })
        },
        // 删除博客
        deleteBlog(id, key){
          this.$axios.get("/api/blog_war_exploded/blog/deleteBlog?id="+id).then(response=>{
            console.log(response);
            if(response.data.status == 200){
              this.blogList.splice(key, 1);
            }

          })
            .catch(err=>{
              console.log(err);
            })
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
        this.getData();
      }
    }
</script>

<style scoped>
  .bg-purple-dark {
    background: lightskyblue;
  }
  .bg-purple {
    background: white;
  }
  .bg-purple-light {
    background: white;
  }
  .grid-content {
    /*border-radius: 4px;*/
    min-height: 36px;
  }
  .title{
    display: block;
    padding-top: 5px;
    padding-left: 5px;
  }
  td{
    width: 300px;
    text-align: center;
  }
  th{
    width: 300px;
    text-align: center;
  }
  .sp{
    color: deepskyblue;
  }
  .block{
    text-align: center;
  }
</style>
