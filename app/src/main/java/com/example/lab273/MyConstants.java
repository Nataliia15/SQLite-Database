package com.example.lab273;

import android.provider.BaseColumns;

public final class MyConstants {
    public static final String CREATE_ENTRIES="CREATE TABLE "+ConstantsOfNames.TABLE_NAME+" ("+ConstantsOfNames._ID+" INTEGER_PRIMARY_KEY,"+ConstantsOfNames.COLUMN_NAME+" TEXT,"+ConstantsOfNames.CULUMN_LAST_NAME+" TEXT)";

    public static final String DELETE_ENTRIES="DROP TABLE IF EXISTS "+ConstantsOfNames.TABLE_NAME;
    private MyConstants() {
    }

    public static class ConstantsOfNames implements BaseColumns {
        public static final String TABLE_NAME="people";
        public static final String COLUMN_NAME="name";
        public static final String CULUMN_LAST_NAME="last_name";

    }
}
