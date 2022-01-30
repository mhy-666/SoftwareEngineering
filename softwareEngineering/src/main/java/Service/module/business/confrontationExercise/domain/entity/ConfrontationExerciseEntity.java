package Service.module.business.confrontationExercise.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import Service.common.domain.BaseEntity;
import lombok.Data;

/**
 * [ 对抗练习信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-21 22:41:43
 * @since JDK1.8
 */
@Data
@TableName("e_confrontation_exercise")
public class ConfrontationExerciseEntity extends BaseEntity{

    /**
     * 对抗练习id
     */
    private Long confrontationId;
    /**
     * 对抗练习名称
     */
    private String confrontationName;

    /**
     * 课程id
     */
    private Long courseId;

    /**
     * 班级id
     */
    private Long classId;

    /**
     * 对抗练习描述
     */
    private String confrontationDescrip;

    /**
     * 题库id
     */
    private Long questionbankId;

    /**
     * 作答时间
     */
    private String answerTime;

    /**
     * 截止时间
     */
    private String deadline;

}
