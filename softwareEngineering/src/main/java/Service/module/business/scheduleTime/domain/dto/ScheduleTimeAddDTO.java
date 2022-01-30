package Service.module.business.scheduleTime.domain.dto;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新建 [ 上课安排 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 2018 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-09 00:47:47
 * @since JDK1.8
 */
@Data
public class ScheduleTimeAddDTO {
    @ApiModelProperty("上课日期")
    private String day;

    @ApiModelProperty("上课开始时间")
    private String startTime;

    @ApiModelProperty("结束时间")
    private String endTime;


}
