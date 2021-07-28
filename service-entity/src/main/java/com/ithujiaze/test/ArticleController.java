package com.ithujiaze.test;

import com.ithujiaze.entity.Authority;
import com.ithujiaze.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    /**
     * 根据id查找文章
     * @param id
     * @return
     */
    @GetMapping("/getOneById/{id}")
    public Authority getOneById(@PathVariable int id) {
        return articleService.getOneById(id);
    }


}
