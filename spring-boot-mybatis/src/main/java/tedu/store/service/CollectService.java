package tedu.store.service;

import tedu.store.entity.CollectionDao;

import java.util.List;

public interface CollectService {

    public List<CollectionDao> getByUid(Integer uid);

}
