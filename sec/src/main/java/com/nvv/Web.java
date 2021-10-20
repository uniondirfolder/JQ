package com.nvv;

import com.nvv.configuration.Config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Web extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{Config.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
