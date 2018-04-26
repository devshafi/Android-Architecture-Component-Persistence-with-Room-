package learn.shafi.roompersistance.persistence;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {

    private WordDao wordDao;
    private LiveData<List<Word>> wordList;


    public WordRepository(Application application){

        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        wordDao = db.wordDao();
        wordList = wordDao.getAllWords();

    }

    LiveData<List<Word>> getWordList (){
        return wordList;
    }

    public void insert(Word word){
        new insertAsyncTask(wordDao).execute(word);

    }

    private static class insertAsyncTask extends AsyncTask<Word,Void,Void>{

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao wordDao){

            mAsyncTaskDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mAsyncTaskDao.insert(words[0]);
            return null;
        }
    }
}
