package com.imooc.game.pintu;

import com.imooc.game.pintu.view.GamePintuLayout;
import com.imooc.game.pintu.view.GamePintuLayout.GamePintuListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity
{

	private GamePintuLayout mGamePintuLayout;
	private TextView mStep ; 
	private TextView mClear;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mClear = (TextView) findViewById(R.id.id_clear);
		
		mStep = (TextView) findViewById(R.id.id_step);
		
		mGamePintuLayout = (GamePintuLayout) findViewById(R.id.id_gamepintu);
		//mGamePintuLayout.setTimeEnabled(true);
		
		mGamePintuLayout.setOnGamePintuListener(new GamePintuListener()
		{
			@Override
			public void timechanged(int currentTime)
			{
				mClear.setText(""+currentTime);
			}

			@Override
			public void stepShow(int step) {
				mStep.setText(""+step);
				
			}
			
			/*
			@Override
			public void nextLevel(final int nextLevel)
			{
				new AlertDialog.Builder(MainActivity.this)
						.setTitle("Game Info").setMessage("LEVEL UP !!!")
						.setPositiveButton("NEXT LEVEL", new OnClickListener()
						{
							@Override
							public void onClick(DialogInterface dialog,
									int which)
							{
								mGamePintuLayout.nextLevel();
								mStep.setText(""+nextLevel);
							}
						}).show();
			}
			@Override
			public void gameover()
			{
				new AlertDialog.Builder(MainActivity.this)
				.setTitle("Game Info").setMessage("Game over !!!")
				.setPositiveButton("RESTART", new OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog,
							int which)
					{
						mGamePintuLayout.restart();
					}
				}).setNegativeButton("QUIT",new OnClickListener()
				{
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						finish();
					}
				}).show();
			}*/
		});
		mClear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mGamePintuLayout.initItems();
				mStep.setText("0");
			}
		});
	}
	/*
	@Override
	protected void onPause()
	{
		super.onPause();
		
		mGamePintuLayout.pause();
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		mGamePintuLayout.resume();
	}
	*/
}
