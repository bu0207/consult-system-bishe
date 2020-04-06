package com.consult_system.util;

import java.io.IOException;
import java.util.Map;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.consult_system.viewmodel.ApiResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

/**
 * @author jacob
 * @date 2019/12/30
 * @description json工具类
 */

public class JSONUtils {

	private static ObjectMapper objectMapper = new ObjectMapper();


    public static String toJsonString(Object object) {
        String result = null;
        try {
            result = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Map<String, Object> toMap(String jsonString) {
        TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
        };

        Map<String, Object> result = null;
        try {
            result = objectMapper.readValue(jsonString, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

    public static boolean checkIsJson(String jsonData){
        try {
            JSONObject.parseObject(jsonData);
        } catch (JSONException ex) {
            try {
                JSONObject.parseArray(jsonData);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }
}
