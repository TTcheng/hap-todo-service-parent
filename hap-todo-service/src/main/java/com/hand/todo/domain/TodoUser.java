package com.hand.todo.domain;

import com.hand.hap.cloud.mybatis.annotation.ModifyAudit;
import com.hand.hap.cloud.mybatis.annotation.VersionAudit;
import com.hand.hap.cloud.mybatis.domain.AuditDomain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Copyright @ 2017 Shanghai Hand Co. Ltd.
 * All right reserved.
 *
 * @author chuncehng.wang@hand-china.com
 * @version 1.0
 * @name TodoUser
 * @description todo
 * @date 19-1-11 下午2:58
 */
@ModifyAudit    //更新审计字段 createdBy creationDate ,lastUpdatedBy ,lastUpdateDate
@VersionAudit   //更新时需回传版本号 objectVersionNumber
@Table(name = "todo_user")
public class TodoUser extends AuditDomain {
    @Id
    @GeneratedValue
    private Long id;

    private String employeeName;
    @NotNull
    private Long employeeNumber;
    private String email;
}
