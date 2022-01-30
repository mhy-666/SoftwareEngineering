package Service.module.business.questions.domain.dto;

import Service.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

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
public class QuestionsQueryDTO extends PageParamDTO {

    @ApiModelProperty("题目id")
    private Long questionId;

    @ApiModelProperty("题目内容")
    private String question;

    @ApiModelProperty("题目选项")
    private String options;

    @ApiModelProperty("题解")
    private String solution;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
