package Service.module.business.teacher.domain.dto;

import lombok.Data;

/**
 * 更新 [ 教师信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 2018 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-10 10:25:31
 * @since JDK1.8
 */
@Data
public class TeacherUpdateDTO extends TeacherAddDTO {

    private Long id;

}
