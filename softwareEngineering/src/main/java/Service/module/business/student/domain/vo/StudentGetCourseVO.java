package Service.module.business.student.domain.vo;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 *  [ 学生信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-10 10:19:19
 * @since JDK1.8
 */
@Data
public class StudentGetCourseVO {

    @ApiModelProperty("课程编号")
    private Long courseId;

    @ApiModelProperty("班级编号")
    private Long classId;

    @ApiModelProperty("班级开课学年学期")
    private String classTerm;

    @ApiModelProperty("课程名称")
    private String name;

    @ApiModelProperty("教师")
    private String teacherName;

    @ApiModelProperty("学分")
    private BigDecimal credit;

    @ApiModelProperty("院系")
    private String department;

    @ApiModelProperty("地点")
    private String place;
}
