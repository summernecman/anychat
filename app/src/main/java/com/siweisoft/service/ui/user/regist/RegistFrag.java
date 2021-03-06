package com.siweisoft.service.ui.user.regist;

//by summer on 2017-07-10.

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.android.lib.base.fragment.BaseUIFrag;
import com.android.lib.base.interf.OnFinishListener;
import com.android.lib.util.FragmentUtil;
import com.siweisoft.service.R;
import com.siweisoft.service.ui.Constant.Value;
import com.siweisoft.service.ui.user.login.LoginFrag;

import butterknife.OnClick;

public class RegistFrag extends BaseUIFrag<RegistUIBean,RegistDAOpe> {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getOpes().getUi().viewDataBinding.setUser(getOpes().getDa().getUserInfo());
    }

    @OnClick({R.id.onRegist})
    public void onClickEvent(View v){
        getOpes().getDa().getUserI().regist(getOpes().getDa().getUserInfo(), new OnFinishListener() {
            @Override
            public void onFinish(Object o) {
                if((Boolean) o){
                    FragmentUtil.getInstance().add(activity, Value.ROOTID,new LoginFrag());
                }
            }
        });
    }

}
