package com.example.carbonfootprintcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FootprintActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_footprint);
		
		TextView txtFP = (TextView) findViewById(R.id.txtFP);
		TextView txtFPLevel = (TextView) findViewById(R.id.txtFPLevel);
		Button btnReduce = (Button) findViewById(R.id.txtReduceFP);
		
		Intent intent = getIntent();
		int fp = intent.getIntExtra("FootPrint", 0);
		txtFP.setText(""+fp);
		
		if (fp<6000)
			txtFPLevel.setText("Very Low");
		else if (fp>=6000 && fp<16000)
			txtFPLevel.setText("Low");
		else if (fp>=16000 && fp<22000)
			txtFPLevel.setText("Average");		
		else if (fp>=22000)
			txtFPLevel.setText("High"); 
		
		btnReduce.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), TipsActivity.class);
				startActivity(intent);
			}
		});
	}
}
