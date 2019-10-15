package tedu.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tedu.store.entity.CollectionDao;
import tedu.store.mapper.CollectMapper;
import tedu.store.service.CollectService;

import java.util.List;

public class CollectServiceImpl implements CollectService {

    @Autowired
    CollectMapper collectMapper;


    @Override
    public List<CollectionDao> getByUid(Integer uid) {


        return collectMapper.getByUid(uid);
    }


}
