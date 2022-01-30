package Service.module.business.score.domain.dto;

import Service.common.domain.PageParamDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * [ 课程成绩 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:13:10
 * @since JDK1.8
 */
@Data
public class ScoreQueryDTO extends PageParamDTO {

    @ApiModelProperty("学号")
    private Long studentId;

    @ApiModelProperty("课程编号")
    private Long courseId;

    @ApiModelProperty("班级号")
    private Long classId;

    @ApiModelProperty("考勤分数")
    private BigDecimal attendScore;

    @ApiModelProperty("实验分数")
    private BigDecimal experimentScore;

    @ApiModelProperty("总分")
    private BigDecimal sumScore;

    @ApiModelProperty("创建时间-开始")
    private Date createTimeBegin;

    @ApiModelProperty("创建时间-截止")
    private Date createTimeEnd;

    @ApiModelProperty("上次更新时间-开始")
    private Date updateTimeBegin;

    @ApiModelProperty("上次更新创建时间-开始")
    private Date updateTimeEnd;
}
