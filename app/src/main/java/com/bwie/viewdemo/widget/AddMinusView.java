package com.bwie.viewdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.viewdemo.R;

public class AddMinusView extends RelativeLayout {
    private   TextView addView,minusView;
    private EditText numView;
    private NumOnclick numOnclick;
    private int num = 1;
    /**
     * 代码动态创建view的时候调用
     * @param context
     */
    public AddMinusView(Context context) {
        this(context,null);
    }

    public AddMinusView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AddMinusView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void setNumOnclick(NumOnclick numOnclick) {
        this.numOnclick = numOnclick;
    }

    /**
     * 初始化数据
     * @param context
     */
    private void init(Context context){

        //渲染view对象
        View view = LayoutInflater.from(context).inflate(R.layout.cart_num_layout,this,false);
        //添加当前view对象给父类
        addView(view);

        addView = findViewById(R.id.add);
        minusView = findViewById(R.id.minus);
        numView = findViewById(R.id.num);
        numView.setText("2");
        num = Integer.valueOf(numView.getText().toString());

        addView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numOnclick!=null){
                    numOnclick.addOnclick(v);
                }
                ++num;
                numView.setText(num+"");
//                Toast.makeText(v.getContext(), "add", Toast.LENGTH_SHORT).show();
            }
        });

        minusView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numOnclick!=null){
                    numOnclick.minusOnclick(v);
                }
                --num;
                if (num==0){

                    num = 1;
                }
                numView.setText(num+"");
//                Toast.makeText(v.getContext(), "minus", Toast.LENGTH_SHORT).show();
            }
        });



    }

    public String getNumViewValue() {
        return numView.getText().toString();
    }

    public interface  NumOnclick{
        void addOnclick(View view);
        void minusOnclick(View view);
    }
}
