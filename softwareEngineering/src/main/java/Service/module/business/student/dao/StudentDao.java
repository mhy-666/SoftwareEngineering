package Service.module.business.student.dao;

import Service.module.business.student.domain.dto.*;
import Service.module.business.student.domain.vo.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import Service.module.business.experimentProject.domain.entity.ExperimentProjectEntity;
import Service.module.business.selecting.domain.entity.SelectingEntity;
import Service.module.business.stuExperimentProjectReport.domain.entity.StuExperimentProjectReportEntity;
import Service.module.business.student.domain.dto.*;
import Service.module.business.student.domain.entity.StudentEntity;
import Service.module.business.teacherExperimentProject.domain.entity.TeacherExperimentProjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 学生信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-10 10:19:19
 * @since JDK1.8
 */
@Mapper
@Component
public interface StudentDao extends BaseMapper<StudentEntity> {

    /**
     * 实验项目
     * @param queryDTO
     * @return
     */



    //List<StuConfrontationExerciseAnswerVO>queryConfrontResult(@Param("queryDTO") StudentSubmitConfrontationDTO queryDTO);

    //void updateSubmitConfrontation(@Param("queryDTO") StudentSubmitConfrontationDTO queryDTO);

    List<StuExperimentProjectReportEntity>queryReportGrade(@Param("queryDTO") StudentQueryReportDetailDTO queryDTO);

    //void SubmitConfrontation(@Param("queryDTO") StudentSubmitConfrontationDTO queryDTO);


    List<StudentGetCourseVO> queryCourse(@Param("queryDTO") StudentGetCourseDTO queryDTO);

    List<ExperimentProjectEntity> queryProject(@Param("queryDTO") StudentQueryProjectDTO queryDTO);

    List<SelectingEntity> queryGrade(@Param("queryDTO") StudentQueryGradeDTO queryDTO);

    List<TeacherExperimentProjectEntity>queryProDetail(@Param("queryDTO") StudentQueryProjectDetailDTO queryDTO);

    List<StuExperimentProjectReportEntity>queryReportDetail(@Param("queryDTO") StudentQueryReportDetailDTO queryDTO);

    void addReportDetail(@Param("queryDTO") StudentQueryAddReportDTO queryDTO);

    /**
     * 分页查询
     * @param queryDTO
     * @return StudentVO
    */
    IPage<StudentVO> queryByPage(Page page, @Param("queryDTO") StudentQueryDTO queryDTO);

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
    List<StudentExcelVO> queryAllExportData(@Param("queryDTO")StudentQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<StudentExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);

//    @Select("select ")
//    IPage<StudentGetCourseVO>StudentGetCourse(@Param("GetCourseDTO") StudentGetCourseDTO GetCourseDTO);



}
