package com.step.orm.core.param;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 * 排序
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class Sort extends Column {

    private String order = "asc";

    public Sort() {
    }
    public Sort(String column) {
        this.setName(column);
    }

    public String getOrder() {
        if ("desc".equalsIgnoreCase(order)) {
            return order;
        } else {
            return order = "asc";
        }
    }

    public void asc() {
        this.order = "asc";
    }

    public void desc() {
        this.order = "desc";
    }

}
