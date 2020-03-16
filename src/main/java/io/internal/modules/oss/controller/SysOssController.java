

package io.internal.modules.oss.controller;

import com.google.gson.Gson;
import io.internal.common.exception.RRException;
import io.internal.common.utils.ConfigConstant;
import io.internal.common.utils.PageUtils;
import io.internal.common.utils.R;
import io.internal.common.validator.ValidatorUtils;
import io.internal.common.validator.group.AliyunGroup;
import io.internal.modules.oss.cloud.CloudStorageConfig;
import io.internal.modules.oss.cloud.OSSFactory;
import io.internal.modules.oss.entity.SysOssEntity;
import io.internal.modules.oss.service.SysOssService;
import io.internal.modules.sys.service.SysConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 文件上传
 *
 * @author
 */
@RestController
@RequestMapping("sys/oss")
public class SysOssController {
	@Autowired
	private SysOssService sysOssService;
    @Autowired
    private SysConfigService sysConfigService;

    private final static String KEY = ConfigConstant.CLOUD_STORAGE_CONFIG_KEY;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("sys:oss:all")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = sysOssService.queryPage(params);
		return R.ok().put("page", page);
	}


    /**
     * 云存储配置信息
     */
    @GetMapping("/config")
    @RequiresPermissions("sys:oss:all")
    public R config(){
        CloudStorageConfig config = sysConfigService.getConfigObject(KEY, CloudStorageConfig.class);

        return R.ok().put("config", config);
    }


	/**
	 * 保存云存储配置信息
	 */
	@PostMapping("/saveConfig")
	@RequiresPermissions("sys:oss:all")
	public R saveConfig(@RequestBody CloudStorageConfig config){
		//校验类型
		ValidatorUtils.validateEntity(config);

			//校验阿里云数据
		ValidatorUtils.validateEntity(config, AliyunGroup.class);
		
        sysConfigService.updateValueByKey(KEY, new Gson().toJson(config));

		return R.ok();
	}


	/**
	 * 上传文件
	 */
	@PostMapping("/upload")
	@RequiresPermissions("sys:oss:all")
	public R upload(@RequestParam("file") MultipartFile file) throws Exception {
		if (file.isEmpty()) {
			throw new RRException("上传文件不能为空");
		}

		//上传文件
		String suffix = file.getOriginalFilename();  //文件名
		String suffix1 = suffix.substring(suffix.lastIndexOf(".")); //截取后缀
		String url = OSSFactory.build().uploadSuffix(file.getBytes(), suffix1);

		//保存文件信息
		SysOssEntity ossEntity = new SysOssEntity();
		ossEntity.setUrl(suffix);
		ossEntity.setCreateDate(new Date());
		sysOssService.save(ossEntity);
		return R.ok().put("url", url);
	}


	public R download(){
		return null;
	}

	/**
	 * 删除
	 */
	@PostMapping("/delete")
	@RequiresPermissions("sys:oss:all")
	public R delete(@RequestBody Long[] ids){
		sysOssService.removeByIds(Arrays.asList(ids));

		return R.ok();
	}

}
