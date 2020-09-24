package com.step.oa.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-23.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 * 流程分类
 */
@Getter
@Setter
public class WorkflowCategory {
    /***
     * 主键id
     */
    private Integer id;
    /***
     * 名称
     */
    private String name;
    /***
     * 描述信息
     */
    private String memo;
    /***
     * 排序
     */
    private Integer orders;
    /***
     * 流程定义表
     */
    private List<WorkflowBase> workflowBaseList;

}
