package com.flf.funny.model.bean.base;


import java.util.List;

/**
 * author: zheng
 * created on: 2017/2/13 17:42
 * description:列表数据,目前分页格式
 * TODO 依照本项目分页结构,重写本类与{@link BaseListModel}
 * version: 1.0
 */
public class ListWrapper<T> {
    private int total;
    private int records;
    private int page;
    private List<T> rows;


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
