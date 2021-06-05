package com.example.miniproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {
    TextView Name,Age,Pick;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ViewPager viewPager = findViewById(R.id.viewPager);

        Adapter adapter = new Adapter(this);
        viewPager.setAdapter(adapter);

        edit = findViewById(R.id.edit);


        Name = findViewById(R.id.name);
        Age = findViewById(R.id.age);
        Pick = findViewById(R.id.pick);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userId = fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                Name.setText(documentSnapshot.getString("name"));
                Age.setText(documentSnapshot.getString("age"));
                Pick.setText(documentSnapshot.getString("preference"));
            }
        });

        edit.setOnClickListener(v->{

            DocumentReference docRef = fStore.collection("users").document(userId);
            Map<String,Object> edited = new HashMap<>();
            edited.put("name", Name.getText().toString());
            edited.put("age", Age.getText().toString());
            edited.put("preference", Pick.getText().toString());
            docRef.update(edited).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(ProfileActivity.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                }
            });


            Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });


    }




}