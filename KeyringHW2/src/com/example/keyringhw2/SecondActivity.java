package com.example.keyringhw2;
 
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
 
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
 
public class SecondActivity extends Activity {
 
        public static final String SETTING_INFOS = "SETTING_Infos";
          public static final String NAME = "NAME";
          public static final String PASSWORD = "PASSWORD";
         
          ListView listView;
          ArrayAdapter<String> adapter;
 
        static ArrayList<String> abc = new ArrayList<String>();
        final private static int DIALOG_LOGIN = 1;
        final private static int DIALOG_DELETE= 0;
       
        @Override
        public boolean onCreateOptionsMenu(Menu menu)
        {
                MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.main_activity_actions, menu);
            return super.onCreateOptionsMenu(menu);
        }
       
       
         @Override
         public void onCreate(Bundle savedInstanceState)
         {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_second);
          fileToArray();          
         }
         
//-------------------Store------------------------
         
//------------------------------------------------       
     //********************method from array to file
     private final static String STORETEXT="storetext.txt";
     public void fromArrayWritetoFile()
     {
 
         try
         {
 
                 OutputStreamWriter out= new OutputStreamWriter(openFileOutput(STORETEXT, 0));
 
                 for (int k = 0; k < abc.size(); k++)  
                         out.write(abc.get(k)+"\n");    
 
 
                 out.close();
 
                 //to announce the user that the contents are saved
                 Toast.makeText(this, "The contents are saved in the file.", Toast.LENGTH_LONG)
 
                 .show();
 
         }
 
         catch (Throwable t)
         {
                 Toast.makeText(this, "Exception: "+t.toString(), Toast.LENGTH_LONG).show();
         }
     }
     
     //******method from file to array
     public void fileToArray(){
 
                    try {
 
                    InputStream in = openFileInput(STORETEXT);
 
                    if (in != null) {
 
                    InputStreamReader tmp=new InputStreamReader(in);
 
                    BufferedReader reader=new BufferedReader(tmp);
 
                    String str;
 
                    StringBuilder buf=new StringBuilder();
                   
                    while ((str = reader.readLine()) != null) {
                           
                    abc.add(str);
                    }
 
                    in.close();
 
                   
 
                    }
 
                    }
 
                    catch (java.io.FileNotFoundException e) {
 
                    // that's OK, we probably haven't created it yet
 
                    }
 
                    catch (Throwable t) {
 
                    Toast.makeText(this, "Exception: "+t.toString(), Toast.LENGTH_LONG).show();
 
                    }
     }
     
     
     //************
     
