package com.mobcent.discuz.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import com.appbyme.dev.R;
import com.mobcent.common.JsonConverter;
import com.mobcent.discuz.api.LqForumApi;
import com.mobcent.discuz.bean.Base;
import com.mobcent.discuz.bean.UploadPicResult;
import com.mobcent.discuz.fragments.HttpResponseHandler;
import com.mobcent.lowest.base.utils.MCToastUtils;

import static com.mobcent.discuz.base.constant.BaseIntentConstant.BUNDLE_TOPIC_ID;

/**
 * Created by sun on 2016/8/29.
 * 举报帖子
 *
 */

public class ReportActivity extends BaseActivity {

    String mType;
    private long mId;
    private EditText mEditText;

    public static void start(Context context, long id) {
        Intent starter = new Intent(context, ReportActivity.class);
        starter.putExtra(BUNDLE_TOPIC_ID, id);
        context.startActivity(starter);
    }

    @Override
    public void initParams(Bundle bundle) {
        mId = bundle.getLong(BUNDLE_TOPIC_ID);
    }

    @Override
    public int bindLayout() {
        return R.layout.report_fragment;
    }

    @Override
    public void initView(ViewGroup container, Bundle savedInstanceState) {
        mEditText = (EditText) container.findViewById(R.id.mc_forum_report_detail_description_edit);
        // 设置spinner
        Spinner spinner = (Spinner) container.findViewById(R.id.spinner_report);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String[] arr = getResources().getStringArray(R.array.report_type_name);
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mType = arr[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mType = arr[0];
            }
        });

        findViewById(R.id.mc_forum_report_submit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                report();
            }
        });
    }

    @Override
    public void initData(Context mContext) {
       // nothing
    }


    /**
     * 提交
     */
    private void report() {
        String mContent = mEditText.getText().toString().trim();
        add(LqForumApi.report(mId, mType, mContent, new HttpResponseHandler() {
            @Override
            public void onSuccess(String result) {
                // 回复成功
                Base base = JsonConverter.format(result, Base.class);
                base.checkAlert(getBaseContext());
                if (base.isSuccess()) finish();
            }

            @Override
            public void onFail(String result) {
                MCToastUtils.toast(getBaseContext(), result);
            }
        }));
    }

}
