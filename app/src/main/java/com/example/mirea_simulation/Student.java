package com.example.mirea_simulation;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Student extends AsyncTask<Void, Void, Void> {
    public int getRandom(int from, int to) {
        return from + (int)(Math.random() * (to - from));
    }

    int number;
    int wanted_food;
    int wanted_drink;
    Automat automat;

    private void debug_message(int n) {
        System.out.println(Integer.toString(n) + " этап, студент номер " + Integer.toString(number));
    }

    public Student(int new_number, ArrayList<Automat> automats) {
        number = new_number;
        automat = automats.get(getRandom(0, 1));
        wanted_drink = getRandom(0, 3);
        wanted_food = getRandom(0, 3);
    }

    private void walk_to_automat() {
        try {
            TimeUnit.SECONDS.sleep(getRandom(5, 12));
        }
        catch (InterruptedException e) {
            System.out.println("Ошибка в исключении");
        }

        debug_message(1);
    }

    private void get_to_queue() {
        try {
            Student current_student = automat.getFirstStudent();
            if (current_student != null) {
                automat.getFirstStudent().get();
            }
            automat.addStudent(this);
        }
        catch (ExecutionException e) {
            System.out.println("get_to_queue: Ошибка сука бл*н, в студенте номер " + Integer.toString(number));
        }
        catch (InterruptedException e) {
            System.out.println("Ошибка в исключении");
        }

        debug_message(2);
    }

    private void start_buying() {
        automat.changeStatus(0);

        try {
            TimeUnit.MILLISECONDS.sleep(getRandom(500, 1001));
        }
        catch (InterruptedException e) {
            System.out.println("Ошибка в исключении");
        }

        debug_message(3);
    }

    private boolean choose_food() {
        automat.changeStatus(1);

        try {
            TimeUnit.SECONDS.sleep(getRandom(1, 2));
        }
        catch (InterruptedException e) {
            System.out.println("Ошибка в исключении");
        }

        if (automat.chips.isEmpty() && automat.chocolate.isEmpty() && automat.snacks.isEmpty()) {
            return false;
        }

        if (wanted_food == 1) {
            if (automat.chips.left() == 0) {
                wanted_food = 2;
                return choose_food();
            }
            else {
                return true;
            }
        }
        else if (wanted_food == 2) {
            if (automat.chocolate.left() == 0) {
                wanted_food = 0;
                return choose_food();
            }
            else {
                return true;
            }
        }
        else {
            if (automat.snacks.left() == 0) {
                wanted_food = 1;
                return choose_food();
            }
            else {
                return true;
            }
        }
    }

    private boolean choose_drink() {
        automat.changeStatus(2);

        try {
            TimeUnit.SECONDS.sleep(getRandom(1, 2));
        }
        catch (InterruptedException e) {
            System.out.println("Ошибка в исключении");
        }

        if (automat.cola.isEmpty() && automat.energyDrink.isEmpty() && automat.water.isEmpty()) {
            return false;
        }

        if (wanted_drink == 1) {
            if (automat.cola.left() == 0) {
                wanted_drink = 2;
                return choose_drink();
            }
            else {
                return true;
            }
        }
        else if (wanted_drink == 2) {
            if (automat.energyDrink.left() == 0) {
                wanted_drink = 0;
                return choose_drink();
            }
            else {
                return true;
            }
        }
        else {
            if (automat.water.left() == 0) {
                wanted_drink = 1;
                return choose_drink();
            }
            else {
                return true;
            }
        }
    }

    private void buyFood() {
        System.out.println("\n\n\n%\n\n\n");
        debug_message(8);

        automat.changeStatus(3);

        debug_message(7);

        try {
            TimeUnit.SECONDS.sleep(getRandom(1, 3));
        }
        catch (InterruptedException e) {
            System.out.println("Ошибка в исключении");
        }

        if (wanted_food == 0) {
            automat.buyChips();
        }
        else if (wanted_food == 1) {
            automat.buyChocolate();
        }
        else {
            automat.buySnacks();
        }

        debug_message(4);
    }

    private void buyDrink() {
        automat.changeStatus(3);

        try {
            TimeUnit.SECONDS.sleep(getRandom(1, 3));
        }
        catch (InterruptedException e) {
            System.out.println("Ошибка в исключении");
        }

        if (wanted_drink == 0) {
            automat.buyCola();
        }
        else if (wanted_drink == 1) {
            automat.buyEnergyDrink();
        }
        else {
            automat.buyWater();
        }

        debug_message(5);
    }

    private void endBuying(boolean is_automat_empty) {
        automat.changeStatus(4);

        try {
            TimeUnit.SECONDS.sleep(getRandom(2, 3));
        }
        catch (InterruptedException e) {
            System.out.println("Ошибка в исключении");
        }

        if (is_automat_empty) {
            automat.changeStatus(0);
        }
        else {
            automat.nextStudent();
        }

        if (is_automat_empty) {
            debug_message(6);
        }
        else {
            debug_message(10);
        }
    }

    @Override
    protected Void doInBackground(Void... params) {
        publishProgress();
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);

        walk_to_automat();
        get_to_queue();
        start_buying();
        if (!choose_food()) {
            endBuying(false);
            return;
        }
        if (!choose_drink()) {
            endBuying(false);
            return;
        }
        buyFood();
        buyDrink();
        endBuying(true);

        System.out.println("Сoси kоk");
    }
}
