package com.example.carbonfootprintcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;



public class Splash extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		Thread timer=new Thread(){
			public void run()
			{
				try{
					sleep(5000);
					
				} catch(InterruptedException e){
					e.printStackTrace();
				}
					finally{
				Intent it=new Intent(Splash.this,SplashContinue.class);
				startActivity(it);
			}
		}
	};
	timer.start();

}

}
