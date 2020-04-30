package com.july.bpm.entity;

import lombok.Data;

import java.util.List;

/**
 * 流程表单信息
 * @author zengxueqi
 * @since 2020/4/7
 */
@Data
public class FlowForm {

    /**
     * 任务名称
     */
    private String actName;
    /**
     * 派遣人
     */
    private String assignee;
    /**
     * 流程实例ID
     */
    private String procInstId;
    /**
     * 任务ID
     */
    private String taskId;
    /**
     * 表单属性
     */
    private List<KeyValue> process;

}