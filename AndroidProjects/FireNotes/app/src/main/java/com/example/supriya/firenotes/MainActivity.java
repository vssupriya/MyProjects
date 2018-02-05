package com.example.supriya.firenotes;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ChildEventListener {
    Activity activity;
    String topic="";
    String description="";
    String status="";
    FirebaseDatabase firebaseDatabase;
    FirebaseUser firebaseUser;
    private String TAG="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<Note> notes = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final NoteAdapter noteAdapter = new NoteAdapter(notes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //use false for having a simple straight layout
        //GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        //span count gives: no of columns required
        //StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL;)
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        firebaseDatabase=FirebaseDatabase.getInstance();
        //firebaseDatabase.getReference().addChildEventListener(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(noteAdapter);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser == null) {

            //Start sign in
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(Arrays.asList(
                                    new AuthUI.IdpConfig.EmailBuilder().build(),
                                    new AuthUI.IdpConfig.PhoneBuilder().build(),
                                    new AuthUI.IdpConfig.GoogleBuilder().build()))
                            .build(),
                    12345);

        } else {
            firebaseDatabase.getReference("notes").addChildEventListener(this);
        }
        Button bt1=findViewById(R.id.bt);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText et1 = findViewById(R.id.et1);
                final EditText et2 = findViewById(R.id.et2);
                final EditText et3= findViewById(R.id.et3);
                topic=et1.getText().toString();
                description=et2.getText().toString();
                status=et3.getText().toString();
                Note note1=new Note(""+System.currentTimeMillis(),topic,description,status);
                DatabaseReference reference=firebaseDatabase.getReference(("notes")).child(note1.getId());//generates an id based on notetopics
                // firebaseDatabase.getReference("notes").push().setValue(notes);   generates a random key
                reference.setValue(notes);

                et1.setText("");
                et2.setText("");
                et3.setText("");
                //notes.add(new Note(topic,description,status));
                //noteAdapter.notifyItemInserted(notes.size());
            }
        });

    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        final ArrayList<Note> notes = new ArrayList<>();
        final NoteAdapter noteAdapter = new NoteAdapter(notes);
        Note note1=dataSnapshot.getValue(Note.class);
        Log.e(TAG, "onChildAdded: "+note1.getId());
        notes.add(note1);
        //notes.add(new Note("",topic,description,status));
        noteAdapter.notifyItemInserted(notes.size());
        //Add to arraylist here

    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {

    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 12345) {

        }
    }
}
