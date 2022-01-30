package Service.module.system.position.domain.entity;

import Service.common.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 岗位关联关系
 *
 * @author zzr
 */
@Data
@TableName("t_position_relation")
public class PositionRelationEntity extends BaseEntity {

    /**
     * 岗位ID
     */
    private Long positionId;

    /**
     * 员工ID
     */
    private Long employeeId;

}
