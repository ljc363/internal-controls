
package io.internal.common.annotation;

import java.lang.annotation.*;

/**
 * 数据过滤
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataFilter {
    /**  表的别名 */
    String tableAlias() default "";

    /**  true：没有本部门数据权限，也能查询本人数据 */
    boolean user() default true;

    /**  true：拥有岗位数据权限 */
    boolean subPosition() default false;

    /**  岗位ID */
    String positionId() default "position_id";

    /**  用户ID */
    String userId() default "user_id";
}

