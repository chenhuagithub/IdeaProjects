<template>
  <div>
    <el-row>
      <el-col :span="24"><div class="grid-content bg-purple-dark">
        <span class="title">修改博客</span>
      </div></el-col>
    </el-row>
    <el-row>
      <el-col :span="3"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="2"><div class="grid-content bg-purple">
        博客标题
      </div></el-col>
      <el-col :span="1"><div class="grid-content bg-purple-light"></div></el-col>
      <el-col :span="17"><div class="grid-content bg-purple-light">
        <input datatype="text" name="blogtitle" v-model="blogtitle"></input>
      </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="3"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="2"><div class="grid-content bg-purple-light">
        所属类型
      </div>
      </el-col>
      <el-col :span="1"><div class="grid-content bg-purple-light"></div></el-col>
      <el-col :span="17"><div class="grid-content bg-purple">
        <el-select v-model="value" disabled placeholder="请选择">
          <el-option
            v-for="item in blogtype"
            :key="item.id"
            :label="item.typeName"
            :value="item.id">
          </el-option>
        </el-select>
      </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="3"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="2"><div class="grid-content bg-purple-light">
        博客内容
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
          v-model="blogcontext" >
        </el-input>
      </div></el-col>
    </el-row>
    <el-row>
      <el-col :span="3"><div class="grid-content bg-purple"></div></el-col>
      <el-col :span="2"><div class="grid-content bg-purple-light">
        关键字
      </div>
      </el-col>
      <el-col :span="1"><div class="grid-content bg-purple-light"></div></el-col>
      <el-col :span="17"><div class="grid-content bg-purple">
        <input datatype="text" v-model="blogkeyword" name="blogkeyword"></input>
        <span>(多个关键字可以用空格隔开)</span>
      </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="24">
        <div class="grid-content bg-purple btn">
          <el-button type="success" @click="submitData()">修改</el-button>
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
        inject:['reload'],
        id: '',
        blogtitle: '',
        blogcontext: '',
        blogtype: [],
        blogkeyword: '',
        // 存储类型id
        value: ''

      }
    },
    methods: {
      getData(){
        this.$axios.get("").then(response=>{

        })
          .catch(err=>{
            console.log(err);
          })
      }
      ,
      submitData(){
        this.$axios.post('/api/blog_war_exploded/blog/updateBlog',qs.stringify({
          id: this.id,
          title: this.blogtitle,
          // typeId: this.value,
          content: this.blogcontext,
          keyWord: this.blogkeyword
        }),{
          headers: {
            'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
          }
        }).then(response=>{
          console.log(response);
          if(response.data.status == 200){
            alert("数据提交成功");
            this.$router.push({path: '/blogInfoManager'})
          }

        })
          .catch(err=>{
            console.log(err);
          })
      },
      getBlogType(){
        //获取类型名
        this.$axios.get('/api/blog_war_exploded/blogtype/countList').then(response=>{
          let ret = response.data.data;
          for(var i=0; i<ret.length; i++){
            this.blogtype.push({
              id: ret[i].id,
              typeName: ret[i].typeName,
            })
          }

        })
          .catch(err=>{
            console.log(err);
          })
      },
      getInfo(){
        let aid = this.$route.params.aid;
        this.$axios.get("/api/blog_war_exploded/blog/findBlogById?id="+aid).then(response=>{
          console.log(response);
          if(response.data.status == 200){
            this.id = response.data.data.id
            this.blogtitle = response.data.data.title;
            this.value =response.data.data.blogType.typeName;
            this.blogcontext = response.data.data.content;
            this.blogkeyword = response.data.data.keyWord;
          }


        })
          .catch(err=>{
            console.log(err);
          })
      },
    },

    mounted() {

      this.getBlogType();
      this.getInfo();
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
