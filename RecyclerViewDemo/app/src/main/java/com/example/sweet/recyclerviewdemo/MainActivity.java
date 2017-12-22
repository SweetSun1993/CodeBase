package com.example.sweet.recyclerviewdemo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    int lastPostion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new NormalRecyclerViewAdapter(this));
        mRecyclerView.addItemDecoration(new MyDecoration(this, MyDecoration.VERTICAL_LIST, R.drawable.divider));
        mRecyclerView.addItemDecoration(new MyDecoration(this, MyDecoration.HORIZONTAL_LIST, R.drawable.divider));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private int getMaxPosition(int[] positions) {
        int size = positions.length;
        int maxPosition = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            maxPosition = Math.max(maxPosition, positions[i]);
        }
        return maxPosition;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_normal_list:
                Toast.makeText(this, "LinearLayout", Toast.LENGTH_SHORT).show();
                if (mRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
                    lastPostion = ((GridLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
                } else if (mRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                    StaggeredGridLayoutManager layoutManager = (StaggeredGridLayoutManager) mRecyclerView.getLayoutManager();
                    int[] lastPostions = layoutManager.findLastCompletelyVisibleItemPositions(new int[layoutManager.getSpanCount()]);
                    lastPostion = getMaxPosition(lastPostions);
                }
                mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                break;
            case R.id.action_normal_grid:
                Toast.makeText(this, "GridLayout", Toast.LENGTH_SHORT).show();
                if (mRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                    lastPostion = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
                } else if (mRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                    StaggeredGridLayoutManager layoutManager = (StaggeredGridLayoutManager) mRecyclerView.getLayoutManager();
                    int[] lastPostions = layoutManager.findLastCompletelyVisibleItemPositions(new int[layoutManager.getSpanCount()]);
                    lastPostion = getMaxPosition(lastPostions);
                }
                mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
                break;
            case R.id.action_normal_staggered:
                if (mRecyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                    lastPostion = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
                } else if (mRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
                    lastPostion = ((GridLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
                }
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
                break;
            default:
                //  lastPostion = mRecyclerView.getLayoutManager().getItemCount() - 1;
                break;
        }

        // mRecyclerView.setAdapter(new NormalRecyclerViewAdapter(this));
        //mRecyclerView.scrollToPosition(lastPostion);
        return super.onOptionsItemSelected(item);
    }

}
