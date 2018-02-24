package deepin.anotationautopacelable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import deepin.anotationautopacelable.pacelable.UserInfo;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.id_go_to_second_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                UserInfo userInfo = new UserInfo();
                userInfo.mId = ((EditText)findViewById(R.id.user_input_text)).getText().toString();
                userInfo.mName = "Lee";
                userInfo.bMale = true;
                userInfo.mAge = 17;
                userInfo.mMoney = 19.3F;

                intent.putExtra("userInfo", userInfo);
                startActivity(intent);
            }
        });
    }
}
