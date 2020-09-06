package com.sp4beans.leetcode;

import java.security.Permission;

/**
 * @author wangjixin <wangjixin@kuaishou.com>
 * Created on 2020-08-31
 */
public class TempTaskSecurityManager extends SecurityManager {

    @Override
    public void checkPermission(Permission perm) {

    }

    @Override
    public void checkPermission(Permission perm, Object context) {
        // allow anything.
    }

    @Override
    public void checkExit(int status) {
        throw new SecurityException("" + status);
    }
}
