package com.example.keyringhw2;



import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
				getMenuInflater().inflate(R.menu.second, menu);
				return true;
				
		
	}
	
	public void methodOne(View v){
		
		EditText et = (EditText) findViewById(R.id.editText1);
		
		
		
		if(et.getText().toString().equals("plm"))
		{
		Intent intent = new Intent(MainActivity.this, SecondActivity.class);
       startActivity(intent);
		}
		else
		{
			 Context context = MainActivity.this;
             
             int duration = Toast.LENGTH_SHORT;

             Toast.makeText(context, "Wrong pass bitch!", duration).show();
		}
		
	}
	
	
	
	

}
