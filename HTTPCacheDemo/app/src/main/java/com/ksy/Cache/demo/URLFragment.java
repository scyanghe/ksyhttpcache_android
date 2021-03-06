package com.ksy.Cache.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class URLFragment extends Fragment {
    private ListView listView;
    private ArrayList<HashMap<String,String>> urllist;

    public URLFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        urllist = new ArrayList<HashMap<String,String>>();
        HashMap<String,String> map1 = new HashMap<String,String>();
        HashMap<String,String> map2 = new HashMap<String,String>();
        HashMap<String,String> map3 = new HashMap<String,String>();

        map1.put("url","http://cxy.kssws.ks-cdn.com/h265_56c26b7a7dc5f6043.mp4");
        map2.put("url","http://zbvideo.ks3-cn-beijing.ksyun.com/record/live/101743_1466076252/hls/101743_1466076252.m3u8");
        map3.put("url","https://mvvideo5.meitudata.com/571090934cea5517.mp4");

        urllist.add(map1);
        urllist.add(map2);
        urllist.add(map3);
        View view = inflater.inflate(R.layout.fragment_url, container, false);
        listView = (ListView)view.findViewById(R.id.list_url);
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),urllist,R.layout.urllist_view,new String[]{"url"},new int[]{R.id.list_url_txt});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(),VideoPlayerActivity.class);
                intent.putExtra("path", urllist.get(i).get("url"));
                startActivity(intent);
            }
        });
        return view;
    }


}
