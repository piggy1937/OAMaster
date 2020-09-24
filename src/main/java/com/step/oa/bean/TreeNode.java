package com.step.oa.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-24.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 * 树形图node 信息
 */
@Getter
@Setter
public class TreeNode implements Serializable{
    private String key; //主键
    private String title;//名称
    private List<TreeNode> child;
}
