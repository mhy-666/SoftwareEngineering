package Service.module.business.course.domain.dto;

import lombok.Data;

/**
 * 更新 [ 课程管理 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 2018 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-01 23:51:13
 * @since JDK1.8
 */
@Data
public class CourseUpdateDTO extends CourseAddDTO {

    private Long id;

}
