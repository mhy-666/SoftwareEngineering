package Service.module.business.scheduleTime.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import Service.module.business.scheduleTime.domain.dto.ScheduleTimeQueryDTO;
import Service.module.business.scheduleTime.domain.entity.ScheduleTimeEntity;
import Service.module.business.scheduleTime.domain.vo.ScheduleTimeVO;
import Service.module.business.scheduleTime.domain.vo.ScheduleTimeExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 上课安排 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-09 00:47:47
 * @since JDK1.8
 */
@Mapper
@Component
public interface ScheduleTimeDao extends BaseMapper<ScheduleTimeEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return ScheduleTimeVO
    */
    IPage<ScheduleTimeVO> queryByPage(Page page, @Param("queryDTO") ScheduleTimeQueryDTO queryDTO);

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
    List<ScheduleTimeExcelVO> queryAllExportData(@Param("queryDTO")ScheduleTimeQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<ScheduleTimeExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
