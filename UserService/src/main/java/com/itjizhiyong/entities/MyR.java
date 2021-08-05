package com.itjizhiyong.entities;

import com.itchenyang.result.R;
import com.itchenyang.result.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

    @Data
    @AllArgsConstructor


    public class MyR {
        private Integer code;
        private String message;
        private String Affiliation;
        private Map<String, Object> data = new HashMap<>();

        public MyR(){};    // 私有构造函数

        public static com.itjizhiyong.entities.MyR ok() {
            com.itjizhiyong.entities.MyR r = new com.itjizhiyong.entities.MyR();
            r.setCode(ResponseEnum.SUCCESS.getCode());
            r.setMessage(ResponseEnum.SUCCESS.getMessage());
            return r;
        }

        public static com.itjizhiyong.entities.MyR error() {
            com.itjizhiyong.entities.MyR r = new com.itjizhiyong.entities.MyR();
            r.setCode(ResponseEnum.ERROR.getCode());
            r.setMessage(ResponseEnum.ERROR.getMessage());
            return r;
        }

        public static com.itjizhiyong.entities.MyR setResult(ResponseEnum responseEnum) {
            com.itjizhiyong.entities.MyR r = new com.itjizhiyong.entities.MyR();
            r.setCode(responseEnum.getCode());
            r.setMessage(responseEnum.getMessage());
            return r;
        }

        // 设置data
//        public com.itjizhiyong.entities.MyR playData(Map<String,String> map) {
//            this.setData(map);
//            return this;
//        }
        public MyR playData(Map<String,Object> map) {
            this.setData(map);
            return this;
        }

        public MyR playData(String key,Object value) {
            this.data.put(key, value);
            return this;
        }

        // 设置具体的打印消息
        public com.itjizhiyong.entities.MyR playAffiliation(String Affiliation) {
            this.setAffiliation(Affiliation);
            return this;
        }
        public com.itjizhiyong.entities.MyR playMessage(String message) {
            this.setMessage(message);
            return this;
        }



        // 设置具体的状态码
        public com.itjizhiyong.entities.MyR playCode(Integer code) {
            this.setCode(code);
            return this;
        }


    }

