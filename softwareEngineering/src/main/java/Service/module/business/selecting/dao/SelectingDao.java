package Service.module.business.selecting.dao;

import Service.module.business.selecting.domain.dto.SelectingQueryDTO;
import Service.module.business.selecting.domain.entity.SelectingEntity;
import Service.module.business.selecting.domain.vo.SelectingExcelVO;
import Service.module.business.selecting.domain.vo.SelectingVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 学生课程信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:15:32
 * @since JDK1.8
 */
@Mapper
@Component
public interface SelectingDao extends BaseMapper<SelectingEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return SelectingVO
    */
    IPage<SelectingVO> queryByPage(Page page, @Param("queryDTO") SelectingQueryDTO queryDTO);

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
    List<SelectingExcelVO> queryAllExportData(@Param("queryDTO")SelectingQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<SelectingExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
