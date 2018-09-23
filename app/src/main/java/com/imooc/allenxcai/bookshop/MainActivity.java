package com.imooc.allenxcai.bookshop;

import android.support.v7.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;


import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText returntime;
    private EditText name;
    private EditText borrowtime;
    private TextView userage;
    private TextView findbook;
    private TextView bookname;
    private TextView bookfitage;
    private TextView booktype;

    private RadioGroup sex;
    private CheckBox history, art, suspense;
    private SeekBar seekBar;
    private Button find;
    private Button next;
    private ImageView imageView;

    private List<Book> lists_book;
    private List<Book> lists_getbook;
    private Person person;
    private RadioGroupListener radioGroupListener;
    private boolean isHistory;
    private boolean isArt;
    private boolean isSuspense;

    private CheckBoxListener checkBoxListener;
    private int age = 0;
    private SeekBarListener seekBarListener;
    private ButtonListener buttonListener;
    private int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
        //初始化数据
        initData();
        // 为控件添加监听器
        setListener();


    }

    private void setListener() {
        radioGroupListener = new RadioGroupListener();
        sex.setOnCheckedChangeListener(radioGroupListener);
        checkBoxListener = new CheckBoxListener();
        history.setOnCheckedChangeListener(checkBoxListener);
        art.setOnCheckedChangeListener(checkBoxListener);
        suspense.setOnCheckedChangeListener(checkBoxListener);
        seekBarListener = new SeekBarListener();
        seekBar.setOnSeekBarChangeListener(seekBarListener);
        buttonListener = new ButtonListener();
        find.setOnClickListener(buttonListener);
        next.setOnClickListener(buttonListener);


        // toggleButton.setOnClickListener(buttonListener);
    }


    private void initData() {
        person = new Person();

        lists_book = new ArrayList<Book>();
        lists_getbook = new ArrayList<Book>();

        lists_book.add(new Book("人生感悟", R.drawable.aa, false, true, false, 50, "文艺"));
        lists_book.add(new Book("边城", R.drawable.bb, false, true, false, 30, "文艺"));
        lists_book.add(new Book("Sapir", R.drawable.cc, false, true, false, 30, "文艺"));
        lists_book.add(new Book("光辉岁月", R.drawable.dd, true, true, false, 30, "文艺"));
        lists_book.add(new Book("唐诗宋词300首", R.drawable.ee, false, true, false, 30, "诗词"));
        lists_book.add(new Book("中国古代文学", R.drawable.ff, true, true, false, 40, "文学"));
        lists_book.add(new Book("无花果", R.drawable.gg, false, true, false, 20, "小说"));
        lists_book.add(new Book("古镇记忆", R.drawable.hh, false, true, false, 30, "文学"));

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        returntime.setText(simpleDateFormat.format(calendar.getTime()));

    }

    private void initView() {
        name = findViewById(R.id.et_name);
        sex = findViewById(R.id.rg_sex);
        history = findViewById(R.id.cb_history);
        art = findViewById(R.id.cb_art);
        suspense = findViewById(R.id.cb_suspense);
        seekBar = findViewById(R.id.sb_age);
        find = findViewById(R.id.btn_find);
        next = findViewById(R.id.btn_next);
        borrowtime = findViewById(R.id.et_borrowtime);
        returntime = findViewById(R.id.et_returntime);
        imageView = findViewById(R.id.iv_pic);
        userage = findViewById(R.id.tv_age);
        findbook = findViewById(R.id.tv_description);
        bookname = findViewById(R.id.tv_bookname);
        bookfitage = findViewById(R.id.tv_bookage);
        booktype = findViewById(R.id.tv_booktype);
    }


    class RadioGroupListener implements OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            // 当用户选择当前RadioGroup组的Button时被触发
            switch (checkedId) {
                case R.id.rb_man:
                    person.setSex("男");
                    break;
                case R.id.rb_woman:
                    person.setSex("女");
                    break;
            }
            System.out.println("性别：" + person.getSex());
        }

    }

    class CheckBoxListener implements
            android.widget.CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            // 当控件状态改变时被触发
            CheckBox cbBox = (CheckBox) buttonView;
            switch (cbBox.getId()) {
                case R.id.cb_history:
                    if (isChecked) {
                        isHistory = true;
                    } else {
                        isHistory = false;
                    }

                    break;
                case R.id.cb_art:
                    if (isChecked) {
                        isArt = true;
                    } else {
                        isArt = false;
                    }
                    break;
                case R.id.cb_suspense:
                    if (isChecked) {
                        isSuspense = true;
                    } else {
                        isSuspense = false;
                    }
                    break;

            }
            System.out.println("爱好：" + "历史：" + isHistory + " 文艺：" + isArt + " 悬疑" + isSuspense);

        }

    }

    class SeekBarListener implements OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub
            age = seekBar.getProgress();

            //Toast.makeText(MainActivity.this, "年龄：" + age, Toast.LENGTH_SHORT).show();
            person.setAge(age);
            userage.setText(String.valueOf(age));
        }

    }

    class ButtonListener implements OnClickListener {

        @Override
        public void onClick(View v) {

            try {
                Date borrowDate = new SimpleDateFormat("yyyy-MM-dd").parse(borrowtime.getText().toString());
                Date returnDate = new SimpleDateFormat("yyyy.MM.dd").parse(returntime.getText().toString());

                if (borrowDate.after(returnDate)) {
                    Toast.makeText(MainActivity.this, "借书日期晚于还书日期，退出", Toast.LENGTH_LONG).show();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    finish();
                    return;

                }

                borrowtime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(borrowDate));
                person.setDate(borrowtime.getText().toString());
                person.setName(name.getText().toString());
                Toast.makeText(MainActivity.this, person.toString(), Toast.LENGTH_SHORT).show();

            } catch (ParseException e) {
                //e.printStackTrace();
            }


            switch (v.getId()) {

                case R.id.btn_find:
                    lists_getbook.clear();

                    count = 0;
                    checkData();

                    if (lists_getbook.size() > 0) {
                        count = 0;
                        findbook.setText("符合条件的书有" + lists_getbook.size() + "本");
                        showPic(count);
                    } else {
                        findbook.setText("没有符合条件的书");

                    }

                    break;
                case R.id.btn_next:

                    count++;
                    findbook.setText("符合条件的书有" + (lists_getbook.size() - count) + "本");
                    if (count == lists_getbook.size()) {

                        count = 0;
                    }
                    showPic(count);

                    break;
            }

        }

        private void checkData() {
            // 找出书籍

            for (int i = 0; i < lists_book.size(); i++) {
                Book book = lists_book.get(i);
                if ((book.getFitAge() <= age)
                        && (book.isArt() == isArt && book.isHistory() == isHistory && book
                        .isSuspense() == isSuspense)) {
                    lists_getbook.add(book);
                }
            }
            System.out.println("*********" + lists_getbook.size());


        }

    }

    private void showPic(int count) {

        int num = lists_getbook.size();


        if (count < num) {
            imageView.setImageResource(lists_getbook.get(count).getPic());

            bookname.setText(lists_getbook.get(count).getName());

            booktype.setText(lists_getbook.get(count).getType());

            bookfitage.setText(String.valueOf(lists_getbook.get(count).getFitAge()));
        }


    }

}
