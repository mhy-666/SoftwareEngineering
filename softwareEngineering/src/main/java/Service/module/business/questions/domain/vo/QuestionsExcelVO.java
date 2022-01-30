package Service.module.business.questions.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 *  [  ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-22 15:34:53
 * @since JDK1.8
 */
@Data
public class QuestionsExcelVO {
    @Excel(name = "题目id")
    private Long questionId;

    @Excel(name = "题目内容")
    private String question;

    @Excel(name = "题目选项")
    private String options;

    @Excel(name = "题解")
    private String solution;



}
