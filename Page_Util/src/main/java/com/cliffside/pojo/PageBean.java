package com.cliffside.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:
 * @Description: MircoMessage:Mark_7001
 */
public class PageBean<T> implements Serializable {
    // 当前页数据
    private List<T> data;
    // 查询出的总记录数
    private int totalSize;
    // 页大小
    private int pageSize;
    // 总页数
    private int totalPage;
    // 当前页数
    private int currentPage;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public PageBean(List<T> data, int totalSize, int pageSize, int totalPage, int currentPage) {
        this.data = data;
        this.totalSize = totalSize;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
    }

    public PageBean() {
    }
}
