package com.nitro.falcon.utils;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;

/**
 * FaceUtils
 * @author leops
 */
public final class FaceUtils {
    private FaceUtils() {
        // Prevent instantiation
    }
    
    public static void redirect(final String redirect) {
        final FacesContext facesContext = FacesContext.getCurrentInstance();
        final NavigationHandler nav = facesContext.getApplication().getNavigationHandler();
        nav.handleNavigation(facesContext, null, redirect);
    }
}
