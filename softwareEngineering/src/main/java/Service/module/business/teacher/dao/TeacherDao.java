package Service.module.business.teacher.dao;

import Service.module.business.courseResourcePublishing.domain.entity.CourseResourcePublishingEntity;
import Service.module.business.experimentProject.domain.entity.ExperimentProjectEntity;
import Service.module.business.stuExperimentProjectReport.domain.entity.StuExperimentProjectReportEntity;
import Service.module.business.teacher.domain.dto.*;
import Service.module.business.teacherExperimentProject.domain.entity.TeacherExperimentProjectEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import Service.module.business.courseResourcePublishing.domain.dto.CourseResourcePublishingQueryDTO;
import Service.module.business.teacher.domain.dto.*;
import Service.module.business.teacher.domain.entity.TeacherEntity;
import Service.module.business.teacher.domain.vo.TeacherQueryCourseVO;
import Service.module.business.teacher.domain.vo.TeacherVO;
import Service.module.business.teacher.domain.vo.TeacherExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 教师信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-10 10:25:31
 * @since JDK1.8
 */
@Mapper
@Component
public interface TeacherDao extends BaseMapper<TeacherEntity> {

    List<TeacherExperimentProjectEntity> queryProjectDetail(@Param("queryDTO") TeacherQueryProjectDTO queryDTO);

    void closeCourse(@Param("id") Long id);

    void addCourse(@Param("queryDTO") TeacherAddCourseDTO queryDTO);
    void addCourse2(@Param("queryDTO") TeacherAddCourseDTO queryDTO);
    void addCourse3(@Param("queryDTO") TeacherAddCourseDTO queryDTO);


    void addConfrontation(@Param("queryDTO") TeacherAddConfrontationDTO queryDTO);

    List<TeacherQueryCourseVO>queryCourse(@Param("queryDTO") TeacherQueryCourseDTO queryDTO);

    List<StuExperimentProjectReportEntity>queryReport(@Param("queryDTO") TeacherQueryReportDTO queryDTO);

    void addProject(@Param("queryDTO") TeacherAddProjectDTO queryDTO);

    List<ExperimentProjectEntity> queryProject(@Param("queryDTO") TeacherQueryProjectDTO queryDTO);

    List<StuExperimentProjectReportEntity>queryReportDetail(@Param("queryDTO") TeacherQueryReportDetailDTO queryDTO);

    void updateReportGrade(@Param("queryDTO") TeacherUpdateReportGradeDTO queryDTO);

    void updateScoreWeights(@Param("queryDTO") TeacherUpdateScoreWeightsDTO queryDTO);

    List<CourseResourcePublishingEntity>queryRescource(@Param("queryDTO") CourseResourcePublishingQueryDTO queryDTO);


    /**
     * 分页查询
     * @param queryDTO
     * @return TeacherVO
    */
    IPage<TeacherVO> queryByPage(Page page, @Param("queryDTO") TeacherQueryDTO queryDTO);

    /**
     * 根据id删除
     * @param id
     * @return
    */
    void deleteById(@Param("id")Long id);

    /**
     * 根据id批量删除
     * @param idList
     * @return
    */
    void deleteByIdList(@Param("idList") List<Long> idList);

        /**
     * 查询所有导出数据
     * @param queryDTO
     * @return
     */
    List<TeacherExcelVO> queryAllExportData(@Param("queryDTO")TeacherQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<TeacherExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
