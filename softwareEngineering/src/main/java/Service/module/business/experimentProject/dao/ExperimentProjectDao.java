package Service.module.business.experimentProject.dao;

import Service.module.business.experimentProject.domain.dto.ExperimentProjectQueryDTO;
import Service.module.business.experimentProject.domain.entity.ExperimentProjectEntity;
import Service.module.business.experimentProject.domain.vo.ExperimentProjectExcelVO;
import Service.module.business.experimentProject.domain.vo.ExperimentProjectVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 教师发布实验项目 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:04:39
 * @since JDK1.8
 */
@Mapper
@Component
public interface ExperimentProjectDao extends BaseMapper<ExperimentProjectEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return ExperimentProjectVO
    */
    IPage<ExperimentProjectVO> queryByPage(Page page, @Param("queryDTO") ExperimentProjectQueryDTO queryDTO);

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
    List<ExperimentProjectExcelVO> queryAllExportData(@Param("queryDTO")ExperimentProjectQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<ExperimentProjectExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
