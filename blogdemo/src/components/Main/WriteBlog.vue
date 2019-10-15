<template>
  <div>
    <el-row>
      <el-col :span="24"><div class="grid-content bg-purple-dark">
        <span class="title">编写博客</span>
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
        <el-select v-model="value" placeholder="请选择">
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
            blogtitle: '',
            blogcontext: '',
            blogtype: [],
            blogkeyword: '',
            // 存储类型id
            value: ''

          }
        },
      methods: {
        submitData(){
          // alert(this.blogtitle);
          // alert(this.value);
          // alert(this.blogcontext);
          // alert(this.blogkeyword);


          this.$axios.post('/api/blog_war_exploded/blog/addBlog',qs.stringify({
              title: this.blogtitle,
              typeId: this.value,
              content: this.blogcontext,
              keyWord: this.blogkeyword,
              bloggerId: this.$cookieStore.getCookie("userNameId")
          }),{
            headers: {
              'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
            }
          }).then(response=>{
            console.log(response);
            if(response.data.status == 200){
              alert("数据提交成功");
            }

          })
            .catch(err=>{
              console.log(err);
            })
        }
      },
      mounted() {
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
