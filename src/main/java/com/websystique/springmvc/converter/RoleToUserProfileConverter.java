package com.websystique.springmvc.converter;


import com.websystique.springmvc.model.UserProfile;
import com.websystique.springmvc.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile> {

    static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);

    @Autowired
    UserProfileService userProfileService;

    /**
     * Gets UserProfile by Id
     *
     * @see Converter#convert(Object)
     */
    public UserProfile convert(Object element) {

        int id = Integer.parseInt((String) element);
        UserProfile profile = userProfileService.findById(id);

        logger.info("Profile : {}", profile);

        return profile;
    }
}