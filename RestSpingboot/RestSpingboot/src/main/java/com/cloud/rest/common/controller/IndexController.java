package com.cloud.rest.common.controller;

import com.cloud.rest.common.bean.ResultBean;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api")
public class IndexController {

    @RequestMapping(value = "/fibonacci", method = RequestMethod.POST)
    public ResultBean fibonacci(@RequestBody Map<String, Object> param) {

        //result
        Map<String,Object> resultMap=new HashMap<>();

        //get the data from front end
        Integer elements=Integer.valueOf(param.get("elements").toString());

        if(elements<1||elements>100){
            ResultBean resultBean=new ResultBean();
            resultBean.setCode(-1);
            resultBean.setMsg("cant smaller than 1 or bigger than 100");
            return resultBean;
        }

        List<Integer> fibonacciList=getFibonacciDatas(elements);

        resultMap.put("fibonacci",fibonacciList);

        List<Integer> oddList=new ArrayList<>();
        List<Integer> evenList=new ArrayList<>();

        for(Integer i:fibonacciList){
            if(oddOrEven(i).equals("odd")){
                oddList.add(i);
            }else {
                evenList.add(i);
            }
        }

        //sort
        Collections.reverse(oddList);
        Collections.reverse(evenList);

        //combine the array
        evenList.addAll(oddList);

        resultMap.put("sorted",evenList);

        return new ResultBean<>(resultMap);
    }


    /**
     * return fibonacci array
     * @param num
     * @return
     */
    public List<Integer> getFibonacciDatas(Integer num) {
        List<Integer> results=new ArrayList<>();
        int n0 = 0, n1 = 1, n2;
        results.add(n0);
        results.add(n1);
        for (int i = 0; i < (num - 2); i++) {
            n2 = n1 + n0;
            results.add(n2);
            n0 = n1;
            n1 = n2;
        }
        return results;
    }


    /**
     * odd or even
     * @param a
     * @return
     */
    public  String oddOrEven(int a) {
        if (a % 2 != 0) {
            return "odd";
        } else {
            return "even";
        }
    }
}
