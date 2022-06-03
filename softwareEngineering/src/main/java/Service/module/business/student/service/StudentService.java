package Service.module.business.student.service;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.module.business.experimentProject.domain.entity.ExperimentProjectEntity;
import Service.module.business.selecting.domain.entity.SelectingEntity;
import Service.module.business.stuConfrontationExercise.domain.entity.StuConfrontationExerciseEntity;
import Service.module.business.stuExperimentProjectReport.domain.entity.StuExperimentProjectReportEntity;
import Service.module.business.student.dao.StudentDao;
import Service.module.business.student.domain.dto.*;
import Service.module.business.student.domain.entity.StudentEntity;
import Service.module.business.student.domain.vo.*;
import Service.module.business.teacherExperimentProject.domain.entity.TeacherExperimentProjectEntity;
import Service.util.SmartBeanUtil;
import Service.util.SmartPageUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import Service.module.business.student.domain.dto.*;
import Service.module.business.student.domain.vo.*;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

//    /**
//     * 获取对抗练习作答情况
//     * @author mhy
//     * @date 2021-12-10 10:19:19
//     * @return
//     */
//    public ResponseDTO<List<StuConfrontationExerciseAnswerVO>> queryConfrontResult(StudentSubmitConfrontationDTO queryDTO) {
//
//        List<StuConfrontationExerciseAnswerVO> VOList = studentDao.queryConfrontResult(queryDTO);
//
//        List<StuConfrontationExerciseAnswerVO> voList = VOList.stream().map(e -> {
//            StuConfrontationExerciseAnswerVO vo = new StuConfrontationExerciseAnswerVO();
//            vo.setStudentId(e.getStudentId());
//            vo.setTotals(e.getTotals());
//            vo.setRank(e.getRank());
//            vo.setAnswertime(e.getAnswertime());
//            vo.setQuestion(e.getQuestion());
//            vo.setOptions(e.getOptions());
//            vo.setSolution(e.getSolution());
//            vo.setStudentAnswer(e.getStudentAnswer());
//            vo.setQuestionId(e.getQuestionId());
//            return vo;
//        }).collect(Collectors.toList());
//
//        return ResponseDTO.succData(voList);
//    }

    /**
     * 查询报告成绩
     * @author mhy
     * @date 2021-12-10 10:19:19
     * @return
     */
    public ResponseDTO<List<StudentQueryreportGradeVO>> queryreportGrade(StudentQueryReportDetailDTO queryDTO) {

        List<StuExperimentProjectReportEntity> EntityList = studentDao.queryReportGrade(queryDTO);
        if (CollectionUtils.isEmpty(EntityList)) {
            return ResponseDTO.succData(Lists.newArrayList());
        }

        List<StudentQueryreportGradeVO> voList = EntityList.stream().map(e -> {
            StudentQueryreportGradeVO vo = new StudentQueryreportGradeVO();
            vo.setProjectId(e.getProjectId());
            vo.setProjectName(e.getName());
            vo.setScore(e.getGrade());
            return vo;
        }).collect(Collectors.toList());

        return ResponseDTO.succData(voList);
    }


