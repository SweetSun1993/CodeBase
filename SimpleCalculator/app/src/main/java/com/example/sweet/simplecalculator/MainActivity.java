package com.example.sweet.simplecalculator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /**
     * 数字
     */
    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;

    /**
     * 运算
     */
    private Button puls_bt;
    private Button subtract_bt;
    private Button multiply_bt;
    private Button divide_bt;
    private Button equal_bt;

    /**
     * 其他
     */
    private Button ac_bt;
    private Button delete_bt;
    private Button percent_bt;
    private Button dot_bt;

    /**
     * 结果
     */
    private EditText result_tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();

    }

    /**
     * 初始化控件
     */
    private void initview() {
        /**
         * 数字
         */
        num0 = findViewById(R.id.num_zero);
        num1 = findViewById(R.id.num_one);
        num2 = findViewById(R.id.num_two);
        num3 = findViewById(R.id.num_three);
        num4 = findViewById(R.id.num_four);
        num5 = findViewById(R.id.num_five);
        num6 = findViewById(R.id.num_six);
        num7 = findViewById(R.id.num_seven);
        num8 = findViewById(R.id.num_eight);
        num9 = findViewById(R.id.num_nine);

        /**
         * 运算
         */
        puls_bt = findViewById(R.id.plus_bt);
        subtract_bt = findViewById(R.id.subtract_bt);
        multiply_bt = findViewById(R.id.multiply_bt);
        divide_bt = findViewById(R.id.divide_bt);
        equal_bt = findViewById(R.id.equal_bt);
        /**
         * 其他
         */
        ac_bt = findViewById(R.id.ac_bt);
        delete_bt = findViewById(R.id.delete_bt);
        percent_bt = findViewById(R.id.percent_bt);
        dot_bt = findViewById(R.id.dot_bt);

        /**
         * 结果
         */
        result_tx = findViewById(R.id.result_tx);

    }
}
