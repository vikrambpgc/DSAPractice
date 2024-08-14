package com.australia.LLD;

import java.util.*;

class Page {
    int pageId;
    Integer parentPageId;
    boolean inheritPermissions;
    List<ACL> acl;

    public Page(int pageId, Integer parentPageId, boolean inheritPermissions) {
        this.pageId = pageId;
        this.parentPageId = parentPageId;
        this.inheritPermissions = inheritPermissions;
        this.acl = new ArrayList<>();
    }

    public void addPermission(int userId, String permissionLevel) {
        this.acl.add(new ACL(userId, permissionLevel));
    }
}

class ACL {
    int userId;
    String permissionLevel;

    public ACL(int userId, String permissionLevel) {
        this.userId = userId;
        this.permissionLevel = permissionLevel;
    }
}

public class PermissionChecker {
    private Map<Integer, Page> pages;

    public PermissionChecker() {
        this.pages = new HashMap<>();
        // Initialize pages
        pages.put(1, new Page(1, null, false));
        pages.put(2, new Page(2, 1, true));
        pages.put(3, new Page(3, 1, true));
        pages.put(4, new Page(4, 2, false));
    }

    public boolean checkPermissions(int pageId, int userId, String permissionLevel) {
        Page page = pages.get(pageId);
        if (page == null) {
            return false;
        }

        // Check page's ACL
        for (ACL acl : page.acl) {
            if (acl.userId == userId && acl.permissionLevel.equals(permissionLevel)) {
                return true;
            }
        }

        // If page inherits permissions, traverse up the hierarchy
        if (page.inheritPermissions) {
            return checkPermissions(page.parentPageId, userId, permissionLevel);
        }

        return false;
    }

    public static void main(String[] args) {
        PermissionChecker permissionChecker = new PermissionChecker();
        Page page = permissionChecker.pages.get(3);
        page.addPermission(1, "read");
        page.addPermission(2, "write");

        System.out.println(permissionChecker.checkPermissions(3, 1, "read"));  // true
        System.out.println(permissionChecker.checkPermissions(3, 2, "read"));  // true
        System.out.println(permissionChecker.checkPermissions(3, 3, "read"));  // false
    }
}