package Service.module.business.scheduleTime.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 *  [ 上课安排 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-09 00:47:47
 * @since JDK1.8
 */
@Data
public class ScheduleTimeExcelVO {
    @Excel(name = "上课安排编号")
    private Long id;

    @Excel(name = "上课日期")
    private String day;

    @Excel(name = "上课开始时间")
    private String startTime;

    @Excel(name = "结束时间")
    private String endTime;



}
