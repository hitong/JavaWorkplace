package org.ec.xm.api.controller;

import kotlin.LateinitKt;
import org.ec.auth.entity.User;
import org.ec.auth.service.impl.AuthenticateServiceImpl;
import org.ec.ge.entity.GeUser;
import org.ec.ge.service.IUserService;
import org.ec.utils.controller.APIController;
import org.ec.ge.service.impl.UserServiceImpl;
import org.ec.ge.service.IUserService;

public class BaseController extends APIController {

    public IUserService userService;

    protected final GeUser currentUser(){
        UserServiceImpl.Companion companion = UserServiceImpl.Companion;

        return companion.currentUser(userService);
    }
}
