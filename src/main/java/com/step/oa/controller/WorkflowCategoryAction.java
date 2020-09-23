package com.step.oa.controller;

import com.step.oa.entity.WorkflowCategory;
import com.step.oa.service.WorkflowCategoryService;
import com.step.utils.WrapMapper;
import com.step.utils.Wrapper;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-18.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@RestController("workflowCategoryAction")
@RequestMapping("/workflow_category")
public class WorkflowCategoryAction {
    @Autowired
    private WorkflowCategoryService workflowCategoryService;
    /***
     * 新增流程分类
     * @param workflowCategory 流程分类
     * @return json
     */
    @PostMapping
    public String add(@RequestBody WorkflowCategory workflowCategory){

        workflowCategoryService.save(workflowCategory);

        return "HellWord";
    }
    /***
     * 新增流程分类
     * @param workflowCategory 流程分类
     * @return json
     */
    @GetMapping("/{id}")
    public String add(@PathVariable("id") Integer id){

        WorkflowCategory workflowCategory= workflowCategoryService.findById(id).orElseGet(()->{
          return null;
       });
        if(workflowCategory==null){
            return "无法找到实体类";
        }


        return workflowCategory.toString();
    }
    @GetMapping("/all")
    public Wrapper all(){
        List<WorkflowCategory> workflowCategorys= workflowCategoryService.findList().orElse(Collections.emptyList());
        return WrapMapper.ok(workflowCategorys);
    }
}
