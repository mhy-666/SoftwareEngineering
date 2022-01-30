package Service.module.business.course.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import Service.module.business.course.domain.dto.CourseQueryDTO;
import Service.module.business.course.domain.entity.CourseEntity;
import Service.module.business.course.domain.vo.CourseVO;
import Service.module.business.course.domain.vo.CourseExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 课程管理 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-01 23:51:13
 * @since JDK1.8
 */
@Mapper
@Component
public interface CourseDao extends BaseMapper<CourseEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return CourseVO
    */
    IPage<CourseVO> queryByPage(Page page, @Param("queryDTO") CourseQueryDTO queryDTO);


    //void insert()


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
    List<CourseExcelVO> queryAllExportData(@Param("queryDTO")CourseQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<CourseExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
