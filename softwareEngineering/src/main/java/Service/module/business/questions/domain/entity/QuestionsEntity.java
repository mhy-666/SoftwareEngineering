package Service.module.business.questions.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import Service.common.domain.BaseEntity;
import lombok.Data;

/**
 * [  ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-22 15:34:53
 * @since JDK1.8
 */
@Data
@TableName("e_questions")
public class QuestionsEntity extends BaseEntity{

    /**
     * 题目id
     */
    private Long questionId;

    /**
     * 题目内容
     */
    private String question;

    /**
     * 题目选项
     */
    private String options;

    /**
     * 题解
     */
    private String solution;

}
