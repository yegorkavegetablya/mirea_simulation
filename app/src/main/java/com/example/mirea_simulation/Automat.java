package com.example.mirea_simulation;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

public class Automat {
    int number;

    int status;
    ArrayList<String> statuses;
    ArrayDeque<Student> students;

    ColaKeeper cola;
    EnergyDrinkKeeper energyDrink;
    WaterKeeper water;
    ChipsKeeper chips;
    ChocolateKeeper chocolate;
    SnacksKeeper snacks;

    int current_sum;

    private boolean isOccupied;

    Activity activity;

    public Automat(int new_number, Activity new_activity) {
        number = new_number;

        status = 0;

        statuses = new ArrayList<String>();
        statuses.add("Ожидание");
        statuses.add("Выбор еды");
        statuses.add("Выбор напитка");
        statuses.add("Покупка");
        statuses.add("Выдача");

        students = new ArrayDeque<Student>();

        cola = new ColaKeeper(this);
        energyDrink = new EnergyDrinkKeeper(this);
        water = new WaterKeeper(this);
        chips = new ChipsKeeper(this);
        chocolate = new ChocolateKeeper(this);
        snacks = new SnacksKeeper(this);

        current_sum = 0;

        isOccupied = false;

        activity = new_activity;
    }

    public Cola buyCola() {
        Cola current_cola = (Cola)cola.getProduct();
        AutomatViewModel.getInstance(activity).automatViewsPacks.get(number).sum.setText("Сумма заказа" + Integer.toString(current_sum));

        return current_cola;
    }
    public EnergyDrink buyEnergyDrink() {
        EnergyDrink current_energy_drink = (EnergyDrink)energyDrink.getProduct();
        AutomatViewModel.getInstance(activity).automatViewsPacks.get(number).sum.setText("Сумма заказа" + Integer.toString(current_sum));

        return current_energy_drink;
    }
    public Water buyWater() {
        Water current_water = (Water)water.getProduct();
        AutomatViewModel.getInstance(activity).automatViewsPacks.get(number).sum.setText("Сумма заказа" + Integer.toString(current_sum));

        return current_water;
    }
    public Chips buyChips() {
        Chips current_chips = (Chips)chips.getProduct();
        AutomatViewModel.getInstance(activity).automatViewsPacks.get(number).sum.setText("Сумма заказа" + Integer.toString(current_sum));

        return current_chips;
    }
    public Chocolate buyChocolate() {
        Chocolate current_chocolate = (Chocolate)chocolate.getProduct();
        AutomatViewModel.getInstance(activity).automatViewsPacks.get(number).sum.setText("Сумма заказа" + Integer.toString(current_sum));

        return current_chocolate;
    }
    public Snacks buySnacks() {
        Snacks current_snack = (Snacks)snacks.getProduct();
        AutomatViewModel.getInstance(activity).automatViewsPacks.get(number).sum.setText("Сумма заказа" + Integer.toString(current_sum));

        return current_snack;
    }

    public void changeStatus(int new_status) {
        status = new_status;

        AutomatViewModel.getInstance(activity).automatViewsPacks.get(number).status.setText("Статус: " + statuses.get(status));
    }

    public Student getFirstStudent() {
        if (students.isEmpty()) {
            return null;
        }
        else {
            return students.peekLast();
        }
    }
    public void nextStudent() {
        students.getFirst();

        AutomatViewModel.getInstance(activity).automatViewsPacks.get(number).student_number.setText("Номер нынешнего покупатель: " + Integer.toString(students.peekFirst().number));
        AutomatViewModel.getInstance(activity).automatViewsPacks.get(number).queue.setText("Количество человек в очереди: " + Integer.toString(students.size()));
    }
    public void addStudent(Student new_student) {
        students.addLast(new_student);

        AutomatViewModel.getInstance(activity).automatViewsPacks.get(number).queue.setText("Количество человек в очереди: " + Integer.toString(students.size()));
    }
}
