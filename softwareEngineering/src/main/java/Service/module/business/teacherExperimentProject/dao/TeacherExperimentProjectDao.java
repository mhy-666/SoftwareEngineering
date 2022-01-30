package Service.module.business.teacherExperimentProject.dao;

import Service.module.business.teacherExperimentProject.domain.dto.TeacherExperimentProjectQueryDTO;
import Service.module.business.teacherExperimentProject.domain.entity.TeacherExperimentProjectEntity;
import Service.module.business.teacherExperimentProject.domain.vo.TeacherExperimentProjectExcelVO;
import Service.module.business.teacherExperimentProject.domain.vo.TeacherExperimentProjectVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 实验项目发布信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:10:10
 * @since JDK1.8
 */
@Mapper
@Component
public interface TeacherExperimentProjectDao extends BaseMapper<TeacherExperimentProjectEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return TeacherExperimentProjectVO
    */
    IPage<TeacherExperimentProjectVO> queryByPage(Page page, @Param("queryDTO") TeacherExperimentProjectQueryDTO queryDTO);

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
    List<TeacherExperimentProjectExcelVO> queryAllExportData(@Param("queryDTO")TeacherExperimentProjectQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<TeacherExperimentProjectExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
