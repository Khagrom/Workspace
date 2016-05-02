package iut.tp3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class Formulaire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulaire, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void message(View view) {
        hideSoftKeyboard(Formulaire.this);

        RadioGroup rg = (RadioGroup)findViewById(R.id.sex);
        EditText name = (EditText)findViewById(R.id.name);
        EditText phone = (EditText)findViewById(R.id.phone);
        EditText email = (EditText)findViewById(R.id.mail);
        EditText dob = (EditText)findViewById(R.id.dob);
        EditText address = (EditText)findViewById(R.id.address);
        EditText zip = (EditText)findViewById(R.id.zip);
        TextView result = (TextView)findViewById(R.id.result);

        int selectedSexId = rg.getCheckedRadioButtonId();
        RadioButton sex = (RadioButton)findViewById(selectedSexId);

        Intent i = new Intent(Formulaire.this, Recap.class);
        i.putExtra("sex", sex.getText().toString());
        i.putExtra("name", name.getText().toString());
        i.putExtra("phone", phone.getText().toString());
        i.putExtra("mail", email.getText().toString());
        i.putExtra("dob", dob.getText().toString());
        i.putExtra("address", address.getText().toString());
        i.putExtra("zip", zip.getText().toString());
        startActivity(i);
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }
}
