package com.example.baitap_json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private int layout;

    private List<User> lits;

    public UserAdapter(Context context, int layout, List<User> list) {
        this.context = context;
        this.layout = layout;
        this.lits = list;
    }
    @Override
    public int getCount() {
        return lits.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.txtName = (TextView)view.findViewById(R.id.tenuser);
            holder.txtDate = (TextView)view.findViewById(R.id.ngaysinh);
            holder.img = view.findViewById(R.id.image);
            view.setTag(holder);

        }else {
            holder = (ViewHolder) view.getTag();

        }
        User user = lits.get(i);
        Glide.with(context).load(user.getImg()).into(holder.img);
        holder.txtName.setText(user.getFirstname() + " "+ user.getLastname());
        holder.txtDate.setText(user.getBirthday()+ " | " + user.getPhonenumber());

        return view;
    }
    private  class ViewHolder{
        TextView txtName, txtDate;
        ImageView img;
    }
}
