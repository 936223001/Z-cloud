package com.zqj.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;

import java.util.Date;

/***
 * @Description 实体类基类
 * @author zhuqijing
 * @date 2021/4/13
 * @Version 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@FieldNameConstants
public class BaseEntity<T> extends Model<BaseEntity<T>> {

    @TableId(value = "id", type = IdType.AUTO)
    protected String id;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date updateTime;

    /**
     * 创建者
     */
//    @TableField(value = "creator", fill = FieldFill.INSERT)
//    public String creator;

    /**
     * 排序号
     */
//    @TableField(value = "sort")
//    public Integer sort = 1;
}
