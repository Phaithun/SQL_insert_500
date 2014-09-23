package app.phaithun.resume_55410500;

import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class dbcontroler_500 extends SQLiteOpenHelper {


	String Age ,Nickname,Birthday,Tel,Facebook ;

	private static final String DATABASE_NAME = "game";
	private static final String TABLE_REGISTER = "register";
	private static final int DATABASE_VERSION = 1;

	private static final String TABLE_MEMBER = null; 
			
	
	
	public dbcontroler_500(Context context) {
		super(context, TABLE_REGISTER, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE   "+  TABLE_REGISTER 
				+"(MemberId INTEGER PRIMARY KEY AUTOINCREMENT,"
				+"Name INTEGER,"
				+"Age  TEXT(100),"
				+"Birthday TEXT(100),"
				+"Tel INTEGER);");
		Log.d("CREATE TABLE","Create Table Successfully");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS  "+TABLE_REGISTER );
		onCreate(db);
	}

	public long insertData(String Age,String Nickname,String Birthday
			,String Tel,String Facebook){
		try {
			SQLiteDatabase db;
			db=this.getWritableDatabase();
			ContentValues s = new ContentValues();
		
			s.put("Age",Age);
			s.put("Nickname", Nickname);
			s.put("Birthday",Birthday);
			s.put("Tel", Tel);
			s.put("Facebook",Facebook);
			
			long k = db.insert(TABLE_REGISTER, null,s);
			db.close();
			return k ;
			
		} catch (Exception e) {
			// TODO: handle exception
			return -1 ;
		}
	
	
	}
	public String[] CheckData(String strMemberID) {
	    try {
	        String arrData[] = null;

	        SQLiteDatabase db;
	        db = this.getReadableDatabase();

	        Cursor cursor = db.query(TABLE_MEMBER, new String[] { "*" },
	                "MemberID=?", new String[] { String.valueOf(strMemberID) },
	                null, null, null);
	        if (cursor != null) {
	            if (cursor.moveToFirst()) {
	                arrData = new String[cursor.getColumnCount()];
	                arrData[0] = cursor.getString(0);
	                arrData[1] = cursor.getString(1);
	                arrData[2] = cursor.getString(2);
	            }
	        }
	        cursor.close();
	        db.close();
	        return arrData;

	    } catch (Exception e) {
	        return null;
	    }
	}
}
	
	
	