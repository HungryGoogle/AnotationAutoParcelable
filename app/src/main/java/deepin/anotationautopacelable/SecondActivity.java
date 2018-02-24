package deepin.anotationautopacelable;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import deepin.anotationautopacelable.pacelable.BaseParcelable;
import deepin.anotationautopacelable.pacelable.UserInfo;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent mIntent = getIntent();
        if(mIntent != null) {
            BaseParcelable received_userInfo = mIntent.getParcelableExtra("userInfo");

            if(received_userInfo != null && received_userInfo instanceof UserInfo){
                UserInfo userInfo = (UserInfo)received_userInfo;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("\n使用序列化基类处理后得到\n ");
                stringBuilder.append("\n用户id   : ").append(userInfo.mId);
                stringBuilder.append("\n用户name : ").append(userInfo.mName);
                stringBuilder.append("\n用户性别 : ").append(userInfo.bMale);
                stringBuilder.append("\n用户年龄 : ").append(userInfo.mAge);
                stringBuilder.append("\n用户金钱 : ").append(userInfo.mMoney);

                ((TextView)findViewById(R.id.id_show_user_info)).setText(stringBuilder.toString());
            }
        }
    }

}
