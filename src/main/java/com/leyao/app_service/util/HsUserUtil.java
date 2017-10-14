package com.leyao.app_service.util;

import java.util.ArrayList;
import java.util.List;

import com.leyao.app_service.entity.hs_user.HUser;
import com.leyao.app_service.entity.hs_user.SUserActive;
import com.leyao.app_service.entity.hs_user.SUserEmail;
import com.leyao.app_service.entity.hs_user.SUserFeedback;
import com.leyao.app_service.entity.hs_user.SUserFeedbackSummary;
import com.leyao.app_service.entity.hs_user.SUserGender;
import com.leyao.app_service.entity.hs_user.SUserName;
import com.leyao.app_service.entity.hs_user.SUserPassword;
import com.leyao.app_service.entity.hs_user.SUserProfile;
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
        userPassword.setsUserPasswordStr(CommonUtil.getMD5String(tUserSummary.getsUserPasswordStr()));
        userPassword.setCreateTs(tUserSummary.getCreateTs());
        userPassword.setUpdateTs(tUserSummary.getUpdateTs());

        return userPassword;
    }

    public static SUserActive userSummary2UserActive(TUserSummary tUserSummary) {
        SUserActive userActive = new SUserActive();
        userActive.sethUserId(tUserSummary.gethUserId());
        userActive.setsUserActiveInd(tUserSummary.getsUserActiveInd());
        userActive.setCreateTs(tUserSummary.getCreateTs());
        userActive.setUpdateTs(tUserSummary.getUpdateTs());

        return userActive;
    }

    public static SUserFeedback userFeedbackSummanry2UserFeedback(SUserFeedbackSummary sUserFeedbackSummary) {
        if (null == sUserFeedbackSummary) {
            return null;
        }

        SUserFeedback sUserFeedback = new SUserFeedback();
        sUserFeedback.setCreateTs(sUserFeedbackSummary.getCreateTs());
        sUserFeedback.sethUserId(sUserFeedbackSummary.gethUserId());
        sUserFeedback.setsUserFeedbackId(sUserFeedback.getsUserFeedbackId());
        sUserFeedback.setsUserFeedbackStr(sUserFeedbackSummary.getsUserFeedbackStr());
        sUserFeedback.setUpdateTs(sUserFeedback.getUpdateTs());

        return sUserFeedback;
    }

    public static SUserEmail userSummary2UserEmail(TUserSummary tUserSummary) {
        SUserEmail sUserEmail = new SUserEmail();
        sUserEmail.sethUserId(tUserSummary.gethUserId());
        sUserEmail.setCreateTs(tUserSummary.getCreateTs());
        sUserEmail.setUpdateTs(tUserSummary.getUpdateTs());
        sUserEmail.setsUserEmailStr(tUserSummary.getsUserEmailStr());

        return sUserEmail;
    }

    public static SUserProfile userSummary2UserProfile(TUserSummary tUserSummary) {
        SUserProfile sUserProfile = new SUserProfile();
        sUserProfile.sethUserId(tUserSummary.gethUserId());
        sUserProfile.setsUserProfileUrl(tUserSummary.getsUserProfileUrl());
        sUserProfile.setCreateTs(tUserSummary.getCreateTs());
        sUserProfile.setUpdateTs(tUserSummary.getUpdateTs());

        return sUserProfile;
    }

    public static SUserGender userSummary2UserGender(TUserSummary tUserSummary) {
        SUserGender sUserGender = new SUserGender();
        sUserGender.sethUserId(tUserSummary.gethUserId());
        sUserGender.setsUserGenderCd(tUserSummary.getsUserGenderCd());
        sUserGender.setCreateTs(tUserSummary.getCreateTs());
        sUserGender.setUpdateTs(tUserSummary.getUpdateTs());

        return sUserGender;
    }

    public static SUserName userSummary2UserName(TUserSummary tUserSummary) {
        SUserName sUserName = new SUserName();
        sUserName.sethUserId(tUserSummary.gethUserId());
        sUserName.setsUserNameStr(tUserSummary.getsUserNameStr());
        sUserName.setCreateTs(tUserSummary.getCreateTs());
        sUserName.setUpdateTs(tUserSummary.getUpdateTs());

        return sUserName;
    }
}
