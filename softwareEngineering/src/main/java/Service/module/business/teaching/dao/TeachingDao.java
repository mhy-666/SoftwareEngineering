package Service.module.business.teaching.dao;

import Service.module.business.teaching.domain.dto.TeachingQueryDTO;
import Service.module.business.teaching.domain.entity.TeachingEntity;
import Service.module.business.teaching.domain.vo.TeachingExcelVO;
import Service.module.business.teaching.domain.vo.TeachingVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 授课信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:24:09
 * @since JDK1.8
 */
@Mapper
@Component
public interface TeachingDao extends BaseMapper<TeachingEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return TeachingVO
    */
    IPage<TeachingVO> queryByPage(Page page, @Param("queryDTO") TeachingQueryDTO queryDTO);

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
    List<TeachingExcelVO> queryAllExportData(@Param("queryDTO")TeachingQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<TeachingExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
