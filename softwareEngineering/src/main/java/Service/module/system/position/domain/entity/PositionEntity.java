package Service.module.system.position.domain.entity;

import Service.common.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 岗位
 *
 * @author zzr
 */
@Data
@TableName("t_position")
public class PositionEntity extends BaseEntity {

    /**
     * 岗位名称
     */
    private String positionName;

    /**
     * 岗位描述
     */
    private String remark;

}
