package Service.module.business.courseResourcePublishing.service;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.module.business.courseResourcePublishing.domain.entity.CourseResourcePublishingEntity;
import Service.util.SmartBeanUtil;
import Service.util.SmartPageUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import Service.module.business.courseResourcePublishing.dao.CourseResourcePublishingDao;
import Service.module.business.courseResourcePublishing.domain.dto.CourseResourcePublishingAddDTO;
import Service.module.business.courseResourcePublishing.domain.dto.CourseResourcePublishingUpdateDTO;
import Service.module.business.courseResourcePublishing.domain.dto.CourseResourcePublishingQueryDTO;
import Service.module.business.courseResourcePublishing.domain.vo.CourseResourcePublishingVO;
import Service.module.business.courseResourcePublishing.domain.vo.CourseResourcePublishingExcelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class CourseResourcePublishingService {

    @Autowired
    private CourseResourcePublishingDao courseResourcePublishingDao;

    /**
     * 根据id查询
     */
    public CourseResourcePublishingEntity getById(Long id){
        return  courseResourcePublishingDao.selectById(id);
    }

    /**
     * 分页查询
     * @author mhy
     * @date 2021-12-12 00:07:30
     */
    public ResponseDTO<PageResultDTO<CourseResourcePublishingVO>> queryByPage(CourseResourcePublishingQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<CourseResourcePublishingVO> voList = courseResourcePublishingDao.queryByPage(page, queryDTO);
        PageResultDTO<CourseResourcePublishingVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author mhy
     * @date 2021-12-12 00:07:30
     */
    public ResponseDTO<String> add(CourseResourcePublishingAddDTO addDTO) {
        CourseResourcePublishingEntity entity = SmartBeanUtil.copy(addDTO, CourseResourcePublishingEntity.class);
        courseResourcePublishingDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author mhy
     * @date 2021-12-12 00:07:30
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(CourseResourcePublishingUpdateDTO updateDTO) {
        CourseResourcePublishingEntity entity = SmartBeanUtil.copy(updateDTO, CourseResourcePublishingEntity.class);
        courseResourcePublishingDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author mhy
     * @date 2021-12-12 00:07:30
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        courseResourcePublishingDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author mhy
     * @date 2021-12-12 00:07:30
     */
    public List<CourseResourcePublishingExcelVO> queryAllExportData(CourseResourcePublishingQueryDTO queryDTO) {
        return courseResourcePublishingDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author mhy
     * @date 2021-12-12 00:07:30
     */
    public List<CourseResourcePublishingExcelVO> queryBatchExportData(List<Long> idList) {
        return courseResourcePublishingDao.queryBatchExportData(idList);
    }
}
