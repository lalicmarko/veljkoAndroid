package vex.firma.moja.veljkoarsicandroid;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private Fragment currentFragment = null;
    private List<String> zadaci = Arrays.asList("Zadatak 1", "Zadatak 2", "Zadatak 3", "Zadatak 4", "Zadatak 5", "Zadatak 6", "Zadatak 7", "Zadatak 8", "Zadatak 9", "Zadatak 10");
    private FragmentManager fragmentManager;
    public static final String TAG = "HONOLULU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        lv = findViewById(R.id.list);
        ListAdapter adapter = new ArrayAdapter<>(this, R.layout.list_item, zadaci);
        lv.setAdapter(adapter);

        //new GetPosts().execute();
    }

    public void openZadatak1Fragment(MenuItem item) {
        Toast.makeText(this, "Zad1", Toast.LENGTH_SHORT).show();
    }

    public void bla(View view) {
        TextView tv = (TextView) view;
        String tvText = tv.getText().toString();
        switch (tvText) {
            case "Zadatak 1" : {
                startActivity(new Intent(this, Zadatak1Activity.class));
                break;
            }
            case "Zadatak 2" : {
                startActivity(new Intent(this, Zadatak2Activity.class));
                break;
            }
            case "Zadatak 3" : {
                startActivity(new Intent(this, Zadatak3Activity.class));
                break;
            }
            case "Zadatak 4" : {
                startActivity(new Intent(this, Zadatak4Activity.class));
                break;
            }
            case "Zadatak 5" : {
                startActivity(new Intent(this, Zadatak5Activity.class));
                break;
            }
            case "Zadatak 6" : {
                startActivity(new Intent(this, Zadatak6Activity.class));
                break;
            }
            case "Zadatak 7" : {
                startActivity(new Intent(this, Zadatak7Activity.class));
                break;
            }
            case "Zadatak 8" : {
                startActivity(new Intent(this, Zadatak8Activity.class));
                break;
            }
            case "Zadatak 9" : {
                startActivity(new Intent(this, Zadatak9Activity.class));
                break;
            }
            case "Zadatak 10" : {
                startActivity(new Intent(this, Zadatak10Activity.class));
                break;
            }
            default: {
                Toast.makeText(this, "default", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private class GetPosts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this,"Json Data is downloading", Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://api.myjson.com/bins/1g81bu";
            String jsonStr = sh.makeServiceCall(url);

            if (jsonStr != null) {
                try {
                    JSONArray posts = new JSONArray(jsonStr);

                    for (int i = 0; i < posts.length(); i++) {
                        JSONObject c = posts.getJSONObject(i);
                        String userId = c.getString("userId");
                        String id = c.getString("id");
                        String title = c.getString("title");
                        String body = c.getString("body");

                        HashMap<String, String> post = new HashMap<>();

                        post.put("userId", userId);
                        post.put("id", id);
                        post.put("title", title);
                        post.put("body", body);

//                        postList.add(post);
                    }
                } catch (final JSONException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            e.printStackTrace();
                        }
                    });

                }

            } else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
//            ListAdapter adapter = new SimpleAdapter(MainActivity.this, postList,
//                    R.layout.list_item, new String[]{ "title","body"},
//                    new int[]{R.id.title, R.id.body});
//            lv.setAdapter(adapter);
        }
    }

}

