package learn.shafi.roompersistance.persistence;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository wordRepository;
    private LiveData<List<Word>> wordList;

    public WordViewModel(@NonNull Application application) {
        super(application);

        wordRepository = new WordRepository(application);
        wordList = wordRepository.getWordList();


    }

    public LiveData<List<Word>> getWordList() {
        return wordList;
    }

    public void insert(Word word){
        wordRepository.insert(word);
    }


}
