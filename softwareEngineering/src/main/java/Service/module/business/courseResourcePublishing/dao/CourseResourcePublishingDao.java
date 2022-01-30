package Service.module.business.courseResourcePublishing.dao;

import Service.module.business.courseResourcePublishing.domain.dto.CourseResourcePublishingQueryDTO;
import Service.module.business.courseResourcePublishing.domain.entity.CourseResourcePublishingEntity;
import Service.module.business.courseResourcePublishing.domain.vo.CourseResourcePublishingExcelVO;
import Service.module.business.courseResourcePublishing.domain.vo.CourseResourcePublishingVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 教学资料库 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:07:30
 * @since JDK1.8
 */
@Mapper
@Component
public interface CourseResourcePublishingDao extends BaseMapper<CourseResourcePublishingEntity> {


    /**
     * 分页查询
     * @param queryDTO
     * @return CourseResourcePublishingVO
    */
    IPage<CourseResourcePublishingVO> queryByPage(Page page, @Param("queryDTO") CourseResourcePublishingQueryDTO queryDTO);

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
    List<CourseResourcePublishingExcelVO> queryAllExportData(@Param("queryDTO")CourseResourcePublishingQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<CourseResourcePublishingExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
