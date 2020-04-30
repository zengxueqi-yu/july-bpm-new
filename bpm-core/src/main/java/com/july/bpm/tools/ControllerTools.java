package com.july.bpm.tools;

import com.july.bpm.query.*;
import com.july.bpm.response.impl.ResultMsg;
import com.july.bpm.utils.RequestUtil;
import com.july.bpm.utils.StringUtil;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ControllerTools {

    protected Logger LOG = LoggerFactory.getLogger(getClass());

    protected <T> ResultMsg<T> getSuccessResult(T data, String msg) {
        ResultMsg<T> resultMsg = new ResultMsg<T>();
        resultMsg.setOk(true);
        resultMsg.setMsg(msg);
        resultMsg.setData(data);
        return resultMsg;
    }

    protected <T> ResultMsg<T> getSuccessResult(T data) {
        ResultMsg<T> resultMsg = new ResultMsg<T>();
        resultMsg.setOk(true);
        resultMsg.setData(data);
        return resultMsg;
    }


    protected ResultMsg<String> getSuccessResult(String msg) {
        ResultMsg<String> resultMsg = new ResultMsg<String>();
        resultMsg.setOk(true);
        resultMsg.setMsg(msg);
        resultMsg.setData(msg);
        return resultMsg;
    }

    protected ResultMsg<String> getWarnResult(String msg) {
        ResultMsg<String> resultMsg = new ResultMsg<String>();
        resultMsg.setOk(false);
        resultMsg.setMsg(msg);
        return resultMsg;
    }

    protected ResultMsg<String> getSuccessResult() {
        ResultMsg<String> resultMsg = new ResultMsg<String>();
        resultMsg.setOk(true);
        resultMsg.setMsg("操作成功");
        return resultMsg;
    }


    /**
     * 返回构建的QueryFilter
     * @param request
     * @return QueryFilter
     * @throws
     * @since 1.0.0
     */
    protected QueryFilter getQueryFilter(HttpServletRequest request) {
        DefaultQueryFilter queryFilter = new DefaultQueryFilter();
        try {
            RequestUtil.handleRequestParam(request, queryFilter);

            String offset = request.getParameter("offset");
            String limit = request.getParameter("limit");
            if (StringUtil.isNotEmpty(offset) && StringUtil.isNotEmpty(limit)) {
                RowBounds rowBounds = new RowBounds(Integer.parseInt(offset), Integer.parseInt(limit));
                DefaultPage page = new DefaultPage(rowBounds);
                queryFilter.setPage(page);
            }

            // 设置排序字段
            String sort = request.getParameter("sort");
            String order = request.getParameter("order");
            if (StringUtil.isNotEmpty(sort) && StringUtil.isNotEmpty(order)) {
                List<FieldSort> fieldSorts = new ArrayList<FieldSort>();
                fieldSorts.add(new DefaultFieldSort(sort, Direction.fromString(order)));
                queryFilter.setFieldSortList(fieldSorts);
            }
        } catch (Exception e) {
        }
        return queryFilter;
    }

}
