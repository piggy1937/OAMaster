package com.step.orm.rdb.executor.wrapper;

public interface ColumnWrapperContext<T> {

    int getColumnIndex();

    String getColumnLabel();

    Object getResult();

    T getRowInstance();

    void setRowInstance(T instance);
}
