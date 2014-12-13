package com.example.colormix;

import java.math.BigInteger;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity{
	private SeekBar seekBarac, seekBarrc, seekBargc, seekBarbc;
	private TextView textViewaa, textViewrr, textViewgg, textViewbb, textviewdata;
	private String code;
	private Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		initializeVariables();
		
		//textView = (TextView) findViewById(R.id.aa);
		//seekBar = (SeekBar)findViewById(R.id.seekbarac);
		
		seekBarac.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {// alpha channel
			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
				String temp = Integer.toHexString(progresValue).toUpperCase();
				if(temp.length() < 2)
				{
					temp = "0" + temp;		//ensures the hexadecimal is a two digit output. want x01 rather than x1
				}
				textViewaa.setText(temp);
				code = textViewaa.getText().toString() //parse code
						+ textViewrr.getText().toString() 
						+ textViewgg.getText().toString() 
						+ textViewbb.getText().toString();
				//Color.parseColor("#" + code);
				button.setBackgroundColor(Color.parseColor("#" + code)); // output color
				textviewdata.setText("x" + code);		//output code to textview
			}
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {}
		});
		seekBarrc.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {// red channel
			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
				String temp = Integer.toHexString(progresValue).toUpperCase();
				if(temp.length() < 2)
				{
					temp = "0" + temp;			//ensures the hexadecimal is a two digit output. want x01 rather than x1
				}
				textViewrr.setText(temp);
				code = textViewaa.getText().toString() 		//parse code
						+ textViewrr.getText().toString() 
						+ textViewgg.getText().toString() 
						+ textViewbb.getText().toString(); 
				//button.setBackgroundColor(Integer.parseInt(code));
				button.setBackgroundColor(Color.parseColor("#" + code));		// output color
				textviewdata.setText("x" + code);			//output code to textview
			}
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {}
		});
		seekBargc.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {// green channel
			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
				String temp = Integer.toHexString(progresValue).toUpperCase();
				if(temp.length() < 2)
				{
					temp = "0" + temp;			//ensures the hexadecimal is a two digit output. want x01 rather than x1
				}
				textViewgg.setText(temp);
				code = textViewaa.getText().toString() 			//parse code
						+ textViewrr.getText().toString() 
						+ textViewgg.getText().toString() 
						+ textViewbb.getText().toString(); 
				//button.setBackgroundColor(Integer.parseInt(code));
				button.setBackgroundColor(Color.parseColor("#" + code));		// output color
				textviewdata.setText("x" + code);				//output code to textview
			}
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {}
		});
		
		
		seekBarbc.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {// blue channel
			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
				String temp = Integer.toHexString(progresValue).toUpperCase();
				if(temp.length() < 2)
				{
					temp = "0" + temp;			//ensures the hexadecimal is a two digit output. want x01 rather than x1
				}
				textViewbb.setText(temp);
				code = textViewaa.getText().toString() 			//parse code
						+ textViewrr.getText().toString() 
						+ textViewgg.getText().toString() 
						+ textViewbb.getText().toString(); 
				//button.setBackgroundColor(Integer.parseInt(code));
				button.setBackgroundColor(Color.parseColor("#" + code));			// output color
				textviewdata.setText("x" + code);			//output code to textview
			}
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {}
		});
		

		
	}
	
	private void initializeVariables()
	{
		seekBarac = (SeekBar) findViewById(R.id.seekbarac);
		seekBarrc = (SeekBar) findViewById(R.id.seekbarrc);
		seekBargc = (SeekBar) findViewById(R.id.seekbargc);
		seekBarbc = (SeekBar) findViewById(R.id.seekbarbc);
		textViewaa = (TextView) findViewById(R.id.aa);
		textViewrr = (TextView) findViewById(R.id.rr);
		textViewgg = (TextView) findViewById(R.id.gg);
		textViewbb = (TextView) findViewById(R.id.bb);
		textviewdata = (TextView) findViewById(R.id.data);
		button = (Button)findViewById(R.id.canvas);
		
		textViewaa.setText("00");
		textViewrr.setText("00");
		textViewgg.setText("00");
		textViewbb.setText("00");
		
		textviewdata.setText("x00000000");
		button.setBackgroundColor(0);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	/**
	 * A placeholder fragment containing a simple view.
	 */
	
	
	public static class PlaceholderFragment extends Fragment {
		
		

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
			
		}
		
		
	}
	
	
	
}


