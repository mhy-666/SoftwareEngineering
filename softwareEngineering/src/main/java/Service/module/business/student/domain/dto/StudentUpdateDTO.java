package Service.module.business.student.domain.dto;

import lombok.Data;

/**
 * 更新 [ 学生信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 2018 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-10 10:19:19
 * @since JDK1.8
 */
@Data
public class StudentUpdateDTO extends StudentAddDTO {

    private Long id;

}
