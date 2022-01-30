package Service.module.business.questions.domain.dto;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [  ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 2018 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-22 15:34:53
 * @since JDK1.8
 */
@Data
public class QuestionsAddDTO {
    @ApiModelProperty("题目id")
    private Long questionId;

    @ApiModelProperty("题目内容")
    private String question;

    @ApiModelProperty("题目选项")
    private String options;

    @ApiModelProperty("题解")
    private String solution;


}
