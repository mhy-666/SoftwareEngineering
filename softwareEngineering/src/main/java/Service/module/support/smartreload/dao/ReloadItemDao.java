package Service.module.support.smartreload.dao;
import Service.module.support.smartreload.domain.entity.ReloadItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * t_reload_item 数据表dao
 *
 * @author listen
 * @date 2018/02/10 09:23
 */
@Component
@Mapper
public interface ReloadItemDao extends BaseMapper<ReloadItemEntity> {}
