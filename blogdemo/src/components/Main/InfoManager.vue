<template>
  <div>
    <div>
      <el-row>
        <el-col :span="24"><div class="grid-content bg-purple-dark">
          <span class="title">博客类别信息管理</span>
        </div></el-col>
      </el-row>
<!--      添加-->
      <el-button type="text" @click="dialogFormVisible = true">添加</el-button>

      <el-dialog title="添加博客类型" :visible.sync="dialogFormVisible">
        <el-form :model="form">
          <el-form-item label="博客类型名称" :label-width="formLabelWidth">
            <el-input v-model="form.typeName" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="博客类型序号" :label-width="formLabelWidth">
            <el-input v-model="form.orderNo" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary"  @click="submitData()">确 定</el-button>
        </div>
      </el-dialog>

    </div>
    <div>

      <table cellspacing="0" cellpadding="5" border="1px">
        <th>编号</th>
        <th>博客类型名称</th>
        <th>排序序号</th>
        <th>删除操作</th>
        <th>修改操作</th>
        <tr v-for="(item, key) in tableData">
          <td>{{item.id}}</td>
          <td>{{item.typeName}}</td>
          <td>{{item.orderNo}}</td>
          <td @click="deleteData(item.id,key)" style="color: deepskyblue">删除</td>
          <td style="color:deepskyblue">

            <el-popover
              placement="right"
              width="400"
              trigger="click">
              <div>
                <div>
                  <span style="font-size: 20px;">博客信息修改</span><br><br>
                </div>
                <div class="content">
<!--                  <p><input datatype="text" value="{{item.id}}"></input></p>-->
                  <p>博客类型名称 <input class="updatep"  datatype="text" v-model="typeName" ></input></p>
                  <p>博客排序序号 <input class="updatep"  datatype="text" v-model="orderNo"></input></p>
                </div>
                <el-button size="mini" type="text" style="margin-left: 90%" @click="updateData(key)">修改</el-button>
              </div>

              <el-button style="border: none;"  slot="reference" ><span style="color: deepskyblue" @click="chang(key)">修改</span></el-button>
            </el-popover>

          </td>

        </tr>
      </table>

    </div>

  </div>

</template>

<script>
  import qs from 'qs'
  export default {
    data() {
      return {
        inject:['reload'],
        visible: false,
        tableData: [],
        id: '',
        typeName: '',
        orderNo: '',
        dialogTableVisible: false,
        dialogFormVisible: false,
        form: {

          typeName: '',
          orderNo: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        formLabelWidth: '120px',

      }
    },
    methods: {
      submitData(){
        this.dialogFormVisible = false;
        this.$axios.post('/api/blog_war_exploded/blogtype/addBlogType', qs.stringify({
          typeName: this.form.typeName,
          orderNo: this.form.orderNo
        }),{
          headers: {
            'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
          }
        })
          .then(response=>{
            console.log(response);
            this.tableData = [];
            this.getInfo();
            this.form.typeName='';
            this.form.orderNo='';
            // orderNo: '';
            // window.location.reload();
            // this.reload();

          })
          .catch(err=>{
            console.log(err);
          })

      },
      deleteData(id,key){

        this.$axios.get('/api/blog_war_exploded/blogtype/deleteBlogType?id='+id).then(response=>{
          console.log(response);
          if(response.data.status == 200){
            this.tableData.splice(key,1);
          }
          if(response.data.status == 202){
            alert("该博客类别下有博客, 不能删除");
          }
        }).catch(err=>{
          console.log(err);
        })
      },
      updateData(key){
        var id = this.id;
        var typeName = this.typeName;
        var orderNo = this.orderNo;
        this.chang(key);
        this.$axios.post('/api/blog_war_exploded/blogtype/updateBlogType', qs.stringify({
          id: id,
          typeName: typeName,
          orderNo: orderNo
        }),{
          headers: {
            'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
          }
        })
          .then(response=>{
          console.log(response);
          this.$set(this.tableData, key,{
            id,
            typeName,
            orderNo
          })
          // window.location.reload();

        })
          .catch(err=>{
            console.log(err);
          })
      },

      chang(key){

        this.id = this.tableData[key].id;
        this.typeName = this.tableData[key].typeName;
        this.orderNo = this.tableData[key].orderNo;


      },
      aaa(){


      },
      //获取博客类别列表
      getInfo(){
        this.$axios.get('api/blog_war_exploded/blogtype/countList').then(response=>{
          console.log(response)
          var ret = response.data.data;

          for(var i =0; i<ret.length; i++){
            this.tableData.push({
              id: ret[i].id,
              typeName: ret[i].typeName,
              orderNo: ret[i].orderNo
            })
          }
        }).catch(err=>{
          console.log(err);
        })
      }
    },
    mounted() {
      this.getInfo();

    }
  }
</script>

<style scoped>
  td{
    width: 300px;
    text-align: center;
  }
  .updatep{
    height: 20px;
  }
  .content{
    text-align: center;
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
  .title{
    display: block;
    padding-top: 5px;
    padding-left: 5px;
  }
</style>
