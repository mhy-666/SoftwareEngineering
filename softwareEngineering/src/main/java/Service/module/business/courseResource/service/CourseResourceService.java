package Service.module.business.courseResource.service;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.module.business.courseResource.domain.dto.CourseResourceQueryDTO;
import Service.module.business.courseResource.domain.dto.CourseResourceUpdateDTO;
import Service.module.business.courseResource.domain.entity.CourseResourceEntity;
import Service.util.SmartBeanUtil;
import Service.util.SmartPageUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import Service.module.business.courseResource.dao.CourseResourceDao;
import Service.module.business.courseResource.domain.dto.CourseResourceAddDTO;
import Service.module.business.courseResource.domain.vo.CourseResourceVO;
import Service.module.business.courseResource.domain.vo.CourseResourceExcelVO;
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
 * @date 2021-12-12 00:00:05
 * @since JDK1.8
 */
@Service
public class CourseResourceService {

    @Autowired
    private CourseResourceDao courseResourceDao;

    /**
     * 根据id查询
     */
    public CourseResourceEntity getById(Long id){
        return  courseResourceDao.selectById(id);
    }

    /**
     * 分页查询
     * @author mhy
     * @date 2021-12-12 00:00:05
     */
    public ResponseDTO<PageResultDTO<CourseResourceVO>> queryByPage(CourseResourceQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<CourseResourceVO> voList = courseResourceDao.queryByPage(page, queryDTO);
        PageResultDTO<CourseResourceVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author mhy
     * @date 2021-12-12 00:00:05
     */
    public ResponseDTO<String> add(CourseResourceAddDTO addDTO) {
        CourseResourceEntity entity = SmartBeanUtil.copy(addDTO, CourseResourceEntity.class);
        courseResourceDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author mhy
     * @date 2021-12-12 00:00:05
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(CourseResourceUpdateDTO updateDTO) {
        CourseResourceEntity entity = SmartBeanUtil.copy(updateDTO, CourseResourceEntity.class);
        courseResourceDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author mhy
     * @date 2021-12-12 00:00:05
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        courseResourceDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author mhy
     * @date 2021-12-12 00:00:05
     */
    public List<CourseResourceExcelVO> queryAllExportData(CourseResourceQueryDTO queryDTO) {
        return courseResourceDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author mhy
     * @date 2021-12-12 00:00:05
     */
    public List<CourseResourceExcelVO> queryBatchExportData(List<Long> idList) {
        return courseResourceDao.queryBatchExportData(idList);
    }
}
