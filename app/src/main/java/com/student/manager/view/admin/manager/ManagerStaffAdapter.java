package com.student.manager.view.admin.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.student.manager.R;

public class ManagerStaffAdapter extends RecyclerView.Adapter<ManagerStaffAdapter.ViewHolder> {

    Context context;
//    OgjectGamePlay data;
//    ClickCell clickCell;


//    public CellAdapter(Context context, OgjectGamePlay data, ClickCell clickCell) {
//        this.data = data;
//        this.context = context;
//        this.clickCell = clickCell;
//    }

//    @SuppressLint("NotifyDataSetChanged")
//    public void setData(OgjectGamePlay data) {
//        this.data = new OgjectGamePlay();
//        this.data = data;
//        notifyDataSetChanged();
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_manager_staff, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        CellParent cellParent = data.getList().get(position);
//
//        if (cellParent.isFirst()) {
//            holder.number.setTextColor(context.getColor(R.color.black));
//        }

    }


    @Override
    public int getItemCount() {
        return 81;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView number, number_01, number_02, number_03, number_04, number_05, number_06, number_07, number_08, number_09;
        View bg_cell;
        ConstraintLayout root;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            bg_cell = itemView.findViewById(R.id.bg_cell);
//            root = itemView.findViewById(R.id.root);
//            number = itemView.findViewById(R.id.number);
//            number_01 = itemView.findViewById(R.id.number_01);
//            number_02 = itemView.findViewById(R.id.number_02);
//            number_03 = itemView.findViewById(R.id.number_03);
//            number_04 = itemView.findViewById(R.id.number_04);
//            number_05 = itemView.findViewById(R.id.number_05);
//            number_06 = itemView.findViewById(R.id.number_06);
//            number_07 = itemView.findViewById(R.id.number_07);
//            number_08 = itemView.findViewById(R.id.number_08);
//            number_09 = itemView.findViewById(R.id.number_09);
        }

    }
}