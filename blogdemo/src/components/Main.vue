<template>
    <div>
      <div class="head">
        <span class="head_sp">个人博客</span>

        <el-badge :value="3" class="item">
          <el-button size="small">回复</el-button>
        </el-badge>

        <el-badge :value="1" class="item" type="primary">
          <el-button size="small">评论</el-button>
        </el-badge>
        <span class="usericon" @click="aaa()"><img :src="imagePath" width="50px" height="50px"  style="border-radius: 50%;display: inline-block">&nbsp;&nbsp;</span><span class="userName">{{blogger}}</span>
        <span class="community"><router-link to="/community">社区</router-link></span>



        <el-drawer
          title="头像上传"
          :visible.sync="drawer"
          size="30%">
          <div>


            <el-upload
              class="avatar-uploader"
              :action="'/api/blog_war_exploded/blogger/uploadImage?id='+userNameId"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>

          </div>
        </el-drawer>


      </div>

<!--      <i class="el-icon-user-solid"></i>-->
      <div class="foot_left">
        <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
          <el-radio-button :label="false">展开</el-radio-button>
          <el-radio-button :label="true">收起</el-radio-button>
        </el-radio-group>

        <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-suitcase"></i>
              <span slot="title">博客管理</span>
            </template>
            <el-menu-item-group>

              <el-menu-item index="1-1" @click="chageTitle('写博客')"><router-link to="/writeBlog">写博客</router-link></el-menu-item>
              <el-menu-item index="1-2"><router-link to="/infoManager"><router-link to="/blogInfoManager">博客信息管理</router-link></router-link></el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>

        <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-suitcase"></i>
              <span slot="title">博客类别管理</span>
            </template>
            <el-menu-item-group>

              <el-menu-item index="1-1" ><router-link to="/infoManager">博客类别信息管理</router-link></el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>


        <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-suitcase"></i>
              <span slot="title">个人信息管理</span>
            </template>

            <el-menu-item-group>

              <el-menu-item index="1-1"><router-link to="/updateBloggerInfo">修改个人信息</router-link></el-menu-item>
            </el-menu-item-group>

            <el-menu-item-group>

              <el-menu-item index="1-1"><router-link to="/myFocus">我关注的人</router-link></el-menu-item>
            </el-menu-item-group>

            <el-menu-item-group>
              <el-menu-item index="1-1"><router-link :to="userNameId">我的资料</router-link></el-menu-item>
            </el-menu-item-group>

          </el-submenu>
        </el-menu>

        <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-suitcase"></i>
              <span slot="title">系统管理</span>
            </template>
            <el-menu-item-group>

<!--              <el-menu-item index="1-1"><router-link to="">友情链接管理</router-link></el-menu-item>-->
              <el-menu-item index="1-1"><router-link to="/passwordChange">修改密码</router-link></el-menu-item>
<!--              <el-menu-item index="1-1"><router-link to="">刷新系统缓存</router-link></el-menu-item>-->
              <el-menu-item index="1-1"><span @click="quit()">安全退出</span></el-menu-item>

            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </div>


<!--      内容盒子-->
      <div class="foot_right">

        <router-view v-if="isRouterAlive"/>
      </div>

    </div>
</template>

