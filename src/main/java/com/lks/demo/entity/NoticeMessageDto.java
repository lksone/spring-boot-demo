package com.lks.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 發送message對象
 *
 * @author likesheng
 * @Time 2019/10/30
 **/
@Data
public class NoticeMessageDto implements Serializable {


    private static final long serialVersionUID = -7787900927693116530L;

    /**
     * 【必传】112312待办的唯一标示，注意：待办ID唯一，如果不同系统编号推相同待办ID，则无法推送成功！！！！
     */
    private String todoId;
    /**
     * 【必传】TEST（系统编号，如成本系统为COST，编号自己定义，同一个系统产生的待办，编号保持一样。）
     */
    private String systemNo;
    /**
     * 【必传】 xxxxxxx（待办的标题）
     */
    private String title;
    /**
     * 0（ 0:待审批，1:已审批，2:已取消 3:已删除 4:提交中 5:审批失败）
     */
    private Integer todoStatus = 0;
    /**
     * 待办所属的流程id，在BPM中叫instantId
     */
    private String flowId;
    /**
     * 【必传】待办的业务类型，如“合同审批”、“日常报销”，最好是英文
     */
    private String businessType;
    /**
     * 【必传】发起人oa账号
     */
    private String pubUserAccount;
    /**
     * 发起人UC的用户ID
     */
    private String pubUserId;
    /**
     * 【必传】审批人oa账号
     */
    private String appvUserAccount;
    /**
     * 审批人UC的用户ID
     */
    private String appvUserId;
    /**
     * 时间戳，1533108932000（毫秒）
     * 如果不传，则是调用时的时间
     */
    private Long createTime;
    /**
     * 步骤ID，待办在流程中步骤的ID
     */
    private String runNodeId;
    /**
     * PC端打开地址，要求此地址实现OA的单点登陆
     */
    private String target = "";
    /**
     * 发布人真实姓名，如果不传，则显示OA账号
     */
    private String pubTrueName;
    /**
     * 待办类型
     * 0待办，1通知，2传阅，3催办，4归档，5预警，6协商
     */
    private Integer todoType;
    /**
     * 移动端打开地址，注意：请确保实现了龙信的单点登陆，否则无法打开成功
     */
    private String spare = "";
    /**
     * 是否移动端可见，0不可见，1可见。 默认0，如果为1，“spare”字段不能为空
     * ，否则在移动端无法看到待办
     */
    private Integer isOpen = 1;

    /**
     * 0:非催办，1：催办。默认0
     */
    private Integer isReminder;

    /**
     * 扩展字段，可以是json字符串
     */
    private String enlarge;
}
