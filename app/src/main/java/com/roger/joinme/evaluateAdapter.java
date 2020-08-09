package com.roger.joinme;

import android.content.Context;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.facebook.FacebookSdk.getApplicationContext;

public class evaluateAdapter extends RecyclerView.Adapter<evaluateAdapter.ViewHolder> {
    private Context context;
    private List<evaluate> evaluateList;
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private String currentUserID,currentUserName;


    public evaluateAdapter(Context context, List<evaluate> evaluateList){
        this.context = context;
        this.evaluateList = evaluateList;
    }



    @Override
    public evaluateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mAuth = FirebaseAuth.getInstance();
        db=FirebaseFirestore.getInstance();
        currentUserID = mAuth.getCurrentUser().getUid();

//        final DocumentReference docRef = db.collection("user").document(currentUserID).collection("profile")
//                .document(currentUserID);
//        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    DocumentSnapshot snapshot = task.getResult();
//                    if (snapshot != null && snapshot.exists()) {
//                        currentUserName=snapshot.getString("name");
//                    } else {
//
//                    }
//                }
//            }
//        });

        View view = LayoutInflater.from(context).inflate(R.layout.verify_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(evaluateAdapter.ViewHolder holder, int position) {
        evaluate evaluate = evaluateList.get(position);
        holder.textName.setText(evaluate.getName());


        Glide.with(holder.itemView.getContext())
                .load(evaluate.getImage())
                .circleCrop()
                .into(holder.circleImageViewid);

        holder.circleImageViewid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String visit_user_id = evaluate.getID();
                Intent profileIntent = new Intent(holder.itemView.getContext(), ProfileActivity.class);
                profileIntent.putExtra("visit_user_id", visit_user_id);
                holder.itemView.getContext().startActivity(profileIntent);
            }
        });

        holder.one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String visit_user_id = evaluate.getID();
                Intent profileIntent = new Intent(holder.itemView.getContext(), personalevaluateActivity.class);
                profileIntent.putExtra("visit_user_id", visit_user_id);
                profileIntent.putExtra("star", 1);
                holder.itemView.getContext().startActivity(profileIntent);
            }
        });

        holder.two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String visit_user_id = evaluate.getID();
                Intent profileIntent = new Intent(holder.itemView.getContext(), personalevaluateActivity.class);
                profileIntent.putExtra("visit_user_id", visit_user_id);
                profileIntent.putExtra("star", 2);
                holder.itemView.getContext().startActivity(profileIntent);
            }
        });

        holder.three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String visit_user_id = evaluate.getID();
                Intent profileIntent = new Intent(holder.itemView.getContext(), personalevaluateActivity.class);
                profileIntent.putExtra("visit_user_id", visit_user_id);
                profileIntent.putExtra("star", 3);
                holder.itemView.getContext().startActivity(profileIntent);
            }
        });

        holder.four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String visit_user_id = evaluate.getID();
                Intent profileIntent = new Intent(holder.itemView.getContext(), personalevaluateActivity.class);
                profileIntent.putExtra("visit_user_id", visit_user_id);
                profileIntent.putExtra("star", 4);
                holder.itemView.getContext().startActivity(profileIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return evaluateList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView circleImageViewid;
        TextView textName;
        Button one,two,three,four,five;
        ViewHolder(View itemView) {
            super(itemView);
            circleImageViewid= (ImageView) itemView.findViewById(R.id.users_profile_image);
            textName = (TextView) itemView.findViewById(R.id.user_name);
            one=(Button) itemView.findViewById(R.id.one);
            two=(Button) itemView.findViewById(R.id.two);
            three=(Button) itemView.findViewById(R.id.three);
            four=(Button) itemView.findViewById(R.id.four);
            five=(Button) itemView.findViewById(R.id.five);
        }
    }


}
