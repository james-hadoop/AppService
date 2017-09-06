package com.leyao.app_service.util;

import java.util.ArrayList;
import java.util.List;

import com.leyao.app_service.entity.hs_user.TUserPage;
import com.leyao.app_service.entity.hs_user.TUserSummary;

public class HsUserUtil {
    public static List<TUserSummary> userPage2UserSummary(List<TUserPage> userPageList) {
        if (null == userPageList || 0 == userPageList.size()) {
            return null;
        }

        List<TUserSummary> userSummaryList = new ArrayList<TUserSummary>();

        for (TUserPage userPage : userPageList) {
            TUserSummary userSummary = new TUserSummary();
            userSummary.sethUserId(userPage.gethUserId());
            userSummary.sethUserPhoneNr(userPage.gethUserPhoneNr());
            userSummary.setsUserGenderCd(userPage.getsUserGenderCd());
            userSummary.setsUserGenderDesc(userPage.getsUserGenderDesc());
            userSummary.setsUserNameStr(userPage.getsUserNameStr());
            userSummary.setsUserProfileUrl(userPage.getsUserProfileUrl());
            userSummary.setsUserEmailStr(userPage.getsUserEmailStr());
            userSummary.setsUserActiveInd(userPage.getsUserActiveInd());
            userSummary.setCreateTs(userPage.getCreateTs());
            userSummary.setUpdateTs(userPage.getUpdateTs());

            userSummaryList.add(userSummary);
        }

        return userSummaryList;
    }

    public static List<TUserPage> userSummary2UserPage(List<TUserSummary> userSummaryList) {
        if (null == userSummaryList || 0 == userSummaryList.size()) {
            return null;
        }

        List<TUserPage> userPageList = new ArrayList<TUserPage>();

        for (TUserSummary userSummary : userSummaryList) {
            TUserPage userPage = new TUserPage();
            userPage.sethUserId(userSummary.gethUserId());
            userPage.sethUserPhoneNr(userSummary.gethUserPhoneNr());
            userPage.setsUserGenderCd(userSummary.getsUserGenderCd());
            userPage.setsUserGenderDesc(userSummary.getsUserGenderDesc());
            userPage.setsUserNameStr(userSummary.getsUserNameStr());
            userPage.setsUserProfileUrl(userSummary.getsUserProfileUrl());
            userPage.setsUserEmailStr(userSummary.getsUserEmailStr());
            userPage.setsUserActiveInd(userSummary.getsUserActiveInd());
            userPage.setCreateTs(userSummary.getCreateTs());
            userPage.setUpdateTs(userSummary.getUpdateTs());

            userPageList.add(userPage);
        }

        return userPageList;
    }
}
