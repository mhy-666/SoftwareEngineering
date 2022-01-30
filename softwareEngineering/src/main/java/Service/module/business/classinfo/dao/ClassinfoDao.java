package Service.module.business.classinfo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import Service.module.business.classinfo.domain.dto.ClassinfoQueryDTO;
import Service.module.business.classinfo.domain.entity.ClassinfoEntity;
import Service.module.business.classinfo.domain.vo.ClassinfoVO;
import Service.module.business.classinfo.domain.vo.ClassinfoExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 实验班级信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-02 20:44:23
 * @since JDK1.8
 */
@Mapper
@Component
public interface ClassinfoDao extends BaseMapper<ClassinfoEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return ClassinfoVO
    */
    IPage<ClassinfoVO> queryByPage(Page page, @Param("queryDTO") ClassinfoQueryDTO queryDTO);

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
    List<ClassinfoExcelVO> queryAllExportData(@Param("queryDTO")ClassinfoQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<ClassinfoExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
