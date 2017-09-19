package com.leyao.app_service.util;

import java.util.ArrayList;
import java.util.List;

import com.leyao.app_service.entity.hs_user.HUser;
import com.leyao.app_service.entity.hs_user.SUserPassword;
import com.leyao.app_service.entity.hs_user.TUserPage;
import com.leyao.app_service.entity.hs_user.TUserSummary;

public class HsUserUtil {
    public static List<TUserSummary> userPage2UserSummary(List<TUserPage> userPageList) {
        if (null == userPageList || 0 == userPageList.size()) {
            return null;
        }

        List<TUserSummary> userSummaryList = new ArrayList<TUserSummary>();

        for (TUserPage userPage : userPageList) {
            TUserSummary tUserSummary = new TUserSummary();
            tUserSummary.sethUserId(userPage.gethUserId());
            tUserSummary.sethUserPhoneNr(userPage.gethUserPhoneNr());
            tUserSummary.setsUserGenderCd(userPage.getsUserGenderCd());
            tUserSummary.setsUserGenderDesc(userPage.getsUserGenderDesc());
            tUserSummary.setsUserNameStr(userPage.getsUserNameStr());
            tUserSummary.setsUserProfileUrl(userPage.getsUserProfileUrl());
            tUserSummary.setsUserEmailStr(userPage.getsUserEmailStr());
            tUserSummary.setsUserActiveInd(userPage.getsUserActiveInd());
            tUserSummary.setCreateTs(userPage.getCreateTs());
            tUserSummary.setUpdateTs(userPage.getUpdateTs());

            userSummaryList.add(tUserSummary);
        }

        return userSummaryList;
    }

    public static List<TUserPage> userSummary2UserPage(List<TUserSummary> userSummaryList) {
        if (null == userSummaryList || 0 == userSummaryList.size()) {
            return null;
        }

        List<TUserPage> userPageList = new ArrayList<TUserPage>();

        for (TUserSummary tUserSummary : userSummaryList) {
            TUserPage userPage = new TUserPage();
            userPage.sethUserId(tUserSummary.gethUserId());
            userPage.sethUserPhoneNr(tUserSummary.gethUserPhoneNr());
            userPage.setsUserGenderCd(tUserSummary.getsUserGenderCd());
            userPage.setsUserGenderDesc(tUserSummary.getsUserGenderDesc());
            userPage.setsUserNameStr(tUserSummary.getsUserNameStr());
            userPage.setsUserProfileUrl(tUserSummary.getsUserProfileUrl());
            userPage.setsUserEmailStr(tUserSummary.getsUserEmailStr());
            userPage.setsUserActiveInd(tUserSummary.getsUserActiveInd());
            userPage.setCreateTs(tUserSummary.getCreateTs());
            userPage.setUpdateTs(tUserSummary.getUpdateTs());

            userPageList.add(userPage);
        }

        return userPageList;
    }

    public static TUserPage userSummary2UserPage(TUserSummary tUserSummary) {
        TUserPage userPage = new TUserPage();
        userPage.sethUserId(tUserSummary.gethUserId());
        userPage.sethUserPhoneNr(tUserSummary.gethUserPhoneNr());
        userPage.setsUserGenderCd(tUserSummary.getsUserGenderCd());
        userPage.setsUserGenderDesc(tUserSummary.getsUserGenderDesc());
        userPage.setsUserNameStr(tUserSummary.getsUserNameStr());
        userPage.setsUserProfileUrl(tUserSummary.getsUserProfileUrl());
        userPage.setsUserEmailStr(tUserSummary.getsUserEmailStr());
        userPage.setsUserActiveInd(tUserSummary.getsUserActiveInd());
        userPage.setCreateTs(tUserSummary.getCreateTs());
        userPage.setUpdateTs(tUserSummary.getUpdateTs());

        return userPage;
    }
    
    public static HUser userSummary2User(TUserSummary tUserSummary) {
    	HUser user = new HUser();
    	user.sethUserId(tUserSummary.gethUserId());
    	user.sethUserPhoneNr(tUserSummary.gethUserPhoneNr());
    	user.setCreateTs(tUserSummary.getCreateTs());
    	user.setUpdateTs(tUserSummary.getUpdateTs());

        return user;
    }
    
    public static SUserPassword userSummary2UserPassword(TUserSummary tUserSummary) {
    	SUserPassword userPassword = new SUserPassword();
    	userPassword.sethUserId(tUserSummary.gethUserId());
    	userPassword.setsUserPasswordStr(tUserSummary.getsUserPasswordStr());
    	userPassword.setCreateTs(tUserSummary.getCreateTs());
    	userPassword.setUpdateTs(tUserSummary.getUpdateTs());

        return userPassword;
    }
    
    
}
