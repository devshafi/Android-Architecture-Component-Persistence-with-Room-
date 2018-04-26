package learn.shafi.roompersistance.persistence;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @ColumnInfo(name = "word")
    @NonNull
    public String mWord;


    public Word( String mWord){
        this.mWord = mWord;
    }

    public String getmWord() {
        return mWord;
    }
}


