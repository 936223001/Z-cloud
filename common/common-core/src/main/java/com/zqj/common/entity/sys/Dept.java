package com.zqj.common.entity.sys;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zqj.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author zqj
 * @since 2021-04-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_dept")
public class Dept extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 上级部门ID
     */
    private Long parentId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 排序
     */
    private Double orderNum;

}
