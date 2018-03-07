package com.caohua.zhousaito.dragdemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.caohua.zhousaito.dragdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhousaito on 2018/2/26.
 */

public class OneFragment extends Fragment {

    private RecyclerView recyclerView;
    public List<String> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        for (int i = 1; i < 15; i++) {
            list.add("这是item值为" + i);
        }
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View inflate = View.inflate(getActivity(), R.layout.recycler_item, null);
                return new RecyclerView.ViewHolder(inflate) {

                };
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((Button) holder.itemView.findViewById(R.id.item_btn)).setText(list.get(position));
            }

            @Override
            public int getItemCount() {
                return list.size();
            }

        });
    }
}
