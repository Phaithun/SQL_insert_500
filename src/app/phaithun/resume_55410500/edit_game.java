package app.phaithun.resume_55410500;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class edit_game extends Activity implements OnClickListener {
	private Button btnsubmit;
	private EditText etxt1, etxt2, etxt3, etxt4;
	private String txt01, txt02, txt03, txt04;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.edit_500);
		super.onCreate(savedInstanceState);
		ViewMatching();
	}

	private void ViewMatching() {
		btnsubmit = (Button) findViewById(R.id.btngame);
		btnsubmit.setOnClickListener(this);
		etxt1 = (EditText) findViewById(R.id.etxt1);
		etxt2 = (EditText) findViewById(R.id.etxt2);
		etxt3 = (EditText) findViewById(R.id.etxt3);
		etxt4 = (EditText) findViewById(R.id.etxt4);

	}

	@Override
	public void onClick(View v) {
		
		  save();
		  
		switch (v.getId()) {
		case R.id.btngame:
			txt01 = (etxt1.getText().toString());
			txt02 = (etxt2.getText().toString());
			txt03 = (etxt3.getText().toString());
			txt04 = (etxt4.getText().toString());

			Intent R = new Intent(getApplicationContext(), MainActivity.class);
			R.putExtra("txt01", txt01);
			R.putExtra("txt02", txt02);
			R.putExtra("txt03", txt03);
			R.putExtra("txt04", txt04);
			startActivity(R);
			break;
		default:
			break;
		}
	}
	public boolean save() {
		final AlertDialog.Builder ab = new AlertDialog.Builder(this);
		AlertDialog vv = ab.create();

		dbcontroler_500 dbclass = new dbcontroler_500(this);
		long savedata = dbclass.insertData(etxt1.getText().toString(), etxt2
				.getText().toString(), etxt3.getText().toString(), etxt4
				.getText().toString(), null);

		if (savedata <= 0) {
			vv.setMessage("Error !!!!");
			vv.show();
			return false;
		}

		Toast.makeText(getApplicationContext(), "Add Data Successfully",
				Toast.LENGTH_SHORT).show();
		return true;
	}
}