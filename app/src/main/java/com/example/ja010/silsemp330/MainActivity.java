package com.example.ja010.silsemp330;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.ed1);
        e2 = (EditText)findViewById(R.id.ed2);

    }
    public void clcl(View v){
        if(v.getId()==R.id.b1){
            Toast.makeText(getApplicationContext(),"일반메세지 창입니다.",Toast.LENGTH_SHORT).show();
        }
        else if (v.getId()==R.id.b2){ // toast 를 위치를 지정할수 있는것
            Toast toastView = Toast.makeText(this,"위치지정",Toast.LENGTH_SHORT);
            //int x = Integer.parseInt(e1.getText().toString());
            toastView.setGravity(Gravity.LEFT|Gravity.TOP,10,20);
            toastView.show();
        }
        else if(v.getId()==R.id.b3){
            View view = getLayoutInflater().inflate(R.layout.mytoast,null);
            TextView msg = (TextView)view.findViewById(R.id.textView); //view 에서 찾아야 됨
            msg.setText("abcdefg");
            Toast ts = new Toast(this);
            ts.setDuration(Toast.LENGTH_SHORT);
            ts.setGravity(Gravity.CENTER,0,100);
            ts.setView(view);
            ts.show();
        }
        else  if(v.getId()==R.id.b4){//ctrl + p
            Snackbar.make(v,"snackbar의 내용 !",1000).setAction("ok", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();
                }
            }).show();//v는 onclick 의 view 파라미터값을 집어넣는것 (this x ,context x) 1000 = 1sec
        }
        else if (v.getId()==R.id.b5){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("제목");
            dlg.setMessage("내용").setIcon(R.mipmap.ic_launcher).setPositiveButton("닫기",null)// null 값은 event 가 없다는 뜻!
            .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"확인을 눌렀음 ",Toast.LENGTH_SHORT).show();
                }
            });
            dlg.show();
            // dig.setTitle("제목").setMessage("내용"); 이 가능 하다 .이 함수들의 return 값이 대화상자이므로가능
        }

        else if (v.getId()==R.id.b6){//누가선택? -> 전역변수로 선택후 data,1,new set-> 해서 저장을 한다
            String data[] = {"치킨","피자"};
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("제목");// radio box는 배열이 필요( 배열, 누가먼저 선택, 클릭시 이벤트여부)
            dlg.setSingleChoiceItems(data, 1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            }).setIcon(R.mipmap.ic_launcher).setPositiveButton("닫기",null)// null 값은 event 가 없다는 뜻!
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),"확인을 눌렀음 ",Toast.LENGTH_SHORT).show();
                        }
                    });
            dlg.show();
        }
        else if (v.getId()==R.id.b7){// check box //누가 선택? ->
            final String data[] = {"치킨","피자","짜장","탕수육"}; // final 전역변수화
            final boolean checkdata[] = {true,false,true,false}; // string array 와 같은 크기를 가지고, 체크된 여부를 저장하는 array
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("제목");
            dlg.setMultiChoiceItems(data, checkdata, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {// 번호와 체크정보가 같이 넘어옴
                    checkdata[which] = isChecked;
                }
            }).setIcon(R.mipmap.ic_launcher).setPositiveButton("닫기",null)// null 값은 event 가 없다는 뜻!
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            for(int a=0;a<data.length;a++);
                            Toast.makeText(getApplicationContext(),"확인을 눌렀음 ",Toast.LENGTH_SHORT).show();
                        }
                    });
            dlg.show();
        }
        else if (v.getId()==R.id.b8){
           View view = View.inflate(this,R.layout.te,null);
            final EditText et = (EditText)view.findViewById(R.id.ett1);
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("제목");
            dlg.setView(view)
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기",null)// null 값은 event 가 없다는 뜻!
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Toast.makeText(getApplicationContext(),et.getText().toString() ,Toast.LENGTH_SHORT).show();
                        }
                    });
            dlg.show();
        }

    }
}
