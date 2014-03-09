package com.example.carbonfootprintcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class SplashContinue extends Activity {

	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			
			
			super.onCreate(savedInstanceState);
			setContentView(R.layout.splashcontinue);
			Thread timer=new Thread(){
				public void run()
				{
					try{
						sleep(5000);
						
					} catch(InterruptedException e){
						e.printStackTrace();
					}
						finally{
							Intent it=new Intent(SplashContinue.this,MainActivity.class);
							startActivity(it);
				}
			}
		};
		timer.start();

	}
		

}
