package com.itjizhiyong.controller;

import com.itchenyang.result.R;
import com.itjizhiyong.entities.Role_Authority;
import com.itjizhiyong.service.Role_AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Role_Authority")
@CrossOrigin(origins = "*")
public class Role_AuthorityController {
    @Autowired
    private Role_AuthorityService role_authorityService;

    @GetMapping("/DeleteAllByRoleId")
    public R DeleteAllByRoleId(@RequestParam("id") int role_id) {
        return role_authorityService.DeleteAllByRoleId(role_id);
    }

    @PostMapping("/UpdateAllByRoleId")
    public R UpdateAllByRoleId(@RequestBody List<Role_Authority> role_authorities) {
        return role_authorityService.UpdateByRoleId(role_authorities);
    }

    @PostMapping("/InsertAllByRoleId")
    public R InsertAllByRoleId(@RequestBody List<Role_Authority> role_authorities) {
        return role_authorityService.InsertAllByRoleId(role_authorities);
    }
}
