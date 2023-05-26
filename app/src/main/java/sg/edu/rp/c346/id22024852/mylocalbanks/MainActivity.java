package sg.edu.rp.c346.id22024852.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView DBS;
    TextView OCBC;
    TextView UOB;

String wordClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBS = findViewById(R.id.textViewDBS);
        OCBC = findViewById(R.id.textViewOCBC);
        UOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.menuItemChinese) {
            DBS.setText(getResources().getString(R.string.DBSChinese));
            OCBC.setText(getResources().getString(R.string.OCBCChinese));
            UOB.setText(getResources().getString(R.string.UOBChinese));
            return true;
        } else if (id == R.id.menuItemEnglish) {
            DBS.setText(getResources().getString(R.string.DBS));
            OCBC.setText(getResources().getString(R.string.OCBC));
            UOB.setText(getResources().getString(R.string.UOB));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact The Bank");
        menu.add(0,2,2,"Toggle Favourite");

        if (v == UOB){
            wordClicked = "UOB";
        } else if (v == OCBC){
            wordClicked = "OCBC";
        } else if (v == DBS){
            wordClicked = "DBS";
        }

    }

    public boolean onContextItemSelected(MenuItem item) {


        if(wordClicked.equalsIgnoreCase("dbs")){
            if(item.getItemId()==0) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getResources().getString(R.string.DBSURL)));
                startActivity(intent);
            } else if (item.getItemId()==1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +18001111111L));
                startActivity(intentCall);
            } else if (item.getItemId()==2){
                if (DBS.getCurrentTextColor()== Color.RED){
                    DBS.setTextColor(Color.BLACK);
                } else {
                    DBS.setTextColor(Color.RED);
                };
            }
        } else if(wordClicked.equalsIgnoreCase("ocbc")){
            if (item.getItemId()==0){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getResources().getString(R.string.OCBCURL)));
                startActivity(intent);
            } else if (item.getItemId()==1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +18003633333L));
                startActivity(intentCall);
            } else if (item.getItemId()==2){
                if (OCBC.getCurrentTextColor()== Color.RED){
                    OCBC.setTextColor(Color.BLACK);
                } else {
                    OCBC.setTextColor(Color.RED);
                }

            }
        } else if(wordClicked.equalsIgnoreCase("uob")){
            if (item.getItemId()==0){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(getResources().getString(R.string.UOBURL)));
                startActivity(intent);
            } else if (item.getItemId()==1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +18002222121L));
                startActivity(intentCall);
            } else if (item.getItemId()==2){
                if (UOB.getCurrentTextColor()== Color.RED){
                    UOB.setTextColor(Color.BLACK);
                } else {
                    UOB.setTextColor(Color.RED);
                }
            }
        }







        return super.onContextItemSelected(item); //pass menu item to the superclass implementation


    }




}