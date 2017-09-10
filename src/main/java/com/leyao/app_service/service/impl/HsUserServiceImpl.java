package com.leyao.app_service.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leyao.app_service.common.Response;
import com.leyao.app_service.common.VerifyCodeManager;
import com.leyao.app_service.dao.mapper.hs_user.HUserMapper;
import com.leyao.app_service.dao.mapper.hs_user.SUserPasswordMapper;
import com.leyao.app_service.dao.mapper.hs_user.TUserPageMapper;
import com.leyao.app_service.entity.hs_user.HUser;
import com.leyao.app_service.entity.hs_user.SUserPassword;
import com.leyao.app_service.entity.hs_user.TUserPage;
import com.leyao.app_service.entity.hs_user.TUserSummary;
import com.leyao.app_service.service.IHsUserService;
import com.leyao.app_service.util.CommonUtil;
import com.leyao.app_service.util.HsUserUtil;

@Service
public class HsUserServiceImpl implements IHsUserService {
	@Autowired
	TUserPageMapper tUserPageMapper;

	@Autowired
	HUserMapper hUserMapper;

	@Autowired
	SUserPasswordMapper sUserPasswordMapper;

	@Override
	public List<TUserSummary> getTUserSummary(Map<String, Object> paramMap) {
		List<TUserPage> userPageList = tUserPageMapper.getTUserPage(paramMap);
		List<TUserSummary> userSummaryList = HsUserUtil.userPage2UserSummary(userPageList);

		return userSummaryList;
	}

	@Override
	public int regist(TUserSummary tUserSummary) {
		String verifyCode = VerifyCodeManager.getVerifyCodeByPhoneNum(String.valueOf(tUserSummary.gethUserPhoneNr()));
		if (null == verifyCode) {
			return Response.ERROR;
		}

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("hUserPhoneNr", tUserSummary.gethUserPhoneNr());
		List<TUserPage> userPageList = tUserPageMapper.getTUserPage(paramMap);
		if (null != userPageList && 0 < userPageList.size()) {
			return Response.ERROR;
		}

		// HUser
		HUser user = HsUserUtil.userSummary2User(tUserSummary);
		long userId = hUserMapper.insertSelective(user);

		tUserSummary.sethUserId(userId);
		tUserSummary.setsUserPasswordStr(CommonUtil.getMD5String(tUserSummary.getsUserPasswordStr()));

		// SUserPassword
		SUserPassword sUserPassword = HsUserUtil.userSummary2UserPassword(tUserSummary);
		sUserPasswordMapper.insertSelective(sUserPassword);

		// TUserPage
		TUserPage userPage = HsUserUtil.userSummary2UserPage(tUserSummary);
		tUserPageMapper.insertSelective(userPage);
		return Response.SUCCESS;
	}

	@Override
	public int login(TUserSummary tUserSummary) {
		if (null == tUserSummary || null == tUserSummary.gethUserPhoneNr()
				|| null == tUserSummary.getsUserPasswordStr()) {
			return Response.ERROR;
		}

		TUserSummary tUserSummaryResult = selectByhUserPhoneNr(tUserSummary.gethUserPhoneNr());

		if (null == tUserSummaryResult) {
			return Response.ERROR;
		}

		if (!tUserSummaryResult.getsUserPasswordStr()
				.equals(CommonUtil.getMD5String(tUserSummary.getsUserPasswordStr()))) {
			return Response.ERROR;
		}

		return Response.SUCCESS;
	}

	@Override
	public int logout(TUserSummary tUserSummary) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reset(TUserSummary tUserSummary) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getVerifyCode(TUserSummary tUserSummary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TUserSummary selectByhUserPhoneNr(Long hUserPhoneNr) {
		return tUserPageMapper.selectByhUserPhoneNr(hUserPhoneNr);
	}
}
