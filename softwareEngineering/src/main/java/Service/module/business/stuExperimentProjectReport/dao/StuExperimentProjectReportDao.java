package Service.module.business.stuExperimentProjectReport.dao;

import Service.module.business.stuExperimentProjectReport.domain.dto.StuExperimentProjectReportQueryDTO;
import Service.module.business.stuExperimentProjectReport.domain.entity.StuExperimentProjectReportEntity;
import Service.module.business.stuExperimentProjectReport.domain.vo.StuExperimentProjectReportExcelVO;
import Service.module.business.stuExperimentProjectReport.domain.vo.StuExperimentProjectReportVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 实验报告提交信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:21:27
 * @since JDK1.8
 */
@Mapper
@Component
public interface StuExperimentProjectReportDao extends BaseMapper<StuExperimentProjectReportEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return StuExperimentProjectReportVO
    */
    IPage<StuExperimentProjectReportVO> queryByPage(Page page, @Param("queryDTO") StuExperimentProjectReportQueryDTO queryDTO);

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
    List<StuExperimentProjectReportExcelVO> queryAllExportData(@Param("queryDTO")StuExperimentProjectReportQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<StuExperimentProjectReportExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
