package ce.iut.chatva;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList animal_id, animal_name, animal_age, animal_espece, animal_sexe;

    Animation translate_anim;


    CustomAdapter(Activity activity,
                  Context context,
                  ArrayList animal_id,
                  ArrayList animal_name,
                  ArrayList animal_age,
                  ArrayList animal_espece,
                  ArrayList animal_sexe){
        this.activity = activity;
        this.context = context;
        this.animal_id = animal_id;
        this.animal_name = animal_name;
        this.animal_age = animal_age;
        this.animal_espece = animal_espece;
        this.animal_sexe = animal_sexe;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.animal_name_txt.setText(String.valueOf(animal_name.get(position)));
        holder.animal_age_txt.setText(String.valueOf(animal_age.get(position)));
        holder.animal_espece_txt.setText(String.valueOf(animal_espece.get(position)));
        holder.animal_sexe_txt.setText(String.valueOf(animal_sexe.get(position)));

        String idString = String.valueOf(animal_id.get(position));
        String nameString = String.valueOf(animal_name.get(position));
        String ageString = String.valueOf(animal_age.get(position));
        String especeString = String.valueOf(animal_espece.get(position));
        String sexeString = String.valueOf(animal_sexe.get(position));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateAnimal.class);
                intent.putExtra("id", idString);
                intent.putExtra("nom", nameString);
                intent.putExtra("age", ageString);
                intent.putExtra("espece", especeString);
                intent.putExtra("sexe", sexeString);
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return animal_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView animal_name_txt, animal_age_txt, animal_espece_txt, animal_sexe_txt;
            LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            animal_name_txt = itemView.findViewById(R.id.animal_name_text);
            animal_age_txt = itemView.findViewById(R.id.animal_age_text);
            animal_espece_txt = itemView.findViewById(R.id.animal_espece_text);
            animal_sexe_txt = itemView.findViewById(R.id.animal_sexe_text);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            // Animation Recyclerview
            translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }
    }
}
