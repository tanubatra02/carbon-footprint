package com.example.carbonfootprintcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.EditText;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btnCalc = (Button) findViewById(R.id.btnCalc);

		btnCalc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText TVelectricity = (EditText) findViewById(R.id.txtElectricityBill);
				EditText TVgas = (EditText) findViewById(R.id.txtGasBill);
				EditText TVoil = (EditText) findViewById(R.id.txtOilBill);
				EditText TVmileage = (EditText) findViewById(R.id.txtMileage);
				EditText TVflight4 = (EditText) findViewById(R.id.txtFlightsA);
				EditText TVflightMore = (EditText) findViewById(R.id.txtFlightsB);
				RadioButton RADPaperYes = (RadioButton) findViewById(R.id.radPaperY);
				RadioButton RADPaperNo = (RadioButton) findViewById(R.id.radPaperN);
				RadioButton RADTinYes = (RadioButton) findViewById(R.id.RadTinY);
				RadioButton RADTinNo = (RadioButton) findViewById(R.id.radTinN);
				int elec = 0;
				int oil = 0;
				int  gas = 0;
				int mileage = 0;
				int flightsA = 0;
				int flightMore =0;
				int paper = 0;
				int tin = 0;
				
				if(!RADPaperYes.isChecked() &&RADPaperNo.isChecked())
					paper = 184;
				if(!RADTinYes.isChecked() &&RADTinNo.isChecked())
					tin = 166;
				
				String tvelecValue = TVelectricity.getText().toString();
				if (!tvelecValue.equals("") && !tvelecValue.equals(" ")) {
				    elec = Integer.parseInt(tvelecValue);
				}
				
				String tvoilValue = TVoil.getText().toString();
				if (!tvoilValue.equals("") && !tvoilValue.equals(" ")) {
				    oil = Integer.parseInt(tvoilValue);
				}
				
				String tvgasValue = TVgas.getText().toString();
				if (!tvgasValue.equals("") && !tvgasValue.equals(" ")) {
				    gas = Integer.parseInt(tvgasValue);
				}
				
				String tvmileageValue = TVmileage.getText().toString();
				if (!tvmileageValue.equals("") && !tvmileageValue.equals(" ")) {
				    mileage = Integer.parseInt(tvmileageValue);
				}
				
				String tvflightsAValue = TVflight4.getText().toString();
				if (!tvflightsAValue.equals("") && !tvflightsAValue.equals(" ")) {
				    flightsA = Integer.parseInt(tvflightsAValue);
				}
				
				String tvflightMoreValue = TVflightMore.getText().toString();
				if (!tvflightMoreValue.equals("") && !tvflightMoreValue.equals(" ")) {
				    flightMore = Integer.parseInt(tvflightMoreValue);
				}
				
				int footprint = (int) (elec*105 + oil*113 + gas*105 + mileage*0.79 + flightsA*1100 + flightMore*4400 + paper + tin);

				Intent intent = new Intent(getBaseContext(), FootprintActivity.class);
				intent.putExtra("FootPrint", footprint);
				startActivity(intent);
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
