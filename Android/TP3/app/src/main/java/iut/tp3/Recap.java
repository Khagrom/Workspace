package iut.tp3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class Recap extends AppCompatActivity {
    String text;
    String adresse;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap);
        affiche();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recap, menu);
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

    public void affiche() {
        Intent i = getIntent();
        TextView result = (TextView)findViewById(R.id.recap);
        StringBuilder sb = new StringBuilder();
        sb.append("Sexe : ");
        sb.append(i.getStringExtra("sex"));
        sb.append("\n");
        sb.append("Nom / Prénom : ");
        sb.append(i.getStringExtra("name"));
        sb.append("\n");
        sb.append("Téléphone : ");
        sb.append(i.getStringExtra("phone"));
        sb.append("\n");
        sb.append("E-mail : ");
        sb.append(i.getStringExtra("mail"));
        sb.append("\n");
        sb.append("Date de naissance : ");
        sb.append(i.getStringExtra("dob"));
        sb.append("\n");
        sb.append("Adresse : ");
        sb.append(i.getStringExtra("address"));
        sb.append("\n");
        sb.append("Code postal : ");
        sb.append(i.getStringExtra("zip"));
        result.setText(sb.toString());
        text = sb.toString();
        adresse = i.getStringExtra("mail");
    }

    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{adresse});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Confirmation d'enregistrement");
        intent.putExtra(Intent.EXTRA_TEXT, text);

        startActivity(Intent.createChooser(intent, "Envoyer la confirmation"));
    }
}
