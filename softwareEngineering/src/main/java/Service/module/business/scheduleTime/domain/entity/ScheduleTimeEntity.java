package Service.module.business.scheduleTime.domain.entity;

import Service.common.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * [ 上课安排 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-09 00:47:47
 * @since JDK1.8
 */
@Data
@TableName("e_schedule_time")
public class ScheduleTimeEntity extends BaseEntity {

    /**
     * 上课安排编号
     */
    private Long id;
    /**
     * 上课日期
     */
    private String day;

    /**
     * 上课开始时间

     */
    private String startTime;

    /**
     * 结束时间

     */
    private String endTime;

}
