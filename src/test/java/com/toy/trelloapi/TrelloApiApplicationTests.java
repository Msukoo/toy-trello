package com.toy.trelloapi;

import org.junit.jupiter.api.Test;
import org.junit.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TrelloApiApplicationTests {

    @Test
    void contextLoads() {
    }
}


//import java.util.ArrayList;
//        import java.util.Arrays;
//        import java.util.HashMap;
//        import java.util.Map;
//        import java.util.Map.Entry;
//        import java.util.Iterator;
//
//class Solution {
//    Map<String, String> userMap = new HashMap();
//    ArrayList<String> answer = new ArrayList();
//
//    public String[] solution(String[] record) {
//
//        for(String code : record){
//            String[] codeArr = code.split(" ");
//            String service = codeArr[0];
//            String user = codeArr[1];
//            String nickName = "";
//            if(codeArr.length>2){
//                nickName = codeArr[2];
//            }
//
//            switch(service) {
//                case "Enter":
//                    userMap.put(user, nickName);
//                    answer.add(enterMessage(name));
//                    break;
//                case "Leave":
//                    answer.add(leaveMessage(name));
//                    break;
//                case "Change":
//                    userMap.put(user, nickName);
//                    break;
//                default: break;
//            }
//        }
//
//        for(String str : answer){
//            for(String key : userMap.keySet()){
//                str.replace(key, userMap.get(key));
//            }
//        }
//
//        return answer.toArray(new String[answer.size()]);
//
//    }
//
//    private String enterMessage(String user){
//        return String.format("%s님이 들어왔습니다.", user);
//    }
//    private String leaveMessage(String user){
//        return String.format("%s님이 나갔습니다.", user);
//    }
//
//}