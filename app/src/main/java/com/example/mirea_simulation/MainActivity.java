package com.example.mirea_simulation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    public int getRandom(int from, int to) {
        return from + (int)(Math.random() * (to - from));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("\n\n\n!\n\n\n");

        ArrayList<Automat> automats = new ArrayList<Automat>();
        for (int i = 0; i < 4; i++) {
            automats.add(new Automat(i, this));
            automats.get(i).cola.addProducts(getRandom(100, 200));
            automats.get(i).energyDrink.addProducts(getRandom(100, 200));
            automats.get(i).water.addProducts(getRandom(100, 200));
            automats.get(i).chips.addProducts(getRandom(100, 200));
            automats.get(i).chocolate.addProducts(getRandom(100, 200));
            automats.get(i).snacks.addProducts(getRandom(100, 200));

        }

        ArrayList<Student> students = new ArrayList<Student>();
        for (int i = 0; i < 20; i++) {
            students.add(new Student(i, automats));
        }

        System.out.println("\n\n\n*\n\n\n");

        for (int i = 0; i < 20; i++) {
            System.out.println("\n\n\n#\n\n\n");
            students.get(i).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
    }
}