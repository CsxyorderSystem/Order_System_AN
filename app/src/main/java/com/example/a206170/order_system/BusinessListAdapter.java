package com.example.a206170.order_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2017/8/17.
 */

public class BusinessListAdapter {
    public List<Map<String, Object>> getData(){
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        Map<String,Object>map=new HashMap<String,Object>();


        map.put("business_logo",R.drawable.adtest1);
        map.put("business_name","商店测试1");
        map.put("business_estimate","评分测试");
        map.put("business_seal_num","月销量");
        map.put("business_price","人均测试");
        map.put("business_open","开店测试");
        list.add(map);
        return list;

    }

}
