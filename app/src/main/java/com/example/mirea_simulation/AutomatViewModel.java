package com.example.mirea_simulation;

import android.app.Activity;
import android.widget.TextView;

import java.util.ArrayList;

public class AutomatViewModel {
    public ArrayList<AutomatViewsPack> automatViewsPacks;

    private static AutomatViewModel instance = null;

    public static AutomatViewModel getInstance(Activity activity) {
        if (AutomatViewModel.instance == null) {
            AutomatViewModel.instance = new AutomatViewModel(activity);
        }

        return AutomatViewModel.instance;
    }

    private AutomatViewModel(Activity activity) {
        automatViewsPacks = new ArrayList<AutomatViewsPack>();

        automatViewsPacks.add(new AutomatViewsPack(
                activity,
                R.id.first_status,
                R.id.first_student_number,
                R.id.first_food_first,
                R.id.first_food_second,
                R.id.first_food_third,
                R.id.first_drink_first,
                R.id.first_drink_second,
                R.id.first_drink_third,
                R.id.first_queue,
                R.id.first_sum
        ));
        // second
        // third
        // fourth
    }

    class AutomatViewsPack {
        public TextView status;
        public TextView student_number;

        public TextView food_first;
        public TextView food_second;
        public TextView food_third;
        public TextView drink_first;
        public TextView drink_second;
        public TextView drink_third;

        public TextView queue;
        public TextView sum;

        public AutomatViewsPack(
                Activity activity,
                int status_id,
                int student_number_id,
                int food_first_id,
                int food_second_id,
                int food_third_id,
                int drink_first_id,
                int drink_second_id,
                int drink_third_id,
                int queue_id,
                int sum_id
        ) {
            status = activity.findViewById(status_id);
            student_number = activity.findViewById(student_number_id);

            food_first = activity.findViewById(food_first_id);
            food_second = activity.findViewById(food_second_id);
            food_third = activity.findViewById(food_third_id);
            drink_first = activity.findViewById(drink_first_id);
            drink_second = activity.findViewById(drink_second_id);
            drink_third = activity.findViewById(drink_third_id);

            queue = activity.findViewById(queue_id);
            sum = activity.findViewById(sum_id);
        }
    }
}
