<template>
  <div>
    <div class="re">
    <el-row>
      <el-col :span="4"><div class="grid-content "></div></el-col>
      <el-col :span="16">
        <div class="grid-content bg-purple-dark retur">
          <span @click="retuPage()" class="return"><i class="el-icon-arrow-left">返回</i></span>
        </div>
      </el-col>
      <el-col :span="4"><div class="grid-content "></div></el-col>

    </el-row>
    </div>
    <br><br><br>


    <el-row>
      <el-col :span="4"><div class="grid-content "></div></el-col>
      <el-col :span="16">
        <div class="grid-content bg-purple-dark head">
          <div class="title">
            <span class="titlesp">{{title}}</span>
          </div>

        </div>
      </el-col>
      <el-col :span="4"><div class="grid-content "></div></el-col>
    </el-row>

    <el-row>
      <el-col :span="4"><div class="grid-content "></div></el-col>
      <el-col :span="10">
        <div class="grid-content ">
          <img :src="bloggerImage" height="40px" width="40px" style="border-radius: 50%">
          <span class="blogger">{{blogger}}</span>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="grid-content bg-purple-dark head">
          <div class="guanzhu" @click="changeFlag(bloggerId)">
            <el-button type="success" v-if="!guanzhuFlag" @click="">+关注</el-button>
            <el-button type="info" v-if="guanzhuFlag"><i class="el-icon-check"></i>已关注</el-button>
          </div>
        </div>
      </el-col>
      <el-col :span="4"><div class="grid-content "></div></el-col>
    </el-row>

    <el-row>
      <el-col :span="4"><div class="grid-content "></div></el-col>
      <el-col :span="16">
        <div class="grid-content bg-purple-dark head">
          <span class="three">字数 {{wordNumber}}</span> | <span class="three">阅读 {{hasRead}}</span>
          <span class="three_right three">{{releaseDate}}</span>
        </div>
      </el-col>
      <el-col :span="4"><div class="grid-content "></div></el-col>
    </el-row>

    <el-row>
      <el-col :span="4"><div class="grid-content "></div></el-col>
      <el-col :span="16">
        <div class="grid-content bg-purple-dark head">
          {{content}}
        </div>
      </el-col>
      <el-col :span="4"><div class="grid-content "></div></el-col>
    </el-row>

    <el-row>
      <el-col :span="4"><div class="grid-content "></div></el-col>
      <el-col :span="16">
        <div class="grid-content bg-purple-dark " @click="love()">
          <i class="el-icon-position" v-if="!flag"></i>
          <i class="el-icon-s-promotion" v-if="flag"></i>
        </div>
      </el-col>
      <el-col :span="4"><div class="grid-content "></div></el-col>
    </el-row>

    <el-row>
      <el-col :span="4"><div class="grid-content "></div></el-col>
      <el-col :span="16">
        <div class="grid-content bg-purple-dark " >
          <span class="three">评论({{commentNum}})</span>
          <hr>
        </div>
      </el-col>
      <el-col :span="4"><div class="grid-content "></div></el-col>
    </el-row>

    <div v-for="item in mycomment">
      <el-row>
        <el-col :span="4"><div class="grid-content "></div></el-col>
        <el-col :span="2"><div class="grid-content "><img :src="item.imagePath" width="50px" height="50px"  style="border-radius: 50%;display: inline-block"></div></el-col>
        <el-col :span="14">
          <div class="grid-content bg-purple-dark " >
<!--            评论者-->
            <span class="commenter">{{item.commenter}}</span><br>
<!--            评论内容-->
            <span>{{item.comment}}</span><br><br>
<!--            评论时间-->
            <span class="three">{{item.commentDate}}</span>



            <span @click="returnComment(item.commentId, item.commenterId)" class="three retu"><i class="el-icon-chat-square"></i></span>

            <el-dialog
              title="消息回复"
              :visible.sync="dialogVisible"
              width="30%"
              :before-close="handleClose">

              <el-row>
                <el-col :span="24"><div class="grid-content bg-purple-light">
                  <el-input
                    type="textarea"
                    :rows="10"
                    placeholder="回复"
                    v-model="returnblogcontext" >
                  </el-input>
                </div></el-col>
              </el-row>


              <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="submitReturnComment()">确 定</el-button>
              </span>
            </el-dialog>



