package Service.module.business.stuConfrontationExercise.dao;

import Service.module.business.confrontationExercise.domain.entity.ConfrontationExerciseEntity;
import Service.module.business.stuConfrontationExercise.domain.dto.StuConfrontationExerciseQueryListDTO;
import Service.module.business.stuConfrontationExercise.domain.dto.StuConfrontationExerciseQueryQuestionDTO;
import Service.module.business.stuConfrontationExercise.domain.vo.StuConfrontationExerciseQueryListVO;
import Service.module.business.stuConfrontationExercise.domain.vo.StuConfrontationExerciseQueryQuestionVO;
import Service.module.business.teacher.domain.dto.TeacherQueryCourseDTO;
import Service.module.business.teacher.domain.vo.TeacherQueryCourseVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import Service.module.business.stuConfrontationExercise.domain.dto.StuConfrontationExerciseQueryDTO;
import Service.module.business.stuConfrontationExercise.domain.entity.StuConfrontationExerciseEntity;
import Service.module.business.stuConfrontationExercise.domain.vo.StuConfrontationExerciseVO;
import Service.module.business.stuConfrontationExercise.domain.vo.StuConfrontationExerciseExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

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
@Mapper
@Component
public interface StuConfrontationExerciseDao extends BaseMapper<StuConfrontationExerciseEntity> {


    List<StuConfrontationExerciseQueryQuestionVO>queryConfrontationQuestion(@Param("queryDTO") StuConfrontationExerciseQueryQuestionDTO queryDTO);

    List<ConfrontationExerciseEntity>queryConfrontationList(@Param("queryDTO") StuConfrontationExerciseQueryListDTO queryDTO);


    /**
     * 分页查询
     * @param queryDTO
     * @return StuConfrontationExerciseVO
    */
    IPage<StuConfrontationExerciseVO> queryByPage(Page page, @Param("queryDTO") StuConfrontationExerciseQueryDTO queryDTO);

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
    List<StuConfrontationExerciseExcelVO> queryAllExportData(@Param("queryDTO")StuConfrontationExerciseQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<StuConfrontationExerciseExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
