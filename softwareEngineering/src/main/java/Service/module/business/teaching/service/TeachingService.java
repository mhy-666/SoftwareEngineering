package Service.module.business.teaching.service;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import Service.module.business.teaching.dao.TeachingDao;
import Service.module.business.teaching.domain.dto.TeachingAddDTO;
import Service.module.business.teaching.domain.dto.TeachingUpdateDTO;
import Service.module.business.teaching.domain.dto.TeachingQueryDTO;
import Service.module.business.teaching.domain.entity.TeachingEntity;
import Service.module.business.teaching.domain.vo.TeachingVO;
import Service.module.business.teaching.domain.vo.TeachingExcelVO;
import Service.util.SmartPageUtil;
import Service.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 授课信息 ]
 *
 * @author mhy
 * @version 1.0
 * @company 同济大学软件学院
 * @copyright (c)  同济大学软件学院Inc. All rights reserved.
 * @date 2021-12-12 00:24:09
 * @since JDK1.8
 */
@Service
public class TeachingService {

    @Autowired
    private TeachingDao teachingDao;

    /**
     * 根据id查询
     */
    public TeachingEntity getById(Long id){
        return  teachingDao.selectById(id);
    }

    /**
     * 分页查询
     * @author mhy
     * @date 2021-12-12 00:24:09
     */
    public ResponseDTO<PageResultDTO<TeachingVO>> queryByPage(TeachingQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<TeachingVO> voList = teachingDao.queryByPage(page, queryDTO);
        PageResultDTO<TeachingVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author mhy
     * @date 2021-12-12 00:24:09
     */
    public ResponseDTO<String> add(TeachingAddDTO addDTO) {
        TeachingEntity entity = SmartBeanUtil.copy(addDTO, TeachingEntity.class);
        teachingDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author mhy
     * @date 2021-12-12 00:24:09
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(TeachingUpdateDTO updateDTO) {
        TeachingEntity entity = SmartBeanUtil.copy(updateDTO, TeachingEntity.class);
        teachingDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author mhy
     * @date 2021-12-12 00:24:09
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        teachingDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author mhy
     * @date 2021-12-12 00:24:09
     */
    public List<TeachingExcelVO> queryAllExportData(TeachingQueryDTO queryDTO) {
        return teachingDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author mhy
     * @date 2021-12-12 00:24:09
     */
    public List<TeachingExcelVO> queryBatchExportData(List<Long> idList) {
        return teachingDao.queryBatchExportData(idList);
    }
}
