package com.step.oa.service;

import com.step.oa.entity.WorkflowCategory;

import java.util.Optional;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-23.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 * service -流程分类
 */
public interface WorkflowCategoryService {
    /***
     * 新增流程分类
     * @param workflowCategory 流程分类
     */
    void save(WorkflowCategory workflowCategory);

    Optional<WorkflowCategory> findById(Integer id);
}
