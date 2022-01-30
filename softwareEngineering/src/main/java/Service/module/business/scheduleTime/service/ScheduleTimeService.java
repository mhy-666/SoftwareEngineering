package Service.module.business.scheduleTime.service;

import Service.common.domain.PageResultDTO;
import Service.common.domain.ResponseDTO;
import Service.module.business.scheduleTime.dao.ScheduleTimeDao;
import Service.module.business.scheduleTime.domain.dto.ScheduleTimeAddDTO;
import Service.module.business.scheduleTime.domain.dto.ScheduleTimeQueryDTO;
import Service.module.business.scheduleTime.domain.dto.ScheduleTimeUpdateDTO;
import Service.module.business.scheduleTime.domain.entity.ScheduleTimeEntity;
import Service.module.business.scheduleTime.domain.vo.ScheduleTimeExcelVO;
import Service.module.business.scheduleTime.domain.vo.ScheduleTimeVO;
import Service.util.SmartBeanUtil;
import Service.util.SmartPageUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class ScheduleTimeService {

    @Autowired
    private ScheduleTimeDao scheduleTimeDao;

    /**
     * 根据id查询
     */
    public ScheduleTimeEntity getById(Long id){
        return  scheduleTimeDao.selectById(id);
    }

    /**
     * 分页查询
     * @author mhy
     * @date 2021-12-09 00:47:47
     */
    public ResponseDTO<PageResultDTO<ScheduleTimeVO>> queryByPage(ScheduleTimeQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<ScheduleTimeVO> voList = scheduleTimeDao.queryByPage(page, queryDTO);
        PageResultDTO<ScheduleTimeVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author mhy
     * @date 2021-12-09 00:47:47
     */
    public ResponseDTO<String> add(ScheduleTimeAddDTO addDTO) {
        ScheduleTimeEntity entity = SmartBeanUtil.copy(addDTO, ScheduleTimeEntity.class);
        scheduleTimeDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author mhy
     * @date 2021-12-09 00:47:47
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(ScheduleTimeUpdateDTO updateDTO) {
        ScheduleTimeEntity entity = SmartBeanUtil.copy(updateDTO, ScheduleTimeEntity.class);
        scheduleTimeDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author mhy
     * @date 2021-12-09 00:47:47
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        scheduleTimeDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author mhy
     * @date 2021-12-09 00:47:47
     */
    public List<ScheduleTimeExcelVO> queryAllExportData(ScheduleTimeQueryDTO queryDTO) {
        return scheduleTimeDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author mhy
     * @date 2021-12-09 00:47:47
     */
    public List<ScheduleTimeExcelVO> queryBatchExportData(List<Long> idList) {
        return scheduleTimeDao.queryBatchExportData(idList);
    }
}
