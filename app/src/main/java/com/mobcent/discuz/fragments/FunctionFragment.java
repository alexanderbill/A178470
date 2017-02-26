package com.mobcent.discuz.fragments;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.appbyme.dev.R;
import com.foamtrace.photopicker.PhotoPickerActivity;
import com.foamtrace.photopicker.SelectModel;
import com.foamtrace.photopicker.intent.PhotoPickerIntent;

import java.util.ArrayList;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

/**
 * Extra 面板，添加 照片
 */
@RuntimePermissions
public class FunctionFragment extends Fragment {

    @NeedsPermission({Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void startSelectPicture() {
        PhotoPickerIntent intent = new PhotoPickerIntent(getActivity());
        intent.setSelectModel(SelectModel.MULTI);
        intent.setShowCarema(true); // 是否显示拍照， 默认false
        intent.setMaxTotal(9); // 最多选择照片数量，默认为9
        // intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
        getRootFragment().startActivityForResult(intent, 1);
    }

    /**
     * 得到根Fragment
     *
     * @return
     */
    private Fragment getRootFragment() {
        Fragment fragment = this;
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inputpanel_function, container, false);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        FunctionFragmentPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.pan_camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //相机
                FunctionFragmentPermissionsDispatcher.startSelectPictureWithCheck(FunctionFragment.this
                );
            }
        });
//            view.findViewById(R.id.pan_album).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //相册
//                }
//            });
    }

}
