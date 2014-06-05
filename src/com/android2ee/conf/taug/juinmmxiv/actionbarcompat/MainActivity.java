package com.android2ee.conf.taug.juinmmxiv.actionbarcompat;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	EditText edtSearch;
	MenuItem item;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		item = menu.findItem(R.id.action_search);
		RelativeLayout lil = (RelativeLayout) MenuItemCompat.getActionView(item);
		edtSearch = (EditText) lil.findViewById(R.id.edt_search);
		Button btnSearch = (Button) lil.findViewById(R.id.btn_search);
		btnSearch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				search();

			}
		});
		return true;
	}

	private void search() {
		Toast.makeText(this, edtSearch.getText(), Toast.LENGTH_LONG).show();
		MenuItemCompat.collapseActionView(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast.makeText(this, "OK ", Toast.LENGTH_LONG).show();
		if (item.getItemId() == R.id.action_settings) {
			startSupportActionMode(new Callback() {
				@Override
				public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
					return false;
				}
				@Override
				public void onDestroyActionMode(ActionMode mode) {
				}
				@Override
				public boolean onCreateActionMode(ActionMode mode, Menu menu) {
					getMenuInflater().inflate(R.menu.actionmode_menu, menu);
					return true;
				}
				@Override
				public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
					mode.finish();
					return true;
				}

			});
		}
		return super.onOptionsItemSelected(item);
	}

}
