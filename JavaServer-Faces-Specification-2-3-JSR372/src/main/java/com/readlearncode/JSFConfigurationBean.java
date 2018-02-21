package com.readlearncode;

import javax.faces.annotation.FacesConfig;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;

@FacesConfig(version = JSF_2_3)
public class JSFConfigurationBean {

    @Inject
    FacesContext facesContext;

}
