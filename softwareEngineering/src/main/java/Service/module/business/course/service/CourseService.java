package Service.module.business.course.service;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.module.business.course.dao.CourseDao;
import Service.util.SmartBeanUtil;
import Service.util.SmartPageUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import Service.module.business.course.domain.dto.CourseAddDTO;
import Service.module.business.course.domain.dto.CourseUpdateDTO;
import Service.module.business.course.domain.dto.CourseQueryDTO;
import Service.module.business.course.domain.entity.CourseEntity;
import Service.module.business.course.domain.vo.CourseVO;
import Service.module.business.course.domain.vo.CourseExcelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    /**
     * 根据id查询
     */
    public CourseEntity getById(Long id){
        return  courseDao.selectById(id);
    }

    /**
     * 分页查询
     * @author mhy
     * @date 2021-12-01 23:51:13
     */
    public ResponseDTO<PageResultDTO<CourseVO>> queryByPage(CourseQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<CourseVO> voList = courseDao.queryByPage(page, queryDTO);
        PageResultDTO<CourseVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author mhy
     * @date 2021-12-01 23:51:13
     */
    public ResponseDTO<String> add(CourseAddDTO addDTO) {
        CourseEntity entity = SmartBeanUtil.copy(addDTO, CourseEntity.class);
        courseDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author mhy
     * @date 2021-12-01 23:51:13
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(CourseUpdateDTO updateDTO) {
        CourseEntity entity = SmartBeanUtil.copy(updateDTO, CourseEntity.class);
        courseDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author mhy
     * @date 2021-12-01 23:51:13
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        courseDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author mhy
     * @date 2021-12-01 23:51:13
     */
    public List<CourseExcelVO> queryAllExportData(CourseQueryDTO queryDTO) {
        return courseDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author mhy
     * @date 2021-12-01 23:51:13
     */
    public List<CourseExcelVO> queryBatchExportData(List<Long> idList) {
        return courseDao.queryBatchExportData(idList);
    }
}
