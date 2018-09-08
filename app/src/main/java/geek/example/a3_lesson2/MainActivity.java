package geek.example.a3_lesson2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text);
        textView = findViewById(R.id.text_view);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Observable.just(s)
                        .subscribe(new Subscriber<CharSequence>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(CharSequence charSequence) {
                                textView.setText(String.valueOf(charSequence));
                            }
                        });
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //

        //

    }
    private void someHot(CharSequence s) {
        ConnectableObservable<CharSequence> observable = Observable
                .just(s)
                .publish();
        observable.connect();
    }

    //someHot(s);
    //
//                String str = editText.getText().toString();
    //Log.d("STR",String.valueOf(s));


//                Observable<CharSequence> observable = Observable.just(s);
//
//                Observer<CharSequence> observer = new Observer<CharSequence>() {
//
//                    @Override
//                    public void onCompleted() {
//                        Log.d("Dto", "onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("Dto", "onError");
//                        e.printStackTrace();
//                    }
//
//                    @Override
//                    public void onNext(CharSequence s) {
//                        Log.d("Dto", "onNext " + s);
//                        textView.setText(s);
//                    }
//                };
//                observable.subscribe(observer);
//                ConnectableObservable<CharSequence> observable = (ConnectableObservable<CharSequence>) Observable
//                        .just(s)
//                        .publish();
//                observable.connect();



//        List<String> liters = Arrays.asList("a","s","d","f","g");
//
//        Observable<String> observable = Observable.from(liters);
//       Observer<CharSequence> observer =  new Observer<CharSequence>() {
//
//            @Override
//            public void onCompleted() {
//                Log.d("Dto", "onCompleted");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d("Dto", "onError");
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onNext(CharSequence s) {
//                Log.d("Dto", "onNext " + s);
//                textView.setText(s);
//            }
//        };
//        observable.subscribe(observer);

}