//    /**
//     * 提交对抗练习
//     * @author mhy
//     * @date 2021-12-10 10:19:19
//     */
//    public ResponseDTO<String> addConfront(StudentSubmitConfrontationDTO addDTO) {
//        studentDao.SubmitConfrontation(addDTO);
//        studentDao.updateSubmitConfrontation(addDTO);
//        return ResponseDTO.succ();
//    }



    /**
     * 查询选课情况
     * @author mhy
     * @date 2021-12-10 10:19:19
     * @return
     */
    public ResponseDTO<List<StudentGetCourseVO>> queryCourse(StudentGetCourseDTO queryDTO) {

        List<StudentGetCourseVO> VOList = studentDao.queryCourse(queryDTO);

        List<StudentGetCourseVO> voList = VOList.stream().map(e -> {
            StudentGetCourseVO vo = new StudentGetCourseVO();
            vo.setCourseId(e.getCourseId());
            vo.setClassId(e.getClassId());
            vo.setClassTerm(e.getClassTerm());
            vo.setName(e.getName());
            vo.setTeacherName(e.getTeacherName());
            vo.setCredit(e.getCredit());
            vo.setDepartment(e.getDepartment());
            vo.setPlace(e.getPlace());
            return vo;
        }).collect(Collectors.toList());

        return ResponseDTO.succData(voList);
    }

    /**
     * 查询实验项目
     * @author mhy
     * @date 2021-12-10 10:19:19
     * @return
     */
    public ResponseDTO<List<StudentQueryProjectVO>> queryProject(StudentQueryProjectDTO queryDTO) {

        List<ExperimentProjectEntity> EntityList = studentDao.queryProject(queryDTO);
        if (CollectionUtils.isEmpty(EntityList)) {
            return ResponseDTO.succData(Lists.newArrayList());
        }

        List<StudentQueryProjectVO> voList = EntityList.stream().map(e -> {
            StudentQueryProjectVO vo = new StudentQueryProjectVO();
            vo.setProjectId(e.getId());
            vo.setProjectName(e.getName());
            return vo;
        }).collect(Collectors.toList());

        return ResponseDTO.succData(voList);
    }

    /**
     * 查询成绩
     * @author mhy
     * @date 2021-12-10 10:19:19
     * @return
     */
    public ResponseDTO<List<StudentQueryGradeVO>> queryGrade(StudentQueryGradeDTO queryDTO) {

        List<SelectingEntity> EntityList = studentDao.queryGrade(queryDTO);
        if (CollectionUtils.isEmpty(EntityList)) {
            return ResponseDTO.succData(Lists.newArrayList());
        }

        List<StudentQueryGradeVO> voList = EntityList.stream().map(e -> {
            StudentQueryGradeVO vo = new StudentQueryGradeVO();
            vo.setAttendScore(e.getAttendScore());
            vo.setSumScore(e.getSumScore());
            return vo;
        }).collect(Collectors.toList());

        return ResponseDTO.succData(voList);
    }

    /**
     * 查看实验项目详情
     * @author mhy
     * @date 2021-12-10 10:19:19
     * @return
     */
    public ResponseDTO<List<StudentQueryProjectDetailVO>> queryProjectDetail(StudentQueryProjectDetailDTO queryDTO) {

        List<TeacherExperimentProjectEntity> EntityList = studentDao.queryProDetail(queryDTO);
        if (CollectionUtils.isEmpty(EntityList)) {
            return ResponseDTO.succData(Lists.newArrayList());
        }

        List<StudentQueryProjectDetailVO> voList = EntityList.stream().map(e -> {
            StudentQueryProjectDetailVO vo = new StudentQueryProjectDetailVO();
            vo.setProjectName(e.getName());
            vo.setPublishTeacherId(e.getPublishTeacherId());
            vo.setPublishTeacherName(e.getPublishTeacherName());
            vo.setProjectDescrip(e.getProjectDescrip());
            vo.setDeadline(e.getDeadline());
            return vo;
        }).collect(Collectors.toList());

        return ResponseDTO.succData(voList);
    }

    /**
     * 获取实验报告
     * @author mhy
     * @date 2021-12-10 10:19:19
     * @return
     */
    public ResponseDTO<List<StudentQueryReportDetailVO>> queryReportDetail(StudentQueryReportDetailDTO queryDTO) {

        List<StuExperimentProjectReportEntity> EntityList = studentDao.queryReportDetail(queryDTO);
        if (CollectionUtils.isEmpty(EntityList)) {
            return ResponseDTO.succData(Lists.newArrayList());
        }

        List<StudentQueryReportDetailVO> voList = EntityList.stream().map(e -> {
            StudentQueryReportDetailVO vo = new StudentQueryReportDetailVO();
            vo.setPrinciple(e.getPrinciple());
            vo.setPurpose(e.getPurpose());
            vo.setContent(e.getContent());
            vo.setSummary(e.getSummary());
            return vo;
        }).collect(Collectors.toList());

        return ResponseDTO.succData(voList);
    }

    /**
     * 提交报告
     * @author mhy
     * @date 2021-12-10 10:19:19
     */
    public ResponseDTO<String> addReport(StudentQueryAddReportDTO addDTO) {
        studentDao.addReportDetail(addDTO);
        return ResponseDTO.succ();
    }


    /**
     * 根据id查询
     */
    public StudentEntity getById(Long id){
        return  studentDao.selectById(id);
    }

    /**
     * 分页查询
     * @author mhy
     * @date 2021-12-10 10:19:19
     */
    public ResponseDTO<PageResultDTO<StudentVO>> queryByPage(StudentQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<StudentVO> voList = studentDao.queryByPage(page, queryDTO);
        PageResultDTO<StudentVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }



    /**
     * 添加
     * @author mhy
     * @date 2021-12-10 10:19:19
     */
    public ResponseDTO<String> add(StudentAddDTO addDTO) {
        StudentEntity entity = SmartBeanUtil.copy(addDTO, StudentEntity.class);
        studentDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author mhy
     * @date 2021-12-10 10:19:19
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(StudentUpdateDTO updateDTO) {
        StudentEntity entity = SmartBeanUtil.copy(updateDTO, StudentEntity.class);
        studentDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author mhy
     * @date 2021-12-10 10:19:19
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        studentDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author mhy
     * @date 2021-12-10 10:19:19
     */
    public List<StudentExcelVO> queryAllExportData(StudentQueryDTO queryDTO) {
        return studentDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author mhy
     * @date 2021-12-10 10:19:19
     */
    public List<StudentExcelVO> queryBatchExportData(List<Long> idList) {
        return studentDao.queryBatchExportData(idList);
    }
}
