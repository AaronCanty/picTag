package com.example.ass2android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;


// taken help from https://firebase.google.com/docs/database/android/read-and-write
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<ImageModel> imageModelArrayList;
    private RecyclerViewAdaptor recyclerViewAdaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        recyclerView.setHasFixedSize(true);


        imageModelArrayList = new ArrayList<>();
        clearall();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("images");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                clearall();

                for(DataSnapshot snapshot1: snapshot.getChildren()){
                    ImageModel imageModel = new ImageModel();
                    imageModel.setImageUrl(snapshot1.getValue()
                            .toString());

                    imageModelArrayList.add(imageModel);
                }

                recyclerViewAdaptor = new RecyclerViewAdaptor(getApplicationContext(), imageModelArrayList);
                recyclerView.setAdapter(recyclerViewAdaptor);
                recyclerViewAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this,
                        "DB Error:" + error.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void clearall(){
        if(imageModelArrayList != null){
            imageModelArrayList.clear();
            if(recyclerViewAdaptor != null){
                recyclerViewAdaptor.notifyDataSetChanged();
            }
        }
imageModelArrayList = new ArrayList<>();
    }
}





//
//package com.example.ass2android;
//
//        import androidx.annotation.NonNull;
//        import androidx.appcompat.app.AlertDialog;
//        import androidx.appcompat.app.AppCompatActivity;
//        import android.content.DialogInterface;
//        import android.os.Bundle;
//        import android.view.View;
//        import android.widget.AdapterView;
//        import android.widget.ArrayAdapter;
//        import android.widget.Button;
//        import android.widget.EditText;
//        import android.widget.LinearLayout;
//        import android.widget.ListView;
//        import android.widget.TextView;
//        import com.google.firebase.database.DataSnapshot;
//        import com.google.firebase.database.DatabaseError;
//        import com.google.firebase.database.DatabaseReference;
//        import com.google.firebase.database.FirebaseDatabase;
//        import com.google.firebase.database.ValueEventListener;
//        import java.util.ArrayList;
//        import java.util.List;
//
//
//// taken help from https://firebase.google.com/docs/database/android/read-and-write
//public class MainActivity extends AppCompatActivity {
//    DatabaseReference photoDB;
//
//    EditText tagEdit, descriptionEdit, locationEdit;
//    Button addBTN;
//    ListView imageListView;
//    List<ImageModel> imageModelList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        //get them from the xml file
//        tagEdit = findViewById(R.id.Tag);
//        descriptionEdit = findViewById(R.id.Description);
//        locationEdit = findViewById(R.id.Location);
//
//        addBTN = findViewById(R.id.add_img);
//
//        imageListView = findViewById(R.id.image_listview);
//        imageModelList = new ArrayList<>();
////get firebase reference to the database path where the images will be
//        photoDB = FirebaseDatabase.getInstance().getReference("Image");
//
//        addBTN.setOnClickListener(v -> addImg(tagEdit.getText().toString().trim(),
//                descriptionEdit.getText().toString().trim(),
//                locationEdit.getText().toString().trim()));
//    }
//    // adding the typed in data
//    private void addImg(String tag, String description, String location)
//    {
//        String id = photoDB.push().getKey();
//
//        ImageModel imgModel = new ImageModel(tag, description, location);
//        photoDB.child(id).setValue(imgModel);
//
//
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        photoDB.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                // imageModelList.clear(); // every time when data updates in firebase, it creates a list with
//                // updated items. Clear list
//                if(snapshot.exists())
//                {
//                    for(DataSnapshot imageSnapShot: snapshot.getChildren())
//                    {
//                        ImageModel imageModel = imageSnapShot.getValue(ImageModel.class);
//                        imageModelList.add(imageModel);
//                    }
//
//                    Image_ListAdaptor adaptor = new Image_ListAdaptor(MainActivity.this, imageModelList);
//                    imageListView.setAdapter(adaptor);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
//}