package Service.module.business.classinfo.domain.entity;

import Service.common.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * [ 实验班级信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-02 20:44:23
 * @since JDK1.8
 */
@Data
@TableName("t_classinfo")
public class ClassinfoEntity extends BaseEntity {

    /**
     * 班级编号
     */
    private Long classId;

    /**
     * 课程编号
     */
    private Long courseId;

    /**
     * 开课学年学期
     */
    private String classTerm;

    /**
     * 上课安排编号
     */
    private Long scheduleTimeId;

    /**
     * 上课地点
     */
    private String place;

}
