package com.example.hackathon.manager.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hackathon.R;
import com.example.hackathon.activity.FindActivity;
import com.example.hackathon.manager.holder.FindViewHolder;
import com.example.hackathon.model.Token;
import com.example.hackathon.model.Write;
import com.example.hackathon.network.client.FindClient;
import com.example.hackathon.network.client.LikeClient;
import com.example.hackathon.network.request.LikeRequest;
import com.example.hackathon.viewmodel.FindViewModel;
import com.example.hackathon.viewmodel.ViewModelFactory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class FindAdapter extends RecyclerView.Adapter<FindViewHolder> {

    List<Write> list;
    LikeClient likeClient;
    Context context;
    Token token;
    Activity activity;
    String value;

    public FindAdapter(List<Write> list, Context context, Activity activity, String value) {
        this.list = list;
        likeClient = new LikeClient();
        token = new Token(context);
        this.activity = activity;
        this.value = value;
    }
    @NonNull
    @Override
    public FindViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new FindViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.find_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FindViewHolder holder, int position) {
        Write write = list.get(position);

        holder.binding.like.setText("추천 " + write.getLikeCount() + "개");
        holder.binding.textView.setText(write.getContents());
        holder.binding.writer.setText(write.getWriter());

        if (write.getLike() == 1) {
            holder.binding.like.setBackgroundResource(R.drawable.like_part);
            holder.binding.like.getResources().getColor(R.color.white);
        } else {
            holder.binding.like.setBackgroundResource(R.drawable.login_part);
            holder.binding.like.setTextColor(holder.binding.like.getResources().getColor(R.color.back));
        }

        holder.binding.like.setOnClickListener(v -> {
            LikeRequest likeRequest = new LikeRequest();
            likeRequest.setPostIdx(list.get(position).getIdx());

            new CompositeDisposable().add(likeClient.like(token, likeRequest).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).subscribeWith(
                            new DisposableSingleObserver<String>() {
                                @Override
                                public void onSuccess(String message) {
                                    Intent intent = new Intent(activity, FindActivity.class);
                                    intent.putExtra("barcode",value);
                                    context.startActivity(intent);
                                }

                                @Override
                                public void onError(Throwable e) {
                                }
                            }));
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
