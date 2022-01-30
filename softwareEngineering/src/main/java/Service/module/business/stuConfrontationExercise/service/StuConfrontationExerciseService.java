package Service.module.business.stuConfrontationExercise.service;

import Service.module.business.confrontationExercise.domain.entity.ConfrontationExerciseEntity;
import Service.module.business.stuConfrontationExercise.domain.dto.*;
import Service.module.business.stuConfrontationExercise.domain.vo.StuConfrontationExerciseQueryListVO;
import Service.module.business.stuConfrontationExercise.domain.vo.StuConfrontationExerciseQueryQuestionVO;
import Service.module.business.stuExperimentProjectReport.domain.entity.StuExperimentProjectReportEntity;
import Service.module.business.teacher.domain.dto.TeacherQueryCourseDTO;
import Service.module.business.teacher.domain.dto.TeacherQueryReportDTO;
import Service.module.business.teacher.domain.vo.TeacherQueryCourseVO;
import Service.module.business.teacher.domain.vo.TeacherQueryReportVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.module.business.stuConfrontationExercise.dao.StuConfrontationExerciseDao;
import Service.module.business.stuConfrontationExercise.domain.entity.StuConfrontationExerciseEntity;
import Service.module.business.stuConfrontationExercise.domain.vo.StuConfrontationExerciseVO;
import Service.module.business.stuConfrontationExercise.domain.vo.StuConfrontationExerciseExcelVO;
import Service.util.SmartPageUtil;
import Service.util.SmartBeanUtil;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * [ 学生对抗练习作答情况 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-21 22:44:59
 * @since JDK1.8
 */
@Service
public class StuConfrontationExerciseService {




    /**
     * 获取对抗练习题目
     * @author mhy
     * @date 2021-12-10 10:19:19
     * @return
     */
    public ResponseDTO<List<StuConfrontationExerciseQueryQuestionVO>> queryConfrontationQuestion(StuConfrontationExerciseQueryQuestionDTO queryDTO) {

        List<StuConfrontationExerciseQueryQuestionVO> VOList = stuConfrontationExerciseDao.queryConfrontationQuestion(queryDTO);


        List<StuConfrontationExerciseQueryQuestionVO> voList = VOList.stream().map(e -> {
            StuConfrontationExerciseQueryQuestionVO vo = new StuConfrontationExerciseQueryQuestionVO();
            vo.setQuestion(e.getQuestion());
            vo.setOptions(e.getOptions());
            vo.setSolution(e.getSolution());

            return vo;
        }).collect(Collectors.toList());

        return ResponseDTO.succData(voList);
    }

    /**
     * 获取对抗练习列表
     * @author mhy
     * @date 2021-12-10 10:19:19
     * @return
     */
    public ResponseDTO<List<StuConfrontationExerciseQueryListVO>> queryConfrontationList(StuConfrontationExerciseQueryListDTO queryDTO) {

        List<ConfrontationExerciseEntity> EntityList = stuConfrontationExerciseDao.queryConfrontationList(queryDTO);
        if (CollectionUtils.isEmpty(EntityList)) {
            return ResponseDTO.succData(Lists.newArrayList());
        }

        List<StuConfrontationExerciseQueryListVO> voList = EntityList.stream().map(e -> {
            StuConfrontationExerciseQueryListVO vo = new StuConfrontationExerciseQueryListVO();
            vo.setConfrontationId(e.getConfrontationId());
            vo.setConfrontationName(e.getConfrontationName());
            vo.setDeadline(e.getDeadline());
            System.out.println("哈哈哈哈哈哈哈"+e.getConfrontationId());
            System.out.println("哈哈哈哈哈哈哈"+e.getConfrontationName());
            System.out.println("哈哈哈哈哈哈哈"+e.getDeadline());
            System.out.println("哈哈哈哈哈哈哈"+e.getConfrontationDescrip());
            System.out.println("哈哈哈哈哈哈哈"+e.getAnswerTime());
            System.out.println("哈哈哈哈哈哈哈"+e.getQuestionbankId());
            return vo;
        }).collect(Collectors.toList());

        return ResponseDTO.succData(voList);
    }


    @Autowired
    private StuConfrontationExerciseDao stuConfrontationExerciseDao;

    /**
     * 根据id查询
     */
    public StuConfrontationExerciseEntity getById(Long id){
        return  stuConfrontationExerciseDao.selectById(id);
    }

    /**
     * 分页查询
     * @author mhy
     * @date 2021-12-21 22:44:59
     */
    public ResponseDTO<PageResultDTO<StuConfrontationExerciseVO>> queryByPage(StuConfrontationExerciseQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<StuConfrontationExerciseVO> voList = stuConfrontationExerciseDao.queryByPage(page, queryDTO);
        PageResultDTO<StuConfrontationExerciseVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author mhy
     * @date 2021-12-21 22:44:59
     */
    public ResponseDTO<String> add(StuConfrontationExerciseAddDTO addDTO) {
        StuConfrontationExerciseEntity entity = SmartBeanUtil.copy(addDTO, StuConfrontationExerciseEntity.class);
        stuConfrontationExerciseDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author mhy
     * @date 2021-12-21 22:44:59
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(StuConfrontationExerciseUpdateDTO updateDTO) {
        StuConfrontationExerciseEntity entity = SmartBeanUtil.copy(updateDTO, StuConfrontationExerciseEntity.class);
        stuConfrontationExerciseDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author mhy
     * @date 2021-12-21 22:44:59
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        stuConfrontationExerciseDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author mhy
     * @date 2021-12-21 22:44:59
     */
    public List<StuConfrontationExerciseExcelVO> queryAllExportData(StuConfrontationExerciseQueryDTO queryDTO) {
        return stuConfrontationExerciseDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author mhy
     * @date 2021-12-21 22:44:59
     */
    public List<StuConfrontationExerciseExcelVO> queryBatchExportData(List<Long> idList) {
        return stuConfrontationExerciseDao.queryBatchExportData(idList);
    }
}
