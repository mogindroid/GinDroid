/*
 *                 [[ Frozen-Bubble ]]
 *
 * Copyright (c) 2000-2003 Guillaume Cottenceau.
 * Java sourcecode - Copyright (c) 2003 Glenn Sanson.
 * High score manager source - Copyright (c) 2010 Michel Racic.
 * Additional source - Copyright (c) 2013 Eric Fortin.
 *
 * This code is distributed under the GNU General Public License
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 2 or 3, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to:
 * Free Software Foundation, Inc.
 * 675 Mass Ave
 * Cambridge, MA 02139, USA
 *
 * Artwork:
 *    Alexis Younes <73lab at free.fr>
 *      (everything but the bubbles)
 *    Amaury Amblard-Ladurantie <amaury at linuxfr.org>
 *      (the bubbles)
 *
 * Soundtrack:
 *    Matthias Le Bidan <matthias.le_bidan at caramail.com>
 *      (the three musics and all the sound effects)
 *
 * Design & Programming:
 *    Guillaume Cottenceau <guillaume.cottenceau at free.fr>
 *      (design and manage the project, whole Perl sourcecode)
 *
 * Java version:
 *    Glenn Sanson <glenn.sanson at free.fr>
 *      (whole Java sourcecode, including JIGA classes
 *             http://glenn.sanson.free.fr/jiga/)
 *
 * Android port:
 *    Pawel Aleksander Fedorynski <pfedor@fuw.edu.pl>
 *    Eric Fortin <videogameboy76 at yahoo.com>
 *    Copyright (c) Google Inc.
 *
 *          [[ http://glenn.sanson.free.fr/fb/ ]]
 *          [[ http://www.frozen-bubble.org/   ]]
 */

package com.efortin.frozenbubble;

/**
 * SQlite DB adapter class based on the code from:<br>
 * http://www.screaming-penguin.com/node/7742
 *
 * @author Michel Racic (http://www.2030.tk)
 */
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

public class HighscoreDB {
  private static final int    DATABASE_VERSION = 1;
  private static final String TABLE_NAME       = "highscore";
  private static String databaseName;

  private final Context context;
  private final SQLiteDatabase db;
  private final SQLiteStatement insertStmt;
  private static final String INSERT = "insert into " + TABLE_NAME +
    "(level, name, shots, time) values (?,?,?,?)";


  public HighscoreDB(Context context, String databaseName) {
    this.context = context;
    HighscoreDB.databaseName = databaseName;
    OpenHelper openHelper = new OpenHelper(this.context);
    db = openHelper.getWritableDatabase();
    insertStmt = db.compileStatement(INSERT);
  }

  public void close() {
    db.close();
  }

  public long insert(HighscoreDO hi) {
    insertStmt.bindLong(1, hi.getLevel());
    insertStmt.bindString(2, hi.getName());
    insertStmt.bindLong(3, hi.getShots());
    insertStmt.bindLong(4, hi.getTime());
    return insertStmt.executeInsert();
  }

  public void deleteAll() {
    db.delete(TABLE_NAME, null, null);
  }

  public void deleteById(int id) {
    db.delete(TABLE_NAME, "id=" + id, null);
  }

  public List<HighscoreDO> selectAll() {
    List<HighscoreDO> list = new ArrayList<HighscoreDO>();
    Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null,
                             "level asc, shots asc, time asc");
    if (cursor.moveToFirst()) {
      do {
        list.add(new HighscoreDO(cursor.getInt(0), cursor.getInt(1),
                 cursor.getString(2), cursor.getInt(3), cursor.getLong(4)));
      } while (cursor.moveToNext());
    }
    if ((cursor != null) && !cursor.isClosed()) {
      cursor.close();
    }
    return list;
  }

  public List<HighscoreDO> selectByLevel(int level, int limit) {
    List<HighscoreDO> list = new ArrayList<HighscoreDO>();
    Cursor cursor = db.query(TABLE_NAME, null, "level=" + level, null,
                             null, null, "shots asc, time asc", "" + limit);
    if (cursor.moveToFirst()) {
      do {
        list.add(new HighscoreDO(cursor.getInt(0), cursor.getInt(1),
                 cursor.getString(2), cursor.getInt(3), cursor.getLong(4)));
      } while (cursor.moveToNext());
    }
    if ((cursor != null) && !cursor.isClosed()) {
      cursor.close();
    }
    return list;
  }

  public List<HighscoreDO> selectLastByLevel(int level, int limit) {
    List<HighscoreDO> list = new ArrayList<HighscoreDO>();
    Cursor cursor = db.query(TABLE_NAME, null, "level=" + level, null,
                             null, null, "shots asc, time asc", null);
    if (cursor.moveToLast()) {
      int index = 0;
      do {
        list.add(new HighscoreDO(cursor.getInt(0), cursor.getInt(1),
                 cursor.getString(2), cursor.getInt(3), cursor.getLong(4)));
        index++;
      } while (cursor.moveToPrevious() && (index < limit));
    }
    if ((cursor != null) && !cursor.isClosed()) {
      cursor.close();
    }
    return list;
  }

  private static class OpenHelper extends SQLiteOpenHelper {
    OpenHelper(Context context) {
      super(context, databaseName, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("CREATE TABLE " + TABLE_NAME +
                 " (id INTEGER PRIMARY KEY, level INTEGER, name TEXT, shots INTEGER, time LONG)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      Log.w("Example",
            "Upgrading database, this will drop tables and recreate.");
      db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
      onCreate(db);
    }
  }
}
