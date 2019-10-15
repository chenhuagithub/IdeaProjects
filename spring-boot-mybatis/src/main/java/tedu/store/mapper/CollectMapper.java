package tedu.store.mapper;

import tedu.store.entity.CollectionDao;

import java.util.List;

public interface CollectMapper {

    public List<CollectionDao> getByUid(Integer uid);

}
