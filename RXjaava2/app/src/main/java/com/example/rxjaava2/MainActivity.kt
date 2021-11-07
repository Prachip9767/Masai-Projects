package com.example.rxjaava2


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;



class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var create: Button? = null
    private var flatMap: Button? = null
    private val TAG = "Prachi"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        create = findViewById(R.id.btnCreate)
        flatMap = findViewById(R.id.btnFaltMap)
        create.setOnClickListener(this)
        flatMap.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id: Int = view.id
        when (id) {
            R.id.btnCreate -> {
                val taskObservable: Observable<jdk.internal.org.jline.utils.ShutdownHooks.Task> =
                    Observable.create(ObservableOnSubscribe<Any?> { emitter ->
                        val task: jdk.internal.org.jline.utils.ShutdownHooks.Task =
                            jdk.internal.org.jline.utils.ShutdownHooks.Task(1, "Do it", true)
                        val taskList: List<ShutdownHooks.Task> =
                            list
                        for (task1 in taskList) {
                            if (!emitter.isDisposed()) {
                                emitter.onNext(task1)
                            }
                        }
                        emitter.onComplete()
                    }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                val taskObserver: Observer<jdk.internal.org.jline.utils.ShutdownHooks.Task> =
                    object : Observer<jdk.internal.org.jline.utils.ShutdownHooks.Task?> {
                        override fun onSubscribe(d: Disposable) {}
                        override fun onNext(task: jdk.internal.org.jline.utils.ShutdownHooks.Task) {
                            Log.v(TAG, task.getName())
                        }

                        override fun onError(e: Throwable) {}
                        override fun onComplete() {}
                    }
                taskObservable.subscribe(taskObserver)
            }
            R.id.btnFaltMap -> {
                val response = StudentResponse(1, student as MutableList<Student>?)
                val studentObservable: @NonNull Observable<Student?>? = Observable.just(response)
                    .flatMap { t ->
                        val studentList: List<Student> = t.studentList
                        Observable.fromIterable(studentList)
                    }.filter { t -> t.getS_marks() > 75 }
                val studentObserver: Observer<Student?> = object : Observer<Student?> {
                    override fun onSubscribe(d: Disposable) {}

                    override fun onError(e: Throwable) {
                        e.message?.let { Log.v("prachi", it) }
                    }

                    override fun onComplete() {}
                    override fun onNext(t: Student?) {
                        t?.let { Log.v("prachi", it.s_name) }
                    }
                }
                studentObservable?.subscribe(studentObserver)
            }
        }
    }

    private val student: List<Any>
        private get() {
            val s_list: MutableList<Student> = ArrayList()
            s_list.add(Student("umang", 1, 95.4))
            s_list.add(Student("abhi", 2, 90.4))
            s_list.add(Student("naruto", 3, 89.4))
            s_list.add(Student("doremon", 4, 34.4))
            s_list.add(Student("shinchan", 5, 70.4))
            s_list.add(Student("mario", 6, 23.4))
            s_list.add(Student("charlie", 7, 67.4))
            s_list.add(Student("stark", 8, 76.4))
            s_list.add(Student("steve", 9, 70.4))
            s_list.add(Student("strange", 10, 45.4))
            return s_list
        }
    val list: List<Any>
        get() {
            val taskList: MutableList<jdk.internal.org.jline.utils.ShutdownHooks.Task> = ArrayList()
            val tasks = arrayOf("Excersice", "Meditaion", "house work", "eating")
            for (i in tasks.indices) {
                val task: jdk.internal.org.jline.utils.ShutdownHooks.Task =
                    jdk.internal.org.jline.utils.ShutdownHooks.Task(
                        i + 1,
                        tasks[i], true
                    )
                taskList.add(task)
            }
            return taskList
        }
}