<script>
  export default {
    provide(){
      return {
        reload: this.reload
      }
    },
    data() {
      return {
        userNameId: '',
        imagePath: '',
        userNameId: '',
        imageUrl: '',
        drawer: false,
        innerDrawer: false,
        blogger: '',
        isRouterAlive:true,
        isCollapse: true,
        editableTabsValue: '2',
        editableTabs: [{
          title: 'Tab 1',
          name: '1',
          content: 'Tab 1 content'
        }, {
          title: 'Tab 2',
          name: '2',
          content: 'Tab 2 content'
        },{
          title: 'Tab 3',
          name: '3',
          content: 'Tab 3 content'
        }],
        tabIndex: 2
      };
    },
    methods: {
      quit(){
        // alert(this.$cookieStore.getCookie('userNameId'));
        this.$cookieStore.delCookie('userNameId');
        // alert(this.$cookieStore.getCookie('userNameId'));
        // alert(this.getCookie2("userNameId"));
        // var aaa = this.getCookie2("userNameId");
        // alert(aaa);
        // alert("djkfj");
        // let cookievalue = this.getCookieId("userNameId");
        // this.$axios.get("/api/blog_war_exploded/blogger/quit").then(response=>{
        //   console.log(response);
        // })
        //   .catch(err=>{
        //     console.log(err);
        //   })
        // this.delCookie("userNameId");
        this.$router.push({path: '/login'});
      },
      //删除cookie
      delCookie (name) {
        let exp = new Date();
        exp.setTime(exp.getTime() - 1);
        let cval = getCookie(name);
        if (cval != null)
          document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
      },
      //获取cookie、
      getCookie2(cname) {
        var name = cname + '=';
        var ca = document.cookie.split(';');
        for (var i = 0; i < ca.length; i++) {
          var c = ca[i];
          while (c.charAt(0) == ' ') c = c.substring(1);
          if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
        }
        return '';
      },
      delCookie (name) {
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var cval = getCookie(name);
        if (cval != null)
          document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
      },
      aaa(){
        // alert("djfldjf");
        this.drawer = true;
      },
      handleAvatarSuccess(res, file) {

        this.imageUrl = URL.createObjectURL(file.raw);
        // alert("图片上传成功");
        this.$message.success("图片上传成功");
        setTimeout(()=>{
          this.drawer = false;
        }, 2000);

      },
      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;
      },
      reload(){
        this.isRouterAlive = false;
        this.$nextTick(()=> {
          this.isRouterAlive = true;
        })
      },
      // handleClose(done) {
      //   this.$confirm('还有未保存的工作哦确定关闭吗？')
      //     .then(_ => {
      //       done();
      //     })
      //     .catch(_ => {});
      // },
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      // handleClose(key, keyPath) {
      //   console.log(key, keyPath);
      // },
      handleTabsEdit(targetName, action) {
        if (action === 'add') {
          let newTabName = ++this.tabIndex + '';
          this.editableTabs.push({
            title: 'New Tab',
            name: newTabName,
            content: 'New Tab content'
          });
          this.editableTabsValue = newTabName;
        }
        if (action === 'remove') {
          let tabs = this.editableTabs;
          let activeName = this.editableTabsValue;
          if (activeName === targetName) {
            tabs.forEach((tab, index) => {
              if (tab.name === targetName) {
                let nextTab = tabs[index + 1] || tabs[index - 1];
                if (nextTab) {
                  activeName = nextTab.name;
                }
              }
            });
          }

          this.editableTabsValue = activeName;
          this.editableTabs = tabs.filter(tab => tab.name !== targetName);
        }
      },
      chageTitle(val){
        this.editableTabs.push({
          title: val,
          name: val,
          content: val
        });
        this.editableTabsValue = activeName;
        this.editableTabs = tabs.filter(tab => tab.name !== targetName);
      },
      getBlogger(){
        this.$axios.get("/api/blog_war_exploded/blogger/findBlogerById").then(response=>{
          console.log(response);
          this.blogger = response.data.data.userName;
          this.imagePath = response.data.data.imageName;
          this.imageUrl = response.data.data.imageName;

          // alert(this.imagePath);

        })
          .catch(err=>{
            console.log(err);
          })
      },
      getCookieId(name) { //获取指定名称的cookie值
        // (^| )name=([^;]*)(;|$),match[0]为与整个正则表达式匹配的字符串，match[i]为正则表达式捕获数组相匹配的数组；
        var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
        if(arr != null) {
          console.log(arr);
          return unescape(arr[2]);
        }
        return null;
      },
    },


    mounted() {
      this.userNameId = this.getCookieId("userNameId");
      this.getBlogger();
      this.userNameId ='/myData/' + this.getCookieId("userNameId");

    }
  }
</script>

<style scoped>
  .head{
    width: 100%;
    height: 70px;
    padding: 0px;
    margin: 0px;
    background-color: lightskyblue;
  }
  .head_sp{
    font-size: 20px;
    display: inline-block;
    position: relative;
    /*top: 20px;*/
    left: 2%;
  }
  .foot_left{
    width: 15%;
  }
  .foot_right{
    position: fixed;
    top: 80px;
    left: 16%;
    width: 82%;
    height: 200px;
    /*background-color: red;*/
  }
  .usericon{
    display: inline-block;
    position: relative;
    top: 15%;
    left:75%;

  }
  .community{
    display: inline-block;
    position: relative;
    /*top: -45%;*/
    /*left: 90%;*/
    font-size: 20px;
  }
  .userName{
    display: inline-block;
    position: relative;
    left: 75%;
    top: -10%;
  }
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
  .item {
    display: inline-block;
    position: relative;
    left: 50%;
    top: -20%;
    margin-top: 10px;
    margin-right: 40px;
  }
</style>
