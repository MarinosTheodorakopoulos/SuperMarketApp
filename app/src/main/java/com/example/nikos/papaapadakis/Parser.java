package com.example.nikos.papaapadakis;

/**
 * Created by Nikos on 15/4/2016.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
/**
 * Created by Hp on 3/24/2016.
 */
public class Parser extends AsyncTask<Void,Integer,Integer> {
    Context c;
    ListView lv;
    String data;
    ArrayList<String> players=new ArrayList<>();
    ProgressDialog pd;
    public Parser(Context c, String data, ListView lv) {
        this.c = c;
        this.data = data;
        this.lv = lv;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setTitle("Parser");
        pd.setMessage("Parsing ....Please wait");
        pd.show();
    }
    @Override
    protected Integer doInBackground(Void... params) {
        return this.parse();
    }
    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        if(integer == 1)
        {
            //ADAPTER
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(c,android.R.layout.simple_list_item_1,players);
            //ADAPT TO LISTVIEW
            lv.setAdapter(adapter);
            //LISTENET
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Snackbar.make(view,players.get(position),Snackbar.LENGTH_SHORT).show();;
                }
            });
        }else
        {
            Toast.makeText(c,"Unable to Parse",Toast.LENGTH_SHORT).show();
        }
        pd.dismiss();
    }
    //PARSE RECEIVED DATA
    private int parse()
    {
        try
        {
            //ADD THAT DATA TO JSON ARRAY FIRST
            JSONArray ja=new JSONArray(data);
            //CREATE JO OBJ TO HOLD A SINGLE ITEM
            JSONObject jo=null;
            players.clear();
            //LOOP THRU ARRAY
            for(int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);
                //RETRIOEVE NAME
                int name=jo.getInt("id");

                //ADD IT TO OUR ARRAYLIST
                if(name==1) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΖΥΜΑΡΙΚΑ");
                }else if(name==2) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΚΑΦΕΔΕΣ");
                }else if(name==3) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΓΑΛΑΤΑ");
                }else if(name==4) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΡΥΖΙΑ");
                }else if(name==5) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΖΑΧΑΡΗ");
                }
                else if(name==6) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΚΕΝΑ ΣΥΣΚΕΥΑΣΙΑΣ");
                }
                else if(name==7) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΚΟΝΣΕΡΒΕΣ-ΚΟΜΠΟΣΤΕΣ");
                }
                else if(name==8) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΟΣΠΡΙΑ");
                }
                else if(name==9) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΟΙΝΟΠΝΕΥΜΑΤΩΔΗ-ΚΡΑΣΙΑ-ΜΠΥ");
                }
                else if(name==10) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΧΑΡΤΙΚΑ");
                }
                else if(name==11) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΑΛΕΥΡΙΑ-ΦΑΡΙΝΕΣ");
                }
                else if(name==12) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΠΡΟΙΟΝΤΑ ΝΤΟΜΑΤΑΣ");
                }
                else if(name==13) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΑΝΑΨΥΚΤΙΚΑ-ΧΥΜΟΙ-ΝΕΡΑ");
                }
                else if(name==14) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΑΥΓΑ");
                }
                else if(name==15) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΜΠΙΣΚΟΤΑ-ΚΡΟΥΑΣΑΝ-ΚΕΙΚ");
                }
                else if(name==16) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΚΑΛΛΥΝΤΙΚΑ-ΞΥΡΙΣΤΙΚΑ");
                }
                else if(name==17) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΦΡΥΓΑΝΙΕΣ");
                }
                else if(name==18) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΜΠΑΧΑΡ-ΜΥΡΩΔ-ΒΟΤΑΝΑ-ΑΛΑΤΙ");
                }
                else if(name==19) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΠΡ.ΦΩΤΙΑΣ BBQ- ΥΓΡΑΕΡΙΟΥ");
                }
                else if(name==20) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΑΠΟΡΡΥΠΑΝΤΙΚΑ-ΑΠΟΛΥΜΑΝΤΙΚ");
                }
                else if(name==21) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΜΑΡΓΑΡΙΝΕΣ-ΦΡΕΣΚ.ΒΟΥΤΥΡΑ");
                }
                else if(name==22) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΣΟΚΟΛΑΤΟΕΙΔΗ");
                }
                else if(name==23) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΟΠΩΡΟΠΩΛΕΙΟΥ ΕΙΔΗ");
                }
                else if(name==24) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΤΥΡΟΚΟΜΙΚΑ ΚΟΠΗΣ");
                }
                else if(name==25) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΕΙΔΗ ΚΑΘΑΡΙΣΜ-ΤΑΚΤΟΠ.ΣΠΙΤ");
                }
                else if(name==26) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΣΕΡΒΙΕΤΕΣ-ΠΑΝΕΣ-ΕΠΙΔΕΣΜΙΚ");
                }
                else if(name==27) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΕΙΔΗ ΜΙΑΣ ΧΡΗΣΕΩΣ");
                }
                else if(name==28) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΕΛΑΙΑ-ΕΛΙΕΣ-ΜΑΓ.ΛΙΠΗ");
                }
                else if(name==29) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΗΛΕΚΤ.ΕΙΔΗ-ΕΡΓ.-ΜΠΑΤ-ΑΥΤΟ");
                }
                else if(name==30) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΥΛΙΚΑ ΖΑΧ/ΚΗΣ-ΕΙΔΗ ΖΑΧΑΡΟ");
                }
                else if(name==31) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΣΧΟΛΙΚΑ");
                }
                else if(name==32) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("SNACKS-ΞΗΡΟΙ ΚΑΡΠΟΙ");
                }
                else if(name==33) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΟΙΝΟΠΝΕΥΜΑΤΑ -ΒΕΝΖΙΝΕΣ");
                }
                else if(name==34) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΜΕΛΙ-ΜΑΡΜΕΛΑΔΑ-ΓΛ.ΚΟΥΤΑΛΙ");
                }
                else if(name==35) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΤΡΟΦΕΣ ΖΩΩΝ-ΠΤΗΝΩΝ * ΑΞΕΣ");
                }
                else if(name==36) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΔΗΜΗΤΡΙΑΚΑ");
                }
                else if(name==37) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΕΙΔΗ ΥΠΟΔ-ΣΤΙΛΒ.ΠΑΠΟΥΤΣ.");
                }
                else if(name==38) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΠΑΣΤΕΛΙΑ-ΜΑΝΤΟΛ-ΛΟΥΚ-ΞΕΡΟ");
                }
                else if(name==39) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΚΑΤΕΨΥΓΜΕΝΑ ΔΙΑΦΟΡΑ");
                }
                else if(name==40) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΕΙΔΗ ΕΝΔΥΣ.-Λ.ΕΙΔΗ-ΑΞΕΣΟ");
                }
                else if(name==41) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΑΛΙΕΥΜΑΤΑ ΚΑΤ/ΝΑ");
                }
                else if(name==42) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΕΡΓΑΛ.ΚΟΥΖ.ΜΑΓ.ΣΚ-ΦΥΛΑΞΗΣ");
                }
                else if(name==43) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΤΥΡΟΚΟΜΙΚΑ ΣΥΣΚΕΥΑΣΙΑΣ");
                }
                else if(name==44) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΡΟΦΗΜΑΤΑ");
                }
                else if(name==45) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΚΥΒΟΙ ΣΑΛΤΣΕΣ");
                }
                else if(name==46) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΧΑΛΒΑΔΕΣ-TAXINI");
                }
                else if(name==47) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΑΡΤΟΣΚΕΥΑΣΜΑΤΑ");
                }
                else if(name==48) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΚΑΡΑΜΕΛΕΣ-ΤΣΙΧΛΕΣ");
                }
                else if(name==49) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΠΑΓΩΤΑ");
                }
                else if(name==50) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΕΙΔΗ DELICATESSEN");
                }
                else if(name==51) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΥΛΙΚΑ ΣΥΣΚΕΥΑΣΙΑΣ");
                }
                else if(name==52) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΠΑΙΧΝΙΔΙΑ");
                }
                else if(name==53) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΠΡΟΙΟΝ.ΒΡΕΦ.&ΠΑΙΔ.ΔΙΑΤΡΟΦ");
                }
                else if(name==54) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΕΝΤΟΜΟΚΤ-ΣΚΩΡΟΚΤ.ΑΠΟΣΜ.ΧΩ");
                }
                else if(name==55) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΚΡΕΑΤΑ ΝΩΠΑ");
                }
                else if(name==56) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΑΛΙΠΑΣΤΑ-ΚΑΠΝΙΣΤΑ");
                }
                else if(name==57) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΓΙΑΟΥΡΤΙΑ");
                }
                else if(name==58) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΑΛΛΑΝΤΙΚΑ ΣΥΣΚΕΥΑΣΜΕΝΑ");
                }
                else if(name==59) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΕΙΔΗ ΥΓΙΕΙΝΗΣ ΔΙΑΤΡΟΦΗΣ");
                }
                else if(name==60) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΓΑΛΑΤΑ ΦΡΕΣΚΑ");
                }
                else if(name==61) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΠΡΟΩΘΗΣΕΙΣ-ΔΙΑΦΟΡΑ");
                }
                else if(name==62) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΠΙΑΤΑ-ΠΟΤΗΡ-ΓΥΑΛ-ΔΙΑΚΟΣΜΗ");
                }
                else if(name==63) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΕΠΟΧΙΑΚΑ ΕΙΔΗ");
                }
                else if(name==64) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΑΛΛΑΝΤΙΚΑ ΚΟΠΗΣ");
                }
                else if(name==65) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΣΑΛΑΤΕΣ ΨΥΓΕΙΟΥ ΣΥΣΚ.");
                }
                else if(name==66) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΗΛ.ΜΙΚΡΟΣΥΣΚΕΥΕΣ");
                }
                else if(name==67) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΥΛ.ΖΑΧ.-ΓΛΥΚΑ-ΣΟΚ(ΨΥΓΕΙΟΥ");
                }
                else if(name==68) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΚΡΕΑΤΑ ΚΑΤ/ΝΑ");
                }
                else if(name==69) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΑΝΤΗΛΙΑΚΑ");
                }
                else if(name==70) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΑΝΘΗ-ΕΠΙΠΛΑ ΒΕΡΑΝΤΑ-ΚΗΠΟΥ");
                }
                else if(name==71) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΔΙΕΘΝΗΣ ΚΟΥΖΙΝΑ");
                }
                else if(name==72) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΦΡΕΣΚΟΙ ΧΥΜΟΙ ΣΥΝΤΗΡΗΣΗΣ");
                }
                else if(name==73) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΚΡΕΑΤΑ ΝΩΠΑ ΣΥΣΚΕΥΑΣΙΑΣ");
                }
                else if(name==74) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΒΙΟΛΟΓΙΚΑ");
                }
                else if(name==75) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΖΥΜΗ-ΦΥΛΛΑ ΣΥΝΤΗΡΗΣΗΣ");
                }
                else if(name==76) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΣΑΛΑΤΕΣ ΨΥΓΕΙΟΥ ΧΥΜΑ");
                }
                else if(name==77) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΑΛΙΕΥΜΑΤΑ ΝΩΠΑ");
                }
                else if(name==78) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΦΑΓΗΤΑ ΨΗΜΕΝΑ");
                }
                else if(name==79) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΕΙΔΗ ΤΑΞΙΔΙΟΥ");
                }
                else if(name==80) {
                    Log.d("ADebugTag", "Value: " + name);
                    players.add("ΕΙΔΗ ΚΑΠΝ.-ΚΑΡΤΕΣ-ΕΦΗΜΕΡ.");
                }


            }
            return 1;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
}


