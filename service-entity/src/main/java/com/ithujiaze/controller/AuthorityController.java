package com.ithujiaze.controller;

import com.itchenyang.result.R;
import com.ithujiaze.entity.Authority;
import com.ithujiaze.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Authority")
@CrossOrigin(origins = "*")
public class AuthorityController {
    @Autowired
    private AuthorityService authorityService;

    @GetMapping("/GetAuthorityById/{id}")
    public R GetAuthorityById(@PathVariable int id) {
        return authorityService.GetAuthorityById(id);
    }

    @GetMapping("/GetAuthorityAll")
    public R GetAuthorityAll() {
        return authorityService.GetAuthorityAll();
    }

//    @GetMapping("/GetPage")
//    public R GetPage(@RequestParam("page") Integer page) {
//        return authorityService.GetPage(page);
//    }

    @PostMapping("/InsertAuthority")
    public R InsertAuthority(@RequestBody Authority authority) {
        return authorityService.InsertAuthority(authority);
    }

    @PutMapping("/UpdateAuthorityById")
    public R UpdateAuthorityById(@RequestBody Authority authority) {
        return authorityService.UpdateAuthorityById(authority);
    }

    @GetMapping("/DeleteAuthorityById")
    public R DeleteAuthorityById(@RequestParam("id") int id){
        return authorityService.DeleteAuthorityById(id);
    }
}
