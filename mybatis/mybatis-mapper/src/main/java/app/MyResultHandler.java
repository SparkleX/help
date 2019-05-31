package app;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import domain.User;

public class MyResultHandler implements ResultHandler<HashMap<String,Object>>{

    private User resultMap = new User();
    
    @Override
    public void handleResult(ResultContext<? extends HashMap<String,Object>> resultContext) {

        Map<String,Object> resultObject = resultContext.getResultObject();
        System.out.println(resultObject.get("id"));
        
    }
    public User getResults(){
        return resultMap;
    }
 }