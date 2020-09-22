package com.step.orm.rdb.operator.dml.query;

import com.step.orm.core.MethodReferenceColumn;
import com.step.orm.core.StaticMethodReferenceColumn;
import com.step.orm.rdb.operator.dml.FunctionColumn;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhushubin
 * @version 1.0
 * Created by zhushubin  on 2020-09-22.
 * email:604580436@qq.com
 * @email 604580436@qq.com
 */
@Getter
@Setter
public class SortOrder extends FunctionColumn {

    private Order order = SortOrder.Order.asc;

    public static <T> SortOrder desc(StaticMethodReferenceColumn<T> column) {
        return desc(column.getColumn());
    }

    public static <T> SortOrder asc(StaticMethodReferenceColumn<T> column) {
        return asc(column.getColumn());
    }

    public static <T> SortOrder desc(MethodReferenceColumn<T> column) {
        return desc(column.getColumn());
    }

    public static <T> SortOrder asc(MethodReferenceColumn<T> column) {
        return asc(column.getColumn());
    }

    public static SortOrder desc(String column) {
        SortOrder order = new SortOrder();
        order.setColumn(column);
        order.setOrder(Order.desc);

        return order;
    }

    public static SortOrder asc(String column) {
        SortOrder order = new SortOrder();
        order.setColumn(column);
        order.setOrder(Order.asc);

        return order;
    }

    public enum Order {
        asc,
        desc
    }
}
