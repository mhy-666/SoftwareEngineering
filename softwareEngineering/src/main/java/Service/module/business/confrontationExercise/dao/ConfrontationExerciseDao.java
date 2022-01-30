package Service.module.business.confrontationExercise.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import Service.module.business.confrontationExercise.domain.dto.ConfrontationExerciseQueryDTO;
import Service.module.business.confrontationExercise.domain.entity.ConfrontationExerciseEntity;
import Service.module.business.confrontationExercise.domain.vo.ConfrontationExerciseVO;
import Service.module.business.confrontationExercise.domain.vo.ConfrontationExerciseExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 对抗练习信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-21 22:41:43
 * @since JDK1.8
 */
@Mapper
@Component
public interface ConfrontationExerciseDao extends BaseMapper<ConfrontationExerciseEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return ConfrontationExerciseVO
    */
    IPage<ConfrontationExerciseVO> queryByPage(Page page, @Param("queryDTO") ConfrontationExerciseQueryDTO queryDTO);

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
    List<ConfrontationExerciseExcelVO> queryAllExportData(@Param("queryDTO")ConfrontationExerciseQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<ConfrontationExerciseExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
