package sg.edu.rp.c346.id21020263.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView dbs;
    TextView ocbc;
    TextView uob;
    String bankClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.bank1);
        ocbc = findViewById(R.id.bank2);
        uob = findViewById(R.id.bank3);
        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //
        getMenuInflater().inflate(R.menu.menu_main, menu);

        if (v == dbs) {
            bankClicked = "dbs";
        } else if(v == ocbc) {
            bankClicked = "ocbc";
        } else if(v == uob) {
            bankClicked = "uob";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.websiteSelection) {
            if (bankClicked.equalsIgnoreCase("dbs")) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getResources().getString(R.string.dbsLink)));
                startActivity(intent);
                return true;
            } else if(bankClicked.equalsIgnoreCase("ocbc")) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getResources().getString(R.string.ocbcLink)));
                startActivity(intent);
                return true;
            } else if(bankClicked.equalsIgnoreCase("uob")) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getResources().getString(R.string.uobLink)));
                startActivity(intent);
                return true;
            }
        }

        if(item.getItemId() == R.id.contactSelection) {
            if (bankClicked.equalsIgnoreCase("dbs")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getResources().getString(R.string.dbsNUM)));
                startActivity(intentCall);
            } else if (bankClicked.equalsIgnoreCase("ocbc")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getResources().getString(R.string.ocbcNUM)));
                startActivity(intentCall);
            } else if (bankClicked.equalsIgnoreCase("uob")) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getResources().getString(R.string.uobNUM)));
                startActivity(intentCall);
            }
        }

        if(item.getItemId() == R.id.favouriteSelection) {
            if (bankClicked.equalsIgnoreCase("dbs")) {
                if (dbs.getCurrentTextColor() == Color.parseColor("black")) {
                    dbs.setTextColor(Color.parseColor("red"));
                } else if (dbs.getCurrentTextColor() == Color.parseColor("red")) {
                    dbs.setTextColor(Color.parseColor("black"));
                }
            } else if (bankClicked.equalsIgnoreCase("ocbc")) {
                if (ocbc.getCurrentTextColor() == Color.parseColor("black")) {
                    ocbc.setTextColor(Color.parseColor("red"));
                } else if (ocbc.getCurrentTextColor() == Color.parseColor("red")) {
                    ocbc.setTextColor(Color.parseColor("black"));
                }
            } else if (bankClicked.equalsIgnoreCase("uob")) {
                if (uob.getCurrentTextColor() == Color.parseColor("black")) {
                    uob.setTextColor(Color.parseColor("red"));
                } else if (uob.getCurrentTextColor() == Color.parseColor("red")) {
                    uob.setTextColor(Color.parseColor("black"));
                }
            }
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.ChineseSelection) {
            dbs.setText(getResources().getString(R.string.dbsCN));
            ocbc.setText(getResources().getString(R.string.ocbcCN));
            uob.setText(getResources().getString(R.string.uobCN));
        } else if(id == R.id.EnglishSelection) {
            dbs.setText(getResources().getString(R.string.dbs));
            ocbc.setText(getResources().getString(R.string.ocbc));
            uob.setText(getResources().getString(R.string.uob));
        }

        return super.onOptionsItemSelected(item);
    }
}
