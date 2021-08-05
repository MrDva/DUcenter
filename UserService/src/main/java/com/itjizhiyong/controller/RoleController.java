package com.itjizhiyong.controller;

import com.itchenyang.result.R;
import com.itjizhiyong.entities.Role;
import com.itjizhiyong.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Role")
@CrossOrigin(origins = "*")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/GetRoleById")
    public R GetRoleById(@RequestParam("id") int id){
        return roleService.GetRoleById(id);
    }
    @PostMapping("/UpdateRoleById")
    public R UpdateRoleById(@RequestParam("name") String name,
                              @RequestParam("list") List<String> list,
                              @RequestParam("id") String id){
        return roleService.UpdateRoleById(name,list,id);
    }
    @GetMapping("/DeleteRoleById")
    public  R DeleteRoleById(@RequestParam("id") int id){
        return roleService.DeleteRoleById(id);
    }
    @PostMapping("/InsertRoleId")
    public R   InsertRoleId(@RequestBody Role role){
        return roleService.InsertRoleId(role);
    }

    @GetMapping("/GetRoleAll")
    public R GetRoleAll(){
        return roleService.GetRoleALl();
    }
}
