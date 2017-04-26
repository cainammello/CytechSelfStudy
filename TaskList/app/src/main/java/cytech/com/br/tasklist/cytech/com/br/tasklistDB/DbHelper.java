package cytech.com.br.tasklist.cytech.com.br.tasklistDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cainammello on 4/4/17.
 */

public class DbHelper extends SQLiteOpenHelper{

    public DbHelper(Context context){
        super(context, TaskListDB.DB_NAME, null, TaskListDB.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TaskListEntry.TABLE + " (" +
                    TaskListEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TaskListEntry.COL_TASK_TITLE + " TEXT NOT NULL);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropTable = "DROP TABLE IF EXISTS "+ TaskListEntry.TABLE;
        db.execSQL(dropTable);

        onCreate(db);
    }
}
