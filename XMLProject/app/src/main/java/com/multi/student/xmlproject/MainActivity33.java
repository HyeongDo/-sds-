package com.multi.student.xmlproject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity33 extends AppCompatActivity {


    ArrayList<String> data;
    ArrayAdapter<String> adapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main33);

        list = (ListView)findViewById(R.id.list);
        data = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_2,//listview의 item에 사용할 Layout xmL
                android.R.id.text1,
                data
        );
        list.setAdapter(adapter);
    }

    public void doJob(View v){
        int id = v.getId();
        if(id == R.id.weather){
            //기상청 사이트에 접속해서 xml 문서 받아온 후 작업
            DataBaseAsync dataBaseAsync = new DataBaseAsync();
            dataBaseAsync.execute();

        }else{
            //조선닷컴에 접속해서 xml 문서 받아온 후 작업
            NewsAsync NewsAsync = new NewsAsync();
            NewsAsync.execute();
           
        }

    }


    //기상청에서 받아온 정보 parsing
    //Void, String, Void: params 입력값,
    // String 메인스레드에 전달할 값의 타입, Void 작업 완료 후에 리턴값 타입
    class BookAsync extends AsyncTask<Void, String, Void>{
        @Override
        protected Void doInBackground(Void... voids) {//user thread
            data.clear();

            String url = "http://70.12.114.133:7070/MyServerProject/jsp/bookinfo.jsp";
            String result = "";
            Document xml = null;
            try {
                xml = Jsoup.connect(url).get();//url에 접속하여(connect) xml 문서형식으로 받아들임(get)
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements items = xml.select("book");//이름에 맞는 태그를 찾아줌, 지금은 category(select)



            for(Element e: items){
                String name = e.select("name").text();//원하는 태그만 찾아서 보여줌
                String author = e.select("author").text();
                String price = e.select("price").text();

                data.add(name +"==--" + author + "--" + price);
            }
            publishProgress();
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {//main thread
            super.onProgressUpdate(values);
            adapter.notifyDataSetChanged();//화면에 표시
        }
    }

    class DataBaseAsync extends AsyncTask<Void, String, Void>{
        @Override
        protected Void doInBackground(Void... voids) {//user thread
            data.clear();

            String url = "http://70.12.114.133:7070/MyServerProject/jsp/database.jsp";
            String result = "";
            Document xml = null;
            try {
                xml = Jsoup.connect(url).get();//url에 접속하여(connect) xml 문서형식으로 받아들임(get)
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements items = xml.select("item");//이름에 맞는 태그를 찾아줌, 지금은 category(select)



            for(Element e: items){
                String name = e.select("id").text();//원하는 태그만 찾아서 보여줌
                String author = e.select("name").text();
                String price = e.select("company").text();

                data.add(name +"--" + author + "--" + price);
            }
            publishProgress();
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {//main thread
            super.onProgressUpdate(values);
            adapter.notifyDataSetChanged();//화면에 표시
        }
    }

    class NewsAsync extends AsyncTask<Void, String, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            data.clear();
            String url = "http://www.chosun.com/site/data/rss/rss.xml";
            String result = "";
            Document xml = null;
            try {
                xml = Jsoup.connect(url).get();//url에 접속하여(connect) xml 문서형식으로 받아들임(get)
            } catch (IOException e) {
                e.printStackTrace();
            }
//            Elements category = xml.select("channel");//이름에 맞는 태그를 찾아줌, 지금은 category(select)
//            result += category.get(0).text() + "\n\n";//중간에 있는 글 -> 강남구 역삼동
            Elements items = xml.select("title");
            result+= "title tag 갯수:" + items + "\n\n";
            for(Element e: items){
                String title = e.select("title").text();//원하는 태그만 찾아서 보여줌
                data.add(title);
            }
            publishProgress(result);
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {//main thread
            super.onProgressUpdate(values);
            adapter.notifyDataSetChanged();
        }
    }
}
