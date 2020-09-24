package com.step.oa.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-24.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Getter
@Setter
public class WorkflowBase {
    /*
     * 主键id
     */
    private Integer id;
    private String name;
    private WorkflowCategory workflowCategory;

}
