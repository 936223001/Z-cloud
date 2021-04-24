package com.zqj.common.selector;

import com.zqj.common.config.OAuth2FeignConfigure;
import com.zqj.common.config.ServerProtectConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class CloudApplicationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                OAuth2FeignConfigure.class.getName(),
                ServerProtectConfigure.class.getName()
        };
    }

}
