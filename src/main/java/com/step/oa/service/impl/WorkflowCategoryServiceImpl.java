package com.step.oa.service.impl;

import com.step.oa.entity.WorkflowCategory;
import com.step.oa.mapper.WorkflowCategoryMapper;
import com.step.oa.service.WorkflowCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-23.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Service
public class WorkflowCategoryServiceImpl implements WorkflowCategoryService {

    @Autowired
    private WorkflowCategoryMapper workflowCategoryMapper;
    /***
     * 新增流程分类
     * @param workflowCategory 流程分类
     */
    @Override
    public void save(WorkflowCategory workflowCategory) {
        workflowCategoryMapper.insertWorkflowCategory(workflowCategory);

    }

    /***
     * 根据ID 获取用户信息
     * @param id 流程分类id
     * @return  WorkflowCategory
     */
    @Override
    public Optional<WorkflowCategory> findById(Integer id) {
        Optional optional=Optional.ofNullable(workflowCategoryMapper.findWorkflowCategoryById(id));
        return optional;
    }
}
