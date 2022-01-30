package Service.module.business.score.dao;

import Service.module.business.score.domain.dto.ScoreQueryDTO;
import Service.module.business.score.domain.entity.ScoreEntity;
import Service.module.business.score.domain.vo.ScoreExcelVO;
import Service.module.business.score.domain.vo.ScoreVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 课程成绩 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:13:10
 * @since JDK1.8
 */
@Mapper
@Component
public interface ScoreDao extends BaseMapper<ScoreEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return ScoreVO
    */
    IPage<ScoreVO> queryByPage(Page page, @Param("queryDTO") ScoreQueryDTO queryDTO);

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
    List<ScoreExcelVO> queryAllExportData(@Param("queryDTO")ScoreQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<ScoreExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
