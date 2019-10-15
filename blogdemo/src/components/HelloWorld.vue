<template>
  <div>
    <el-badge :value="12" class="item">
      <el-button size="small" class="el-icon-chat-round">评论</el-button>
    </el-badge>

    <span style="display: inline-block;height: 100px;width: 60px;background-color: #409EFF"><i  class="el-icon-chat-round" height="60px" width="60px"></i></span>
    <el-badge :value="count" class="item">
      <el-button size="small">回复</el-button>
    </el-badge>
    <el-badge :value="1" class="item" type="primary">
      <el-button size="small">评论</el-button>
    </el-badge>


    <el-badge :value="2" class="item" type="warning">
      <el-button size="small">回复</el-button>
    </el-badge>


  </div>
</template>

<script>
  export default {
    data(){
      return{
        count: 23
      }
    }
  }
</script>



<style>
  .item {
    margin-top: 10px;
    margin-right: 40px;
  }
</style>
