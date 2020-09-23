package com.step.oa.mapper;

import com.step.oa.entity.WorkflowCategory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-18.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Repository
public interface WorkflowCategoryMapper {
    /***
     * 插入流程分类
     * @param workflowCategory 流程分类
     */
    void insertWorkflowCategory(WorkflowCategory workflowCategory);

    WorkflowCategory findWorkflowCategoryById(Integer id);
}
