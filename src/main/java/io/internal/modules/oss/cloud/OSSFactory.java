

package io.internal.modules.oss.cloud;


import io.internal.common.utils.ConfigConstant;
import io.internal.common.utils.Constant;
import io.internal.common.utils.SpringContextUtils;
import io.internal.modules.sys.service.SysConfigService;

/**
 * 文件上传Factory
 *
 * @author
 */
public final class OSSFactory {
    private static SysConfigService sysConfigService;

    static {
        OSSFactory.sysConfigService = (SysConfigService) SpringContextUtils.getBean("sysConfigService");
    }

    public static CloudStorageService build(){
        //获取云存储配置信息
        CloudStorageConfig config = sysConfigService.getConfigObject(ConfigConstant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);

            return new AliyunCloudStorageService(config);

    }

}
