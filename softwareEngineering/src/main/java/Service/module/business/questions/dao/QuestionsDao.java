package Service.module.business.questions.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import Service.module.business.questions.domain.dto.QuestionsQueryDTO;
import Service.module.business.questions.domain.entity.QuestionsEntity;
import Service.module.business.questions.domain.vo.QuestionsVO;
import Service.module.business.questions.domain.vo.QuestionsExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [  ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-22 15:34:53
 * @since JDK1.8
 */
@Mapper
@Component
public interface QuestionsDao extends BaseMapper<QuestionsEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return QuestionsVO
    */
    IPage<QuestionsVO> queryByPage(Page page, @Param("queryDTO") QuestionsQueryDTO queryDTO);

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
    List<QuestionsExcelVO> queryAllExportData(@Param("queryDTO")QuestionsQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<QuestionsExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
