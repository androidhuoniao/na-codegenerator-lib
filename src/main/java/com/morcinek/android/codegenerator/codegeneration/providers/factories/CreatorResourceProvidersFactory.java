package com.morcinek.android.codegenerator.codegeneration.providers.factories;

import com.google.common.collect.Lists;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.providers.resources.ButtonProvider;
import com.morcinek.android.codegenerator.codegeneration.providers.resources.CreatorProvider;
import com.morcinek.android.codegenerator.codegeneration.providers.resources.GetterProvider;
import com.morcinek.android.codegenerator.extractor.model.Resource;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class CreatorResourceProvidersFactory implements ResourceProvidersFactory {

    @Override
    public ResourceProvider createResourceProvider(Resource resource) {
        if (isApplicable(resource, "Button", "ImageButton")) {
            return new ButtonProvider(resource);
        } else if (isApplicable(resource, "CheckBox", "EditText", "View")) {
            return new GetterProvider(resource);
        }
        return new CreatorProvider(resource);
    }

    private boolean isApplicable(Resource resource, String... resourcesNames) {
        return Lists.newArrayList(resourcesNames).contains(resource.getResourceType().getFullName());
    }
}
