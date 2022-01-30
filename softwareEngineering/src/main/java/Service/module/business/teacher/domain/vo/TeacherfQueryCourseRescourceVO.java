package Service.module.business.teacher.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 新建 [ 学生信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c) 2018 同济大学软件学院Inc. All rights reserved.
 * @date  2021-12-10 10:19:19
 * @since JDK1.8
 */
@Data
public class TeacherfQueryCourseRescourceVO {


    @ApiModelProperty("项目id")
    private Long resourceId;

    @ApiModelProperty("项目名称")
    private String resourceName;

    @ApiModelProperty("上传者id")
    private Long uploaderId;

    @ApiModelProperty("上传者名称")
    private String uploaderName;

    @ApiModelProperty("下载次数")
    private Long downloadTimes;


}
