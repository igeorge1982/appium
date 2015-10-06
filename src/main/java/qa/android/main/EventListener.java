package main.java.qa.android.main;


import io.appium.java_client.android.AndroidDriver;
import main.java.qa.android.main.TestBase;

import org.apache.log4j.Logger;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;



public class EventListener extends TestBase implements OnClickListener, OnLongClickListener, OnTouchListener {

	public EventListener(AndroidDriver driver){
		super(driver); 
	}
	
	private static Logger Log = Logger.getLogger(Logger.class.getName());

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onClick(View arg0) {
		Log.info(arg0);

	}










}



