package com.example.bdwen.acartoon.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.State;
import android.util.Log;
import android.view.View;

public class ItemDecoration extends RecyclerView.ItemDecoration {
	private static final String TAG = "ItemDecoration";
	private int space;

	public ItemDecoration(int space) {
		this.space = space;
	}

	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
		// TODO Auto-generated method stub
		outRect.top=space;
		if (parent.getChildLayoutPosition(view) % 2 == 0) {
			outRect.left = space;
			outRect.right = space / 2;
		}
		if (parent.getChildLayoutPosition(view) % 2 == 1) {
			outRect.left = space / 2;
			outRect.right = space;
		}
		RecyclerView.Adapter adapter = parent.getAdapter();
		if (parent.getChildLayoutPosition(view)==adapter.getItemCount()-1||
				parent.getChildLayoutPosition(view)==adapter.getItemCount()-2){
			outRect.bottom = space;
		}

	}
}
