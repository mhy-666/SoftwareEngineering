package Service.module.business.scheduleTime.domain.dto;

import lombok.Data;

/**
 * 更新 [ 上课安排 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 2018 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-09 00:47:47
 * @since JDK1.8
 */
@Data
public class ScheduleTimeUpdateDTO extends ScheduleTimeAddDTO {

    private Long id;

}
