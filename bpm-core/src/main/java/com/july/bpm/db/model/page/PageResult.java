package com.july.bpm.db.model.page;

import com.github.pagehelper.Page;
import com.july.bpm.response.impl.BaseResult;

import java.util.List;

@SuppressWarnings("rawtypes")
public class PageResult<T> extends BaseResult {
    private static final long serialVersionUID = 1L;
    // 总记录数
    private Integer pageSize = 0;
    private Integer page = 1;
    private Integer total = 0;
    // 行记录
    private List rows = null;

    public PageResult() {

    }

    public PageResult(List<T> rows, Integer total) {
        this.rows = rows;
        this.total = total;
    }

    public PageResult(List<T> arrayList) {
        this.rows = arrayList;

        //适配 pagehelper 的 page
        if (arrayList instanceof Page) {
            Page pageList = (Page) arrayList;
            Integer total = new Long(pageList.getTotal()).intValue();
            this.pageSize = pageList.getPageSize();
            this.setPage(pageList.getPages());
            this.setTotal(total);

        } else {
            this.total = arrayList.size();
        }
        this.setOk(Boolean.TRUE);
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }


}
