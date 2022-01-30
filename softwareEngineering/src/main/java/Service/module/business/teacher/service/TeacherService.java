package Service.module.business.teacher.service;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.module.business.courseResourcePublishing.domain.dto.CourseResourcePublishingQueryDTO;
import Service.module.business.courseResourcePublishing.domain.entity.CourseResourcePublishingEntity;
import Service.module.business.courseResourcePublishing.domain.vo.CourseResourcePublishingVO;
import Service.module.business.experimentProject.domain.entity.ExperimentProjectEntity;
import Service.module.business.stuExperimentProjectReport.domain.entity.StuExperimentProjectReportEntity;
import Service.module.business.teacher.dao.TeacherDao;
import Service.module.business.teacher.domain.dto.*;
import Service.module.business.teacher.domain.entity.TeacherEntity;
import Service.module.business.teacher.domain.vo.*;
import Service.module.business.teacherExperimentProject.domain.entity.TeacherExperimentProjectEntity;
import Service.util.SmartBeanUtil;
import Service.util.SmartPageUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import Service.module.business.teacher.domain.dto.*;
import Service.module.business.teacher.domain.vo.*;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;


    /**
     * 获取实验项目详情
     * @author mhy
     * @date 2021-12-10 10:25:31
     */
    public ResponseDTO<List<TeacherQueryProjectDetailVO>> queryProjectDetail(TeacherQueryProjectDTO queryDTO) {
        List<TeacherExperimentProjectEntity> VOList = teacherDao.queryProjectDetail(queryDTO);

        List<TeacherQueryProjectDetailVO> voList = VOList.stream().map(e -> {
            TeacherQueryProjectDetailVO vo = new TeacherQueryProjectDetailVO();
            vo.setProjectName(e.getName());
            vo.setTeacherId(e.getPublishTeacherId());
            vo.setTeacherName(e.getPublishTeacherName());
            vo.setProjectDescrip(e.getProjectDescrip());
            vo.setDeadline(e.getDeadline());
            return vo;
        }).collect(Collectors.toList());

        return ResponseDTO.succData(voList);
    }

    /**
     * 关闭课程
     * @author mhy
     * @date 2021-12-10 10:25:31
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> closeCourse(Long id) {
        teacherDao.closeCourse(id);
        return ResponseDTO.succ();
    }

    /**
     * 发布实验项目
     * @author mhy
     * @date 2021-12-10 10:19:19
     */
    public ResponseDTO<String> addCourse(TeacherAddCourseDTO addDTO) {
        teacherDao.addCourse(addDTO);
        teacherDao.addCourse2(addDTO);
        teacherDao.addCourse3(addDTO);
        return ResponseDTO.succ();
    }


    /**
     * 获取课程
     * @author mhy
     * @date 2021-12-10 10:19:19
     * @return
     */
    public ResponseDTO<List<TeacherQueryCourseVO>> queryCourse(TeacherQueryCourseDTO queryDTO) {

        List<TeacherQueryCourseVO> VOList = teacherDao.queryCourse(queryDTO);


        List<TeacherQueryCourseVO> voList = VOList.stream().map(e -> {
            TeacherQueryCourseVO vo = new TeacherQueryCourseVO();
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
     * 获取实验报告
     * @author mhy
     * @date 2021-12-10 10:19:19
     * @return
     */
    public ResponseDTO<List<TeacherQueryReportVO>> queryReport(TeacherQueryReportDTO queryDTO) {

        List<StuExperimentProjectReportEntity> EntityList = teacherDao.queryReport(queryDTO);
        if (CollectionUtils.isEmpty(EntityList)) {
            return ResponseDTO.succData(Lists.newArrayList());
        }

        List<TeacherQueryReportVO> voList = EntityList.stream().map(e -> {
            TeacherQueryReportVO vo = new TeacherQueryReportVO();
            vo.setReportId(e.getReportId());
            vo.setUploaderId(e.getId());
            vo.setUploaderName(e.getReportUploaderName());
            vo.setGrade(e.getGrade());
            return vo;
        }).collect(Collectors.toList());

        return ResponseDTO.succData(voList);
    }

    /**
     * 发布实验项目
     * @author mhy
     * @date 2021-12-10 10:19:19
     */
    public ResponseDTO<String> addProject(TeacherAddProjectDTO addDTO) {
        teacherDao.addProject(addDTO);
        return ResponseDTO.succ();
    }

    /**
     * 发布一个对抗练习
     * @author mhy
     * @date 2021-12-10 10:19:19
     */
    public ResponseDTO<String> addConfrontation(TeacherAddConfrontationDTO addDTO) {
        teacherDao.addConfrontation(addDTO);
        return ResponseDTO.succ();
    }



    /**
     * 获取实验项目
     * @author mhy
     * @date 2021-12-10 10:19:19
     * @return
     */
    public ResponseDTO<List<TeacherQueryProjectVO>> queryProject(TeacherQueryProjectDTO queryDTO) {

        List<ExperimentProjectEntity> EntityList = teacherDao.queryProject(queryDTO);
        if (CollectionUtils.isEmpty(EntityList)) {
            return ResponseDTO.succData(Lists.newArrayList());
        }

        List<TeacherQueryProjectVO> voList = EntityList.stream().map(e -> {
            TeacherQueryProjectVO vo = new TeacherQueryProjectVO();
            vo.setId(e.getId());
            vo.setProjectName(e.getName());
            vo.setDeadline(e.getDeadline());
            return vo;
        }).collect(Collectors.toList());

        return ResponseDTO.succData(voList);
    }

    /**
     * 获取实验项目
     * @author mhy
     * @date 2021-12-10 10:19:19
     * @return
     */
    public ResponseDTO<List<TeacherQueryReportDetailVO>> queryReportDetail(TeacherQueryReportDetailDTO queryDTO) {

        List<StuExperimentProjectReportEntity> EntityList = teacherDao.queryReportDetail(queryDTO);
        if (CollectionUtils.isEmpty(EntityList)) {
            return ResponseDTO.succData(Lists.newArrayList());
        }

        List<TeacherQueryReportDetailVO> voList = EntityList.stream().map(e -> {
            TeacherQueryReportDetailVO vo = new TeacherQueryReportDetailVO();
            vo.setUploaderId(e.getId());
            vo.setUploaderName(e.getReportUploaderName());
            vo.setPurpose(e.getPurpose());
            vo.setPrinciple(e.getPrinciple());
            vo.setContent(e.getContent());
            vo.setSummary(e.getSummary());
            vo.setGrade(e.getGrade());
            return vo;
        }).collect(Collectors.toList());

        return ResponseDTO.succData(voList);
    }

    /**
     * 实验报告评分
     * @author mhy
     * @date 2021-12-10 10:25:31
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> updateReportGrade(TeacherUpdateReportGradeDTO updateDTO) {
        teacherDao.updateReportGrade(updateDTO);
        return ResponseDTO.succ();
    }


    /**
     * 设置分数权重
     * @author mhy
     * @date 2021-12-10 10:25:31
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> updateScoreWeights(TeacherUpdateScoreWeightsDTO updateDTO) {
        teacherDao.updateScoreWeights(updateDTO);
        return ResponseDTO.succ();
    }


    /**
     * 获取教学资料
     * @author mhy
     * @date 2021-12-10 10:19:19
     * @return
     */
    public ResponseDTO<List<CourseResourcePublishingVO>> queryRescource(CourseResourcePublishingQueryDTO queryDTO) {

        List<CourseResourcePublishingEntity> EntityList = teacherDao.queryRescource(queryDTO);
        if (CollectionUtils.isEmpty(EntityList)) {
            return ResponseDTO.succData(Lists.newArrayList());
        }

        List<CourseResourcePublishingVO> voList = EntityList.stream().map(e -> {
            CourseResourcePublishingVO vo = new CourseResourcePublishingVO();
            vo.setId(e.getId());
            vo.setName(e.getName());
            vo.setUploaderId(e.getUploaderId());
            vo.setUploaderName(e.getUploaderName());
            vo.setDownloadTimes(e.getDownloadTimes());
            return vo;
        }).collect(Collectors.toList());

        return ResponseDTO.succData(voList);
    }

    /**
     * 根据id查询
     */
    public TeacherEntity getById(Long id){
        return  teacherDao.selectById(id);
    }

    /**
     * 分页查询
     * @author mhy
     * @date 2021-12-10 10:25:31
     */
    public ResponseDTO<PageResultDTO<TeacherVO>> queryByPage(TeacherQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<TeacherVO> voList = teacherDao.queryByPage(page, queryDTO);
        PageResultDTO<TeacherVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author mhy
     * @date 2021-12-10 10:25:31
     */
    public ResponseDTO<String> add(TeacherAddDTO addDTO) {
        TeacherEntity entity = SmartBeanUtil.copy(addDTO, TeacherEntity.class);
        teacherDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author mhy
     * @date 2021-12-10 10:25:31
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(TeacherUpdateDTO updateDTO) {
        TeacherEntity entity = SmartBeanUtil.copy(updateDTO, TeacherEntity.class);
        teacherDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author mhy
     * @date 2021-12-10 10:25:31
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        teacherDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author mhy
     * @date 2021-12-10 10:25:31
     */
    public List<TeacherExcelVO> queryAllExportData(TeacherQueryDTO queryDTO) {
        return teacherDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author mhy
     * @date 2021-12-10 10:25:31
     */
    public List<TeacherExcelVO> queryBatchExportData(List<Long> idList) {
        return teacherDao.queryBatchExportData(idList);
    }
}
