package com.atguigu.tensquarebase.service;

import com.atguigu.tensquare_common.util.IdWorker;
import com.atguigu.tensquarebase.bean.Label;
import com.atguigu.tensquarebase.dao.LabelMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LabelService {

    @Autowired
    private LabelMapper labelMapper;

    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll(){
        return labelMapper.selectList(null);
    }


    public Label findById(String labelId){
        return labelMapper.selectById(labelId);
    }

    // 插入数据
    public void save(Label label){
        label.setId(idWorker.nextId()+"");
        System.out.println(label);
        labelMapper.insert(label);
    }

    // 更新数据
    public void update(String labelId, Label label){
        label.setId(labelId);
        labelMapper.updateById(label);
    }

    //删除数据
    public void deleteById(String labelId){
        labelMapper.deleteById(labelId);
    }


    // 分页
    public List<Label> findSearch(Label label, Integer current, Integer size){

        // 定义条件选择器实例, 并拼接条件
        QueryWrapper<Label> labelQueryWrapper = new QueryWrapper<>();
        if(label.getLabelname() != null){
            labelQueryWrapper = labelQueryWrapper.like("labelname", label.getLabelname());
        }else if(label.getState() != null){
            labelQueryWrapper = labelQueryWrapper.eq("state", label.getState());
        }else if(label.getCount() != null){
            labelQueryWrapper = labelQueryWrapper.eq("count", label.getCount());
        }else if(label.getRecommend() != null){
            labelQueryWrapper = labelQueryWrapper.eq("recommend", label.getRecommend());
        }else if(label.getFans() != null){
            labelQueryWrapper = labelQueryWrapper.eq("fans", label.getFans());
        }else if(label.getId() != null){
            labelQueryWrapper = labelQueryWrapper.eq("id", label.getId());
        }

        IPage<Label> page = labelMapper.selectPage(new Page<Label>(current, size), labelQueryWrapper);
        List<Label> records = page.getRecords();
        return records;
    }

}