<!--          消息回复-->
            <el-row v-for="it in item.replyList">

              <el-col :span="2">
                <div class="grid-content bg-purple-dark " >

                  <span style="display: inline-block;margin-top: 30%;">
                    <img :src="it.responderImage" width="40px" height="40px"  style="border-radius: 50%">
                  </span>
                </div>
              </el-col>
              <el-col :span="22">
                <hr>
                <div class="grid-content bg-purple-dark " >
                  <span class="commenter">{{it.responder}}</span><br>
                  <span style="color: deepskyblue">@{{it.beresponder}}</span>
                  <span @click="returnComment(item.commentId, it.beresponderId)">{{it.replyContent}}</span>

                </div>
              </el-col>
            </el-row>

            <hr>
          </div>

        </el-col>
        <el-col :span="4"><div class="grid-content "></div></el-col>
      </el-row>
    </div>

    <el-row>
      <el-col :span="4"><div class="grid-content "></div></el-col>
      <el-col :span="16">
        <div class="grid-content bg-purple-dark " @click="dialog = true">

          <el-input
            placeholder="写下你的评论"
            prefix-icon="el-icon-edit"
            v-model="input2">
          </el-input>

          <el-drawer
            title="评论"
            :before-close="handleClose"
            :visible.sync="dialog"
            direction="ltr"
            custom-class="demo-drawer"
            ref="drawer"
          >

            <div class="demo-drawer__content">

              <el-row>
                <el-col :span="24"><div class="grid-content bg-purple-light">
                  <el-input
                    type="textarea"
                    :rows="10"
                    placeholder="写入你的评论"
                    v-model="blogcontext" >
                  </el-input>
                </div></el-col>
              </el-row>

              <div class="demo-drawer__footer">
                <el-button @click="dialog = false">取 消</el-button>
                <el-button type="primary" @click="submitComment()" :loading="loading">{{ loading ? '提交中 ...' : '确 定' }}</el-button>
              </div>
            </div>


          </el-drawer>

        </div>
      </el-col>
      <el-col :span="4"><div class="grid-content "></div></el-col>
    </el-row>



  </div>
</template>

