package cytech.com.br.tasklist;

import android.content.ContentValues;
import android.content.DialogInterface;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cytech.com.br.tasklist.cytech.com.br.tasklistDB.DbHelper;
import cytech.com.br.tasklist.cytech.com.br.tasklistDB.TaskListEntry;

public class MainActivity extends AppCompatActivity {
    private List<String> tasks = new ArrayList<String>();
    private ListView listView;
    private ArrayAdapter arrayAdapter;
    private DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DbHelper(this);

        listView = (ListView) findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter(this, R.layout.item_task, R.id.textView, tasks);

        listView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_task:
                return createTask();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean createTask(){
        final EditText taskText = new EditText(this);

        AlertDialog alertDialog = new AlertDialog
                .Builder(this)
                .setTitle("Add a new task")
                .setMessage("What do you want to do?")
                .setView(taskText)
                .setPositiveButton("add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        String task = String.valueOf(taskText.getText());
                        SQLiteDatabase dbHelper = db.getWritableDatabase();
                        ContentValues values = new ContentValues();

                        values.put(TaskListEntry.COL_TASK_TITLE, task);
                        dbHelper.insertWithOnConflict(TaskListEntry.TABLE, null, values, SQLiteDatabase.CONFLICT_REPLACE);
                        db.close();

                    }
                })
                .setNegativeButton("Close", null)
                .create();

        alertDialog.show();
        return true;
    }

    public void removeTask(View view){
        View parent = (View) view.getParent();

        TextView task = (TextView) parent.findViewById(R.id.textView);
        String taskText= String.valueOf(task.getText());

        arrayAdapter.remove(taskText);
        arrayAdapter.notifyDataSetChanged();

    }
}
