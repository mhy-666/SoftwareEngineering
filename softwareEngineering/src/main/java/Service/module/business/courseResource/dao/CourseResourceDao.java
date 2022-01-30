package Service.module.business.courseResource.dao;

import Service.module.business.courseResource.domain.dto.CourseResourceQueryDTO;
import Service.module.business.courseResource.domain.entity.CourseResourceEntity;
import Service.module.business.courseResource.domain.vo.CourseResourceExcelVO;
import Service.module.business.courseResource.domain.vo.CourseResourceVO;
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
 * @date 2021-12-12 00:00:05
 * @since JDK1.8
 */
@Mapper
@Component
public interface CourseResourceDao extends BaseMapper<CourseResourceEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return CourseResourceVO
    */
    IPage<CourseResourceVO> queryByPage(Page page, @Param("queryDTO") CourseResourceQueryDTO queryDTO);

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
    List<CourseResourceExcelVO> queryAllExportData(@Param("queryDTO")CourseResourceQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<CourseResourceExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