<script>
  import qs from 'qs'
    export default {
      data(){
          return{
            guanzhuFlag: '',
            bufferCommentId: '',
            bufferbeResponderId:'',
            dialogVisible: false,
            returnblogcontext:'',
            mycomment: [],
            state: 0,
            blogcontext: '',
            id: '',
            title: '',
            content: '',
            clickHit: '',
            keyWord: '',
            releaseDate: '2018-2-1',
            replyHit: '',
            summary: '',
            wordNumber: '12',
            hasRead: '212',
            flag: false,
            commentNum: 6,
            input2: '',
            table: false,
            dialog: false,
            loading: false,
            form: {
              name: '',
              region: '',
              date1: '',
              date2: '',
              delivery: false,
              type: [],
              resource: '',
              desc: ''
            },
            formLabelWidth: '80px',
            bloggerId: '',
            blogger: '',
            bloggerImage: ''
          }
      },
      methods:{
        // handleClose(done) {
        //   this.$confirm('确认关闭？')
        //     .then(_ => {
        //       done();
        //     })
        //     .catch(_ => {});
        // },
          getBlogData(){
            let aid = this.$route.params.aid;
            this.$axios.get("/api/blog_war_exploded/blog/findBlogById?id="+aid).then(response=>{
              console.log(response);
              var ret = response.data.data;
              this.id = ret.id;
              this.title = ret.title;
              this.clickHit =  ret.clickHit;
              this.keyWord = ret.keyWord;
              this.releaseDate = this.timestampToTime(ret.releaseDate);
              this.replyHit = ret.replyHit;
              this.summary = ret.summary;
              this.content = ret.content;
              this.wordNumber = ret.content.length;
              this.bloggerId = ret.blogger.id;
              this.blogger = ret.blogger.userName;
              this.bloggerImage = ret.blogger.imageName;

              this.getFocus(this.bloggerId);
              // alert("getBlogData-->"+this.id);
              this.getBlogComment();
            })
              .catch(err=>{
                console.log(err);
              });


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
        },
        love(){
            if(this.flag){
              this.flag = false;
            }else {
              this.flag = true;
            }
        },
        retuPage(){
            this.$router.push({path: '/community'})
        },
        submitComment(){

            this.$axios.post("/api/blog_war_exploded/blogComment/addComment", qs.stringify({
              userIp: this.getCookie("userNameId"),
              blogId: this.id,
              content: this.blogcontext,
              state: this.state

            }),{
              headers:{
                'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
              }
            }).then(response=>{
              console.log(response);
              window.location.reload();
            })
              .catch(err=>{
                console.log(err);
              })

            // 关闭窗口
            this.$refs.drawer.closeDrawer();
        },
        submitReturnComment(){
          // alert("commentId-->"+this.bufferCommentId);
          // alert("beresponderId--->"+this.bufferbeResponderId);
          // alert(this.returnblogcontext);
          this.$axios.post("/api/blog_war_exploded/blogReply/addBlogReply", qs.stringify({
            responderId: this.getCookie("userNameId"),
            beresponderId: this.bufferbeResponderId,
            commentId: this.bufferCommentId,
            content: this.returnblogcontext
          }),{
            headers:{
              'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
            }
          })
            .then(response=>{
              console.log(response);
              this.returnblogcontext = '';
              window.location.reload();

            })
            .catch(err=>{
              console.log(err);
            })
          this.dialogVisible = false;

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
        // 获取文章评论
        getBlogComment(){
            // this.getBlogData();
            // alert("getBlogComment--->"+this.id);
            this.$axios.get("/api/blog_war_exploded/blogComment/getBlogComment?blogId="+this.id).then(response=>{
              console.log(response);
              let ret = response.data.data;
              this.commentNum = ret.length;


              for(let i = 0; i<ret.length; i++){
                let replyListitem = [];
                this.$axios.get("/api/blog_war_exploded/blogReply/findBlogReply?commentId="+response.data.data[i].id).then(res=>{
                  console.log(res);
                  let replyret = res.data.data;

                  // 遍历请求回复的内容
                  for(let j=0; j<replyret.length; j++){
                    replyListitem.push({
                      replyContent: replyret[j].content,
                      responder: replyret[j].responder.userName,
                      responderImage: replyret[j].responder.imageName,
                      beresponder: replyret[j].beResponder.userName,
                      beresponderId: replyret[j].responder.id,
                      replyFlag: true,

                    })
                    console.log(replyListitem);
                  }


                })
                  .catch(er=>{
                    console.log(er);
                  });

                this.mycomment.push({
                  commenterId: ret[i].blogger.id,
                  commentId: ret[i].id,
                  commenter: ret[i].blogger.userName,
                  comment: ret[i].content,
                  imagePath: ret[i].blogger.imageName,
                  commentDate: this.timestampToTime(ret[i].commentDate),
                  replyList: replyListitem
                })
                // replyListitem = []
              }
              console.log(this.mycomment);
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
        },
        // commentId: 评论id
        // beresponderId: 被评论者id
        returnComment(commentId, beresponderId){
          // alert("wolaile");
          // alert("re commentId-->"+commentId);
          // alert("beresponderId--->"+beresponderId);
          this.bufferCommentId = commentId;
          this.bufferbeResponderId = beresponderId;
          this.dialogVisible = true;

        },
        // 获取关注信息
        getFocus(bloggerId){
            // alert(bloggerId);
            this.$axios.post("/api/blog_war_exploded/blogFocus/findOneBlogFocus", qs.stringify({
              focusId: this.getCookie("userNameId"),
              befocusId: bloggerId //bloggerId
            }),{
              headers:{
                'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
              }
            })
              .then(response=>{
                console.log(response);
                if(response.data.status == 200){
                  this.guanzhuFlag = true;
                }
                if(response.data.status == 202){
                  this.guanzhuFlag = false;
                }
              })
              .catch(err=>{
                console.log(err);
              })
        },
        changeFlag(bloggerId){
            // alert(bloggerId);
            if(this.guanzhuFlag){
              this.guanzhuFlag = false;
              this.$message.success("已取消关注");
              this.$axios.post("/api/blog_war_exploded/blogFocus/deleteBlogFocus", qs.stringify({
                focusId: this.getCookie("userNameId"),
                befocusId: bloggerId
              }),{
                headers:{
                  'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
                }
              })
                .then(response=>{
                  console.log(response);
                })
                .catch(err=>{
                  console.log(err);
                })
            }else {
              this.guanzhuFlag = true;
              this.$message.success("已关注");
              this.$axios.post("/api/blog_war_exploded/blogFocus/addBlogFocus", qs.stringify({
                focusId: this.getCookie("userNameId"),
                befocusId: this.bloggerId
              }),{
                headers:{
                  'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
                }
              })
                .then(response=>{
                  console.log(response);
                })
                .catch(err=>{
                  console.log(err);
                })
            }
        },
        aaa(){
          this.dialogVisible = false;
        }

      },
      created(){

      },
      mounted() {
        this.getBlogData();



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
    background: white;
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
  .title{
    text-align: center;
  }
  .titlesp{
    font-size: 20px;
  }
  .guanzhu{
    text-align: right;
  }
  .three{
    color: darkgray;
  }
  .three_right{
    display: block;
    margin-left: 80%;
    margin-top: -1.5%;
  }
  .commenter{
    font-weight: bold;
  }
  .retu{
    display: inline-block;
    margin-left: 90%;
  }
  .blogger{
    position: relative;
    top: -10px;
  }
  .re{
    position: fixed;
    width: 100%;
    height: 30px;
    /*background-color: red;*/
    z-index: 100;
    margin-left: -10px;
    margin-top: -8px;
    margin-right: -10px;
  }
  .retur{
    background-color: darkgray;
  }
  .return{
    display: inline-block;
    position: relative;
    top: 10px;
  }
</style>