//------------------------------------------------      
               
         
         public void update(String x){
                        listView = (ListView) findViewById(R.id.list);
                    abc.add(x);
                   
 
                     adapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_multiple_choice, android.R.id.text1, abc);
                    adapter.notifyDataSetChanged();  
                      // Assign adapter to ListView
                      listView.setAdapter(adapter);
                      adapter.notifyDataSetChanged();
                    //  adapter.notifyDataSetChanged();
                   
                }
         
         @Override
         protected Dialog onCreateDialog(int id) {
 
          AlertDialog dialogDetails = null;
 
          switch (id) {
          case DIALOG_LOGIN:
                 
           LayoutInflater inflater = LayoutInflater.from(this);
           View dialogview = inflater.inflate(R.layout.dialog_layout, null);
 
           AlertDialog.Builder dialogbuilder = new AlertDialog.Builder(this);
           dialogbuilder.setTitle("Enter desired text");
           dialogbuilder.setView(dialogview);
           dialogDetails = dialogbuilder.create();
           
           break;
         
          case DIALOG_DELETE:
     
                 
                  /*List<Integer> checkedIDs = new ArrayList<Integer>();
                  final SparseBooleanArray checkedItems = listView.getCheckedItemPositions();
                  String numere = "";
 
                  for (int i = 0; i <= checkedItems.size(); i++){
                            // And this tells us the item status at the above position
                            final boolean isChecked = checkedItems.valueAt(i);
                           
                            if (isChecked)
                            {
                                // This tells us the item position we are looking at
                                final int position = checkedItems.keyAt(i);
                                if(position==0)
                                {
                                        abc.remove(0);
                                        listView.removeViewsInLayout(0,0);
                                        adapter.notifyDataSetChanged();
                                }
                                else
                                {
                                // Put the value of the id in our list
                                        checkedIDs.add(position);
                                        abc.remove(position);
                                        listView.removeViewsInLayout(position, position);
                                        adapter.notifyDataSetChanged();
                                }
                            }
                  }*/
                  int count = this.listView.getAdapter().getCount();
                    for (int i = 0; i < count; i++)
                    {
                        if (this.listView.isItemChecked(i))
                        {
                            abc.remove(i);
                            Toast.makeText(getApplicationContext(), "cleared",  Toast.LENGTH_LONG).show();
                        }
                        /*else if (!this.listView.isItemChecked(i))
                        {
                                Toast.makeText(getApplicationContext(), "Removed",  Toast.LENGTH_LONG).show();
                              
                        }
                        */
                   
                    }
                  String temp =  Integer.toString(count);
                  adapter.notifyDataSetChanged();
                 
                 
                 
          }
 
          return dialogDetails;
         }
 
         @Override
         public void onPrepareDialog(int id, Dialog dialog) {
                 
          switch (id) {
          case DIALOG_LOGIN:
           final AlertDialog alertDialog = (AlertDialog) dialog;
           Button loginbutton = (Button) alertDialog
             .findViewById(R.id.btn_login);
           Button cancelbutton = (Button) alertDialog
             .findViewById(R.id.btn_cancel);
                loginbutton.setOnClickListener(new View.OnClickListener() {
                        final EditText userName = (EditText) alertDialog
                                         .findViewById(R.id.txt_name);
                                        final EditText password = (EditText) alertDialog
                                         .findViewById(R.id.password);
               
               
               
            @Override
            public void onClick(View v) {
 
                // if( userName.getText().toString() != null &&
                    //       password.getText().toString() != null){
                //pin = (EditText)v.findViewById(R.id.insert_pin);
                //input = pin.getText().toString()
                        String haha = userName.getText().toString();
                        update(haha);
                  // }
                         SharedPreferences settings = getSharedPreferences(SETTING_INFOS, 0);
                            String name = settings.getString(NAME, "");
                            String pass = settings.getString(PASSWORD, "");
                            userName.setText(name);
                            password.setText(pass);
                         
             
             alertDialog.dismiss();
            }
           });
 
           cancelbutton.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View v) {
             alertDialog.dismiss();
            }
           });
           break;
          }
 
         }
         //------KILL APP ON BACK BUTTON PRESSED-----------    
     @Override
     public void onBackPressed() {
         Log.d("CDA", "onBackPressed Called");
         Intent intent = new Intent();
         intent.setAction(Intent.ACTION_MAIN);
         intent.addCategory(Intent.CATEGORY_HOME);
         adapter.notifyDataSetChanged();
         startActivity(intent);
     
     }
    //------------------------------------------------    
         
         
         @SuppressWarnings("deprecation")
                public boolean onOptionsItemSelected(MenuItem item) {
                   
                        // Handle presses on the action bar items
                    switch (item.getItemId()) {
                        case R.id.action_new:
                                    showDialog(DIALOG_LOGIN);
                                    return true;
                       
                        case R.id.action_remove:
                                        showDialog(DIALOG_DELETE);
                                        //delete();
                                        return true;
                       case R.id.action_edit:
                            showDialog(DIALOG_LOGIN);             
                            showDialog(DIALOG_DELETE);
                            			return true;
                                        
                        default:
                            return super.onOptionsItemSelected(item);
                       
                    }
                    }
}