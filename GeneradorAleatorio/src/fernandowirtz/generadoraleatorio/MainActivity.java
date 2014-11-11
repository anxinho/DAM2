package fernandowirtz.generadoraleatorio;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private SharedPreferences preferences;
	private TextView txtNums;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtNums = (TextView)findViewById(R.id.textViewAleatorios);
		//if(preferences.contains("numerosAleatorios")){
        preferences=getSharedPreferences("numerosAleatorios",Context.MODE_PRIVATE);
		//}
        txtNums.setText(preferences.getString("numeros", ""));
	}
	
	public void onClickAleatorio(View v){
    	Primitiva p=new Primitiva();
    	System.out.println("Probando");
    	System.out.println(p.getExit());
    	System.out.println("Probando2");
    	txtNums.setText(p.getExit());
    	txtNums.setTextSize(25);
    }
	@Override
	protected void onStop(){
    	super.onStop();
    	saveData();
    }
	
	private void saveData(){
    	SharedPreferences.Editor edit=preferences.edit();
    	edit.putString("numeros", txtNums.getText().toString());
    	edit.commit();
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
}
