package tedu.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tedu.store.entity.CollectionDao;
import tedu.store.service.CollectService;
import tedu.store.util.ResponseResult;

import javax.servlet.http.HttpSession;
import java.util.List;


//@RestController
//@RequestMapping("/collect")
//public class CollectController {
//
//    @Autowired
//    CollectService collectService;
//
//    @RequestMapping("/getinfo")
//    public ResponseResult<List<CollectionDao>> getByUid(HttpSession session){
//
//        //获取用户id
//        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
//
//        return new ResponseResult(200, uid);
//    }
//
//
//
//}
