package com.itjizhiyong.controller;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class loginController {
    @PostMapping("/login")
    public LoginNum login(@RequestParam ("JsonNum") String JsonNum){
        JSONArray jsonArray = new JSONArray(JsonNum);
        String phone = (String) jsonArray.getJSONObject(0).get("phone");
        String password = (String) jsonArray.getJSONObject(0).get("password");
        return null;
    }
}
